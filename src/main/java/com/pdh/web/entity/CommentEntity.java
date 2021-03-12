package com.pdh.web.entity;

import com.pdh.web.Dto.CommentDto;

import com.pdh.web.Key.CommentEntityId;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity

@Table(name = "COMMENTS")
@SequenceGenerator(
        name="COMMENT_NUM_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="COMMENT_NUM_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
//@IdClass(CommentEntityId.class)
public class CommentEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_NUM_SEQ_GEN")
    @Id
    @Column(name = "COMMENT_NUM" , nullable = false  )
    private int commentnum;


    @Column(name = "BOARD_NUM" , nullable = false )
    private int boardnum;

    @Column(name = "EMAIL")
    private String email;


    @Column(name = "WRITER_YEAR")
    @CreationTimestamp
    private LocalDateTime writeryear;


    @Column(name = "COMMENTS")
    private  String comment;

    @Column(name = "LIKES")
    private int like;

    @Column(name = "BAD")
    private int bad;

    @Column(name = "TYPE")
    private String type;


    public CommentDto toDto(){
        return CommentDto.builder()
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
    public CommentEntity(int commentnum, int boardnum, String email, LocalDateTime writeryear, String comment, int like, int bad, String type) {
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
