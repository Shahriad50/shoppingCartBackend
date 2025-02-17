package com.dreamshopbackend.demo.service;

import com.dreamshopbackend.demo.Controller.AuthenticationRequest;
import com.dreamshopbackend.demo.Controller.AuthenticationResponse;
import com.dreamshopbackend.demo.Controller.RegisterRequest;
import com.dreamshopbackend.demo.config.JwtService.JwtService;
import com.dreamshopbackend.demo.repository.UserRepository;
import com.dreamshopbackend.demo.entity.Role;
import com.dreamshopbackend.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;



    public AuthenticationResponse register(RegisterRequest request){
        var user= User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         request.getEmail(),
                         request.getPassword()
                 )

         );
         var user=repository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
