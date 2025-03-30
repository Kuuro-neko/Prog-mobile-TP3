package com.example.prog_mobile_tp3.exceptions;

import androidx.annotation.NonNull;

public class PasswordRulesException extends Exception {
    public PasswordRulesException() {
        super("Password must be at least 6 characters long");
    }

    @NonNull
    @Override
    public String toString() {
        return "Password must be at least 6 characters long";
    }
}
