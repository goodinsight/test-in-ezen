/* ������� ThreadŬ������ Runnable�������̽��� ���� ������
 * 
 * �ش� ������� 0~9���� �����
 */
package kr.co.dong.func;

public class DigitThread extends Thread {
	public String name;
	
	public DigitThread() {
		
	}
	
	public DigitThread(String name){
		this.name = name;
		System.out.println(this.name + "�̸����� ������");
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.name + "Thread : " + i);
		}
	}

}
