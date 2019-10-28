package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends RepositoryWithSpecification<User, Long> {

}
