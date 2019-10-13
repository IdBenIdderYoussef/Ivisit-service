package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends RepositoryWithSpecification<User, Long> {
}
