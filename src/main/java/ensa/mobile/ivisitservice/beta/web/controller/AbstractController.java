package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.AbstractPersistableEntity;
import ensa.mobile.ivisitservice.beta.repository.RepositoryWithSpecification;
import ensa.mobile.ivisitservice.beta.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public abstract class AbstractController<ID, S extends AbstractService<ID, R, M>, R extends RepositoryWithSpecification<M, ID>, M extends AbstractPersistableEntity<ID>> {

    protected S service;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public AbstractController(S service){
        this.service = service;
    }

    @GetMapping(value = "/", params = {})
    public List<M> findAll() {
        return service.findAll(Sort.Order.desc("createdDate"));
    }

    @GetMapping(value = "/paginated/", params = {"page", "size", "!search"})
    public Page<M> findAllPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return service.findAll(page, size, Sort.Order.desc("createdDate"));
    }

    @GetMapping(value = "/{id:[\\d]+}", params = {"!page", "!size", "!search"})
    public ResponseEntity<M> get(@PathVariable("id") ID id) {
        return service.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<M> create(@RequestBody M model) {
        M savedModel = service.create(model);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<M> update(@RequestBody M model, @PathVariable ID id) {

        Optional<M> modelOptional = service.findById(id);

        if (!modelOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);

        service.update(model);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable ID id) {
        service.deleteById(id);
    }
}