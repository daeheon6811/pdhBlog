package com.pdh.web.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "IMAGE_PATH_NAMELIST")
public class ImagePathNameListEntity {

    @Id
    @Column(name ="IMAGE_KIND")
    String imagekind;

    @Column(name ="PATH")
    String path;

    @Builder
    public ImagePathNameListEntity(String imagekind, String path) {
        this.imagekind = imagekind;
        this.path = path;
    }
}
