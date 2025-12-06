package io.exp.objects;

public class LoginResult {
    public final boolean success;
    public final String message;

    public LoginResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}