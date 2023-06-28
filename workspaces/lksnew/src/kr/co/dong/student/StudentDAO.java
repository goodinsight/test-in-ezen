/*
 * DAO(Data Access Object)
 * : 데이터베이스에 접근하는 클래스(인터페이스)
 * 1. 학생 전체 목록
 * 2. 학생추가	
 * 3. 학생조회(학생순번 또는 학생명...)
 * 4. 학생수정
 * 5. 학생삭제
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
