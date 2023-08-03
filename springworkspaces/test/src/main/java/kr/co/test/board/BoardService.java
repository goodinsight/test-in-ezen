package kr.co.test.board;

import java.util.List;
import java.util.Map;

public interface BoardService {
	// 로그인 처리를 위한 메소드
	public abstract Map<String, Object> login(Map<String, Object> map);
	public abstract List<BoardDTO> list();
	public abstract int register(BoardDTO bdto);
	public abstract BoardDTO getDetail(int bno);
	public abstract int update(BoardDTO bdto);
	public abstract int delete(int bno);
	
	//댓글 쓰기를 위한 메소드
	public abstract int reply(BoardReply boardReply);
	//게시물번호에 해당하는 댓글 조회
	public abstract List<BoardReply> getDetail1(int bno);
	//댓글 수정보기를 위한 메소드
	public abstract BoardReply detailReply(int reno);
	//댓글 수정을 처리하기 위한 메소드
	public abstract int replyUpdate(BoardReply boardReply);
	//댓글 삭제를 처리하기 위한 메소드
	public abstract int replyDelete(int reno);
}
