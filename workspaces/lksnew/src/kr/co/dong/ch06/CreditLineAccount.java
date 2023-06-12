/*
 *���̳ʽ� ī�� Ŭ���� 
 * -�������, �����ָ�, �ܾ�, ���̳ʽ��ѵ�
 * -�����Ѵ�, �����Ѵ�(????) 
 * 
 */
package kr.co.dong.ch06;

public class CreditLineAccount extends Account{
	int creditLine;
	
	
	
	public CreditLineAccount() {
		super();
	}
	
	public CreditLineAccount(String accountNo, String ownerName, int balance, int[] a, int creditLine) {
		super(accountNo, ownerName, balance, a);
		this.creditLine = creditLine;
	}

	@Override
	public int withdraw(int amount) throws Exception{
		if (this.balance + this.creditLine < amount) {
//			return 0; // ó���ȵ�
			throw new Exception("�ܾ��� �����մϴ�.");
		}
		this.balance -= amount;
		return amount;// return this.balance;
	}
	
}
