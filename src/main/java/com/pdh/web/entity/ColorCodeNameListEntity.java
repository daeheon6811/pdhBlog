package com.pdh.web.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name ="COLOR_CODE_NAMELIST")
public class ColorCodeNameListEntity {

    @Id
    @Column(name = "COLOR_CM")
    String colorcm;

    @Column(name ="COLOR_NM")
    String colornm;

    @Builder
    public ColorCodeNameListEntity(String colorcm, String colornm) {
        this.colorcm = colorcm;
        this.colornm = colornm;
    }
}
