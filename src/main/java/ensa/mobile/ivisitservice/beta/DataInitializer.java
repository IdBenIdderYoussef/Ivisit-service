package ensa.mobile.ivisitservice.beta;


import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.Comment;
import ensa.mobile.ivisitservice.beta.model.Post;
import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.service.AccountService;
import ensa.mobile.ivisitservice.beta.service.CommentService;
import ensa.mobile.ivisitservice.beta.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {



    private final PostService postService;
    private final CommentService commentService;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public DataInitializer(PostService postService, CommentService commentService, AccountService accountService, PasswordEncoder passwordEncoder) {
        this.postService = postService;
        this.commentService = commentService;
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Account account = Account.builder().email("admin@mail.com").username("admin").password(
                this.passwordEncoder.encode("admin")).roles(Arrays.asList("ROLE_ADMIN"))
                .build();
        accountService.create(account);
        User user = User.builder().account(account).firstName("youssef").lastName("idder").build();
        User user1 = User.builder().account(account).firstName("aniss").lastName("mbk").build();

        Post post = Post.builder().description("So here's what happened... Apparently we were so engaged in tonight " +
                "meetup that we forgot to take any picture! But it was nice, packed and dark thanks everyone who joined," +
                " please feel free to follow with any").title("Marrakech City").build();


        Comment comment = Comment.builder().content("this is a good place !!").post(post).build();
        Comment comment1 = Comment.builder().content("this is a good place !!").post(post).build();

        post.getComments().add(comment);
        post.getComments().add(comment1);

        postService.create(post);
        commentService.create(comment);
        commentService.create(comment1);


        Post post1 = Post.builder().description("Tu es doué en programmation ? Et tu es à la recherche d'une nouvelle " +
                "opportunité professionnelle ? Notre campagne de recrutement te permet de postuler pour un CDI en France" +
                " auprès de l'une de nos SSII partenaires.").title("Oued Zem : Madina chohada2").build();
        postService.create(post1);


    }
}
