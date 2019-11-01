package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.repository.AccountRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<Long , AccountRepository, Account> {
    public AccountService(AccountRepository repository) {
        super(repository);
    }

    public Account findByUsername(String username) {
        Account account = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username or email : "+username));
        return account;
    }
}
