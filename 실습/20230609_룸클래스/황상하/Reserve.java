/*
 * ȣ�� ���� ���α׷� �����ϱ� ver1.0
 * - ȣ�ڹ� : ���̸�, ȣ��, ����, ����, �������
 * - �濹�� : ȣ��, �����ڸ�, �����ڵ�
 * - ��� : ȣ�ڷ� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�
 * - �մԱ�� : �����ϱ�, �������, 
 * - �����ڱ�� : �������� Ȯ��
*/
package kr.co.dong.room;

public class Reserve extends Room {
	private String cumtomer;
	private int revCode;
	
	
	public Reserve(int rNo, String cumtomer, int revCode) {
		super.rNo = rNo;
		this.cumtomer = cumtomer;
		this.revCode = revCode;
	}
	public String getCumtomer() {
		return cumtomer;
	}
	public void setCumtomer(String cumtomer) {
		this.cumtomer = cumtomer;
	}
	public int getRevCode() {
		return revCode;
	}
	public void setRevCode(int revCode) {
		this.revCode = revCode;
	}
	
	@Override
	public String toString() {
		return "Reserve "+rNo+"[������ : " + cumtomer + " / �����ڵ� : " + revCode+"]";
	}
	
}
