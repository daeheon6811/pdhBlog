package com.pdh.web.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;

// 권한 설정

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");

    private String value;
}
