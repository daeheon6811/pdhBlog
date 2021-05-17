package com.pdh.web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TypeCodeNameListService {
    @Transactional
    public String getTypeNm(){

        return "get";
    }

    @Transactional
    public String getTypeCm(){

        return "get";
    }

}
