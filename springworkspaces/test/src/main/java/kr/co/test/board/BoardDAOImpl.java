package kr.co.test.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private final static String namespace="kr.co.test.boardMapper";
	
	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace +".login", map);
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".list");
	}

	@Override
	public int register(BoardDTO bdto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".register", bdto);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".detail", bno);
	}

	@Override
	public int update(BoardDTO bdto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".update", bdto);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".delete", bno);
	}

	@Override
	public int reply(BoardReply boardReply) {
		// 댓글 쓰기를 위한 메소드
		return sqlSession.insert(namespace+".reply", boardReply);
	}

	@Override
	public List<BoardReply> getDetail1(int bno) {
		//게시물번호에 해당하는 댓글 조회
		return sqlSession.selectList(namespace+".detail1", bno);
	}

	@Override
	public BoardReply detailReply(int reno) {
		// 댓글 보기를 위한 메소드
		return sqlSession.selectOne(namespace+".detailReply", reno);
	}

	@Override
	public int replyUpdate(BoardReply boardReply) {
		// 댓글 수정을 처리하기 위한 메소드
		return sqlSession.update(namespace+".replyUpdate", boardReply);
	}

	@Override
	public int replyDelete(int reno) {
		// 댓글 삭제를 처리하기 위한 메소드
		return sqlSession.delete(namespace+".replyDelete", reno);
	}

}
