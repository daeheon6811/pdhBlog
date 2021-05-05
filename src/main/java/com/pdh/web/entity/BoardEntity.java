package com.pdh.web.entity;

import com.pdh.web.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "BOARD")
@SequenceGenerator(
        name="NUM_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="NUM_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class BoardEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NUM_SEQ_GEN")
    @Id
    @Column(name = "NUM" , nullable = false)
    private int num;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "VIEWS")
    private  int views;

    @Column(name = "WRITER_YEAR")
    @CreationTimestamp
    private  LocalDateTime writeryear;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private  String content;

    @Column(name = "LIKES")
    private int like;

    @Column(name = "BAD")
    private int bad;

    @Column(name = "TYPE")
    private String type;

    public BoardDto toDto(){
        return BoardDto.builder()
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
    public BoardEntity(int num, String email,  int views ,LocalDateTime writeryear,String title, String content, int like, int bad ,
                       String type) {
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
