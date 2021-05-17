package com.pdh.web.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name ="FONT_CODE_NAMELIST")
public class FontCodeNameListEntity {

    @Column(name = "FONT_CM")
    String fontcm;
    @Column(name = "FONT_NM")
    String fontnm;

    @Builder
    public FontCodeNameListEntity(String fontcm, String fontnm) {
        this.fontcm = fontcm;
        this.fontnm = fontnm;
    }
}
