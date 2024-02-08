package org.app.fitness_app.Controller;

import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.app.fitness_app.Model.User;
import org.app.fitness_app.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.registry.Registry;
import java.sql.SQLException;

@Controller
@RequestMapping("/")
@AllArgsConstructor
@Data
public class UserController {
    private AuthenticationService service;
    @PostMapping("/signIn")
    public ResponseEntity<AuthenticationResponses> Register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponses> authenticate( @RequestBody  AuthenticateRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
