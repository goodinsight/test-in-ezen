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
		Student s = new Student("삼수", "21", "11", "아침");
		Student s2 = new Student("이수", "22", "12", "점심");
		Student s3 = new Student("일수", "23", "13", "저녁");

		students.add(s);
		students.add(s2);
		students.add(s3);
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.print("1. 추가, 2. 수정, 3. 삭제, 4. 보기. 기타 (아무거나 물러서 종료) : ");
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
		// 1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		System.out.println("1) 전체보기, 2) 학번검색, 3) 삭제정보, 기타, 메뉴");
		String num = input("번호 입력");
		switch (num) {
		case "1":
			for (Student s : students) {
				System.out.println(s);
			}
			break;
		case "2":
			String stname = input("학생의 이름을 입력");
			for (int i = 0; i < students.size(); i++) {
				Student s = students.get(i);
				if (stname.equals(s.getName())) {
					System.out.println(s.getName() + " 학생 학번은 " + s.getStudentNum() + "입니다");
					break;
				}
			}
			break;
		case "3":
			Iterator<Student> sd = studentExpel.expelStudents.iterator();
			while (sd.hasNext()) {
				System.out.println(sd.next());
			}
			break;
		}
	}

	// 추가 메소드
	private void addStudent() {

		// 정보를 입력받아 students 배열에 추가
		System.out.println("학생 정보를 추가합니다");
		String name = input("이름을 적어주세요");
		String age = input("나이를 적어주세요");
		String stnum = input("학번을 적어주세요");
		String ma = input("학과를 적어주세요");

		Student st = new Student(name, age, stnum, ma);

		students.add(st);
		System.out.println("정보를 저장하였습니다");

	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			studentNum = input("[학생정보 수정] 학번을 입력하세요");
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				if (updateStudent(index) == true) {
					System.out.println("수정되었습니다.");
					break;
				} else {
					System.out.println("수정되지 않았습니다.");// 수정
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
		System.out.println("수정할 목록");
		System.out.println("1) 이름, 2) 나이, 3) 학번, 4) 전공");
		String num = input("번호 선택");
		Student s = students.get(index);
		boolean done = false;

		switch (num) {
		case "1":
			System.out.println(s.getName() + " 학생의 이름을 바꿉니다");
			String name = input("바꿀 이름을 입력");
			s.setName(name);
			System.out.println(s.getName() + " 학생으로 바꼈습니다");
			done = true;

			break;
		case "2":
			System.out.println(s.getName() + " 학생의 나이을 바꿉니다");
			String age = input("바꿀 나이를 입력");
			s.setAge(age);
			System.out.println(s.getName() + " 학생 나이가 " + s.getAge() + "으로 바꼈습니다");
			done = true;

			break;
		case "3":
			System.out.println(s.getName() + " 학생의 학번을 바꿉니다");
			String Num = input("바꿀 학번을 입력");
			s.setStudentNum(Num);
			System.out.println(s.getName() + " 학생 학번이 " + s.getStudentNum() + "으로 바꼈습니다");
			done = true;

			break;
		case "4":
			System.out.println(s.getName() + " 학생의 학과을 바꿉니다");
			String ma = input("바꿀 학과를 입력");
			s.setMajor(ma);
			System.out.println(s.getName() + " 학생 학과가 " + s.getMajor() + "으로 바꼈습니다");
			done = true;

			break;

		}

		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		// [학생정보 삭제] 학번을 입력해주세요 :
		String delnum = input("삭제할 학번을 입력");
		int num = searchStudents(delnum);
		if (num != -1) {
			studentExpel.addExpelStudents(students.remove(num));
		} else {
			System.out.println("학번이 맞지 않음");
		}
	}

	String input(String msg) {
		System.out.print(msg + " : ");
		return scan.next();
	}

}
