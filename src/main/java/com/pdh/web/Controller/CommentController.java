package com.pdh.web.Controller;

import com.pdh.web.Dto.BoardDto;
import com.pdh.web.Service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class CommentController {
    CommentService commentService;



}
