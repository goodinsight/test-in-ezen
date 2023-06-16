package vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealVendingMachine {
	Scanner scan = new Scanner(System.in);
	vendingMachineControl2 cont2 = new vendingMachineControl2();
	AdminControl adcont = new AdminControl();
//	List<vendingMachine> list = new ArrayList<vendingMachine>();

	void start() {
		cont2.init();
		boolean power = false;
		while (!power) {
			switch (cont2.menu()) {
			case "1":	// 음료메뉴
				cont2.drinkMenu();
				break;
			case "2":	// 결제
				cont2.payMent();
				break;
			case "3":	// 잔돈반환
				cont2.refund();
				break;
			case "4":	// 종료
				System.out.println("종료");
				power = true;
				break;
			case "77":	// 관리자모드
				adminMenu();
				break;
			default :
				System.out.println("숫자만 입력하세요.");	
			}
		}
	}
//	관리자 메뉴
	private void adminMenu() {
		boolean check = false;
		int pass = cont2.choice("비밀번호 입력 : ");
		if (pass != adcont.password(pass)) {
			System.out.println("비밀번호 틀림.");
		} else {
			while (!check) {
				System.out.println("1.음료추가 2.음료제거 3.음료가격변경 4.음료보기 5.매출현황 6.음료재고수정 7.나가기");
				String sel = adcont.strChoice("번호 입력 : ");
				switch (sel) {
				case "1": // 음료추가
					adcont.addDrink(cont2.drink);
					break;
				case "2": // 음료제거
					adcont.deleteDrink(cont2.drink);
					break;
				case "3": // 음료가격변경
					adcont.editPrice(cont2.drink);
					break;
				case "4": // 음료보기
					adcont.view(cont2.drink);
					break;
				case "5": // 매출현황
					adcont.selling(cont2.drink);
					break;
				case "6":
					adcont.plusDrink(cont2.drink);
					break;
				case "7":
					System.out.println("나가기");
					check = true;
					break;
				default:
					System.out.println("숫자만 입력하세요.");
				}
			}
		}
	}
	
	
}
