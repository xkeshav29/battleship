package com.myapp.exception;

public class TargetAlreadyAttackedException extends RuntimeException {

    public TargetAlreadyAttackedException(String message) {
        super(message);
    }

}
