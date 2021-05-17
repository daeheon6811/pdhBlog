package com.pdh.web.dto;

import com.pdh.web.entity.ColorCodeNameListEntity;
import lombok.Builder;

public class ColorCodeNameListDto {
    String colorcm;
    String colornm;


    public ColorCodeNameListEntity toEntity() {
        return ColorCodeNameListEntity.builder()
                .colorcm(colorcm)
                .colornm(colornm)
                .build();

    }

    @Builder
    public ColorCodeNameListDto(String colorcm, String colornm) {
        this.colorcm = colorcm;
        this.colornm = colornm;
    }
}
