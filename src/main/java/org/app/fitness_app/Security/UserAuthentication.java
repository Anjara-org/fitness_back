package org.app.fitness_app.Security;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.app.fitness_app.Model.User;
import org.app.fitness_app.Repository.UserInterface;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class UserAuthentication implements AuthenticationProvider {
    private UserInterface repository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = repository.findByEmail(email);

        if( user != null && user.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(
                    email,
                    password
            );
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
