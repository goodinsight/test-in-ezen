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
		Student s1 = new Student("송정수", "26", "1622100197", "기계");
		Student s2 = new Student("송정우", "27", "1622100198", "컴공");
		Student s3 = new Student("송정미", "28", "1622100199", "메카트로닉스");
		Student s4 = new Student("송정양", "29", "1622100200", "디자인");
		Student s5 = new Student("송정가", "30", "1622100201", "환경");

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("=====학생정보시스템=====");
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

//	msg받아서 String반환하는 메소드
	String strchoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

	// 보기 메소드
	void studentView() {
		// 1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		System.out.println("1.전체보기 2.학번검색 3.삭제정보 기타. 메뉴");
		String sel = strchoice("번호 입력 : ");
		
		if (sel.equals("1")) {
			for (Student s : students) {
				System.out.println(s);
			}
		} else if (sel.equals("2")) {
			String sNum = strchoice("학번 입력 : ");
			int per = searchStudents(sNum);
			if (per == -1) {
				System.out.println("없는 학번입니다.");
			} else if (!sNum.equals(students.get(per).getStudentNum())) {
				System.out.println("학번을 틀리게 입력했습니다.");
			}else {
				System.out.println(students.get(per));
			}
		} else if (sel.equals("3")) {
			if(studentExpel.expelStudents.size() == 0) {
				System.out.println("삭제한 학생이 없습니다.");
			}else {
				for(int i=0;i<studentExpel.expelStudents.size();i++) {
					System.out.println(studentExpel.expelStudents.get(i));
				}
			}
		} else {
			System.out.println("메뉴로 돌아갑니다.");
		}
	}

	// 추가 메소드
	private void addStudent() {
		// 정보를 입력받아 students 배열에 추가
		Student s1 = new Student(strchoice("학생 이름 입력 : "),strchoice("나이 입력 : ") ,strchoice("학번 입력 : ") , strchoice("전공 입력 : "));
		
		students.add(s1);

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
				if(updateStudent(index) == true) {
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
			if (studentNum.equals(students.get(i).getStudentNum())) {
				index = i;
				break;
			}
		}
		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

	// 수정 메소드
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]
		System.out.println("===수정할 항목 선택===");
		System.out.println("1.이름 2.나이 3.학번 4.전공 5.메뉴");
		String sel = strchoice("원하는 항목 입력 : ");
		boolean done = false;
		switch(sel) {
		case "1":
			String name = strchoice("변경할 이름을 입력 : ");
			students.get(index).setName(name);
			done = true;
			break;
		case "2":
			String age = strchoice("변경할 나이를 입력 : ");
			students.get(index).setAge(age);
			done = true;
			break;
		case "3":
			String studentNum = strchoice("변경할 학번을 입력 : ");
			students.get(index).setStudentNum(studentNum);
			done = true;
			break;
		case "4":
			String major = strchoice("변경할 전공을 입력 : ");
			students.get(index).setMajor(major);
			done = true;
			break;
		case "5":
			System.out.println("뒤로 이동");
			break;
			default :
				System.out.println("잘못 입력했습니다.");
				updateStudent(index);
		}
		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		// [학생정보 삭제] 학번을 입력해주세요 :
		String num = strchoice("[학생정보 삭제] 학번을 입력하세요 : ");
		int per = searchStudents(num);
		if(per == -1) {
			System.out.println("없는 학번입니다.");
		}else if(!num.equals(students.get(per).getStudentNum())) {
			System.out.println("입력한 학번이 틀렸습니다.");
		}else {
			System.out.println("학생정보를 삭제하였습니다.");
			studentExpel.addExpelStudents(students.get(per));
			students.remove(per);
		}
		
		

	}

}
