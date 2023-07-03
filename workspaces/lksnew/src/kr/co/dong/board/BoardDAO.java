/*
 * DAO(Data Access Object)
 * : �����ͺ��̽��� �����ϴ� Ŭ����(�������̽�)
 * 1. ��ǰ ��ü ���
 * 2. ��ǰ�߰�	
 * 3. ��ǰ��ȸ(��ǰ��ȣ �Ǵ� ��ǰ��...)
 * 4. ��ǰ����
 * 5. ��ǰ����
 */

package kr.co.dong.board;

import java.util.List;

public interface BoardDAO {
	public abstract List<BoardBean> listAll();
	public abstract int insert(BoardBean bb);
	public abstract BoardBean selectOne(int bid);
	public abstract List<BoardBean> selectOne(String title);
	public abstract int update(BoardBean bb);
	public abstract int delete(int bid);
}
