/*	����ʵ�� ��� String���� �ۼ��ϱ�
	name;
	age;
	studentNum;
	major;
*/
package member;

public class Student {
	
	private boolean sState = false; // �л� ���� (�ϴ� ����)
	private String sName; // �л� �̸�
	private String sAge; // �л� ����
	private String sNum; // �й�
	private String sMajor; // ����

	
public Student(String sName, String sAge, String sNum, String sMajor) { 
	super();
	this.sName = sName;
	this.sAge = sAge;
	this.sNum = sNum;
	this.sMajor = sMajor;
	
}

public String getsName() { // �̸� ��������
	return sName;
}
public void setsName(String sName) { // �̸� ���ϱ�
	this.sName = sName;
}

public String getsAge() { // ���� ��������
	return sAge;
}
public void setsAge(String sAge) { // ���� ���ϱ�
	this.sAge = sAge;
}

public String getsNum() { // �й� ��������
	return sNum;
}

public void setsNum(String sNum) { // �й� ���ϱ�
	this.sNum = sNum;
}

public String getsMajor() { // ���� ��������
	return sMajor;
}
public void setsMajor(String sMajor) { // ���� ���ϱ�
	this.sMajor = sMajor;
}

public boolean isState(){
	return sState;
}

public void setsState(boolean sState) {
	this.sState = sState;
}


}//Class ED
