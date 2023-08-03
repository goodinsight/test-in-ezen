package kr.co.test.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;
	
	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.login(map);
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public int register(BoardDTO bdto) {
		// TODO Auto-generated method stub
		return dao.register(bdto);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		// TODO Auto-generated method stub
		return dao.getDetail(bno);
	}

	@Override
	public int update(BoardDTO bdto) {
		// TODO Auto-generated method stub
		return dao.update(bdto);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return dao.delete(bno);
	}

	@Override
	public int reply(BoardReply boardReply) {
		// 댓글 쓰기를 위한 메소드
		return dao.reply(boardReply);
	}

	@Override
	public List<BoardReply> getDetail1(int bno) {
		// 게시물번호에 해당하는 댓글 조회
		return dao.getDetail1(bno);
	}

	@Override
	public BoardReply detailReply(int reno) {
		// 댓글 수정보기를 위한 메소드
		return dao.detailReply(reno);
	}

	@Override
	public int replyUpdate(BoardReply boardReply) {
		// 댓글 수정을 처리하기 위한 메소드
		return dao.replyUpdate(boardReply);
	}

	@Override
	public int replyDelete(int reno) {
		// 댓글 삭제를 처리하기 위한 메소드
		return dao.replyDelete(reno);
	}

}
