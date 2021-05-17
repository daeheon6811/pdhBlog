package com.pdh.web.dto;

import com.pdh.web.entity.BoardTypeEntity;
import lombok.*;

//게시판 Type dto

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardTypeDto {

    String boardtypecm;
    String boardtypenm;

    ;


    public BoardTypeEntity toEntity(){
        return BoardTypeEntity.builder()
                .boardtypecm(boardtypecm)
                .boardtypenm(boardtypenm)
                .build();
    }

    @Builder
    public BoardTypeDto(String boardtypecm, String boardtypenm) {
        this.boardtypecm = boardtypecm;
        this.boardtypenm = boardtypenm;
    }
}
