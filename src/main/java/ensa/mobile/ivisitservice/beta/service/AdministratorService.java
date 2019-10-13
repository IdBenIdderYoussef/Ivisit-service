package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Administrator;
import ensa.mobile.ivisitservice.beta.repository.AdministratorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService extends AbstractService<Long , AdministratorRepository , Administrator> {

    public AdministratorService(AdministratorRepository repository) {
        super(repository);
    }
}
