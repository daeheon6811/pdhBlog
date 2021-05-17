package com.pdh.web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RoleCodeNameListService {

    @Transactional
    public String getRoleNm(){

        return "get";
    }

    @Transactional
    public String getRoleCm(){

        return "get";
    }
}
