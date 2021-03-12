package com.pdh.web.Key;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
public class CommentEntityId implements Serializable {
    @Column(name = "COMMENT_NUM" , nullable = false  )
    private int num;

    @Column(name = "BOARD_NUM" , nullable = false )
    private int boardnum;
}
