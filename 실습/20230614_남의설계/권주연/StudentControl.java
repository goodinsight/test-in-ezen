package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import kr.co.dong.room.Room;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성

	// 초기값
	void init_a() {
		students.add(new Student ("노아린", "24","2020","항공과"));
		students.add(new Student ("제갈공명", "26","2018","보건간호과"));
		students.add(new Student ("지은혁", "21","2023","소프트웨어과"));
		students.add(new Student ("남궁별", "25","2019","실용음악과"));
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("      ▶ 원하는 메뉴를 입력하세요 ◀      ");
		System.out.println("=================================");
		System.out.println("1. 추가 2. 수정 3. 삭제 4. 보기 99. 종료");

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

	// 추가 메소드
	private void addStudent() {
		System.out.println("추가할 학생의 이름을 입력하세요 : ");
		String name = scan.next();
		System.out.println("추가할 학생의 나이를 입력하세요 : ");
		String age = scan.next();
		System.out.println("추가할 학생의 학번을 입력하세요 : ");
		String Num = scan.next();
		System.out.println("추가할 학생의 학과를 입력하세요 : ");
		String major = scan.next();
		students.add(new Student(name, age, Num, major));
		// 정보를 입력받아 students 배열에 추가
		
		
	}
	
	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {
		int index;
		String studentNum = "";
		
		while (true) { // 수정한 화면만 보여주는 메소드
			System.out.print("[학생정보 수정] 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				if(updateStudent(index) == true) {// 수정
					System.out.println("수정이 완료되었습니다.");
					break;
				} else {
					System.out.println("취소되었습니다.");
					break;
				}
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}
	
	// 수정 메소드(여기서 수정하는 코드 작성)
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]
		System.out.println("    ▶ 수정하고 싶은 번호를 입력하세요 ◀    ");
		System.out.println("=================================");
		System.out.println("1. 이름 2. 나이 3. 학번 4. 전공");
		int update = scan.nextInt();
		switch (update) {
		case 1:
			System.out.println("수정할 이름을 입력해주세요 : ");
			String name = scan.next();
			students.get(index).setName(name);
			return true;
		case 2:
			System.out.println("수정할 나이를 입력해주세요 : ");
			String age = scan.next();
			students.get(index).setAge(age);
			return true;
		case 3:
			System.out.println("수정할 학번을 입력해주세요 : ");
			String num = scan.next();
			students.get(index).setStudentNum(num);
			return true;
		case 4:
			System.out.println("수정할 전공을 입력해주세요 : ");
			String jaor = scan.next();
			students.get(index).setMajaor(jaor);
			return true;
		default:
			return false;
		}
		
	}
	
	// 삭제 메소드 = remove( )
	void deleteStudent() { 
		//[학생정보 삭제] 학번을 입력해주세요 : 
		System.out.println("삭제할 학생의 학번을 입력해주세요 : ");
		String num = scan.next();
		searchStudents(num);
		int index = searchStudents(num);
		if(index == -1) {
			System.out.println("학번을 다시 입력해주세요.");
		} else {
			System.out.println(students.get(index));
			System.out.println("정말 삭제하시겠습니까? (Y/N)");
			String choice = scan.next().toUpperCase(); // toUpperCase() = 무조건 대문자로 나옴
			if(choice.equals("Y")) {
				studentExpel.addExpelStudents(students.get(index));
				students.remove(index);
			} else {
				System.out.println("취소를 선택하셨습니다.");
			}
//			equals
		}
		
	}
	
	// 보기 메소드
	private void studentView() {
	//1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		System.out.println("    ▶ 확인하고 싶은 번호를 입력하세요 ◀    ");
		System.out.println("=================================");
		System.out.println("1. 전체보기 2. 학번검색 3.삭제정보 4. 종료");
		int sel = scan.nextInt();
		
		switch (sel) {
		case 1: // 전체확인
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			} 
			break;
		case 2: //학번검색
			System.out.println("학번을 입력하세요 : ");
			String sNum = scan.next();
			searchStudents(sNum);
			int index = searchStudents(sNum);
			if(index == -1) {
				System.out.println("학번을 다시 입력하세요.");
			} else {
//				students.get(index);
				System.out.println(students.get(index));
			}
		
			break;
		case 3 : //삭제정보
			if(studentExpel.expelStudents.size() == 0) {
				System.out.println("삭제된 정보가 없습니다.");
			} else {
				for(int i = 0; i < studentExpel.expelStudents.size(); i++ ) {
					System.out.println(studentExpel.expelStudents.get(i));
					
				}
			}
			break;
		case 4: //종료
			
		default:
			break;
		}	
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String sNum) {
		int index = -1;
		for(int i = 0 ; i < students.size(); i++) {
			if(students.get(i).getStudentNum().equals(sNum)) {
				index = i;
			} 
		}

		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

}
