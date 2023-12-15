package com.mycompany.progetto_ing_soft.exceptions;

public class DivisionByZeroException extends Exception{

    public DivisionByZeroException() {
    }

    public DivisionByZeroException(String msg) {
        super(msg);
    }
}
