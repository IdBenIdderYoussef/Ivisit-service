package ensa.mobile.ivisitservice.beta.web.controller;


import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.Administrator;
import ensa.mobile.ivisitservice.beta.repository.AccountRepository;
import ensa.mobile.ivisitservice.beta.repository.AdministratorRepository;
import ensa.mobile.ivisitservice.beta.service.AccountService;
import ensa.mobile.ivisitservice.beta.service.AdministratorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/administrators")
public class AdministratorController extends AbstractController<Long , AdministratorService, AdministratorRepository, Administrator> {
    public AdministratorController(AdministratorService service) {
        super(service);
    }
}
