package kr.co.dong.machine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MachineControl {
	
	BufferedReader br = null;

	Scanner sc = new Scanner(System.in);
	int money;
//	자판기 초기설정
	public void init(List<Machine> list) {
		
		try {
			br = new BufferedReader(new FileReader("drinkList.txt"));
			String str = "";
			while ((str = br.readLine()) != null) {
				String[] str2 = str.split(",");
				String name = str2[0];
				int price = Integer.parseInt(str2[1]);
				int count = Integer.parseInt(str2[2]);
				list.add(new Machine(name, price, count));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//		list.add(new Machine("제로팹시라임", 2500, 10));
//		list.add(new Machine("포카리스웨트", 1500, 10));
//		list.add(new Machine("블루하와이", 2000, 10));
	}
	
//	자판기 매뉴얼
	public void menu() {
		System.out.println("1. 결제 2. 조회 3. 잔돈 4. 충전 5. 종료");
	}
	
//	자판기 매뉴 조회
	public void view(List<Machine> list) {
		for (Machine machine : list) {
			System.out.println(machine);
		}
	}
	
//	자판기 음료 선택
	public void order(List<Machine> list, Map<String, Machine> choiceList) {
		view(list);
		String name = msg("음료를 선택해주세요");
		int index = findName(name, list);
		int count = 0;
		if(index > -1 && list.get(index).getCount() != 0) {
			try {
				while (true) {
					count = count(index, msg("음료의 개수를 입력해주세요"), list);
					if(count <= 0) {
						System.out.println("1개 이상의 재고를 입력하세요.");
					}else {
						choiceList.put("userlist",new Machine(name, list.get(index).getPrice(), count));
						break;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요");
			}
			
		}else if(index > -1 && list.get(index).getCount() == 0) {
			System.out.println("음료의 재고가 없습니다 다음에 이용해주세요.");
		}else{
			System.out.println("입력하신 음료는 저희 자판기에서 판매하지 않는 음료입니다 다시 입력해주세요.");
			order(list, choiceList);
		}
		choiceList.get("userlist");
	}
	
//	결재
	public void payment(List<Machine> list , Map<String, Machine> choiceList, List<Machine> selList) {
		Machine userlist = choiceList.get("userlist");
		if(userlist == null) {
			return;
		}
		int price = userlist.getCount() * userlist.getPrice();
		
		while (true) {
			if(money < price) {
				char c = msg("금액이 부족합니다 추가결제 하시겠습니까 Y/N").charAt(0);
				if(c == 'Y') {
					try {
						money += Integer.parseInt(msg("추가결제하실 금액을 입력해주세요 ==> 부족한 금액 " + (price - money)+"원"));
					} catch (NumberFormatException e) {
						System.out.println("숫자만 입력하세요");
					}
				}else if(c == 'N') {
					choiceList.remove("userlist");
					System.out.println("매뉴로 이동합니다.");
					break;
				}else {
					System.out.println("Y or N만 입력해주세요");
				}
			}else {
				System.out.println("이용해주셔서 감사합니다.");
				selList.add(userlist);
				int index = findName(userlist.getDrink(), list);
				int count = list.get(index).getCount() - userlist.getCount();
				list.get(index).setCount(count);
				choiceList.remove("userlist");
				money -= price;
				break;
			}
		}
		
	}
	
	
//	사용자 메세지 출력
	public String msg(String msg) {
		System.out.println(msg);
		return sc.next();
	}
	
//	입력한 음료 존재 여부 조회
	public int findName(String name, List<Machine> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getDrink())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
//	재고 개수 비교
	public int count(int index, String sel, List<Machine> list) {
		int count = list.get(index).getCount();
		if(Integer.parseInt(sel) > count) {
			count(index, msg("자판기안의 음료개수가 부족합니다 다시 입력해주세요."), list);
		}
		return Integer.parseInt(sel);
	}
	
//	자판기에 금액 넣기
	public void inputMoney() {
		try {
			money += Integer.parseInt(msg("돈을 넣어주세요 현재금액 : " + money));
			System.out.println("금액이 충전되셨습니다 현재금액 : " +money);
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요");
		}
	}
//	잔돈 반환
	public void returnMoney() {
		if(money > 0) {
			System.out.println("잔돈은 "+money+"원입니다.");
			money -= money;
		}else {
			System.out.println("잔액이 없습니다.");
		}
		
	}
}
