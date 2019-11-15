package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.model.dto.UpdateUserDTO;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import ensa.mobile.ivisitservice.beta.service.AccountService;
import ensa.mobile.ivisitservice.beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController extends AbstractController<Long, UserService, UserRepository, User> {

    @Autowired
    private AccountService accountService;

    public UserController(UserService service) {
        super(service);
    }

    @PostMapping("/update")
    boolean update(@RequestBody UpdateUserDTO userDTO) {

        Account account = accountService.findById(userDTO.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> id : " + userDTO.getId()));

        System.out.println(account.getId());

        User user = service.findByAccountId(account.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        service.update(user);

        return true;
    }

}
