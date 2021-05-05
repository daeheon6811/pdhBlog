package com.pdh.web.controller;

import com.pdh.web.dto.MemberDto;
import com.pdh.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// 유저 정보

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/main/resources";
    }
    // 회원가입 페이지
    @GetMapping("/user/register")
    public String dispSignup() {
        return "/register";
    }


    // 회원가입 처리
    @PostMapping("/user/register")
    public String execSignup(@ModelAttribute(name = "memberDto")  MemberDto memberDto) {

         String result = memberService.getJoinUser(memberDto);
         if(result.equals("존재"))
         {
             return "/register";
         }else{
             return "/login";
         }
    }
    @GetMapping("/user/forgot-password")
    public String  forgotPassword() {
        return "/forgot-password";
    }


    @PostMapping("/user/forgot-password")
    public String emailSearch(@ModelAttribute(name = "memberDto")  MemberDto memberDto){


        String result = memberService.getSearchEmail(memberDto);
        if (result.equals("이메일성공")) {
            return "/rename-password";
        } else {
            return "/login";
        }
    }
    @GetMapping("/user/rename-password")
    public String  renamePassword() {
        return "/rename-password";
    }


    // 비밀번호 찾기 (미구현)
    @PostMapping("/user/rename-password")
    public String renamePasswordClear(@ModelAttribute(name = "memberDto")
                                            @PathVariable("email") String email,
                                                    MemberDto memberDto){

        memberDto.setEmail(email);
       memberService.getRenamePassword(memberDto);
            return "/login";

    }
    // 로그인 결과 페이지
    @RequestMapping(value = "/user/login" )
    public String loginResult(@ModelAttribute(name = "memberDto")  MemberDto memberDto,
    @AuthenticationPrincipal MemberDto atpmemberDto , Model model) {
     //    String result = memberService.CheckPassword(memberDto);
      //  int result = memberService.CheckPassword(atpmemberDto);
        return "/login";

    }

    // 로그인 결과 페이지
    @RequestMapping(value ="/user/login/result")
    public String login(@ModelAttribute MemberDto memberDto,
                              @AuthenticationPrincipal MemberDto atpmemberDto , Model model) {
             return "/boardlist/index";

    }

    @GetMapping("/user/myinfo")
    public String myInfo(@AuthenticationPrincipal User user , Model model) {

        MemberDto memberDto = memberService.getMyInformation(user);
        model.addAttribute("memberDto",memberDto);

        return "/boardlist/myinfo";

    }

    @PostMapping("/user/myinfo/update")
    public String infoUpdate(@AuthenticationPrincipal User user ,
                              Model model ,
                              @ModelAttribute MemberDto memberDto) {

        MemberDto back_memberDto = memberService.getMyInformation(user);
        memberDto.setEmail(user.getUsername());
        memberDto.setPassword(back_memberDto.getPassword());
        memberDto.setWarning(back_memberDto.getWarning());
        memberDto.setCreateyear(back_memberDto.getCreateyear());

        memberDto = memberService.getUpdateUser(memberDto);

        return "redirect:/user/myinfo";

    }

    // 로그인 결과 페이지
    @RequestMapping(value = "/user/logout/result" )
    public String logout() {
        return "/login";

    }




}