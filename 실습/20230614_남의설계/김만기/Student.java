/*	멤버필드는 모두 String으로 작성하기
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
	
	/**
	 * @param name
	 * @param age
	 * @param studentNum
	 * @param major
	 */
	public Student(String name, String age, String studentNum, String major) {
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
		return "[학생 이름 : "+name+"] [학생 나이 : "+age+"] [학번 : "+studentNum+"] [과목 : "+major+"]\n";
	}
}
