package ensa.mobile.ivisitservice.beta.web.controller;


import com.sun.xml.bind.v2.model.core.ID;
import ensa.mobile.ivisitservice.beta.model.Comment;
import ensa.mobile.ivisitservice.beta.model.Post;
import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.repository.CommentRepository;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import ensa.mobile.ivisitservice.beta.service.CommentService;
import ensa.mobile.ivisitservice.beta.service.PostService;
import ensa.mobile.ivisitservice.beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/comments")
public class CommentController extends AbstractController<Long , CommentService, CommentRepository, Comment> {

    @Autowired
    private PostService postService;

    public CommentController(CommentService service) {
        super(service);
    }

    @GetMapping(value = "/post_id/{post_id:[\\d]+}", params = {"!page", "!size", "!search"})
    public List<Comment> getCommentsByPostId(@PathVariable("post_id") Long id) {
        return service.findCommentsByPostId(id);
    }

    @PostMapping("/{post_id}")
    public ResponseEntity<Comment> create(@RequestBody Comment model,@PathVariable("post_id") Long postId) throws Exception {
        Post post = postService.findById(postId).orElseThrow(() -> new Exception("No post found with id "));
        post.getComments().add(model);
        model.setPost(post);
       // postService.update(post);
        Comment savedModel = service.create(model);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
