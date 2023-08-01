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
}
