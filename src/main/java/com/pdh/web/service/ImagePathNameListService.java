package com.pdh.web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ImagePathNameListService {
    @Transactional
    public String getImageKind(){

        return "get";
    }

    @Transactional
    public String getPath(){

        return "get";
    }

}
