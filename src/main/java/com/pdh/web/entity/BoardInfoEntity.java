package com.pdh.web.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "BOARD_INFO")
public class BoardInfoEntity {

    @Id
    @Column(name = "EMAIL")
    String email;

    @Column(name = "MYPOST")
    int post;

    @Column(name = "MYLIKES")
    int like;

    @Column(name = "MYSHARE")
    int share;


    @Builder
    public BoardInfoEntity(String email, int post, int like, int share) {
        this.email = email;
        this.post = post;
        this.like = like;
        this.share = share;
    }
}
