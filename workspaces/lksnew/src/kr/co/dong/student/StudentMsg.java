package kr.co.dong.student;

import java.util.List;

public class StudentMsg {
	public void studentErrorMsg(String str) {
		switch (str) {
		case "listAll":
			System.out.println("�л� ��ü ������ �����ϴ�.");
			break;
		case "selectOne":
			System.out.println("�ش� �л� ������ �����ϴ�.");
			break;
		case "update":
			System.out.println("�ش� �л� ������ �����Ͽ����ϴ�.");
			break;
		case "delete":
			System.out.println("�ش� �л� ������ �����Ͽ����ϴ�.");
			break;
		case "insert":
			System.out.println("�ش� �л� �߰��� �����Ͽ����ϴ�.");
			break;

		default:
			System.out.println("���� �߻�");
			break;
		}	
	}

	public void studentMsg(List<StudentBean> list) {
		for(StudentBean sb : list)
			System.out.println(sb);	
	}
	
	
}
