package kr.co.dong.student;

import java.util.Scanner;

public class StudentMenu {
	Scanner scan = new Scanner(System.in);
	StudentControl sc = new StudentControl();

	public String menuView() {
		System.out.println("========== 학생 정보 관리 ==========");
		System.out.println("1.학생전체목록  2.학생추가 3.학생조회  4.학생수정 5.학생삭제 999.종료 ");
		System.out.println("메뉴를 고르세요 : ");
		return scan.nextLine();
	}

	public void menuPlay() {
		while (true) {
			String select = menuView();
			switch (select) {
			case "1":
				sc.listAll();
				break;
			case "2":
				sc.insert(add());
				break;
			case "3":
				System.out.println("1.학생순번 조회 2.학생이름 조회");
				switch (scan.nextLine()) {
				case "1":
					sc.selectOne(studentId());
					break;
				case "2":
					sc.selectOne(studentName());
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
				break;
			case "4":
				sc.update(studentId(), add());
				break;
			case "5":
				sc.delete(studentId());
				break;
			case "999":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("다시 골라 주세요. ");
				break;
			}
		}
	}

	private StudentBean add() {
//		학생 정보 추가/수정 입력받는 메소드
		System.out.println("학생 이름을 입력 :");
		String name = scan.nextLine();
		System.out.println("학생 나이를 입력 :");
		int age = Integer.parseInt(scan.nextLine());
		System.out.println("학생 학번을 입력 : ");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println("학생 전공을 입력 : ");
		String major = scan.nextLine();

		StudentBean sb = new StudentBean(name, age, num, major);

		return sb;
	}

	private int studentId() {
		System.out.println("조회/수정하실 학생 순번을 입력 : ");
		return Integer.parseInt(scan.nextLine());
	}

	private String studentName() {
		System.out.println("조회하실 학생 이름을 입력 : ");
		return scan.nextLine();
	}
}
