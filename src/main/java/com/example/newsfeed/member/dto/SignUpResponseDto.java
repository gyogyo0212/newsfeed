package com.example.newsfeed.member.dto;

import com.example.newsfeed.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto {

    private Long id;


    private String message;

    public static SignUpResponseDto toDto(Member member, String message) {
        return new SignUpResponseDto(member.getId(), message);
    }
}
