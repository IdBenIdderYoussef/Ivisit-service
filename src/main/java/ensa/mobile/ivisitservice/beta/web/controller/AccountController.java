package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.repository.AccountRepository;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import ensa.mobile.ivisitservice.beta.service.AccountService;
import ensa.mobile.ivisitservice.beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController extends AbstractController<Long, AccountService, AccountRepository, Account> {
    public AccountController(AccountService service) {
        super(service);
    }

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/register")
    boolean register(@RequestBody Account account) {

        User user = User.builder().account(account).build();
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRoles(Arrays.asList("ROLE_USER"));
        service.create(account);
        userService.create(user);

        return true;
    }

    @RequestMapping("/findByusername")
    Account findAccountByusername(@RequestBody String username) {
        username = username.replaceAll("\"", "");
        return service.findByUsername(username);
    }

}
