package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.Like;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeRepository extends RepositoryWithSpecification<Like, Long> {

    public void deleteByCreatedByAndPostId(Account createdBY, Long postId);

}
