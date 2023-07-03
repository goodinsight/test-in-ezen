/*
 * Service : DAO를 호출하는 클래스 / DAO 아닌 클래스도 호출
 * 
 */

package kr.co.dong.board;

import java.util.List;

public interface BoardService {
	public abstract List<BoardBean> listAll();
	public abstract int insert(BoardBean bb);
	public abstract BoardBean selectOne(int bid);
	public abstract List<BoardBean> selectOne(String title);
	public abstract int update(BoardBean bb);
	public abstract int delete(int bid);
}
