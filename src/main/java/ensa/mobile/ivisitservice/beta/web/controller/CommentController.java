package ensa.mobile.ivisitservice.beta.web.controller;


import com.sun.xml.bind.v2.model.core.ID;
import ensa.mobile.ivisitservice.beta.model.Comment;
import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.repository.CommentRepository;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import ensa.mobile.ivisitservice.beta.service.CommentService;
import ensa.mobile.ivisitservice.beta.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
public class CommentController extends AbstractController<Long , CommentService, CommentRepository, Comment> {
    public CommentController(CommentService service) {
        super(service);
    }

    @GetMapping(value = "/post_id/{post_id:[\\d]+}", params = {"!page", "!size", "!search"})
    public List<Comment> getCommentsByPostId(@PathVariable("post_id") Long id) {
        return service.findCommentsByPostId(id);
    }

}
