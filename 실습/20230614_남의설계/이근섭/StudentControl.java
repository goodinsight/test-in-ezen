package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성
	FileInputOutput fileInputOutput = new FileInputOutput(); // 파일로 학생정보 초기화 및 정보 저장
	// 초기값
	void init_a() {
		students = fileInputOutput.init();	
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("<학생 관리 시스템 v1.0>");
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
		String sel;
		String studentNum = "";
		menu:
		while (true) {
			System.out.println("1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
			System.out.print("원하시는 메뉴를 입력하세요 : ");
			sel = scan.next();
			switch (sel) {
			case "1":// 학생 전체 정보
				fileInputOutput.readFile("student.txt");
				break;
			case "2":// 학번으로 학생정보 검색
				while (true) {
					System.out.println("정보를 보고싶은 학생의 학번을 입력하세요 : ");
					studentNum = scan.next();
					int index = searchStudents(studentNum); // 학번으로 검색
					if (index >= 0) { // 인덱스값이 있다면
						System.out.println(students.get(index).toString());
						break;
					} else {
						System.out.println("입력된 학번을 찾지 못했습니다.");
						break;
					}
				}
				break;
			case "3":// 삭제된 학생정보
				fileInputOutput.readFile("studentExpel.txt");
				break;

			default:
				System.out.println("이전메뉴로 돌아갑니다.");
				break menu;
			}
		}
	}

	// 추가 메소드
	private void addStudent() {
		// 정보를 입력받아 students 배열에 추가
		Student s1 = new Student();
		System.out.println("학생의 이름을 입력하세요 : ");
		s1.setName(scan.next());
		System.out.println("학생의 나이를 입력하세요 : ");
		s1.setAge(scan.next());
		System.out.println("학생의 학번을 입력하세요 : ");
		s1.setStudentNum(scan.next());
		System.out.println("학생의 전공을 입력하세요 : ");
		s1.setMajor(scan.next());
		fileInputOutput.addStudentInfor(s1);
		students.add(s1);
	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.println("[학생정보 수정] 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				updateStudent(index); // 수정
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다."); // 입력오류시 재입력
				break;
			}
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		int index = -1;
		for(int i = 0; i< students.size(); i++) {
			if(studentNum.equals(students.get(i).getStudentNum())) {
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
		
		while(!done) {
			System.out.println("[학생정보 수정] 수정할 항목을 고르세요 : ");
			System.out.println("[1. 이름] [2. 나이] [3. 학번] [4. 전공] ");
			switch (scan.next()) {
			case "1":
				System.out.println("[학생 이름 수정]");
				System.out.println("바꾸실 이름을 입력하세요 : ");
				String tmp1 = scan.next();
				students.get(index).setName(tmp1);
				System.out.println("이름이 " + tmp1 + "(으)로 수정되었습니다.");
				done = true;
				break;
			case "2":
				System.out.println("[학생 나이 수정]");
				System.out.println("바꾸실 나이를 입력하세요 : ");
				String tmp2 = scan.next();
				students.get(index).setAge(tmp2);
				System.out.println("나이가 " + tmp2 + "으로 수정되었습니다.");
				done = true;
				break;
			case "3":
				System.out.println("[학생 학번 수정]");
				System.out.println("바꾸실 학번을 입력하세요 : ");
				String tmp3 = scan.next();
				students.get(index).setStudentNum(tmp3);
				System.out.println("학번이 " + tmp3 + "로 수정되었습니다.");
				done = true;
				break;
			case "4":
				System.out.println("[학생 전공 수정]");
				System.out.println("바꾸실 전공을 입력하세요 : ");
				String tmp4 = scan.next();
				students.get(index).setName(tmp4);
				System.out.println("전공이 " + tmp4 + "로 수정되었습니다.");
				done = true;
				break;

			default:
				System.out.println("메뉴를 다시 고르세요.");
				break;
			}	
		}
		fileInputOutput.saveStudentInfor(students); // 수정한 정보 저장
		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		//[학생정보 삭제] 학번을 입력해주세요 : 
		int index;
		String studentNum = "";
		
		while(true) {
			System.out.print("[학생정보 삭제] 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				studentExpel.addExpelStudents(students.get(index));
				fileInputOutput.removeStudentInfor(students.get(index));
				students.remove(index);
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다."); // 입력오류시 재입력
				break;
			}
		}	
	}
}
