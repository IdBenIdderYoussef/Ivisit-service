package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Comment;
import ensa.mobile.ivisitservice.beta.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends AbstractService<Long , CommentRepository, Comment>{
    public CommentService(CommentRepository repository) {
        super(repository);
    }
    public List<Comment> findCommentsByPostId(Long postId){
        return repository.getAllByPostId(postId);
    }
}
