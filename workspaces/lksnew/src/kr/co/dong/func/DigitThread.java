/* 스레드는 Thread클래스와 Runnable인터페이스로 구현 가능함
 * 
 * 해당 스레드는 0~9까지 출력함
 */
package kr.co.dong.func;

public class DigitThread extends Thread {
	public String name;
	
	public DigitThread() {
		
	}
	
	public DigitThread(String name){
		this.name = name;
		System.out.println(this.name + "이름으로 생성됨");
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.name + "Thread : " + i);
		}
	}

}
