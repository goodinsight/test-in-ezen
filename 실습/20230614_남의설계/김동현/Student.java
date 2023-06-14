/*	멤버필드는 모두 String으로 작성하기
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	private String name;//이름
	private String age;//나이 는 숫자
	private String studentNum;//학번 은 언더바 앤드 숫자
	private String major;//학부전공??!!
	/**
	 * @param name
	 * @param age
	 * @param studentNum
	 * @param major
	 */
	
	public Student() {}
	/**
	 * @param name
	 * @param age
	 * @param studentNum
	 * @param major
	 */
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
		return "Student [name=" + name + ", age=" + age + ", studentNum=" + studentNum + ", major=" + major + "]";
	}
	
	
	}

	
	

