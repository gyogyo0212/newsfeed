package com.example.newsfeed.member.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private final String email;


    private final String password;

    private final String nickname;

    public SignUpRequestDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }


}
