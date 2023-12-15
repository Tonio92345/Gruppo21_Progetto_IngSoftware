package com.mycompany.progetto_ing_soft.exceptions;

public class StackEmptyException extends Exception{

    public StackEmptyException() {
    }

    public StackEmptyException(String msg) {
        super(msg);
    }
}
