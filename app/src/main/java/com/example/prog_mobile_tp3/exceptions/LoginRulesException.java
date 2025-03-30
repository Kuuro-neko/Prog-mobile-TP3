package com.example.prog_mobile_tp3.exceptions;

import androidx.annotation.NonNull;

public class LoginRulesException extends Exception {
    public LoginRulesException() {
        super("Login must start with a letter and be at most 10 characters long");
    }

    @NonNull
    @Override
    public String toString() {
        return "Login must start with a letter and be at most 10 characters long";
    }
}
