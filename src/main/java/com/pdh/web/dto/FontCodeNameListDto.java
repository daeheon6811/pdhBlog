package com.pdh.web.dto;

import com.pdh.web.entity.FontCodeNameListEntity;
import lombok.Builder;

public class FontCodeNameListDto {

    String fontcm;
    String fontnm;


    public FontCodeNameListEntity toEntity(){
        return FontCodeNameListEntity.builder()
                .fontcm(fontcm)
                .fontnm(fontnm)
                .build();

    }


    @Builder
    public FontCodeNameListDto(String fontcm, String fontnm) {
        this.fontcm = fontcm;
        this.fontnm = fontnm;
    }
}
