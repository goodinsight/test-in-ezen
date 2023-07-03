package kr.co.dong.board;

import java.util.List;

public class BoardServiceImpl implements BoardService {
	BoardDAOimpl bdao = new BoardDAOimpl();
	
	@Override
	public List<BoardBean> listAll() {
		// TODO Auto-generated method stub
		return bdao.listAll();
	}

	@Override
	public int insert(BoardBean bb) {
		// TODO Auto-generated method stub
		return bdao.insert(bb);
	}

	@Override
	public BoardBean selectOne(int bid) {
		// TODO Auto-generated method stub
		return bdao.selectOne(bid);
	}

	@Override
	public List<BoardBean> selectOne(String title) {
		// TODO Auto-generated method stub
		return bdao.selectOne(title);
	}

	@Override
	public int update(BoardBean bb) {
		// TODO Auto-generated method stub
		return bdao.update(bb);
	}

	@Override
	public int delete(int bid) {
		// TODO Auto-generated method stub
		return bdao.delete(bid);
	}

}
