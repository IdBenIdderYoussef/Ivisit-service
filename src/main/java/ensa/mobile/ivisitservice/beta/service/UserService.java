package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService extends AbstractService<Long , UserRepository, User> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
