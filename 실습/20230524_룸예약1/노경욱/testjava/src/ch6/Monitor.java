/* 모니터 클래스
 * 속성 : 모니터명, 해상도, 색상, 가격, 전원
 * 기능: 전원을 끈다 /전원을 켠다.
 */

package ch6;

public class Monitor {
	String name;
	String resol;
	String color;
	int price;
	boolean power;
//	name에 대입기능
	public void setName(String name) {
		this.name = name;
	}
	
//	name 얻어오는 기능
	public String getName() {
		return this.name;
	}
	
	public Monitor() {

	}

	void powerOn() {
		System.out.println("전원을 켭니다");
		this.power = true;
	}

	void powerOff() {
		System.out.println("전원을 끕니다");
		this.power = false;
	}
}
