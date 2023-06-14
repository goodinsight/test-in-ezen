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
		
		Student s1 = new Student("강명석", "47", "1001", "물리");
		Student s2 = new Student("박현진", "43", "1002", "수학");
		Student s3 = new Student("강근비", "8", "1003", "음악");
		Student s4 = new Student("강민지", "13", "1004", "체육");
		Student s5 = new Student("강나연", "12", "1005", "연극");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("========= 학생 정보 페이지입니다. =========");
		System.out.println("1. 추가, 2. 수정, 3. 삭제, 4. 보기, 5. 종료");
		System.out.println("-------------------------------------");
		return scan.next(); // 입력된 데이터를 리턴
	}

	void studentPlay(String sel) {
		switch (sel) {
		case "1": // 추가메소드()
			addStudent();
			break;
		case "2": // 수정메소드()
			updateView(students);
			break;
		case "3": // 삭제메소드()
			deleteStudent(studentExpel);
			break;
		case "4": // 보기메소드()
			studentView();
			break;
		case "5": // 보기메소드()
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
			break;			
		default:
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
	}

	// 보기 메소드
	void studentView() {
		int select = 0;
		
		System.out.println("1. 전체보기 2.학번검색 3.삭제정보 ");
		System.out.println("선택해 주세요 >");
		select = scan.nextInt();
		
		if(select == 1 || select == 2 || select == 3) {
			switch (select) {
			case 1:
				System.out.println("========== 전체 학생 정보 출력 ==========");
				for(int i=0; i<students.size(); i++) {
					System.out.printf("이름: %s  나이: %2s  학번: %4s  전공: %s \n", students.get(i).getName(),
					         students.get(i).getAge(),  
					         students.get(i).getStudentNum(), 
					         students.get(i).getMajor());
				}
				break;
			case 2:
				int idx = -1;
				String studentNum = "111";
				System.out.println("학번으로 학생을 조회합니다.");
				System.out.println("학번 입력");
				studentNum = scan.next();
				
				idx = searchStudents(students, studentNum);
				System.out.println("========== 조회 학생 정보 출력 ==========");
				System.out.printf("이름: %s  나이: %2s  학번: %4s  전공: %s \n", students.get(idx).getName(),
				         students.get(idx).getAge(),  
				         students.get(idx).getStudentNum(), 
				         students.get(idx).getMajor());
				System.out.println();				
				break;
			case 3:
				System.out.println("삭제된 정보가 출력됩니다.");
				
				for(int i=0; i<studentExpel.expelStudents.size(); i++) {
					System.out.println("이름 : " + studentExpel.expelStudents.get(i).getName()
					         + "나이 : " + studentExpel.expelStudents.get(i).getAge() 
					         + "학번 : " + studentExpel.expelStudents.get(i).getStudentNum()
					         + "전공 : " + studentExpel.expelStudents.get(i).major);
				}
				
				break;
			default:
				break;
			}	
		}
		else {
			System.out.println("잘못선택하셨습니다. 다시 선택해 주세요");
		}
	}

	// 추가 메소드
	private void addStudent() {
		// 정보를 입력받아 students 배열에 추가
		boolean OnOff = false;
		int select = 0;
		
		while(!OnOff) {
//			학생 1명 생성 자료 저장
			Student s = new Student(null, null, null, null);
			System.out.println("학생정보를 입력해 주세요");
			System.out.println("이름 입력 >");
			s.setName(scan.next());
			System.out.println("나이 입력 >");
			s.setAge(scan.next());
			System.out.println("학번 입력 >");
			s.setStudentNum(scan.next());
			System.out.println("전공 입력 >");
			s.setMajor(scan.next());
//			저장여부 확인	
			System.out.println("입력하신 정보는 아래와 같습니다. 저장하시겠습니까?");
			System.out.println("저장 1번  다시 입력 2번");
			select = scan.nextInt();
			if(select == 1) {
				students.add(s);
				System.out.println("입력하신 정보가 저장되었습니다. ");
				OnOff = true;
			} 
		}	

	}

	// 수정 메인 메소드 : 학번으로 검색하고 있으면 수정메소드호출 없으면 재입력
	public void updateView(List<Student> students) {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[학생정보 수정] 학번을 입력하세요 : ");
			studentNum = scan.next();
			index = searchStudents(students, studentNum); // 학번으로 검색
			if (index >= 0) { // 인덱스값이 있다면
				if(updateStudent(students ,index))
					System.out.println("수정이 완료되었습니다.");
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(List<Student> students, String studentNum) {
		int index = -1;
		
		for(int i=0; i<students.size(); i++) {
			if(studentNum.equals(students.get(i).getStudentNum())) {
				index = i;				
			}
		}
		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

	// 수정 메소드
	boolean updateStudent(List<Student> students, int index) {
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공] 
		boolean done = false;
		System.out.println("수정하실 항복을 선택해주세요");
		System.out.println("[1. 이름] [2. 나이] [3. 학번] [4. 전공]");

		int select = scan.nextInt();
		
		switch (select) {
		case 1:
			System.out.println("현재의 이름은 " + students.get(index).getName() +" 입니다.");
			System.out.println("변경할 이름을 넣어주세요 >");
			students.get(index).setName(scan.next());
			System.out.println("이름이 " + students.get(index).getName() + " 으로 변경되었습니다.");
			done = true;
			break;
		case 2:
			System.out.println("현재의 나이은 " + students.get(index).getAge() +" 입니다.");
			System.out.println("변경할 나이를 넣어주세요 >");
			students.get(index).setAge(scan.next());
			System.out.println("나이가 " + students.get(index).getAge() + " 으로 변경되었습니다.");
			done = true;
			break;
		case 3:
			System.out.println("현재의 학번은 " + students.get(index).getStudentNum() + " 입니다.");
			System.out.println("변경할 학번을 넣어주세요 >");
			students.get(index).setStudentNum(scan.next());
			System.out.println("학번이 " + students.get(index).getStudentNum() + " 으로 변경되었습니다.");
			done = true;
			break;
		case 4:
			System.out.println("현재의 전공은 " + students.get(index).getMajor()+ " 입니다.");
			System.out.println("변경할 전공을 넣어주세요 >");
			students.get(index).setMajor( scan.next() );
			System.out.println("전공이 " + students.get(index).getMajor() + " 으로 변경되었습니다.");
			done = true;
			break;
		default:
			System.out.println("요청 내용을 확인할수 없습니다. ");
			done = false;
			break;
		}
		
		return done;
	}

	// 삭제 메소드
	void deleteStudent(StudentExpel studentExpel) {
		//[학생정보 삭제] 학번을 입력해주세요 : 
		System.out.println("학생정보를 삭제하겠습니다.");
		System.out.println("학번을 입력해 주세요");
		String tmpNum = scan.next();
		int idx = searchStudents(students, tmpNum);
		System.out.println(students.get(idx).getName() +"의 정보를 삭제하려 합니다. ");
		System.out.println("삭제는 1번 미삭제는 아무키나 눌러주세요");
		int tmpidx = scan.nextInt();		
		
		if(tmpidx ==1) {
//			넣는공간
			studentExpel.addExpelStudents(students.get(idx)); // 다른 클래스값을 함수를 호출
			students.remove(idx);
			
		}
		else {
			System.out.println("정보삭제가 되지 않았습니다. ");
		}	
	}

}
