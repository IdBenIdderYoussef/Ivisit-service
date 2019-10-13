package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import ensa.mobile.ivisitservice.beta.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController extends AbstractController<Long , UserService , UserRepository , User> {
    public UserController(UserService service) {
        super(service);
    }
}
