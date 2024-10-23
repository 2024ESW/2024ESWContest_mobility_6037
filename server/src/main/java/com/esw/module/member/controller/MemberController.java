package com.esw.module.member.controller;

import com.esw.module.member.dto.MemberRequestDTO;
import com.esw.module.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
public class MemberController {
    private final MemberService service;

    @PostMapping("signup")
    public String signUp(@RequestBody MemberRequestDTO.SignUp request) throws Exception {
        service.signUp(request);
        return "회원가입 성공";
    }

}
