package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.Post;
import ensa.mobile.ivisitservice.beta.model.Report;
import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.repository.ReportRepository;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import ensa.mobile.ivisitservice.beta.service.PostService;
import ensa.mobile.ivisitservice.beta.service.ReportService;
import ensa.mobile.ivisitservice.beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/reports")
public class ReportController extends AbstractController<Long , ReportService, ReportRepository, Report> {
    //aniss
    @Autowired
    private PostService postService;

    public ReportController(ReportService service) {
        super(service);
    }

    @GetMapping(value = "/post_id/{post_id:[\\d]+}", params = {"!page", "!size", "!search"})
    public List<Report> getReportsByPostId(@PathVariable("post_id") Long id) {
        return service.findReportsByPostId(id);
    }

    @PostMapping("/{post_id}")
    public ResponseEntity<Report> create(@RequestBody Report model, @PathVariable("post_id") Long postId) throws Exception {
        Post post = postService.findById(postId).orElseThrow(() -> new Exception("No post found with id "));
        post.getReports().add(model);
        model.setPost(post);
        // postService.update(post);
        Report savedModel = service.create(model);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}