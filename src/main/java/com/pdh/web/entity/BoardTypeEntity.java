package com.pdh.web.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "TYPE_CODE_NAMELIST")
public class BoardTypeEntity {

    @Id
    @Column(name ="TYPE_CM")
    String type_cm;

    @Column(name ="TYPE_NM")
    String type_nm;


    @Builder
    public BoardTypeEntity(String type_cm, String type_nm) {
        this.type_cm = type_cm;
        this.type_nm = type_nm;
    }
}
