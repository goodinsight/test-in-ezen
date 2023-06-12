package kr.co.dong.ch06;

import java.util.ArrayList;

public class ArrayListTest02 {
	public static void main(String[] args) {
//		3���� ������������� �Է��ϰ� ����ϱ�
		
		ArrayList<Account> list = new ArrayList<Account>();
		
		Account ac1 = new Account("123", "hong1", 20);
		Account ac2 = new Account("223", "hong2", 50);
		Account ac3 = new Account("323", "hong3", 30);
		
		list.add(ac1);
		list.add(ac2);
		list.add(ac3);
		
		for(Account a:list) {
			System.out.println(a);
		}
//		�����ֿ� �ܾ׸� �������
		for (int i = 0; i<list.size(); i++) {
			Account obj = list.get(i);
			System.out.println(obj.ownerName);
			System.out.println(obj.balance);
		}
		
		for(Account a:list) {
			System.out.println(a.ownerName);
			System.out.println(a.balance);
		}
	}
}
