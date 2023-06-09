/*	멤버필드는 모두 String으로 작성하기
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	private String name; //이름
	private String age; // 나이
	private String studentNum; // 학번
	private String major; // 전공
	
	public Student(String name, String age, String studentNum, String major) {
		super();
		this.name = name;
		this.age = age;
		this.studentNum = studentNum;
		this.major = major;
	}
	
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
	public String getMajaor() {
		return major;
	}
	public void setMajaor(String majaor) {
		this.major = majaor;
	}
	
	@Override
	public String toString() {
		return "[이름 : " + name + "], [나이 : " + age + "], [학번 : " + studentNum + "], [학과 : " + major + "]";
	}
	

}
