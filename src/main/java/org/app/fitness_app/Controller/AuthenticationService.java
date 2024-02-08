package org.app.fitness_app.Controller;

import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.app.fitness_app.Model.User;
import org.app.fitness_app.Repository.UserInterface;
import org.app.fitness_app.Security.JwtService;
import org.app.fitness_app.Security.SecurityModel.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserInterface repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponses register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .role(Role.CLIENT)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateTokens(user);
        return AuthenticationResponses.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponses  authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Optional<User> userOptional = Optional.ofNullable(repository.findByEmail(request.getEmail()));
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new UsernameNotFoundException("User not found");
        }


        var jwtToken = jwtService.generateTokens(user);
        return AuthenticationResponses.builder()
                .token(jwtToken)
                .build();
    }
}

