package com.pdh.web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class FontCodeNameListService {
    @Transactional
    public String getFontNm(){

        return "get";
    }

    @Transactional
    public String getFontCm(){

        return "get";
    }
}
