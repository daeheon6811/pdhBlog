package com.pdh.web.Dto;

import com.pdh.web.entity.BoardEntity;
import com.pdh.web.entity.MemberEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


// 게시판 dto

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private int num;
    private  String email;
    private  LocalDateTime writeryear;
    private  int views;
    private  String title;
    private  String content;
    private int like;
    private int bad;
    private String type;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .num(num)
                .email(email)
                .views(views)
                .writeryear(writeryear)
                .title(title)
                .content(content)
                .like(like)
                .bad(bad)
                .type(type)
                .build();
    }

    @Builder
    public BoardDto(int num, String email, int views , LocalDateTime writeryear, String title, String content, int like, int bad , String type) {
        this.num = num;
        this.email = email;
        this.writeryear = writeryear;
        this.views = views;
        this.title = title;
        this.content = content;
        this.like = like;
        this.bad = bad;
        this.type = type;
    }
}
