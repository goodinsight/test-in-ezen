package kr.co.dong.classTest;

import java.util.Vector;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector<>();
	
	void buy(Product p) {
		/* ������ ��� */
		this.money -= p.price;
		this.bonusPoint += p.point;
		System.out.println(p.toString() + "��/�� �����Ͽ����ϴ�.");
		
		item.add(p);
	}
	
	void refund(Product p) {
		this.money += p.price;
		this.bonusPoint -= p.point;
		System.out.println(p.toString() + "��/�� ��ǰ�Ͽ����ϴ�.");
		item.remove(p);
	}
	
	void summary() {
		int sum = 0;
		String itemList;
		
		if(item.isEmpty()) {
			System.out.println("������ ��ǰ�� �����ϴ�.");
			return;
		}
		
		for(int i = 0; i<item.size(); i++) {
			Product p = (Product)item.get(i);
			sum += p.price;
			System.out.println("�� ������ �ݾ��� "+sum+"�����Դϴ�.");
			System.out.println("�� ������ ��ǰ�� "+item+"�Դϴ�.");
		}
		
	}

}
