package com.pdh.web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ColorCodeNameListService {
    @Transactional
    public String getColorNm(){

        return "get";
    }

    @Transactional
    public String getColorCm(){

        return "get";
    }
}
