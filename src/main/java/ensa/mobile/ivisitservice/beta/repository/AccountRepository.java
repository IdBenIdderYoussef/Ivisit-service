package ensa.mobile.ivisitservice.beta.repository;

import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends RepositoryWithSpecification<Account, Long>{
    Optional<Account> findById(Long id);
    Optional<Account> findByUsername(String username);
}
