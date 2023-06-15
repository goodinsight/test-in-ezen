package kr.co.dong.vendingMachine;

import java.util.List;

public class Administrator {
	Menu menu = new Menu();
	void controlProduct(List<Product> list) {
		// 상품관리
		String sel = productView();
		productPlay(sel);
	}
	
	private void productPlay(String select) {
		// 상품 관리
				switch (select) {
				case "1":
					modifyName();
					break;
				case "2":
					modifyPrice();
					break;
				case "3":
					modifyNumber();
					break;
				case "4":
					System.out.println("이전 메뉴로 이동합니다.");
					break;
				default:
					System.out.println("메뉴를 다시 골라주세요.");
					break;
				}
	}

	private void modifyNumber() {
		// 상품 재고 수정
		
	}

	private void modifyPrice() {
		// 상품 가격 변경
		
	}

	private void modifyName() {
		// 상품 이름 변경
		
	}

	private String productView() {
		menu.showTitle("상품 관리");
		System.out.println("1.이름 변경 2.가격 변경 3.재고 변경 4. 이전메뉴");
		String select = menu.askChoice("메뉴를 선택하세요 : ");
		return select;
	}

	void controlChange(MoneyChanger moneyChanger) {
		// 잔돈관리
		System.out.println("구현 준비중");
	}
	
	
	void controlIncome() {
		// 매출관리
		System.out.println("구현 준비중");
		
	}
}
