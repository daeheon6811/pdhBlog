package com.pdh.web.controller;

import com.pdh.web.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

// 댓글

@Controller
@AllArgsConstructor
public class CommentController {
    CommentService commentService;



}
