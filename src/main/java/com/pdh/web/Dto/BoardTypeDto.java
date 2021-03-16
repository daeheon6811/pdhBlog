package com.pdh.web.Dto;

import com.pdh.web.entity.BoardEntity;
import com.pdh.web.entity.BoardTypeEntity;
import lombok.*;

//게시판 Type Dto

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardTypeDto {

    String type_cm;
    String type_nm;


    public BoardTypeEntity toEntity(){
        return BoardTypeEntity.builder()
                .type_cm(type_cm)
                .type_nm(type_nm)
                .build();
    }

    @Builder
    public BoardTypeDto(String type_cm, String type_nm) {
        this.type_cm = type_cm;
        this.type_nm = type_nm;
    }
}
