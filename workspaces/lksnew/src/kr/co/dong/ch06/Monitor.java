/*
 * ����� Ŭ����
 * �Ӽ� : ����͸�, �ػ�, ����, ����, ����
 * ��� : ������ ����/�Ҵ� 
 * 
 */
package kr.co.dong.ch06;

public class Monitor {
	private String monitorName;
	private String monitorResolution;
	private String monitorColor;
	int monitorPrice;
	boolean onOff;
	
	
	
	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getMonitorResolution() {
		return monitorResolution;
	}

	public void setMonitorResolution(String monitorResolution) {
		this.monitorResolution = monitorResolution;
	}

	public String getMonitorColor() {
		return monitorColor;
	}

	public void setMonitorColor(String monitorColor) {
		this.monitorColor = monitorColor;
	}

	
	
	void powerOn(){
		System.out.println("������ �մϴ�.");
		this.onOff = true;
	}
	
	void powerOff(){
		System.out.println("������ ���ϴ�.");
		this.onOff = false;
	}
	
	void optionMonitor() {
		System.out.println("����� �̸�: " + this.monitorName);
		System.out.println("����� �ػ�: " + this.monitorResolution);
		System.out.println("����� ����: " + this.monitorColor);
		System.out.println("����� ����: " + this.monitorPrice);
	}
}
