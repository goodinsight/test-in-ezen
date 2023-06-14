package kr.co.dong.shopping;

import java.util.List;

public class ManagerAble {
	//매출 확인
	//상품 변경(상품이름)
	//상품 변경(상품가격)
	//상품 변경(상품갯수)
	public void init(List<Product> pList) { // 상품초기화
		pList.add(new Product("딸기", 1000, 40));
		pList.add(new Product("수박", 3000, 30));
		pList.add(new Product("참외", 5000, 20));
		pList.add(new Product("메론", 7000, 10));
	}
}
