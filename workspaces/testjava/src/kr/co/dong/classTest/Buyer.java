package kr.co.dong.classTest;

import java.util.Vector;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector<>();
	
	void buy(Product p) {
		/* 물건을 산다 */
		this.money -= p.price;
		this.bonusPoint += p.point;
		System.out.println(p.toString() + "을/를 구매하였습니다.");
		
		item.add(p);
	}
	
	void refund(Product p) {
		this.money += p.price;
		this.bonusPoint -= p.point;
		System.out.println(p.toString() + "을/를 반품하였습니다.");
		item.remove(p);
	}
	
	void summary() {
		int sum = 0;
		String itemList;
		
		if(item.isEmpty()) {
			System.out.println("구매한 물품이 없습니다.");
			return;
		}
		
		for(int i = 0; i<item.size(); i++) {
			Product p = (Product)item.get(i);
			sum += p.price;
			System.out.println("총 구매한 금액은 "+sum+"만원입니다.");
			System.out.println("총 구매한 물품은 "+item+"입니다.");
		}
		
	}

}
