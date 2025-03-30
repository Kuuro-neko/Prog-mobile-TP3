package com.example.prog_mobile_tp3.exceptions;

import androidx.annotation.NonNull;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("User already exists");
    }

    @NonNull
    @Override
    public String toString() {
        return "User already exists";
    }
}
