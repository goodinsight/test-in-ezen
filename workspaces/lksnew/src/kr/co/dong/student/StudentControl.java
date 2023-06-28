package kr.co.dong.student;

import java.util.List;

public class StudentControl {
	StudentServiceImpl sService = new StudentServiceImpl();
	StudentMsg sm = new StudentMsg();
	public void listAll() {
		List<StudentBean> list = sService.listAll();
		if(list == null)
			sm.studentErrorMsg("listAll");
		else {
			sm.studentMsg(list);
		}
	}
	public void insert(StudentBean sb) {
		int result = sService.insert(sb);
		if(result <= 0)
			sm.studentErrorMsg("insert");
		else
			System.out.println("추가 성공!");
	}
	
	public void selectOne(int sid) {
		StudentBean sb = sService.selectOne(sid);
		if(sb == null)
			sm.studentErrorMsg("selectOne");
		else
			System.out.println(sb);
		
	}
	public void selectOne(String name) {
		List<StudentBean> list = sService.selectOne(name);
		if(list == null)
			sm.studentErrorMsg("selectOne");
		else
			sm.studentMsg(list);
		
	}
	public void update(int studentId, StudentBean sb) {
		sb.setSid(studentId);
		
		int result = sService.update(sb);
		if(result <= 0)
			sm.studentErrorMsg("update");
		else
			System.out.println("수정 성공!");
		
		
	}
	public void delete(int studentId) {
		int result = sService.delete(studentId);
		if(result <= 0)
			sm.studentErrorMsg("delete");
		else
			System.out.println("삭제 성공!");
	}
}
