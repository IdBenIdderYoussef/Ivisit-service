package ensa.mobile.ivisitservice.beta.service;

import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.Like;
import ensa.mobile.ivisitservice.beta.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService extends AbstractService<Long , LikeRepository, Like>{

    @Autowired
    private AccountService accountService;

    public LikeService(LikeRepository repository) {
        super(repository);
    }

    public void delete(String username , Long postId ){
        Account createdBy = accountService.findByUsername(username);
        repository.deleteByCreatedByAndPostId(createdBy,postId);
    }
}
