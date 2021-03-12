package com.pdh.web.Controller;

import com.pdh.web.Service.BoardService;
import com.pdh.web.Service.CommentService;
import com.pdh.web.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BoardKindController {
    private BoardService boardService;
    private CommentService commentService;

}
