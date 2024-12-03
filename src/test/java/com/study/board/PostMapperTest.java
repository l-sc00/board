package com.study.board;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.board.post.PostMapper;
import com.study.board.post.PostRequest;
import com.study.board.post.PostResponse;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.study.board.post")
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNotice_yn(false);
        postMapper.save(params);

        List<PostResponse> posts = postMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }

    @Test
    void findById() {
        PostResponse post = postMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    void update() {
    	//1. 게시글 수정
    	PostRequest params = new PostRequest();
    	params.setId(1L);
    	params.setTitle("1번 게시글 제목 수정합니다.");
    	params.setContent("1번 게시글 내용 수정합니다.");
    	params.setWriter("감자");
    	params.setNotice_yn(true);
    	postMapper.update(params);
    	
    	//2. 게시글 상세정보 조회
    	PostResponse post = postMapper.findById(1L);
    	try {
    		String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
    		System.out.println(postJson);
    	} catch (JsonProcessingException e) {
    		throw new RuntimeException(e);
    	}
    }
    
    @Test
    void delete() {
    	System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다");
    	postMapper.deleteById(1L);
    	System.out.println("삭제 이후의 전체 개시글 개수는 : " + postMapper.findAll().size() + "개입니다");
    }
}