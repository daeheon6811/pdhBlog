package com.pdh.web.entity;


import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Controller
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "TYPE_CODE_NAMELIST")
public class TypeCodeNameListEntity {
    @Id
    @Column(name = "TYPE_CM")
    String typecm;

    @Column(name = "TYPE_NM")
    String typenm;

    @Builder
    public TypeCodeNameListEntity(String typecm, String typenm) {
        this.typecm = typecm;
        this.typenm = typenm;
    }


}
