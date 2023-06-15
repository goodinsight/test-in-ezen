package member;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	FileWriter fw = null;
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // 학생정보를 담고 있는 리스트
	StudentExpel studentExpel = new StudentExpel(); // 삭제된 정보를 담고있는 클래스의 객체 생성

	// 초기값
	void init_a() {
		// 이름, 나이, 학번, 전공 순
		students.add(new Student("홍길동", "5", "1", "ㅁㅁㅁ"));
	}

	// 기본 메뉴 출력메소드
	String menuView() {
		System.out.println("[1. 추가] [2. 수정] [3. 삭제] [4. 보기] [기타. 종료]");
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
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(종료) \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.exit(0);
		}
	}

	// 보기 메소드
	void studentView() {
	//1. 전체보기, 2. 학번검색, 3.삭제정보, 기타. 메뉴");
		System.out.println("[1. 전체보기] [2. 학번검색] [3. 삭제정보] [기타. 종료]");
		switch (scan.nextInt()) {	
		case 1:
			for(Student data : students) {
				System.out.println(data.toString());
			}
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(전체 보기) \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
		case 2:
			System.out.print("[학번 검색] : ");
			int result = searchStudents(scan.next());
			if(result == -1) {
				System.out.println("학번이 올바르지 않습니다.");
			}else {
				System.out.println(students.get(result).toString());
			}
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(학번 검색)" + students.get(result).toString() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
		case 3:
			if(studentExpel.expelStudents.size() != 0) {
				for(Student data : studentExpel.expelStudents) {
					System.out.println(data.toString());
				}
				try {
					fw = new FileWriter("memberLog.txt", true);
					fw.write("(삭제 목록) \n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}else {
				System.out.println("삭제된 학생 정보가 없습니다.");
			}
		default:
			break;
		}
	}

	// 추가 메소드
	private void addStudent() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("나이 : ");
		String age = scan.next();
		String studentNum = null;
		boolean power = false;
		while(!power) {
			System.out.print("학번 : ");
			studentNum = scan.next();
			for(Student data : students) {
				if(data.getStudentNum().equals(studentNum)) {
					System.out.println("중복된 학번입니다.");
					break;
				}else if(students.get(students.size()-1).equals(data)) {
					power = true;
				}
			}
		}
		System.out.print("전공 : ");
		String major = scan.next();
		students.add(new Student(name, age, studentNum, major));
		System.out.println("이름 : " + name + " 나이 : " + age + " 학번 : " + studentNum + " 전공 : " + major + " 추가되었습니다.");
		try {
			fw = new FileWriter("memberLog.txt", true);
			fw.write("(학생 추가)" + "이름 : " + name + " 나이 : " + age + " 학번 : " + studentNum + " 전공 : " + major + " 추가되었습니다." + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
				if(updateStudent(index)) {
					break;
				}else {
					continue;
				}
			} else {
				System.out.println("입력된 학번을 찾지 못했습니다. 다시 입력해주세요."); // 입력오류시 재입력
			}
		}
	}

	// 검색 메소드(학번 기준)
	int searchStudents(String studentNum) {
		int index = -1;
		for(int i = 0; i < students.size(); i++) {
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
		System.out.print("수정할 항목 선택 [1. 이름] [2. 나이] [3. 학번] [4. 전공] : ");
		int sel = scan.nextInt();
		switch (sel) {
		case 1:
			System.out.println("현재 이름 : " + students.get(index).getName());
			System.out.print("수정할 이름 : ");
			String name = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(학생 수정)" + " 기존 이름 : " + students.get(index).getName() + "수정된 이름 : " + name + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setName(name);
			done = true;
			break;
			
		case 2:
			System.out.println("현재 나이 : " + students.get(index).getAge());
			System.out.print("수정할 나이 : ");
			String age = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(학생 수정)" + " 기존 나이 : " + students.get(index).getAge() + "수정된 이름 : " + age + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setAge(age);
			done = true;
			break;
			
		case 3:
			System.out.println("현재 학번 : " + students.get(index).getStudentNum());
			System.out.print("수정할 학번 : ");
			String studentNum = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(학생 수정)" + " 기존 학번 : " + students.get(index).getStudentNum() + "수정된 학번 : " + studentNum + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setStudentNum(studentNum);
			done = true;
			break;
			
		case 4:
			System.out.println("현재 전공 : " + students.get(index).getMajor());
			System.out.print("수정할 전공 : ");
			String major = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(학생 수정)" + " 기존 전공 : " + students.get(index).getName() + "수정된 전공 : " + major + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setMajor(major);
			done = true;
			break;
			
		default:
			break;
		}
		
		return done;
	}

	// 삭제 메소드
	void deleteStudent() {
		//[학생정보 삭제] 학번을 입력해주세요 : 
		System.out.print("[학생정보 삭제] 학번을 입력해주세요 :");
		int index = searchStudents(scan.next());
		studentExpel.addExpelStudents(students.get(index));
		try {
			fw = new FileWriter("memberLog.txt", true);
			fw.write("(학생 삭제)" + students.get(index).toString() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		students.remove(index);
		System.out.println("삭제되었습니다.");
	}

}
