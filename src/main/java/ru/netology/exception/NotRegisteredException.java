package ru.netology.exception;

public class NotRegisteredException extends NullPointerException {
    public NotRegisteredException(String msg) {
        super(msg);
    }
}
