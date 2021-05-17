package com.pdh.web.dto;

import com.pdh.web.entity.FontCodeNameListEntity;
import com.pdh.web.entity.ImagePathNameListEntity;
import lombok.Builder;

public class ImagePathNameListDto {

    String imagekind;
    String path;


    public ImagePathNameListEntity toEntity(){
        return ImagePathNameListEntity.builder()
                .imagekind(imagekind)
                .path(path)
                .build();
    }


    public ImagePathNameListDto(String imagekind, String path) {
        this.imagekind = imagekind;
        this.path = path;
    }
}
