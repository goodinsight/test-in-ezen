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
		students.add(new Student ("김다정", "29", "202310", "이과"));
		students.add(new Student ("김서율", "31", "202309", "문과"));
		students.add(new Student ("신대한", "28", "202304", "문과"));
		students.add(new Student ("송정수", "27", "202303", "이과"));
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("┌─────원하시는 메뉴를 눌러주세요.─────┐");
		System.out.println("1. 학생 [추가]");
		System.out.println("2. 학생 [수정]");
		System.out.println("3. 학생 [삭제]");
		System.out.println("4. 학생 [조회]");
		System.out.println("5. 프로그램 종료");
		System.out.println("└──────────────────────────────┘");

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
		System.out.println("┌─[학생조회] 메뉴입니다.원하시는 메뉴를 선택해주세요.─┐");
		System.out.println("1. 전체보기");
		System.out.println("2. 학번검색");
		System.out.println("3. 삭제정보");
		System.out.println("└───────────────────────────────────────┘");
		
		switch (scan.nextInt()) {
		case 1:
			System.out.println("[전체보기] 입니다.");
			for (int i = 0; i < students.size(); i++) {
//				System.out.println(students);  // 전체 가져오기
				System.out.println(students.get(i));
			}
			break;
		case 2:
			System.out.println("[학번검색] 입니다.");
			System.out.println("학번을 입력해주세요.");
			String no = scan.next();
			int idx = searchStudents(no);
			if(idx==-1) {
				System.out.println("없는 정보입니다.");
			}else {
				System.out.println(students.get(idx));
			}
			break;
		case 3:
			System.out.println("[삭제정보] 입니다.");
			if(studentExpel.expelStudents.size()==0) {
				System.out.println("삭제된 정보가 없습니다.");
			}else {
				for (int i = 0; i < studentExpel.expelStudents.size(); i++) {
					System.out.println(studentExpel.expelStudents.get(i));	
				}
			}
			break;
		default:
			break;
		}
	}

	// 추가 메소드
	private void addStudent() {
		// 정보를 입력받아 students 배열에 추가
		System.out.println("추가하려는 학생의 [이름]을 입력해주세요.");
		String name = scan.next();
		System.out.println("추가하려는 학생의 [나이]를 입력해주세요.");
		String age = scan.next();
		System.out.println("추가하려는 학생의 [학번]을 입력해주세요.");
		String num = scan.next();
		System.out.println("추가하려는 학생의 [전공]을 입력해주세요.");
		String major = scan.next();
	
		Student s1 = new Student(name, age, num, major);
		students.add(s1);
	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {
		int index;
		String studentNum = "";
		boolean b = false;
		while (true) {
			System.out.print("[학생정보 수정]입니다. 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				b = updateStudent(index); // 수정
				if(b==true) {   // true면 멈추기. false면 안멈추기
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
		
		System.out.println("변경을 원하시는 메뉴를 선택해주세요.");
		System.out.println("[1. 이름] [2. 나이] [3. 학번] [4. 전공] ");
		switch (scan.nextInt()) {
		case 1:
			System.out.println("[이름] 변경 입니다.");
			System.out.println("변경할 학생의 이름을 입력해주세요.");
			String name = scan.next();
			students.get(index).setName(name);
			done = true;
			break;
			
		case 2:
			System.out.println("[나이] 변경 입니다.");
			System.out.println("변경할 학생의 나이를 입력해주세요.");
			String age = scan.next();
			students.get(index).setAge(age);
			done = true;
			break;
			
		case 3:
			System.out.println("[학번] 변경 입니다.");
			System.out.println("변경할 학생의 학번을 입력해주세요.");
			String num = scan.next();
			students.get(index).setStudentNum(num);
			done = true;
			break;
			
		case 4:
			System.out.println("[전공] 변경 입니다.");
			System.out.println("변경할 학생의 전공을 입력해주세요.");
			String major = scan.next();
			students.get(index).setMajor(major);
			done = true;
			break;
			
		default:
			System.out.println("잘못누르셨습니다. 다시 눌러주세요.");
			updateStudent(index);
			break;
		}
		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		//[학생정보 삭제] 학번을 입력해주세요 : 
		System.out.println("[학생정보 삭제] 학번을 입력해주세요 :");
		int index = searchStudents(scan.next());
		if (index==-1) {
			System.out.println("없는 학생입니다.");
		}else {
			studentExpel.addExpelStudents(students.get(index));
			students.remove(index);
			System.out.println("학생 정보가 삭제되었습니다.");
		}
		
	}

}
