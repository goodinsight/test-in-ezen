package kr.co.dong.vendingMachine;

import java.util.List;

public class Administrator {
	Menu menu = new Menu();
	FileControl fileControl = new FileControl();

	void controlProduct(List<Product> list) {
		// 상품관리
		List<Product> tmp = list;
		String sel = productView();
		productPlay(sel, tmp);
	}

	private void productPlay(String select, List<Product> list) {
		// 상품 관리
		switch (select) {
		case "1": // 상품 추가
			addProductPlay(list);
			break;
		case "2": // 상품 삭제
			removeProductPlay(list);
			break;
		case "3": // 상품 수정
			String sel = modifyProductView();
			modifyProductPlay(sel, list);
			break;
		case "4":
			System.out.println("이전 메뉴로 이동합니다.");
			break;
		default:
			System.out.println("메뉴를 다시 골라주세요.");
			break;
		}
	}

	private String modifyProductView() {
		menu.showTitle("상품 수정");
		System.out.println("1.이름 변경 2.가격 변경 3.재고 변경 4. 이전메뉴"); // 위의 메뉴로 수정하고 3번 하위로 집어넣을것
		String select = menu.askChoice("메뉴를 선택하세요 : ");
		return select;
	}

	private void addProductPlay(List<Product> list) {
		// 상품 추가
		try {
			menu.showTitle("상품 추가");
			System.out.println("<안내> 차례대로 상품 카테고리, 이름, 가격, 상품설명, 재고를 입력하세요");
			String category = menu.askChoice("상품 카테고리를 입력하세요: ");
			String name = menu.askChoice("상품 이름을 입력하세요: ");
			String price = menu.askChoice("상품 가격을 입력하세요: ");
			String content = menu.askChoice("상품 설명을 입력하세요: ");
			String num = menu.askChoice("재고 수량을 입력하세요: ");
			Product p = new Product(category, name, Integer.parseInt(price), content, Integer.parseInt(num));
			list.add(p);
			fileControl.writeFile(p);

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("상품추가에 실패하였습니다.");
		}
	}

	private void removeProductPlay(List<Product> list) {
		// 상품 삭제
		menu.showTitle("상품 삭제");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("어떤 상품을 삭제하시겠습니까? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String choice = menu.askChoice("해당 상품을 정말 삭제 하시겠습니까?(삭제를 원하시면 y를 입력) ");
				if (choice.equals("y")) {
					fileControl.deleteFile(list.get(i));
					list.remove(i);
					System.out.println("상품이 삭제 되었습니다.");
				} else {
					System.out.println("삭제 진행을 멈추었습니다.");
				}
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("해당 상품은 상품목록에 없습니다.");
		}
	}

	private void modifyProductPlay(String select, List<Product> list) {
		// 상품 수정
		switch (select) {
		case "1":
			modifyName(list); // 상품 이름 변경
			break;
		case "2":
			modifyPrice(list); // 상품 가격 변경
			break;
		case "3":
			modifyNumber(list); // 상품 재고 수정
			break;
		case "4":
			System.out.println("이전 메뉴로 이동합니다.");
			break;
		default:
			System.out.println("메뉴를 다시 골라주세요.");
			break;
		}
	}

	private void modifyNumber(List<Product> list) {
		// 상품 재고 수정
		menu.showTitle("재고 변경");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("어떤 상품을 변경하시겠습니까? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String num = menu.askChoice("바꾸실 재고의 수량을 입력하세요: ");
				list.get(i).setNumberOfProduct(Integer.parseInt(num));
				System.out.println("상품의 재고가 \"" + list.get(i).getNumberOfProduct() + "\" 로 변경되었습니다.");
				fileControl.updateFile(list);
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("해당 상품은 상품목록에 없습니다.");
		}
	}

	private void modifyPrice(List<Product> list) {
		// 상품 가격 변경
		menu.showTitle("가격 변경");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("어떤 상품을 변경하시겠습니까? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String num = menu.askChoice("바꾸실 가격을 입력하세요: ");
				list.get(i).setPrice(Integer.parseInt(num));
				System.out.println("상품의 가격이 \"" + list.get(i).getPrice() + "원\" 로 변경되었습니다.");
				fileControl.updateFile(list);
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("해당 상품은 상품목록에 없습니다.");
		}
	}

	private void modifyName(List<Product> list) {
		// 상품 이름 변경
		menu.showTitle("이름 변경");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("어떤 상품을 변경하시겠습니까? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String newName = menu.askChoice("바꾸실 이름을 입력하세요: ");
				list.get(i).setName(newName);
				System.out.println("상품이름이 \"" + list.get(i).getName() + "\" 로 변경되었습니다.");
				fileControl.updateFile(list);
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("해당 상품은 상품목록에 없습니다.");
		}
	}

	private String productView() {
		menu.showTitle("상품 관리");
		System.out.println("1.상품 추가 2.상품 삭제 3.상품 수정 4. 이전메뉴");
		String select = menu.askChoice("메뉴를 선택하세요 : ");
		return select;
	}

	void controlChange(MoneyChanger moneyChanger) {
		// 잔돈관리
		menu.showTitle("잔돈 관리");
		System.out.println(moneyChanger.toString());
		System.out.println("1."+MoneyChanger.moneyName[0]+ " 2."+MoneyChanger.moneyName[1] +" 3." +MoneyChanger.moneyName[2] +" 4." + MoneyChanger.moneyName[3]+ " 5." + MoneyChanger.moneyName[4] + " 6." + MoneyChanger.moneyName[5]);
		String select = menu.askChoice("어떤 잔돈의 수량을 수정하시겠습니까: ");
		try {
			if(Integer.parseInt(select) >= 1 && Integer.parseInt(select) <= 6) {
				String num = menu.askChoice("바꾸실 수량을 입력하세요: ");
				moneyChanger.moneyCount[Integer.parseInt(select)-1] = Integer.parseInt(num);
				System.out.println(MoneyChanger.moneyName[Integer.parseInt(select)-1] +"의 수량이 \"" + moneyChanger.moneyCount[Integer.parseInt(select)-1] + "개\" 로 변경되었습니다.");
			}else
				System.out.println("메뉴를 다시 선택해주세요.");			
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
	}

	void controlIncome(LogFileControl logFileControl) {
		// 매출관리
		menu.showTitle("매출 관리");
		System.out.println("현재까지 총 매출 : " + logFileControl.sum);
		System.out.println("1. 음료별 판매현황 2. 음료별 매출현황 3. 음료별 매출추이 그래프 (기타).이전메뉴");
		String select = menu.askChoice("메뉴를 선택하세요 : ");
		switch (select) {
		case "1":
			menu.showTitle("음료별 판매현황");
			logFileControl.showBeverageSaleNum();
			break;
		case "2":
			menu.showTitle("음료별 매출현황");
			logFileControl.showBeverageSaleMoney();
			break;
		case "3":
			menu.showTitle("시간순 전체 매출 목록");
			logFileControl.readFile();
			break;
		
		default:
			break;
		}
		

	}
}
