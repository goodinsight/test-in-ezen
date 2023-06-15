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
		// 학생 정보 입력
		Student s1 = new Student ("김승재", "31", "200914001", "트랜스"); // 초기 화면에서 삭제 기능을 바로 사용 할 수 있도록 학생 샘플 입력
		
		// 학생 저장
		students.add(s1);
	}
	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println(" ┌────────┬────────┬────────┬────────┬────────────┐");
		System.out.println(" │  1 추가 │  2 수정 │  3 삭제 │  4 보기 │ 기타입력 종료 │");
		System.out.println(" └────────┴────────┴────────┴────────┴────────────┘");
		
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
		System.out.println(" ┌───────────┬───────────┬───────────┬────────┐");
		System.out.println(" │  1 전체보기 │  2 학번검색 │  3 삭제정보 │  4 기타 │");
		System.out.println(" └───────────┴───────────┴───────────┴────────┘");
		
		int sel = scan.nextInt();
		switch(sel) {
		case 1:  //전체보기
			
//			for(int i= 0; i<students.size(); i++) {
//				Student student = students.get(i);
			
			for(Student sData : students) {// 향상된 for문
				System.out.println(" 이름 :"+sData.getsName()+"/ 나이:"+ sData.getsAge()+"/ 학번:"+ sData.getsNum()+"/ 전공"+ sData.getsMajor());
			}
			break;			
			
		case 2: // 학번검색
			System.out.println("찾으려는 학생 정보의 학번을 입력하세요.");
			int index;
			index = searchStudents(scan.next());
			System.out.println(" 이름 :"+students.get(index).getsName()+"/ 나이:"+ students.get(index).getsAge()+ "/ 전공"+ students.get(index).getsMajor());
			break;
		case 3: // 삭제정보
			
			for(Student dData : studentExpel.expelStudents) {
				System.out.println(" 이름 :"+dData.getsName()+"/ 나이:"+ dData.getsAge()+"/ 학번:"+ dData.getsNum()+"/ 전공"+ dData.getsMajor());
			}
			break;
		case 4: // 기타
			
			break;
		
		}

	}

	// 추가 메소드
	private void addStudent() {
		System.out.println(" 학생 정보를 추가합니다.");
		System.out.print(" 이름 : ");
		String name = scan.next();
		System.out.print(" 나이 : ");
		String age = scan.next();
		
		boolean Same = false;
		String num = null; 
		while(!Same){
			System.out.print(" 학번 : ");
			num = scan.next();
			
			for(Student nData : students) {
				if(nData.getsNum().equals(num)) {
					System.out.println("중복된 학번입니다. 다른 숫자를 입력해주세요.");
					break;
					
				}else if(students.get(students.size()-1).equals(nData)){
					Same = true;
				}
			}
		}
		System.out.print(" 전공 : ");
		String major = scan.next();
		
		students.add(new Student(name, age, num, major));
		// 정보를 입력받아 students 배열에 추가
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
				updateStudent(index); // 수정
				break;
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}
	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		int index = -1;
		
		for(int i= 0; i<students.size(); i++) {
			if(students.get(i).getsNum().equals(studentNum)) {
				index = i;
				break;
			}
		}
		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

	// 수정 메소드
	boolean updateStudent(int index) {
		boolean done = false;
		// 수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공] 
		int sels = scan.nextInt();// 수정할 항목 선택 변수
		switch(sels) {
		
		case 1: // 이름 수정
			System.out.println(" 수정할 이름을 입력해주세요.");
			students.get(index).setsName(scan.next());
			break;
		case 2: // 나이 수정
			System.out.println(" 수정할 나이를 입력해주세요.");
			students.get(index).setsAge(scan.next());
			break;
		case 3: // 학번 수정
			System.out.println(" 수정할 학번을 입력해주세요.");
			students.get(index).setsNum(scan.next());
			break;
		case 4: // 전공 수정
			System.out.println(" 수정할 전공을 입력해주세요.");
			students.get(index).setsMajor(scan.next());
			break;
		}
		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		System.out.println("[학생정보 삭제] 학번을 입력해주세요.");
		//[학생정보 삭제] 학번을 입력해주세요 : 
		int index = searchStudents(scan.next());
		studentExpel.addExpelStudents(students.get(index));
		students.remove(index);
		}

}
