package kr.co.dong.shopping;

import java.util.ArrayList;
import java.util.List;

public class Shopping {

	public static void main(String[] args) {
		boolean power = false;
		List<Product> pList = new ArrayList<Product>();
		Customer cus;
		Menu menu = new Menu();
		ManagerAble manager = new ManagerAble();

		manager.init(pList);

		while (!power) {
			int sel = menu.menu();
			switch (sel) {
			case 1:
				System.out.println("======================");
				cus = new Customer((Etc.inputMS("이름을 입력해주세요 : ")));
				do {
					sel = menu.cMode(cus.getName());
					switch (sel) {
					case 1:
						menu.cMode1(pList);
						break;
					case 2:
								
						break;
					case 3:
													
						break;
					case 88:
						
						break;
					default:
						System.out.println("잘못된 선택입니다.");
						break;
					}
				} while(sel != 2 && sel != 3 && sel != 88);
				break;
			case 2:
				break;
			case 99:
				System.out.println("이용해 주셔서 감사합니다");
				power = true;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}
}
