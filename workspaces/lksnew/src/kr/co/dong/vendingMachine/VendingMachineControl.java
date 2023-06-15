package kr.co.dong.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineControl {
	List<Product> list = null; // 자판기에 들어가는 음료를 담는 리스트
	MoneyChanger moneyChanger = null; // 거스름돈 반환기 (잔돈 갯수 세팅해 줘야함)
	Customer customer = null; // 자판기에 돈을 넣으면 손님 인스턴스를 생성
	Menu menu = new Menu(); // 메뉴 불러올때 사용
	Administrator admin = new Administrator();
	FileControl fileControl = null;

	public void init() {
		// 파일에서 음료 정보 불러와서 세팅
		fileControl = new FileControl();
		moneyChanger = new MoneyChanger();
		customer = new Customer();
		list = fileControl.init();
		if (list == null)
			list = new ArrayList<Product>();
	}

	public String menuView() {
		menu.showTitle("< 음료 자판기 >");
		System.out.println("1. 돈을 넣는다  2. 음료를 뽑는다 3.잔돈을 반환한다 4. 관리자 메뉴로 간다 5. 종료");
		String select = menu.askChoice("메뉴를 선택하세요 : ");
		return select;
	}

	public void vendingMachinePlay(String select) {
		// 자판기 메인 메뉴
		switch (select) {
		case "1":
			insertMoney();
			break;
		case "2":
			getBevarage();
			break;
		case "3":
			returnMoney();
			break;
		case "4":
			String sel = "";
			while (!sel.equals("4")) {
				sel = adminView();
				adminPlay(sel);
			}
			break;
		case "5":
			System.out.println("자판기 프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("메뉴를 다시 골라주세요.");
			break;
		}

	}

	private void adminPlay(String sel) {
		// 관리자 메뉴 선택
		switch (sel) {
		case "1":
			admin.controlProduct(list);
			break;
		case "2":
			admin.controlChange(moneyChanger);
			break;
		case "3":
			admin.controlIncome();
			break;
		case "4":
			System.out.println("관리자 모드를 종료합니다.");
			break;
		default:
			System.out.println("메뉴를 다시 골라주세요.");
			break;
		}
	}

	private String adminView() {
		// 관리자 메뉴
		menu.showTitle("<관리자 메뉴>");
		System.out.println("1. 상품관리 2. 잔돈관리 3. 매출관리 4. 종료");
		String select = menu.askChoice("메뉴를 선택하세요: ");
		return select;
	}

	private void returnMoney() {
		// 잔돈 반환
		moneyChanger.returnOfChange(customer.getMoney());
		customer.setMoney(0);
	}

	private void getBevarage() {
		// 음료 제공
		menu.showTitle("<음료를 고르세요>");
		customer.showMoney();
		fileControl.readFile();
		String select = menu.askChoice("어떤 음료를 고르시겠습니까? ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == (Integer.parseInt(select))) {
				System.out.println(list.get(i).getName() + "을 받으세요");
				int tmp = list.get(i).getNumberOfProduct();
				list.get(i).setNumberOfProduct(tmp - 1); // 재고 1개 감소시킴
				fileControl.updateFile(list); // 재고 수정사항을 파일에 반영
				fileControl.readFile();
				tmp = customer.getMoney();
				customer.setMoney(tmp - list.get(i).getPrice()); // 고객 돈 음료가격만큼 차감
			}
		}
	}

	private void insertMoney() {
		// 돈 투입
		menu.showTitle("<화폐 투입>");
		String insert = menu.askChoice("얼마를 넣으시겠습니까? ");
		if (insert.equals("50000") || insert.equals("10000") || insert.equals("5000") || insert.equals("1000")
				|| insert.equals("500") || insert.equals("100")) {
			int tmp = customer.getMoney();
			customer.setMoney(Integer.parseInt(insert) + tmp); // 고객돈 누적
			moneyChanger.insertMoney(Integer.parseInt(insert));
			System.out.println("잔액은 " + insert);
		} else {
			System.out.println("존재하지 않는 화폐입니다.");
		}
	}
}
