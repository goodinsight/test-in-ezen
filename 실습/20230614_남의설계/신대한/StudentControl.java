package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성
	
	// 초기값
	void init_a() {
		students.add(new Student("신대한", "27", "00001", "컴퓨터활용"));
		students.add(new Student("신민국", "26", "00002", "네트워크"));
		students.add(new Student("정다영", "27", "00003", "회계"));
		students.add(new Student("박상준", "26", "00004", "호텔경영"));
		students.add(new Student("송정수", "26", "00005", "컴퓨터활용"));
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("1. 추가, 2. 수정, 3. 삭제, 4. 보기, 기타. 종료");
		return scan.next(); // 입력된 데이터를 리턴
	}

	void studentPlay(String sel) {
		// 화면 메뉴출력 1. 추가 , 2. 수정, 3. 삭제, 4. 보기, 기타. 종료
		switch (sel) {
		case "1": // 추가메소드()
			addStudent();
			break;
		case "2": // 수정메소드()
			updateView();
			break;
		case "3": // 삭제메소드()
			deleteStudent();
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
		System.out.println("1. 전체보기 2. 학번검색 3. 삭제정보, 기타. 메뉴");
		
		switch (scan.nextInt()) {
		case 1:
			for (Student student : students) {
				System.out.println(student);
			}
			break;
		case 2:
			int index = -1;
			System.out.println("학번을 입력해주세요.");
			String studentNum = scan.next();
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getStudentNum().equals(studentNum)) {
					index = i;
				}
			}
			if(index == -1) {
				System.out.println("입력하신 학번은 조회되지않습니다.");
			}else {
				System.out.println(students.get(index));
			}
			break;
		case 3:
			if(studentExpel.expelStudents.size() != 0) {
				for (Student student : studentExpel.expelStudents) {
					System.out.println(student);
				}
			}else {
				System.out.println("정보를 삭제한 학생이 없습니다.");
			}
			break;
		default:
			System.out.println("매뉴로 돌아갑니다.");
			break;
		}

	}

	// 추가 메소드
	private void addStudent() {
		// 정보를 입력받아 students 배열에 추가
		System.out.println("학생의 이름을 입력해주세요.");
		String name = scan.next();
		System.out.println("학생의 나이를 입력해주세요.");
		String age = scan.next();
		System.out.println("학생의 학번을 입력해주세요");
		String studentNum = scan.next();
		System.out.println("학생의 전공을 입력해주세요");
		String major = scan.next();
		students.add(new Student(name, age, studentNum, major));
	
		
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
				if(updateStudent(index) == true) {// 수정
					System.out.println("수정이 완료되었습니다.");
					break;
				}
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getStudentNum().equals(studentNum)) {
				index = i;
				break;
			}
		}
		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

	// 수정 메소드
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공] 
		boolean done = false;
			System.out.println("수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("수정할 이름을 입력해주세요.");
				String name = scan.next();
				students.get(index).setName(name);
				done = true;
				System.out.println("입력하신 이름으로 수정되셨습니다");
				break;
			case 2:
				System.out.println("수정하실 나이를 입력해주세요.");
				String age = scan.next();
				students.get(index).setAge(age);
				done = true;
				System.out.println("입력하신 나이로 수정되셨습니다");
				break;
			case 3:
				System.out.println("수정하실 학번을 입력해주세요.");
				String studentNum = scan.next();
				students.get(index).setStudentNum(studentNum);
				System.out.println("입력하신 학번으로 수정되셨습니다");
				done = true;
				break;
			case 4:
				System.out.println("수정실 전공을 입력해주세요.");
				String major = scan.next();
				students.get(index).setMajor(major);
				System.out.println("입력하신 전공으로 수정되셨습니다");
				done = true;
				break;
			default:
				System.out.println("1~4번의 매뉴만 선택해주세요.");
				updateStudent(index);
				break;
			}
		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		//[학생정보 삭제] 학번을 입력해주세요 : 
		System.out.println("[학생정보 삭제] 학번을 입력해주세요 : ");
		String studentNum = scan.next();
		int index = searchStudents(studentNum);
		if(index != -1) {
			studentExpel.addExpelStudents(students.get(index));
			students.remove(index);
			System.out.println("학생정보가 삭제되었습니다.");
		}else {
			System.out.println("입력하신 학번이 없습니다 다시 입력해주세요.");
			deleteStudent();
		}
	}

}
