package com.pdh.web.controller;

import com.pdh.web.entity.BoardEntity;
import com.pdh.web.service.BoardService;
import com.pdh.web.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



//게시판 종류
@Controller
public class BoardKindController{
    BoardService boardService;

    @GetMapping("/user/A1403")
    public String a1403(Model model, @PageableDefault Pageable pageable) {
        String type = "A1403";
        Page<BoardEntity> boardDtoPage = boardService.getBoardList(pageable, type);
        model.addAttribute("list", boardService.getBoardList(pageable, type));
        model.addAttribute("type", type);
        return "/boardscreen/board";
    }
}
