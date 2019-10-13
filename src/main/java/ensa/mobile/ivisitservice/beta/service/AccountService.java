package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<Long , AccountRepository, Account> {
    public AccountService(AccountRepository repository) {
        super(repository);
    }
}
