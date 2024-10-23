package com.esw.global.advice;

import com.esw.global.api.ApiResponse;
import com.esw.global.exception.DatabaseRuntimeException;
import com.esw.global.exception.EntityNotFoundException;
import com.esw.global.exception.UnauthorizedRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Order(0)
public class RuntimeExceptionHandler {
    @ExceptionHandler(value = {DatabaseRuntimeException.class})
    public ResponseEntity<ApiResponse> DatabaseRuntime(
            DatabaseRuntimeException e
    ){
        log.error("",e);
        var response =  ApiResponse.builder()
                .resultCode(HttpStatus.BAD_REQUEST.name())
                .resultMessage(e.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(value = {UnauthorizedRequestException.class})
    public ResponseEntity<ApiResponse> UnauthorizedRequest(
            UnauthorizedRequestException e
    ){
        log.error("",e);
        var response =  ApiResponse.builder()
                .resultCode(HttpStatus.BAD_REQUEST.name())
                .resultMessage(e.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ApiResponse> EntityNotFound(
            EntityNotFoundException e
    ){
        log.error("",e);
        var response =  ApiResponse.builder()
                .resultCode(HttpStatus.BAD_REQUEST.name())
                .resultMessage(e.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
