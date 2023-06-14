/*	멤버필드는 모두 String으로 작성하기
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	private String Name;
	private String Age;
	private String StudentNum;
	private String Major;
	
	public String getName() {
		return Name;
	}
	public String setName(String Name) {
		return this.Name = Name;
	}
	public String getAge() {
		return Age;
	}
	public String setAge(String Age) {
		return this.Age = Age;
	}
	public String getStudentNum() {
		return StudentNum;
	}
	public String setStudentNum(String StudentNum) {
		return this.StudentNum = StudentNum;
	}
	public String getMajor() {
		return Major;
	}
	public String setMajor(String Major) {
		return this.Major = Major;
	}

	public Student(String Name, String Age, String StudentNum, String Major) {
		super();
		this.Name = Name;
		this.Age = Age;
		this.StudentNum = StudentNum;
		this.Major = Major;
	}
}