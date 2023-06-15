package vendingMahchine;

import java.util.ArrayList;
import java.util.List;

public class ManagerAble {
	Fruit fruit;
	List<Fruit> fList;

	public ManagerAble() {
		fList = new ArrayList<Fruit>();
	}
	
	void init() {
		fList.add(new Fruit("딸기", 2000, 40));
		fList.add(new Fruit("참외", 4000, 30));
		fList.add(new Fruit("수박", 6000, 20));
		fList.add(new Fruit("메론", 8000, 0));
	}
	
	// 상품이름변경
	void changeName() {
		
	}
	// 상품가격변경
	void changePrice() {
		
	}
	// 상품개수변경
	void changeCount() {
		
	}
	// 매출확인
	void checkSale() {
		
	}
}
