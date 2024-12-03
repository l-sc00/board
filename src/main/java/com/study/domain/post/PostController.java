//package com.study.domain.post;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class PostController {
//
//    private final PostService postService;
//
//    // 게시글 작성 페이지
//    @GetMapping("/post/write")
//    public String openPostWrite(Model model) {
//    	System.out.println("요청 확인 테스트");
//        return "post/write";
//    }
//
//}