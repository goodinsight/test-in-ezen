package ch6;

import java.util.ArrayList;

public class ArryListTest02 {
	public static void main(String[] args) {
//		3���� ������������� �Է��ϰ� ����ϱ�
		ArrayList<Account> list = new ArrayList<Account>();

		Account ac1 = new Account();
		Account ac2 = new Account();
		Account ac3 = new Account();
		Account ac4 = new Account();

		list.add(ac1);
		list.add(ac2);
		list.add(ac3);

		for (int i = 0; i < list.size(); i++) {
			Account obj = list.get(i);
			System.out.println(obj);
		}
		System.out.println("=====================");

//		�����ֿ� �ܾ׸� ����ϱ�
		for (int i = 0; i < list.size(); i++) {
			Account obj = list.get(i);
			System.out.println("������" + list.get(i).ownerName);
			System.out.println("�ܾ�:" + list.get(i).balance);
		}
//		���� for��
		for (Account obj : list) {
			System.out.println("������" + obj.ownerName);
			System.out.println("�ܾ�:" + obj.balance);
		}
	}
}
