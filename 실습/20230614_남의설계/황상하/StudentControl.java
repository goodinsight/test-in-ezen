package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성
	Student student;

	// 초기값
	void init_a() {
		students.add(new Student("황상하", "28", "18", "수학"));
		students.add(new Student("임주영", "29", "17", "국어"));
		students.add(new Student("김동현", "30", "16", "영어"));
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("1. 추가, 2. 수정, 3. 삭제, 4. 보기, 기타. 종료");

		return scan.next();
	}

	// 화면 메뉴출력 1. 추가 , 2. 수정, 3. 삭제, 4. 보기, 기타. 종료
	void studentPlay(String sel) {
		switch (sel) {
		case "1": // 추가
			addStudent();
			break;
		case "2": // 수정
			updateView();
			break;
		case "3": // 삭제
			deleteView();
			break;
		case "4": // 보기
			studentView();
			break;
		default:
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
	}

	// 추가 메소드
	private void addStudent() {
		System.out.println("이름을 입력해주세요.");
		String name = scan.next();
		System.out.println("나이를 입력해주세요.");
		String age = scan.next();
		System.out.println("학번을 입력해주세요.");
		String sNum = scan.next();
		System.out.println("전공을 입력해주세요.");
		String major = scan.next();
		students.add(new Student(name, age, sNum, major));
	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {
		int index;
		String studentNum = "";
		
		while (true) {
			System.out.print("[학생정보 수정] 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				if (updateStudent(index) == true) {
					System.out.println("수정 되었습니다.");
				} else {
					System.out.println("취소 하셨습니다.");
				}
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 수정 메소드
	boolean updateStudent(int index) {
		System.out.println(students.get(index));
		System.out.println("[1. 이름] [2. 나이] [3. 학번] [4. 전공] [기타. 취소]");
		System.out.println("수정할 항목을 선택해주세요 .");
		int sel = scan.nextInt();
		switch (sel) {
		case 1: // 이름수정
			System.out.println("변경하실 이름을 입력해 주세요.");
			String name = scan.next();
			students.get(index).setName(name);
			return true;
		case 2: // 나이수정
			System.out.println("변경하실 나이를 입력해 주세요.");
			String age = scan.next();
			students.get(index).setAge(age);
			return true;
		case 3: // 학번수정
			System.out.println("변경하실 학번을 입력해 주세요.");
			String sNum = scan.next();
			students.get(index).setStudentNum(sNum);
			return true;
		case 4: // 전공수정
			System.out.println("변경하실 전공을 입력해 주세요.");
			String major = scan.next();
			students.get(index).setMajor(major);
			return true;
		default:
			return false;
		}
	}

	// 삭제 메인 메소드
	void deleteView() {
		int index;
		String studentNum = "";
		
		System.out.print("[학생정보 삭제] 학번을 입력하세요 : ");
		studentNum = scan.next();
		index = searchStudents(studentNum); // 학번으로 검색
		if (index >= 0) { // 인덱스값이 있다면
			if (deleteStudents(index) == true) {
				studentExpel.addExpelStudents(students.get(index)); // 삭제정보를 리스트에 추가
				students.remove(index); // 삭제
			} else {
				System.out.println("삭제를 취소합니다.");
			}
		} else {
			System.out.println("입력된 학번을 찾지 못했습니다."); // 입력오류시 재입력
		}
	}

	// 삭제메소드
	boolean deleteStudents(int index) {
		System.out.println(students.get(index));
		while (true) {
			System.out.println("삭제하시겠습니까? (Y/N)");
			String sel = scan.next().toUpperCase();
			if (sel.equals("Y")) {
				return true;
			} else if (sel.equals("N")) {
				return false;
			} else {
				System.out.println("잘못된 입력입니다."); // 잘못된 입력시 다시 입력받음
			}
		}
	}

	// 보기 메소드
	void studentView() {
		System.out.println("1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		int sel = scan.nextInt();
		switch (sel) {
		case 1: // 전체보기
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			}
			break;
		case 2: // 학번검색
			System.out.println("학번을 입력해주세요.");
			String sNum = scan.next();
			int idx = searchStudents(sNum);
			if (idx == -1) {
				System.out.println("존재하지 않는 학번입니다.");
			} else {
				System.out.println(students.get(idx));
			}
			break;
		case 3: // 삭제정보
			if (studentExpel.expelStudents.size() != 0) {
				System.out.println("[ 삭제 정보 ]");
				for (int i = 0; i < studentExpel.expelStudents.size(); i++) {
					studentExpel.expelView(i);
				}
			} else {
				System.out.println("삭제 정보가 없습니다.");
			}
			break;
		default: // 메뉴로돌아감
			System.out.println("메뉴로 돌아갑니다.");
			break;
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentNum().equals(studentNum)) {
				index = i;
			}
		}
		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}
}
