/*	멤버필드는 모두 String으로 작성하기
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	String name = null;
	String age = null;
	String studentNum = null;
	String major = null;
	
	public Student(String name, String age, String studentNum, String major) {
//		생성자
		this.name = name;
		this.age = age;
		this.studentNum = studentNum;
		this.major = major;
	}

//	getters & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentNum=" + studentNum + ", major=" + major + "]";
	}
}
