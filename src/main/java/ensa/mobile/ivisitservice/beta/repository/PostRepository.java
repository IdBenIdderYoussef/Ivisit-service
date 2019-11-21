package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends RepositoryWithSpecification<Post,Long> {

    @Query("SELECT post FROM Post post order by post.likes.size desc , post.comments.size desc , post.reports.size desc" )
    List<Post> findAll();

}

