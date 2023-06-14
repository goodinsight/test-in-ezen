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

//		Student s1 = new Student("송시영", "30", "2011-1", "교육학");
//		Student s2 = new Student("이하은", "25", "2018-2", "건축");
//		Student s3 = new Student("이지윤", "32", "2011-3", "기계공학");
//		Student s4 = new Student("선우예일", "29", "2011-5", "신학");
//		Student s5 = new Student("송민재", "31", "2011-7", "경제학");
		
		Student s1 = new Student("송시영", "30", "2011-1", "교육학");
		Student s2 = new Student("이하은", "25", "2018-2", "건축");
		Student s3 = new Student("이지윤", "32", "2011-3", "기계공학");
		Student s4 = new Student("선우예일", "29", "2011-5", "신학");
		Student s5 = new Student("송민재", "31", "2011-7", "경제학");

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

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

//	private String name;//이름
//	private int age;//나이
//	private String studentNum;//학번
//	private String major;//학부전공??!!

	void studentView() {
		// 1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		System.out.println("1.전체보기,2.학번,3.삭제정보, 기타 등등");
		int sel = scan.nextInt();
		
		if(sel==1) {
			for(Student s:students) {
				System.out.println(s);
			}
		}else if(sel==2) {
			System.out.println("학번을 가져올게염");
			String studentNum =scan.next();
		if(searchStudents(studentNum, students)==-1) {
			System.out.println("학번이존재하지않습니다");
			
		}else {
			System.out.println("부합하는학번입니다:   "+students.get(searchStudents(studentNum, students)));
		}
				
			}
		}
		
	

	// 추가 메소드
	private void addStudent() {// 정보를 입력받아 students 배열에 추가
		System.out.println("정보를입력받자");

		System.out.println("이름,나이,학번,전공 을 추가받자");
		String name = scan.next();
		System.out.println("이름 을 추가");
		int age = scan.nextInt();
		System.out.println("나이 를 추가");
		String studentNum = scan.next();
		System.out.println("학번 을  추가");
		String major = scan.next();
		System.out.println("전공 을 추가");

		students.add(new Student(name, name, studentNum, major));

		
		System.out.println("이름 : " + name + " 나이 : " + age + " 학번 : " + studentNum + " 전공 : " + major + "이 추가됏어염 ");	
	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView() {// 보여주능기능?!?!
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[학생정보 수정] 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(studentNum, students); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				updateStudent(index); // 수정
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum, List<Student>students) {
		int index = -1;
		
		for(int i=0;i<students.size();i++) {
			if(studentNum.equals(students.get(i).getStudentNum())) {
				index =i;
				break;
			}
		}
		
			 
		

		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
}

	// 수정 메소드
	boolean updateStudent(int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공]
		boolean done = false; // true
		//students.get(searchStudents(toString()));
		
		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		// [학생정보 삭제] 학번을 입력해주세요 :
		System.out.println("학생정보 삭제입니다 학번을 입력하자");
		//int index=searchStudents(scan.next());
		//StudentExpel.addExpelStudents(students.get(index));
	}

}
