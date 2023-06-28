/*
 * Service : DAO�� ȣ���ϴ� Ŭ���� / DAO �ƴ� Ŭ������ ȣ��
 * 
 */

package kr.co.dong.student;

import java.util.List;

public interface StudentService {
	public abstract List<StudentBean> listAll();
	public abstract int insert(StudentBean sb);
	public abstract StudentBean selectOne(int sid);
	public abstract List<StudentBean> selectOne(String name);
	public abstract int update(StudentBean sb);
	public abstract int delete(int sid);
}
