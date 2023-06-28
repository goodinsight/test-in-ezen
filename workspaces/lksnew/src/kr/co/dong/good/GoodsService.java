/*
 * Service : DAO를 호출하는 클래스 / DAO 아닌 클래스도 호출
 * 
 */

package kr.co.dong.good;

import java.util.List;

public interface GoodsService {
	public abstract List<GoodsBean> listAll();
	public abstract int insert(GoodsBean gb);
	public abstract GoodsBean selectOne(int gid);
	public abstract List<GoodsBean> selectOne(String gname);
	public abstract int update(GoodsBean gb);
	public abstract int delete(int gid);
}
