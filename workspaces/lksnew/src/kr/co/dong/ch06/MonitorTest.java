package kr.co.dong.ch06;

public class MonitorTest {
	public static void main(String[] args) {
		
		Monitor m1 = new Monitor();
		m1.optionMonitor();
		m1.powerOn();
		System.out.println(m1.onOff);
	}
}
