package com.example.newsfeed.member.controller;

import com.example.newsfeed.member.dto.SignUpRequestDto;
import com.example.newsfeed.member.dto.SignUpResponseDto;
import com.example.newsfeed.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<SignUpResponseDto>signUp(@RequestBody SignUpRequestDto requestDto){
        SignUpResponseDto signUpResponseDto =
                memberService.signUp(
                        requestDto.getEmail(),
                        requestDto.getPassword(),
                        requestDto.getNickname()
                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }
}
