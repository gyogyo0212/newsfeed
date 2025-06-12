package com.example.newsfeed.login.service;

import com.example.newsfeed.login.dto.LoginRequestDto;
import com.example.newsfeed.member.entity.Member;
import com.example.newsfeed.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    public MemberRepository memberRepository;

    public LoginRequestDto login(String email, String password){
       Member member= memberRepository.findByEmail(email);
    }
}
