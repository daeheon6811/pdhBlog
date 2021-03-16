package com.pdh.web.Controller;

import com.pdh.web.Dto.BoardDto;
import com.pdh.web.Dto.CommentDto;
import com.pdh.web.Key.CommentEntityId;
import com.pdh.web.Service.BoardService;
import com.pdh.web.Service.CommentService;
import com.pdh.web.entity.BoardEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

//게시핀 관리

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    private CommentService commentService;


    //글쓰기
    // 메인 페이지

    @GetMapping("/user/write/{type}")
    public String write(@PathVariable("type") String type, Model model) {
        model.addAttribute("type", type);
        return "boardlist/write";
    }

    //검색하기
    @GetMapping("/user/board/search/{type}")
    public String saerch(@PathVariable("type") String type,
                         Model model,
                         @RequestParam("search_value") String search_value,
                         BoardDto boardDto,
                         @PageableDefault Pageable pageable) {

        model.addAttribute("search_value", search_value);
        model.addAttribute("type", type);
        model.addAttribute("list", boardService.getBoardSearchList(pageable, search_value, type));
        return "/boardlist/board";
    }

    // 자유게시판 이동
    @GetMapping("/user/freeboard")
    public String FreeBoard(Model model, @PageableDefault Pageable pageable) {
        String type = "freeboard";
        Page<BoardEntity> boardDtoPage = boardService.getBoardList(pageable, type);
        model.addAttribute("list", boardService.getBoardList(pageable, type));
        model.addAttribute("type", "freeboard");
        return "/boardlist/board";
    }

    //글을 쓰고 난후
    @PostMapping("/user/write/result/{type}")
    public String writeresult(BoardDto boardDto,
                              @PathVariable("type") String type,
                              @AuthenticationPrincipal User user) {
        boardDto.setEmail(user.getUsername());
        boardDto.setType(type);
        boardService.write(boardDto);
        return "redirect:/user/" + type + "";
    }

    //글 보기
    @GetMapping("/user/board/view/{num}/{type}")
    public String view(BoardDto boardDto, Model model,
                       @PathVariable("num") int num,
                       @PathVariable("type") String type,
                       @PageableDefault Pageable pageable
    ) {
        boardDto = boardService.View(num, type);

        model.addAttribute("boardDto", boardDto);
        model.addAttribute("commendlist", commentService.getCommendList(pageable, num));
        model.addAttribute("commendcount", commentService.replycount(num, type));

        return "/boardlist/boardview";
    }

    // 글 수정
    @PostMapping("/user/board/update/{num}/{type}")
    public String update(@PathVariable("num") int num,
                         @PathVariable("type") String type,
                         @ModelAttribute(name = "boardDto") BoardDto boardDto,
                         Model model) {


        boardDto = boardService.View(num, type);
        boardDto.setType(type);
        boardDto.setNum(num);
        model.addAttribute("boardDto", boardDto);
        return "/boardlist/boardupdate";
    }

    // 글 수정 결과
    @PostMapping("/user/board/update/result/{num}/{type}")
    public String update_result(@PathVariable("num") int num,
                                @PathVariable("type") String type,
                                @ModelAttribute(name = "boardDto") BoardDto boardDto,
                                @AuthenticationPrincipal User user,
                                Model model) {
        boardDto = boardService.View(num, type);
        boardDto.setEmail(user.getUsername());
        boardDto.setWriteryear(LocalDateTime.now());
        boardDto.setType(type);
        boardDto.setNum(num);
        boardDto = boardService.Update(boardDto);
        System.out.println("내용값:" + boardDto.getContent());
        model.addAttribute("boardDto", boardDto);
        return "redirect:/user/board/view/{num}/{type}";
    }

    //글삭제
    @PostMapping("/user/board/delete/{num}/{type}")
    public String delete(@PathVariable("num") int num,
                         @PathVariable("type") String type,
                         BoardDto boardDto,
                         Model model) {
        boardService.Delete(boardDto);
        return "redirect:/user/freeboard";
    }

    @PostMapping("/user/board/view/{num}/{type}/comment/")
    public String comment_reply(
            @PathVariable("num") int boardnum,
            @PathVariable("type") String type,
            @ModelAttribute("CommentDto") CommentDto commentDto,
            CommentEntityId commentEntityId) {

        System.out.println(commentDto.getCommentnum() + commentDto.getBoardnum());

        commentDto.setBoardnum(boardnum);
        commentDto.setType(type);

        commentService.reply(commentDto);
        return "redirect:/user/board/view/{num}/{type}/";
    }

    @PostMapping("/user/board/view/{num}/{type}/{comment}/comment/like/")
    public String replylike(@PathVariable("num") int num,
                            @PathVariable("type") String type,
                            @PathVariable("comment") int comment
    ) {
        System.out.println("시작");
        commentService.likes(comment, num, type);
        System.out.println("끝");
        return "redirect:/user/board/view/{num}/{type}/";
    }

    @PostMapping("/user/board/view/{num}/{type}/{comment}/comment/bed/")
    public String replybed(@PathVariable("num") int num,
                           @PathVariable("type") String type,
                           @PathVariable("comment") int comment
    ) {
        System.out.println("시작");
        commentService.bed(comment, num, type);
        System.out.println("끝");
        return "redirect:/user/board/view/{num}/{type}/";
    }


    /////////////////// 글 게시판 관리
    @GetMapping("/user/A1400")
    public String A1400(Model model, @PageableDefault Pageable pageable) {
        String type = "A1400";
        Page<BoardEntity> boardDtoPage = boardService.getBoardList(pageable, type);
        model.addAttribute("list", boardService.getBoardList(pageable, type));
        model.addAttribute("type", type);
        return "/boardlist/board";
    }

    @GetMapping("/user/A1401")
    public String A1401(Model model, @PageableDefault Pageable pageable) {
        String type = "A1401";
        Page<BoardEntity> boardDtoPage = boardService.getBoardList(pageable, type);
        model.addAttribute("list", boardService.getBoardList(pageable, type));
        model.addAttribute("type", type);
        return "/boardlist/board";

    }

    @GetMapping("/user/A1402")
    public String A1402(Model model, @PageableDefault Pageable pageable) {
        String type = "A1402";
        Page<BoardEntity> boardDtoPage = boardService.getBoardList(pageable, type);
        model.addAttribute("list", boardService.getBoardList(pageable, type));
        model.addAttribute("type", type);
        return "/boardlist/board";
    }
    @GetMapping("/user/A1403")
    public String A1403(Model model, @PageableDefault Pageable pageable) {
        String type = "A1403";
        Page<BoardEntity> boardDtoPage = boardService.getBoardList(pageable, type);
        model.addAttribute("list", boardService.getBoardList(pageable, type));
        model.addAttribute("type", type);
        return "/boardlist/board";
    }

}
