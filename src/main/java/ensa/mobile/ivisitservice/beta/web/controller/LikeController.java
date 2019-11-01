package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.Like;
import ensa.mobile.ivisitservice.beta.model.Post;
import ensa.mobile.ivisitservice.beta.repository.LikeRepository;
import ensa.mobile.ivisitservice.beta.service.AccountService;
import ensa.mobile.ivisitservice.beta.service.LikeService;
import ensa.mobile.ivisitservice.beta.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/likes")
public class LikeController extends AbstractController<Long , LikeService, LikeRepository, Like> {

    @Autowired
    private PostService postService;

    public LikeController(LikeService service) {
        super(service);
    }



    @PostMapping("/{post_id}")
    public ResponseEntity<Like> create(@RequestBody Like model,@PathVariable("post_id") Long postId) throws Exception {
        Post post = postService.findById(postId).orElseThrow(() -> new Exception("No post found with id "));
        post.getLikes().add(model);
        model.setPost(post);
       // postService.update(post);
        Like savedModel = service.create(model);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @Transactional
    @PostMapping("/{username}/{postId:[\\d]+}")
    public void delete(@PathVariable String username ,@PathVariable Long postId) {
        service.delete(username,postId);
    }


}
