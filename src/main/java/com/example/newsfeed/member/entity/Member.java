package com.example.newsfeed.member.entity;

import com.example.newsfeed.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name ="member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    private String nickname;

    public Member( String email, String password, String nickname) {

        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
