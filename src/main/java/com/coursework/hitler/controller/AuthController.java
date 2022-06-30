package com.coursework.hitler.controller;


import com.coursework.hitler.Model.Account;
import com.coursework.hitler.jwt.TokenUtil;
import com.coursework.hitler.service.AccountService;
import com.coursework.hitler.Model.UserAuthData;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/authenticate")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenUtil tokenUtil;
    private final AccountService accountsService;


    public AuthController(AuthenticationManager authenticationManager,
                                    TokenUtil tokenUtil,
                                    AccountService accountsService) {
        this.authenticationManager = authenticationManager;
        this.tokenUtil = tokenUtil;
        this.accountsService = accountsService;
    }
    @PostMapping
    public ResponseEntity<String> createAuthenticationToken(@RequestBody UserAuthData authenticationRequest) {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            Account user = accountsService.getByUsername(authenticationRequest.getUsername());
            final String token = tokenUtil.generateToken(user);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }

}
