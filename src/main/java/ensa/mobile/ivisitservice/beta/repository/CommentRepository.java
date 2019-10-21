package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends RepositoryWithSpecification<Comment , Long> {
    public List<Comment> getAllByPostId(Long postId);
}
