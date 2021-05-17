package com.pdh.web.dto;

import com.pdh.web.entity.TypeCodeNameListEntity;
import lombok.Builder;

public class TypeCodeNameListDto {
    String typecm;
    String typenm;


    private TypeCodeNameListEntity toEntity(){
        return TypeCodeNameListEntity.builder()
                .typecm(typecm)
                .typenm(typenm)
                .build();
    }


    @Builder
    public TypeCodeNameListDto(String typecm, String typenm) {
        this.typecm = typecm;
        this.typenm = typenm;
    }
}
