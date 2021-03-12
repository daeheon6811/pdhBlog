package com.pdh.web.Dto;

import com.pdh.web.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private String email;
    private String password;
    private int warning;
    private LocalDateTime createyear;
    private String firstname;
    private String lastname;
    private String phone;
    private String location;



    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .email(email)
                .password(password)
                .warning(warning)
                .createyear(createyear)
                .firstname(firstname)
                .lastname(lastname)
                .phone(phone)
                .location(location)
                .build();
    }

    @Builder
    public MemberDto(String email, String password, int warning, LocalDateTime createyear , String firstname , String lastname , String phone , String location) {
        this.email = email;
        this.password = password;
        this.warning = warning;
        this.createyear = createyear;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.location = location;
    }
}