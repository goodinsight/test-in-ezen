/*
 * DAO(Data Access Object)
 * : �����ͺ��̽��� �����ϴ� Ŭ����(�������̽�)
 * 1. �л� ��ü ���
 * 2. �л��߰�	
 * 3. �л���ȸ(�л����� �Ǵ� �л���...)
 * 4. �л�����
 * 5. �л�����
 */

package kr.co.dong.student;

import java.util.List;

public interface StudentDAO {
	public abstract List<StudentBean> listAll();
	public abstract int insert(StudentBean sb);
	public abstract StudentBean selectOne(int sid);
	public abstract List<StudentBean> selectOne(String name);
	public abstract int update(StudentBean sb);
	public abstract int delete(int sid);
}
