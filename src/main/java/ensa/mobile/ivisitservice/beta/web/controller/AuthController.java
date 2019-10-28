package ensa.mobile.ivisitservice.beta.web.controller;

import ensa.mobile.ivisitservice.beta.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signout")
    public void signOut() {

    }

    /*@PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto user) {
        User updatedModel = authService.changePassword(user);
        if(updatedModel != null)
            return new ResponseEntity<>(updatedModel , HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
