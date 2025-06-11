package com.example.newsfeed.member.service;

import com.example.newsfeed.member.dto.SignUpResponseDto;
import com.example.newsfeed.member.entity.Member;
import com.example.newsfeed.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String email, String password, String nickname){
        Member member = new Member(email, password, nickname);
        memberRepository.save(member);
        return SignUpResponseDto.toDto(member,"회원가입 완료");
    }


}
