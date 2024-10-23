package com.esw.module.member.service;


import com.esw.global.exception.UnauthorizedRequestException;
import com.esw.module.member.dto.MemberRequestDTO;
import com.esw.module.member.entities.Member;
import com.esw.module.member.enums.Role;
import com.esw.module.member.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(MemberRequestDTO.SignUp request) {

        if (memberRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UnauthorizedRequestException("이미 존재하는 이메일입니다.");
        }

//        if (memberRepository.findByNickname(userSignUpDto.getNickname()).isPresent()) {
//            throw new Exception("이미 존재하는 닉네임입니다.");
//        }

        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.MEMBER)
                .name(request.getName())
                .build();

        member.passwordEncode(passwordEncoder);
        memberRepository.save(member);
    }
}
