package com.pdh.web.dto;

import com.pdh.web.entity.BoardInfoEntity;
import lombok.*;

// 게시판 정보 DTO

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
