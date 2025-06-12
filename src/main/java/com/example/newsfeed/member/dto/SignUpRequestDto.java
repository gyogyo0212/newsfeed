package com.example.newsfeed.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import jakarta.validation.constraints.Email;
@Getter
public class SignUpRequestDto {

    @Email(message = "유효하지 않는 이메일 형식입니다.")
    private final String email;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "비밀번호는 대소문자, 숫자, 특수문자를 최소 1자씩 포함하고 8자 이상이어야 합니다.")

    private final String password;

    private final String nickname;

    public SignUpRequestDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }


}
