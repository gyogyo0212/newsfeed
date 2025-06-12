package com.example.newsfeed.member.service;

import com.example.newsfeed.config.PasswordEncoder;
import com.example.newsfeed.exception.member.DuplicateEmailException;
import com.example.newsfeed.login.dto.LoginRequestDto;
import com.example.newsfeed.member.dto.SignUpResponseDto;
import com.example.newsfeed.member.entity.Member;
import com.example.newsfeed.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;// 비밀번호 암호화

    public SignUpResponseDto signUp(String email, String password, String nickname){
        if (memberRepository.existsByEmail(email)) {
            throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
        }
        String encodedPassword = passwordEncoder.encode(password);//비밀번호 암호화
        Member member = new Member(email, password, nickname);
        memberRepository.save(member);
        return SignUpResponseDto.toDto(member,"회원가입 완료");
    }


}
