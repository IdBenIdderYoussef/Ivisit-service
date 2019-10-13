package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.Post;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends RepositoryWithSpecification<Post,Long> {
}
