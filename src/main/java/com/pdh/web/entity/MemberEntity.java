package com.pdh.web.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "MEMBER")
public class MemberEntity {

    @Id
    @Column(name = "EMAIL" , nullable = false)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "WARNING")
    private int warning;

    @Column(name = "CREATE_YEAR")
    @CreationTimestamp
    private LocalDateTime createyear;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "LOCATION")
    private String location;

    @Builder
    public MemberEntity(String email , String password, int warning , LocalDateTime createyear , String firstname , String lastname , String phone, String location ){
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
