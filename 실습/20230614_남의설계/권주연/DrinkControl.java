// 음료 자판기 구현하기
// 1. 음료 종류, 가격, 재고
// 2. 구매하기, 판매하기, 금액지불하기, 잔돈주기, 재고&가격&종류 수정하기, 현황확인하기
package jpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.co.dong.room.Room;

public class DrinkControl {
	Scanner scan = new Scanner(System.in);
	List<Drink> drinks = new ArrayList<Drink>();
	Drink m = new Drink();

	void init() {
		drinks.add(new Drink("옥수수수염차", 1800, 5));
		drinks.add(new Drink("초코에몽", 1500, 10));
		drinks.add(new Drink("생수", 700, 7));
		drinks.add(new Drink("커피우유", 800, 0));
	}

	String manu() {

		System.out.println("현재 잔액 : " + m.getMoniy());
		System.out.println("              ▶ 원하는 메뉴를 입력하세요 ◀              ");
		System.out.println("=================================================");
		System.out.println("1. 금액투입 2. 음료선택 3. 잔돈반환 4. 수정 5. 보기 99. 종료");

		return scan.next();

	}

	void drinkPlay(String sel) {
		// TODO Auto-generated method stub
		switch (sel) {
		case "1": // 금액투입
			deposit(); // 입금
			break;

		case "2": // 음료선택
			choice(); // 선택
			break;

		case "3":// 잔돈반환
			returnP(); // 반환
			break;

		case "4": // 수정
			crystal();
			break;

		case "5": // 보기
			drinkView();
			break;

		case "99":// 종료

			break;

		default:
			System.out.println("프로그램을 종료합니다. 감사합니다 :)");
		}
	}

	private void deposit() { // 금액 투입
		// TODO Auto-generated method stub
		System.out.println("금액을 투입해주세요. ");
		int money = scan.nextInt();

		m.setMoniy(m.getMoniy() + money);

	}

	private void choice() { // 메뉴선택
		// TODO Auto-generated method stub
		for (int i = 0; i < drinks.size(); i++) {
			System.out.println(drinks.get(i));
		}
		System.out.println("드실 음료를 선택해주세요.");
		String name = scan.next();
		searchDriknk(name);
		int index = searchDriknk(name);
		if (index == -1) {
			System.out.println("다시 선택해주세요.");
		} else {
			if (drinks.get(index).getStock() == 0) {
				System.out.println("재고가 없습니다.");
			} else if (m.getMoniy() < drinks.get(index).getPrice()) {
				System.out.println("잔액이 부족합니다.");
			} else {
				System.out.println("선택하신 음료가 나옵니다.");
				drinks.get(index).setStock(drinks.get(index).getStock() - 1);
				m.setMoniy(m.getMoniy() - drinks.get(index).getPrice());
			}
		}

	}

	private void returnP() { // 잔돈반환
		System.out.println("잔돈이 반환됩니다 : " + m.getMoniy());
		m.setMoniy(0);
	}

	// 수정 메인 메소드
	private void crystal() { // 수정(종류, 금액, 재고)
		
		for (int i = 0; i < drinks.size(); i++) {
			System.out.println(drinks.get(i));
		}
		System.out.println("드실 음료를 선택해주세요.");
		String name = scan.next();
		searchDriknk(name);
		int index = searchDriknk(name);
		if (index == -1) {
			System.out.println("다시 선택해주세요.");
		} else {
			System.out.println("             ▶ 확인하실 번호를 입력하세요 ◀            ");
			System.out.println("===============================================");
			System.out.println("1. 종류수정 2. 금액수정 3. 재고수정 88.돌아가기");
			int sel = scan.nextInt();

			switch (sel) {
			case 1: // 종류수정
				System.out.println("수정할 음료를 입력해주세요 : ");
				String cName = scan.next();
				drinks.get(index).setName(cName);
				break;
			case 2: // 금액수정
				System.out.println("수정할 금액을 입력해주세요 : ");
				int cP = scan.nextInt();
				drinks.get(index).setPrice(cP);
				break;
			case 3: // 재고수정
				System.out.println("수정할 재고를 입력해주세요 : ");
				drinks.get(index).setStock(scan.nextInt());
				break;

			case 88: // 돌아가기
				break;

			default:
				break;
			}

		}
	}

	private void drinkView() { // 보기(전체확인 / 구분별 확인)
		// TODO Auto-generated method stub
		System.out.println("             ▶ 확인하실 번호를 입력하세요 ◀            ");
		System.out.println("===============================================");
		System.out.println("1. 전체확인 2. 종류확인 3. 가격확인 4. 재고확인 88. 돌아가기");
		int sel = scan.nextInt();

		switch (sel) {
		case 1: // 전체확인
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i));
			}
			break;
		case 2: // 종류확인
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i).getName());
			}
			break;
		case 3: // 가격확인
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i).getPrice());
			}
			break;
		case 4: // 재고확인
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i).getStock());
			}
			break;

		case 88: // 돌아가기
			break;

		default:
			break;
		}

	}

	// 인덱스 메소드
	int searchDriknk(String name) {
		int index = -1;
		for (int i = 0; i < drinks.size(); i++) {
			if (drinks.get(i).getName().equals(name)) {
				index = i;
			}
		}

		return index; // 검색된 학생정보의 인덱스, 없다면 -1을 리턴
	}

}
