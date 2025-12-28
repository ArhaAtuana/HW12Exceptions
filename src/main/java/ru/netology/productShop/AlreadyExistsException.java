package ru.netology.productShop;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String msg) {

        super(msg);
    }

}
