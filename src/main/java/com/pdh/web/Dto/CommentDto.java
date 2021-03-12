package com.pdh.web.Dto;

import com.pdh.web.entity.CommentEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentDto {

    private int commentnum;
    private int boardnum;
    private String email;
    private LocalDateTime writeryear;
    private  String comment;
    private int like;
    private int bad;
    private String type;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
                .commentnum(commentnum)
                .boardnum(boardnum)
                .email(email)
                .writeryear(writeryear)
                .comment(comment)
                .like(like)
                .bad(bad)
                .type(type)
                .build();
    }


    @Builder
    public CommentDto(int commentnum, int boardnum, String email, LocalDateTime writeryear, String comment, int like, int bad, String type) {
        this.commentnum = commentnum;
        this.boardnum = boardnum;
        this.email = email;
        this.writeryear = writeryear;
        this.comment = comment;
        this.like = like;
        this.bad = bad;
        this.type = type;
    }
}
