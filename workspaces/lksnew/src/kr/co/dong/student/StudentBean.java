package kr.co.dong.student;

public class StudentBean {
	private int sid;	//순번
	private String name;	//이름
	private int age;	//나이
	private int num;	//학번
	private String major;	//학과
	
	public StudentBean() {
		
	}
	/**
	 * @param sid
	 * @param name
	 * @param age
	 * @param num
	 * @param major
	 */
	public StudentBean(int sid, String name, int age, int num, String major) {
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.num = num;
		this.major = major;
	}
	/**
	 * @param name
	 * @param age
	 * @param num
	 * @param major
	 */
	public StudentBean(String name, int age, int num, String major) {
		this.name = name;
		this.age = age;
		this.num = num;
		this.major = major;
	}
	
	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "StudentBean [sid=" + sid + ", name=" + name + ", age=" + age + ", num=" + num + ", major=" + major
				+ "]";
	}
	
	
		
}

