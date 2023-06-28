/*
 * Service : DAO를 호출하는 클래스 / DAO 아닌 클래스도 호출
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
