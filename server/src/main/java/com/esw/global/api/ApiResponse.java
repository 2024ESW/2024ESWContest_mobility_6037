package com.esw.global.api;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;

    private String resultCode;
    private String resultMessage;
}
