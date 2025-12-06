package io.exp.api;

import io.exp.objects.LoginResult;
import org.springframework.stereotype.Component;

@Component
public class ApiClient {

    public LoginResult login(String username, String password) {
        if ("admin".equals(username) && "motdepasse123".equals(password)) {
            return new LoginResult(true, "Welcome, " + username + "!");
        } else {
            return new LoginResult(false, "Échec de la connexion.");
        }
    }
}