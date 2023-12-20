package com.pdv.serviceException;

public class NegocioException extends RuntimeException {

    public NegocioException(String msg){
        super(msg);
    }
}
