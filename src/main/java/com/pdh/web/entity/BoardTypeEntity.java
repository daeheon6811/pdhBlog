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
    String boardtypecm;

    @Column(name ="TYPE_NM")
    String boardtypenm;


    @Builder
    public BoardTypeEntity(String boardtypecm, String boardtypenm) {
        this.boardtypecm = boardtypecm;
        this.boardtypenm = boardtypenm;
    }
}
