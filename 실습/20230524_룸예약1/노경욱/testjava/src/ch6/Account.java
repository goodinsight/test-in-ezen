/* �������Ŭ����
 * - ���¹�ȣ/ ������ �̸� / �ܾ�
 * - �����Ѵ�/����Ѵ�
 */

package ch6;

public class Account {
	static int cnt;
	public String acoountNo;
	public String ownerName;
	public String etc;
	public int balance;
	public int pNo; //������� ����

//	default ������ -> �ڵ��߻� but �ٸ������ڰ� �ִ� ��� �߻����� ����
	public Account() {
		cnt++;
		pNo = cnt;
		System.out.println("������¹߱�");
	}
	
	

	public Account(String accNo, String onName, int balance) { //String etc) {
		super();
		this.acoountNo = accNo;
		this.ownerName = onName;
		this.balance = balance;
		this.etc = etc;
		cnt++;
		pNo = cnt;
	}

	void deposit(int amount) {
		this.balance += amount;
	}

	int withdraw(int amount) throws Exception{
		if (this.balance < amount) {
//			return 0; // ó���ȵ�
			throw new Exception("�ܾ��� �����մϴ�");
		}
		this.balance -= amount;
		return balance;
		
	}
}
