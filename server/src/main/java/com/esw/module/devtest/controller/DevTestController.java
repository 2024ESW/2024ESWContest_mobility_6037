package com.esw.module.devtest.controller;

import com.esw.global.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/dev/test")
@RequiredArgsConstructor
public class DevTestController {
    @GetMapping()
    public ApiResponse<?> devTestApi(){
        return ApiResponse.builder()
                .resultCode(HttpStatus.OK.name())
                .resultMessage("조회 성공")
                .data(LocalDateTime.now().toString())
                .build();
    }
}
