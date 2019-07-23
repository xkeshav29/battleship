package com.myapp.exception;

public class InvalidCellException extends RuntimeException {

    private int x;
    private int y;

    public InvalidCellException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
