package com.study.board.post;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {
	private Long id;	//PK
	private String title; //제목
	private String content; //내용
	private String writer; //작성자
	private int viewCnt; //조회 수
	private Boolean notice_yn; //공지글 여부
	private Boolean delete_yn; //삭제 여부
	private LocalDateTime created_date; //생성일시
	private LocalDateTime modifiedDate; //최종 수정일시
}
