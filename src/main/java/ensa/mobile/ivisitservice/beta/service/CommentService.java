package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Comment;
import ensa.mobile.ivisitservice.beta.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends AbstractService<Long , CommentRepository, Comment>{
    public CommentService(CommentRepository repository) {
        super(repository);
    }
}
