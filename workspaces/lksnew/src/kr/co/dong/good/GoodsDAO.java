/*
 * DAO(Data Access Object)
 * : 데이터베이스에 접근하는 클래스(인터페이스)
 * 1. 상품 전체 목록
 * 2. 상품추가	
 * 3. 상품조회(상품번호 또는 상품명...)
 * 4. 상품수정
 * 5. 상품삭제
 */

package kr.co.dong.good;

import java.util.List;

public interface GoodsDAO {
	public abstract List<GoodsBean> listAll();
	public abstract int insert(GoodsBean gb);
	public abstract GoodsBean selectOne(int gid);
	public abstract List<GoodsBean> selectOne(String gname);
	public abstract int update(GoodsBean gb);
	public abstract int delete(int gid);
}
