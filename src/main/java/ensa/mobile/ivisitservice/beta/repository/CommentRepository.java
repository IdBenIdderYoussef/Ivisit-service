package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.Comment;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends RepositoryWithSpecification<Comment , Long> {
}
