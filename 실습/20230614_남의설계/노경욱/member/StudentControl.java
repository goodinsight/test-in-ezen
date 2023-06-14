package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import room.Room;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성

	// 초기값
	void init_a() {
		Student stu1 = new Student("가", "21", "2121", "가가");
		Student stu2 = new Student("나", "22", "2222", "나나");
		Student stu3 = new Student("다", "23", "2323", "다다");
		Student stu4 = new Student("라", "24", "2424", "라라");
		Student stu5 = new Student("마", "25", "2525", "마마");

		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		students.add(stu4);
		students.add(stu5);

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
		System.out.println("1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		int sel = scan.nextInt();
		switch (sel) {
		case 1:
			for (Student stu : students) {
				System.out.println("성명: " + stu.getName() + " /// 나이: " + stu.getAge() + " /// 학번: "
						+ stu.getStudentNum() + " /// 전공: " + stu.getMajor());
			}
			break;
		case 2:
			System.out.print("학번을 입력하세요: ");
			Student stu = students.get(searchStudents(scan.next()));
			System.out.println("성명: " + stu.getName() + " /// 나이: " + stu.getAge() + " /// 학번: " + stu.getStudentNum()
					+ " /// 전공: " + stu.getMajor());

			break;
		case 3:
			System.out.println("삭제된 정보");
			if (studentExpel.expelStudents.size() != 0) {
				for (Student student : studentExpel.expelStudents) {
					System.out.println("성명: " + student.getName() + " /// 나이: " + student.getAge() + " /// 학번: "
							+ student.getStudentNum() + " /// 전공: " + student.getMajor());
				}
			} else {
				System.out.println("삭제된 정보가 없습니다");
				break;
			}
		}
	}

	// 추가 메소드
	private void addStudent() {
		System.out.println("학생을 추가합니다");
		System.out.println("양식: (이름,나이,학번,전공))");
		String add = scan.next();
		String[] ad = add.split(",");
		String Name = ad[0];
		String Age = ad[1];
		String StudentNum = ad[2];
		String Major = ad[3];
		Student newPerson = new Student(Name, Age, StudentNum, Major);
		// 정보를 입력받아 students 배열에 추가
		students.add(newPerson);
	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[학생정보 수정] 학번을 입력하세요(99: 종료): ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				updateStudent(index); // 수정
				break;
			} else if (studentNum == "99") {
				System.out.println("종료합니다");
				break;
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
		System.out.println("수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]");
		int sel = scan.nextInt();
		String tmp = "";
		switch (sel) {
		case 1:
			System.out.println("수정할 이름을 입력해 주세요");
			tmp = scan.next();
			students.get(index).setName(tmp);
			break;
		case 2:
			System.out.println("수정할 나이을 입력해 주세요");
			tmp = scan.next();
			students.get(index).setAge(tmp);
			break;
		case 3:
			System.out.println("수정할 학번을 입력해 주세요");
			tmp = scan.next();
			students.get(index).setStudentNum(tmp);
			break;
		case 4:
			System.out.println("수정할 전공을 입력해 주세요");
			tmp = scan.next();
			students.get(index).setMajor(tmp);
			break;
		}
		return true;
	}

	// 삭제 메소드
	void deleteStudent() {
		System.out.println("[학생정보 삭제] 학번을 입력해주세요 :");
		int index = searchStudents(scan.next());
		studentExpel.addExpelStudents(students.get(index));
		students.remove(index);
//		int index = searchStudents(scan.next());
//		studentExpel.addExpelStudents(students.get(index));
//		students.remove(index);
	}

}
