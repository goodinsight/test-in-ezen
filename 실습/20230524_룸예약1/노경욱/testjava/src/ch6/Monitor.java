/* ����� Ŭ����
 * �Ӽ� : ����͸�, �ػ�, ����, ����, ����
 * ���: ������ ���� /������ �Ҵ�.
 */

package ch6;

public class Monitor {
	String name;
	String resol;
	String color;
	int price;
	boolean power;
//	name�� ���Ա��
	public void setName(String name) {
		this.name = name;
	}
	
//	name ������ ���
	public String getName() {
		return this.name;
	}
	
	public Monitor() {

	}

	void powerOn() {
		System.out.println("������ �մϴ�");
		this.power = true;
	}

	void powerOff() {
		System.out.println("������ ���ϴ�");
		this.power = false;
	}
}
