/*
 * 모니터 클래스
 * 속성 : 모니터명, 해상도, 색상, 가격, 전원
 * 기능 : 전원을 끈다/켠다 
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
		System.out.println("전원을 켭니다.");
		this.onOff = true;
	}
	
	void powerOff(){
		System.out.println("전원을 끕니다.");
		this.onOff = false;
	}
	
	void optionMonitor() {
		System.out.println("모니터 이름: " + this.monitorName);
		System.out.println("모니터 해상도: " + this.monitorResolution);
		System.out.println("모니터 색상: " + this.monitorColor);
		System.out.println("모니터 가격: " + this.monitorPrice);
	}
}
