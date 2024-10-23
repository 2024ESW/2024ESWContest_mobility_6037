package com.esw.global.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Slf4j

public class AuthenticationExceptionFilter extends OncePerRequestFilter {
    private final HandlerExceptionResolver resolver;

    public AuthenticationExceptionFilter(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response); // JwtAuthenticationProcessingFilter 이동
        } catch (Exception ex) {
            log.info("setErrorResponse 호출");
            request.setAttribute("exception",ex);
            setErrorResponse(request, response, ex);

        }
    }

        private void setErrorResponse(HttpServletRequest request, HttpServletResponse response, Exception ex) {
            resolver.resolveException(request, response, null,(Exception) request.getAttribute("exception"));
        }

    }
