package com.esw.global.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DatabaseRuntimeException extends RuntimeException{
    public DatabaseRuntimeException(String msg){
        super(msg);
    }
}
