/*	����ʵ�� ��� String���� �ۼ��ϱ�
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	private String Name;
	private String StudentNum;
	private String Major;
	private String Age;
	
	public Student(String Name, String Age, String StudentNum, String Major) {
		this.Name = Name;
		this.Age = Age;
		this.StudentNum = StudentNum;
		this.Major = Major;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStudentNum() {
		return StudentNum;
	}
	public void setStudentNum(String studentNum) {
		StudentNum = studentNum;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}


	@Override
	public String toString() {
		return "[�̸� : " + Name + ", �й� : " + StudentNum + ", ���� : " + Major + ", ���� : " + Age + "]";
	}
	
	

}
