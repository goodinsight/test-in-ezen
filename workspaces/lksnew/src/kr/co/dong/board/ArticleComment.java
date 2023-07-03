package kr.co.dong.board;

import java.time.LocalDateTime;

public class ArticleComment {
	private String acid;	//댓글 번호
	private String content;	//댓글 내용
	private LocalDateTime createdAt;	//댓글 작성일
	private String createdBy;	//댓글 작성자
	private LocalDateTime modifiedAt;	//댓글 수정일
	private String modifiedBy;	//댓글 수정자
}
