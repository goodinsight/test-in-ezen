package kr.co.dong.studentManage;

public class Student {
	private String studentName;
	private int studentNum;
	private int studentAge;
	private String studentMajor;
		
	public Student(String studentName, int studentNum, int studentAge, String studentMajor){
		this.studentName = studentName;
		this.studentNum = studentNum;
		this.studentAge = studentAge;
		this.studentMajor = studentMajor;
		System.out.println(studentName + "학생이 등");
	}
	
	public void getInfo(int i, Student s) {
		switch (i) {
		case 1:
			System.out.println(s.getStudentName());
			break;
		case 2:
			System.out.println(s.getStudentNum());
			break;
		case 3:
			System.out.println(s.getStudentAge());
			break;
		case 4:
			System.out.println(s.getStudentMajor());
			break;
		}
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentMajor() {
		return studentMajor;
	}

	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	
	
}
