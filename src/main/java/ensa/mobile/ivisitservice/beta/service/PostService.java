package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Post;
import ensa.mobile.ivisitservice.beta.repository.PostRepository;
import javafx.geometry.Pos;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService extends AbstractService<Long , PostRepository, Post> {
    public PostService(PostRepository repository) {
        super(repository);
    }

    public List<Post> findAll(){
        return repository.findAll();
    }
}
