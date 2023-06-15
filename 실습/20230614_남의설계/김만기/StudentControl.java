package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성

	// 초기값
	void init_a() {
		students.add(new Student("김만기", "10", "230614", "컴퓨터공학"));
		students.add(new Student("정만기", "11", "220614", "컴퓨터네트워크"));
		students.add(new Student("이만기", "13", "200614", "소프트웨어정보"));
		students.add(new Student("최만기", "15", "180614", "정보통신"));
		students.add(new Student("박만기", "17", "160614", "수학"));
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("학생 정보 매니저");
		System.out.println("1. 추가, 2. 수정, 3. 삭제, 4. 보기, 기타. 종료");

		return scan.next(); // 입력된 데이터를 리턴
	}

	void studentPlay(String sel) {
		// 화면 메뉴출력 1. 추가 , 2. 수정, 3. 삭제, 4. 보기, 기타. 종료
		switch (sel) {
		case "1": // 추가메소드()
			addStudent(students);
			break;
		case "2": // 수정메소드()
			updateView();
			break;
		case "3": // 삭제메소드()
			deleteStudent(studentExpel);
			break;
		case "4": // 보기메소드()
			studentView();
			break;
		default:
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
	}

	// 보기 메소드
	void studentView() {
	//1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		String input = "";
		System.out.println("1. 전체보기, 2. 학번검색, 3. 삭제정보, 기타. 메뉴");
		input = scan.next();
		switch(input) {
		case "1":
			allView(students);
			break;
		case "2":
			StudentControl stu = new StudentControl();
			System.out.println("학번을 입력해주세요 : ");
			input = scan.next();
			int index = stu.searchStudents(input);
			if(index >= 0) {
				studentNumView(index);
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요.");
			}
		case "3":
			System.out.println("삭제정보입니다.");
			for(int i=0; i<studentExpel.expelStudents.size(); i++) {
				System.out.println(studentExpel.expelStudents.get(i));				
			}
		case "4":
			return;
			default:
		}
	}

	private void studentNumView(int index) {
		System.out.println(students.get(index));
	}

	private void allView(List<Student> students) {
		for(int i=0; i<students.size(); i++) {
			System.out.println(students.get(i));
		}
	}

	// 추가 메소드
	private void addStudent(List<Student> students) {
		String name = "";
		String age = "";
		String studentNum = "";
		String major = "";
		
		System.out.println("학생 정보를 추가합니다");
		System.out.println("학생 정보를 입력해주세요.");
		System.out.println("학생 이름 : ");
		name = scan.next();
		System.out.println("학생 나이 : ");
		age = scan.next();
		System.out.println("학번 : ");
		studentNum = scan.next();
		System.out.println("과목 : ");
		major = scan.next();
		students.add(new Student(name, age, studentNum, major));
		System.out.println("학생 정보가 추가되었습니다.");
		// 정보를 입력받아 students 배열에 추가
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
				if(updateStudent(index)) {
					System.out.println("수정이 완료되었습니다");
					break;
				} else {
					System.out.println("수정에 실패하였습니다.");
				}
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getStudentNum().equals(studentNum)) {
				return i;
			}
		}
		return -1; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

	// 수정 메소드
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공] 
		String input = "";
		boolean done = false;
		
		System.out.println("수정할 항목 선택");
		System.out.println("[1. 이름] [2. 나이] [3. 학번] [4. 과목]");
		input = scan.next();
		switch(input) {
		case "1":
			System.out.println("학생 이름 : ");
			input = scan.next();
			students.get(index).setName(input);
			done = true;
			break;
		case "2":
			System.out.println("학생 나이 : ");
			input = scan.next();
			students.get(index).setAge(input);
			done = true;
			break;
		case "3":
			System.out.println("학번 : ");
			input = scan.next();
			students.get(index).setStudentNum(input);
			done = true;
			break;
		case "4":
			System.out.println("과목 : ");
			input = scan.next();
			students.get(index).setMajor(input);
			done = true;
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			done = false;
		}
		return done;
	}


	// 삭제 메소드
	void deleteStudent(StudentExpel studentExpel) {
		//[학생정보 삭제] 학번을 입력해주세요 : 
		
		System.out.println("[학생정보 삭제] 학번을 입력해주세요 : ");
		String input = scan.next();
		int index = searchStudents(input);
		if(index >= 0) {
			studentExpel.addExpelStudents(students.get(index));
			students.remove(index);
		} else {
			System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요.");
			deleteStudent(studentExpel);
		}
	}

}
