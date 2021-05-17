package com.pdh.web.entity;

import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Controller
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "ROLE_CODE_NAMELIST")
public class RoleCodeNameListEntity {

    @Id
    @Column(name = "ROLE_CM")
    String rolecm;

    @Column(name = "ROLE_NM")
    String rolenm;

    @Builder
    public RoleCodeNameListEntity(String rolecm, String rolenm) {
        this.rolecm = rolecm;
        this.rolenm = rolenm;
    }
}
