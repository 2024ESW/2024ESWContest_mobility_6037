package com.esw.global.advice;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.esw.global.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Order(1)
public class AuthenticationExceptionHandler {
    @ExceptionHandler(value = {InsufficientAuthenticationException.class})
    public ResponseEntity<ApiResponse> insufficientAuthentication(
            InsufficientAuthenticationException e
    ){
        log.error("",e);
        var response =  ApiResponse.builder()
                .resultCode(HttpStatus.UNAUTHORIZED.name())
                .resultMessage(e.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }

    @ExceptionHandler(value = {JWTVerificationException.class})
    public ResponseEntity<ApiResponse> JwtVerification(
            JWTVerificationException e
    ){
        log.error("인증 관련 에러 : ",e);
        var response =  ApiResponse.builder()
                .resultCode(HttpStatus.BAD_REQUEST.name())
                .resultMessage("인증 관련 에러 : "+e.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
