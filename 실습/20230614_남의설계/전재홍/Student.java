/*	멤버필드는 모두 String으로 작성하기
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	
	private boolean sState = false; // 학생 상태 (일단 보류)
	private String sName; // 학생 이름
	private String sAge; // 학생 나이
	private String sNum; // 학번
	private String sMajor; // 전공

	
public Student(String sName, String sAge, String sNum, String sMajor) { 
	super();
	this.sName = sName;
	this.sAge = sAge;
	this.sNum = sNum;
	this.sMajor = sMajor;
	
}

public String getsName() { // 이름 가져오기
	return sName;
}
public void setsName(String sName) { // 이름 정하기
	this.sName = sName;
}

public String getsAge() { // 나이 가져오기
	return sAge;
}
public void setsAge(String sAge) { // 나이 정하기
	this.sAge = sAge;
}

public String getsNum() { // 학번 가져오기
	return sNum;
}

public void setsNum(String sNum) { // 학번 정하기
	this.sNum = sNum;
}

public String getsMajor() { // 전공 가져오기
	return sMajor;
}
public void setsMajor(String sMajor) { // 전공 정하기
	this.sMajor = sMajor;
}

public boolean isState(){
	return sState;
}

public void setsState(boolean sState) {
	this.sState = sState;
}


}//Class ED
