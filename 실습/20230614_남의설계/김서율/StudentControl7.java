package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl7 {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성

	// 초기값
	void init_a() {
//		학생정보 리스트의 길이는 나와있지 않음. -> list.size() 는 미정
		Student s1 = new Student("김서율", "24", "20230614", "경영");
		Student s2 = new Student("김동율", "23", "20230615", "음악");
		Student s3 = new Student("김북율", "22", "20230616", "기계");
		Student s4 = new Student("김남율", "21", "20230617", "컴공");
		Student s5 = new Student("김중율", "20", "20230618", "정치");

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("--------------");
		System.out.println("1. 학생정보 추가");
		System.out.println("2. 학생정보 수정");
		System.out.println("3. 학생정보 삭제");
		System.out.println("4. 학생정보 보기");
		System.out.println("기타. 종료");
		System.out.println("--------------");
		System.out.print("번호를 입력하세요.> ");

		return scan.next(); // 입력된 데이터를 리턴
	}

	void studentPlay(String sel) {
		// 화면 메뉴출력 1. 추가 , 2. 수정, 3. 삭제, 4. 보기, 기타. 종료`
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
		System.out.println("1.전체보기 2.학번검색 3.삭제정보");
		System.out.println("기타번호. 메뉴");
		System.out.print("번호 입력> ");
		int sel = scan.nextInt();

		switch (sel) {
		case 1:
			// 전체보기
			for (int i = 0; i < students.size(); i++) {
				System.out.println("이름: " + students.get(i).getName() + " 나이: " + students.get(i).getAge() + " 학번: "
						+ students.get(i).getStudentNum() + " 전공: " + students.get(i).getMajor());
			}
			break;

		case 2:
			// 학번검색
			System.out.print("학번을 입력하세요. > ");
			String studentNum = scan.next();

			int index = searchStudents(studentNum);
			if (index == -1) {
				System.out.println("> 없는 번호입니다.");
			} else {
				System.out.println(students.get(index));
			}

			break;

		case 3:
			// 삭제정보
			System.out.println("삭제된 학생 정보");
			if(studentExpel.expelStudents.size()==0) {
				System.out.println("> 삭제된 학생 정보가 없습니다.");
			} else {
				for (int i = 0; i < studentExpel.expelStudents.size(); i++) {
					System.out.println(studentExpel.expelStudents.get(i));
				}
				
			}
			break;

		default:
//			메뉴
			
			break;
		}

	}

//	msg 받아서 String으로 반환하는 메소드
	private String strChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

	// 추가 메소드 ->add
	private void addStudent() {
		// 정보를 입력받아 students 배열에 추가

//		list에는 Student클래스의 필드 정보가 입력. (이름, 나이, 학번, 전공)
//		만약에 -> 배열을 읽어서 값이 없으면 그 자리에 추가 or index+1번자리에 추가?
		System.out.println("> 학생정보를 추가합니다.");
		Student s1 = new Student(strChoice("이름 입력: "), strChoice("나이 입력: "), strChoice("학번 입력: "),
				strChoice("전공 입력: "));
		students.add(s1);

	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력 ->set
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[학생정보 수정] 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				
				if(updateStudent(index) == false) {
					
//					updateStudent(index);
//					break;
				} else {
					break;
				}

			} else {
				System.out.println("> 입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 검색 메소드(학번 기준) //학번으로 index 찾기
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

	// 수정 메소드 ->set
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]
//		학생의 정보를 입력받아서 -> 그 정보가 담긴 index를 가지고 이름,나이,학번,전공 수정

		boolean done = false;
		
		while (!done) {

				System.out.println("수정항목: [1. 이름] [2. 나이] [3. 학번] [4. 전공]");
				System.out.print("수정할 항목을 선택하세요.> ");
				int sel = scan.nextInt();

				switch (sel) {
				case 1: // 이름수정
					System.out.println("변경할 이름을 입력하세요.> ");
					String name = scan.next();
					students.get(index).setName(name);
					System.out.println("> 이름이 " + name + "으로 변경되었습니다.");
					done = true;
					break;
				case 2: // 나이수정
					System.out.println("변경할 나이를 입력하세요.> ");
					String age = scan.next();
					students.get(index).setAge(age);
					System.out.println("> 나이가 " + age + "살로 변경되었습니다.");
					done = true;
					break;
				case 3: // 학번수정
					System.out.println("변경할 학번을 입력하세요.> ");
					String sNum = scan.next();
					students.get(index).setStudentNum(sNum);
					System.out.println("> 학번이 " + sNum + "으로 변경되었습니다.");
					done = true;
					break;

				case 4: // 전공수정
					System.out.println("변경할 전공을 입력하세요.> ");
					String major = scan.next();
					students.get(index).setMajor(major);
					System.out.println("> 전공이 " + major + "으로 변경되었습니다.");
					done = true;
					break;

				default :
					System.out.println("> 잘못된 번호 입니다. 다시 입력하세요.");
			}
		}		

				return done;
	}

	// 삭제 메소드 ->remove
	void deleteStudent() {
		// [학생정보 삭제] 학번을 입력해주세요 :
		System.out.print("삭제할 학생의 학번을 입력하세요.> ");
		String studentNum = scan.next();
		int index = searchStudents(studentNum);
		if (index >= 0) {
			studentExpel.addExpelStudents(students.get(index));
//			System.out.println(students.get(index));
			//studentExpel에 있는 expelStudents 리스트에 추가한다 -> students리스트에 있는 index위치의 정보를 추가.
			students.remove(index);
		} else {
			System.out.println("> 없는 학번입니다. 다시 입력하세요.");
		}

	}

}
