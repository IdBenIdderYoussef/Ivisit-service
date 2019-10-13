package ensa.mobile.ivisitservice.beta.service;



import ensa.mobile.ivisitservice.beta.model.AbstractPersistableEntity;
import ensa.mobile.ivisitservice.beta.repository.RepositoryWithSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;




public class AbstractService<ID, R extends RepositoryWithSpecification<M, ID>, M extends AbstractPersistableEntity<ID>> {

    protected R repository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public AbstractService(R repository) {
        this.repository = repository;
    }

    public List<M> findAll() {
        return repository.findAll();
    }

    public List<M> findAll(Sort.Order... orders) {
        return repository.findAll(Sort.by(orders));
    }

    public Page<M> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Page<M> findAll(int page, int size, Sort.Order... orders) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(orders)));
    }

    public List<M> findAll(Specification<M> specification) {
        return repository.findAll(specification);
    }

    public Page<M> findAll(Specification<M> specification, int page, int size) {
        return repository.findAll(specification, PageRequest.of(page, size));
    }

    public List<M> findAll(Specification<M> specification, Sort.Order... orders) {
        return repository.findAll(specification, Sort.by(orders));
    }

    public Page<M> findAll(Specification<M> specification, int page, int size, Sort.Order... orders) {
        return repository.findAll(specification, PageRequest.of(page, size, Sort.by(orders)));
    }

    public Optional<M> findOne(Specification<M> specification) {
        return repository.findOne(specification);
    }

    public M create(M model) {
        return repository.save(model);
    }

    public void update(M model) {
        repository.save(model);
    }

    public Optional<M> findById(ID id) {
        return repository.findById(id);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }



}