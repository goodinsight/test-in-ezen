/*	����ʵ�� ��� String���� �ۼ��ϱ�
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	
	private String name;
	private String age;
	private String studentNum;
	private String major;
	
	
	public Student() {
	}
	
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "�̸� : " + name + " / ���� : " + age + " / �й� : " + studentNum + " / ���� : " + major;
	}
	

}
