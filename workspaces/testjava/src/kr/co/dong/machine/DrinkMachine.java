package kr.co.dong.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrinkMachine {
	
	List<Machine> list = new ArrayList<Machine>();
	Map<String, Machine> choiceList = new HashMap<String, Machine>();
	List<Machine> selList = new ArrayList<Machine>();
	MachineControl cnt = new MachineControl();
	AdminControl admin = new AdminControl();
	public void on() {
		boolean b = false;
		cnt.init(list);
		while (!b) {
			cnt.menu();
			switch (cnt.sc.next()) {
			case "1":
				cnt.order(list, choiceList);
				cnt.payment(list, choiceList, selList);
				break;
			case "2":
				cnt.view(list);
				break;
			case "3":
				cnt.returnMoney();
				break;
			case "4":
				cnt.inputMoney();
				break;
			case "5":
				b = !b;
				break;
				
			case "77":
				admin();
				break;
			default:
				System.out.println("매뉴에 있는 숫자만 눌러주세요");
			}
		}
	}
	
	public void admin() {
		if(!(cnt.sc.next().equals("admin01"))) {
			return;
		}
		boolean b = false;
		while (!b) {
			admin.menu();
			switch (cnt.sc.next()) {
			case "0":
				admin.view(list);
				break;
			case "1":
				admin.updateCount(list);
				break;
			case "2":
				admin.sales(selList);
				break;
			case "3":
				admin.updateMenu(list);
				break;
			case "4":
				admin.removeMenu(list);
				break;
			case "5":
				admin.updatePrice(list);
				break;
			case "6":
				b = !b;
				break;
			default:
				System.out.println("매뉴얼에 있는 숫자만 눌러주세요");
			}
		}
		
	}
	
}
