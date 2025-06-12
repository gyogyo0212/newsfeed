package com.example.newsfeed.login.service;

import com.example.newsfeed.exception.login.LoginFailException;
import com.example.newsfeed.exception.member.DuplicateEmailException;
import com.example.newsfeed.login.dto.LoginRequestDto;
import com.example.newsfeed.login.dto.LoginResponseDto;
import com.example.newsfeed.member.entity.Member;
import com.example.newsfeed.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public LoginRequestDto login(String email, String password) {

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new LoginFailException("이메일 또는 비밀번호가 일치하지 않습니다."));
    }

        return new LoginResponseDto(accessToken);

}
}
