package ensa.mobile.ivisitservice.beta.security.jwt;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import ensa.mobile.ivisitservice.beta.model.Account;
import ensa.mobile.ivisitservice.beta.model.User;
import ensa.mobile.ivisitservice.beta.repository.AccountRepository;
import ensa.mobile.ivisitservice.beta.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static ensa.mobile.ivisitservice.beta.security.SecurityConstants.*;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private AccountRepository accountRepository;

    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager ,
                                   AccountRepository accountRepository , UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            Account credentials = new ObjectMapper().readValue(req.getInputStream(), Account.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getUsername(),
                            credentials.getPassword(),
                            credentials.getAuthorities())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        Account account = (Account) auth.getPrincipal();
        String jsonUser = new Gson().toJson(account);

        List<String> userRoles = ((Account) auth.getPrincipal()).getRoles();
        String[] roles = userRoles.toArray(new String[userRoles.size()]);

        String token = JWT.create()
                .withClaim("userid", ((Account) auth.getPrincipal()).getId())
                .withArrayClaim("roles",roles)
                .withSubject(((Account) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));

        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        /*res.getWriter().write("{\"token\": \"" + token + "\"}");*/
        res.getWriter().write("{\"token\": \"" + token + "\"," +
                "\"user\" :"+jsonUser+"}");
    }
}