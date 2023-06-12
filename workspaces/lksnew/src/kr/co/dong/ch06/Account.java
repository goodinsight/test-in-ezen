/* ������� Ŭ����
 * - ���¹�ȣ / �������̸� / �ܾ�
 * - �����Ѵ� / ����Ѵ�
 * 
 */
package kr.co.dong.ch06;

public class Account {
	
	public static int cnt;	// Ŭ���� ������� ��
	public int productNumber;	// ������� ������ȣ(����)
	public String accountNo;
	public String ownerName;
	public String etc;
	public int balance;
	

	public int[] a = new int[0];
	
	//	default ������ -> �ڵ��߻� but �ٸ������ڰ� �ִ°�� �߻���������
	public Account() {
		System.out.println("������¹߱�!!!!!");
		cnt++;
		this.productNumber = cnt;
	}
	
	
	public Account(String accountNo, String ownerName, int balance, int[] a) {
		this(accountNo, ownerName, balance);
		this.a = a;
		cnt++;
		this.productNumber = cnt;
	}


	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		cnt++;
		this.productNumber = cnt;
	}

	void deposit(int amount) {
		this.balance += amount;
	}

	public int withdraw(int amount) throws Exception{
		if (this.balance < amount) {
//			return 0; // ó���ȵ�
			throw new Exception("�ܾ��� �����մϴ�.");
		}
		this.balance -= amount;
		return amount;// return this.balance;
	}

	public int printAccount(int b) {
		// TODO Auto-generated method stub
//		System.out.println("���������� �̸��� " + this.ownerName + "�̰�,");
//		System.out.println("���¹�ȣ�� " + this.accountNo + "�̰�,");
//		System.out.println("���� �ܾ��� " + this.balance + "�Դϴ�.");
		b = b + 1;
		
		return b;
	}
	
	@Override
	public String toString() {
		return "�������Ŭ���� [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
}
