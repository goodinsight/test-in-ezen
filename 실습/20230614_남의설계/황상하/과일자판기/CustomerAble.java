package vendingMahchine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerAble {
	Scanner scan = new Scanner(System.in);
	Customer cus;
	List<Fruit> bList;
	String back;
	public CustomerAble() {
		cus = new Customer();
		bList = new ArrayList<Fruit>();
	}

	void addCustomer() { // 등록
		System.out.println("========================");
		System.out.print("이름을 입력해주세요 : ");
		String cName = scan.next();
		cus.setcName(cName);
	}

	// 충전
	void addMoney() {
		System.out.println("========================");
		System.out.print("충전하실 금액을 입력해주세요 :");
		int money = scan.nextInt();
		cus.setcMoney(cus.getcMoney() + money);
	}

	// 구입
	void buyFruit(List<Fruit> fList, Customer cus, int num, int count) {
		if (fList.get(num - 1).getfCount() < count) {
			System.out.println("========================");
			System.out.println("입력하신 개수보다 재고가 적습니다.");
		} else if (fList.get(num - 1).getfPrice() * count > cus.getcMoney()) {
			System.out.println("보유하신 금액이 부족합니다.");
		} else {
			addBlist(fList.get(num - 1).getfName(), fList.get(num - 1).getfPrice() * count, count);
			fList.get(num-1).setfCount(fList.get(num-1).getfCount()-count);
			cus.setcMoney(cus.getcMoney()-fList.get(num - 1).getfPrice() * count);
		}
	}

	// 구매내역 추가
	void addBlist(String fName, int fPrice, int fCount) {
		bList.add(new Fruit(fName, fPrice, fCount));
	}

	// 구매내역 제거
	void delBlist() {
		
	}
	// 구매내역 확인
	void viewBlist() {
		int allPrice=0;
		if(bList.size() == 0) {
			System.out.println("======= 과일 구매내역 =======");
			System.out.println(" [종류 /  주문가격  / 주문개수]");
			System.out.println("------------------------");
			System.out.println("   주문하신 내역이 없습니다.");
			System.out.println("========================");
			System.out.print("돌아가시려면 아무키나 입력해주세요.");
			back = scan.next();
		}else {		
			System.out.println("======= 과일 구매내역 =======");
			System.out.println("  [종류 /  주문가격  / 주문개수]");
			System.out.println("------------------------");
			for (int i = 0; i < bList.size(); i++) {
				System.out.println("  " + bList.get(i));
			}
			System.out.println("------------------------");
			for (int i = 0; i < bList.size(); i++) {
				allPrice += bList.get(i).getfPrice();
			}
			System.out.println("  [총 주문가격 : "+ allPrice+"원]");
			System.out.println("========================");
			System.out.print("돌아가시려면 아무키나 입력해주세요.");
			back = scan.next();
		}
	}
}
