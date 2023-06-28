package kr.co.dong.student;

import java.util.List;

public class StudentMsg {
	public void studentErrorMsg(String str) {
		switch (str) {
		case "listAll":
			System.out.println("학생 전체 정보가 없습니다.");
			break;
		case "selectOne":
			System.out.println("해당 학생 정보가 없습니다.");
			break;
		case "update":
			System.out.println("해당 학생 수정을 실패하였습니다.");
			break;
		case "delete":
			System.out.println("해당 학생 삭제를 실패하였습니다.");
			break;
		case "insert":
			System.out.println("해당 학생 추가를 실패하였습니다.");
			break;

		default:
			System.out.println("에러 발생");
			break;
		}	
	}

	public void studentMsg(List<StudentBean> list) {
		for(StudentBean sb : list)
			System.out.println(sb);	
	}
	
	
}
