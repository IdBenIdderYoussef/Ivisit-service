package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.Post;
import ensa.mobile.ivisitservice.beta.repository.PostRepository;
import ensa.mobile.ivisitservice.beta.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
public class PostController extends AbstractController<Long , PostService, PostRepository, Post> {
    public PostController(PostService service) {
        super(service);
    }
}
