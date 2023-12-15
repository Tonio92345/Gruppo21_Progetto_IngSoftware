package com.mycompany.progetto_ing_soft.exceptions;

public class NotInitializedVarException extends Exception{

    public NotInitializedVarException() {
    }

    public NotInitializedVarException(String msg) {
        super(msg);
    }
}
