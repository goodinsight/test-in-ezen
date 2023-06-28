/*
 * DAO(Data Access Object)
 * : �����ͺ��̽��� �����ϴ� Ŭ����(�������̽�)
 * 1. ��ǰ ��ü ���
 * 2. ��ǰ�߰�	
 * 3. ��ǰ��ȸ(��ǰ��ȣ �Ǵ� ��ǰ��...)
 * 4. ��ǰ����
 * 5. ��ǰ����
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
