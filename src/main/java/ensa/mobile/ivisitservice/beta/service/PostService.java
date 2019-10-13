package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Post;
import ensa.mobile.ivisitservice.beta.repository.PostRepository;
import org.springframework.stereotype.Service;


@Service
public class PostService extends AbstractService<Long , PostRepository, Post> {
    public PostService(PostRepository repository) {
        super(repository);
    }
}
