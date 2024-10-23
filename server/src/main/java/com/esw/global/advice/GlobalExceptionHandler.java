package com.esw.global.advice;

import com.esw.global.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(2)
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ApiResponse> untracked(
            RuntimeException e
    ){
        log.error("기록되지 않은 새로운 예외 발생 : ",e);
        var response =  ApiResponse.builder()
                .resultCode(HttpStatus.SERVICE_UNAVAILABLE.name())
                .resultMessage(e.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }
}
