package com.pdh.web;

import com.pdh.web.dto.BoardDto;
import com.pdh.web.service.BoardService;
import com.pdh.web.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CURD
{
    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;


    @Test
    public void insertTest() throws Exception
    {


        BoardDto boardDto = new BoardDto();
        int i =0;
        while(i < 10000)
        {
            i++;
            boardDto.setNum(i+10);
            boardDto.setBad(0);
            boardDto.setLike(0);
            boardDto.setViews(0);
            boardRepository.save(boardDto.toEntity());
        }
    }




}
