/*
 * Service : DAO�� ȣ���ϴ� Ŭ���� / DAO �ƴ� Ŭ������ ȣ��
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
