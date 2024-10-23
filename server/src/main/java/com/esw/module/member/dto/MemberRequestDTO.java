package com.esw.module.member.dto;

import lombok.*;

public class MemberRequestDTO {

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignUp {
        private String email;
        private String password;
        private String name;
    }
}
