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

}
