package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성
	
	

	// 초기값
	void init_a() {
		students.add(new Student("가", "21", "1111", "AB"));
		students.add(new Student("나", "22", "2222", "CD"));
		students.add(new Student("다", "23", "3333", "EF"));
		students.add(new Student("라", "24", "4444", "GH"));
		
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("1. 추가, 2. 수정, 3. 삭제, 4. 보기, 기타. 종료");
		
		return scan.next(); // 입력된 데이터를 리턴
	}

	void studentPlay(String sel) {
		// 화면 메뉴출력 1. 추가 , 2. 수정, 3. 삭제, 4. 보기, 기타. 종료
		sel=menuView();
		
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
			sel="5";
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
		
	}

	// 보기 메소드
	void studentView() {
	//1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		System.out.println("1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		String sel=scan.next();
		switch(sel) {
		case "1":	// 1. 전체보기
			Iterator<Student> iterS=students.iterator();
			while(iterS.hasNext()) {
				System.out.println(iterS.next());
			}
			return;
		case "2":	// 2. 학번검색
			System.out.print("학번 입력 : ");
			int index=0;
			index=searchStudents(scan.next());
			if(index==-1) {
				System.out.println("해당 학번 없음");
				return;
			}
			System.out.println(students.get(index));
			return;
		case "3":	// 3. 삭제정보
			Iterator<Student> iterE=studentExpel.expelStudents.iterator();
			if(!iterE.hasNext()) {
				System.out.println("삭제 정보 없음");
				return;
			}
			while(iterE.hasNext()) {
				System.out.println(iterE.next());
			}
			return;
		default:
			System.out.println("초기 메뉴로 돌아갑니다");
			return;	
		}

	}

	// 추가 메소드
	private void addStudent() {
		// 정보를 입력받아 students 배열에 추가
		String name, age, num, major;
		System.out.print("학번 : ");
		num=scan.next();
		if(searchStudents(num)!=-1) {
			System.out.println("중복 학번");
			return;
		}
		System.out.print("이름 : ");
		name=scan.next();
		System.out.print("나이 : ");
		age=scan.next();
		System.out.print("전공 : ");
		major=scan.next();
		students.add(new Student(name, age, num, major));
		
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
					System.out.println("수정되었습니다");
				}
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
				continue;
			}
		}
		
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		int index=-1;
		for(int i=0; i<students.size(); i++) {
			if(Objects.equals(studentNum, students.get(i).getStudentNum())) {
				index=i;
				break;
			}
		}
		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
		
	}

	// 수정 메소드
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공] 
		boolean done=false;
		System.out.println("수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]");
		String sel=scan.next();
		switch(sel) {
		case "1":
			System.out.print("번경할 이름 : ");
			students.get(index).setName(scan.next());
			done=true;
			break;
		case "2":
			System.out.print("번경할 나이 : ");
			students.get(index).setAge(scan.next());
			done=true;
			break;
		case "3":
			System.out.print("번경할 학번 : ");
			String num=scan.next();
			if(searchStudents(num)!=-1) {
				System.out.println("중복 학번");
				break;
			}
			students.get(index).setStudentNum(num);
			done=true;
			break;
		case "4":
			System.out.print("번경할 전공 : ");
			students.get(index).setMajor(scan.next());
			done=true;
			break;
		default:
			break;
		}
		return done;
		
	}

	// 삭제 메소드
	void deleteStudent() {
		//[학생정보 삭제] 학번을 입력해주세요 :
		System.out.print("[학생정보 삭제] 학번을 입력해주세요 : ");
		int index=-1;
		index=searchStudents(scan.next());
		if(index==-1) {
			System.out.println("해당 학번 없음");
			return;
		}
		studentExpel.addExpelStudents(students.get(index));
		students.remove(index);
		
	}

	
}
