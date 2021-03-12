package com.pdh.web.Dto;

import com.pdh.web.entity.BoardInfoEntity;
import com.pdh.web.entity.BoardTypeEntity;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardInfoDto {

    String email;
    int post;
    int like;
    int share;


    public BoardInfoEntity toEntity(){
        return BoardInfoEntity.builder()
                .email(email)
                .post(post)
                .like(like)
                .share(share)
                .build();
    }

    @Builder
    public BoardInfoDto(String email, int post, int like, int share) {
        this.email = email;
        this.post = post;
        this.like = like;
        this.share = share;
    }
}
