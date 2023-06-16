package vendingMachine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminControl {
	Scanner scan = new Scanner(System.in);

//		관리자모드 비번
	int password(int pass) {
		int password = 1234;
		return password;
	}
//		음료재고추가
	void plusDrink(List<vendingMachine> drink) {
		view(drink);
		String str = strChoice("재고를 수정할 음료이름을 입력하세요 : ");
		int per = findIndex(drink, str);
		
		if(per == -1) {
			System.out.println("없는 음료입니다.");
		}else if(!str.equals(drink.get(per).getDrinkName())) {
			System.out.println("음료이름이 틀렸습니다.");
		}else {
			drink.get(per).setDrinkCount(choice("수정할 개수를 입력하세요 :"));
		}
		
	}
	
//		매출현황
	void selling(List<vendingMachine> drink) {
		int all = 0;
		for(int i=0;i<drink.size();i++) {
			System.out.println(drink.get(i).getDrinkName() +" 팔린개수 : " +drink.get(i).getSellCount() + " 팔린 금액 : "+(drink.get(i).getDrinkPrice() * drink.get(i).getSellCount())  );
			all += drink.get(i).getDrinkPrice() * drink.get(i).getSellCount();
		}
		System.out.println("총 팔린 금액"+all);
	}
//		음료가격변경
	void editPrice(List<vendingMachine> drink) {
		
		view(drink);
		String edit = strChoice("가격변경할 음료이름 입력 : ");
		int index = findIndex(drink, edit);
		if(index == -1) {
			System.out.println("없는 음료입니다.");
		}else if(!edit.equals(drink.get(index).getDrinkName())) {
			System.out.println("음료이름을 틀렸습니다.");
		}else {
			int editP = choice("변경할 가격을 입력 : ");
			int before = drink.get(index).getDrinkPrice();
			drink.get(index).setDrinkPrice(editP);
			System.out.println(before + "-->" + editP + "로 변경되었습니다.");
		}
	}
//		음료제거
	void deleteDrink(List<vendingMachine> drink) {
		FileWriter wr = null;
		String str = "";
		try {
			wr = new FileWriter("vending.txt");
			
			view(drink);
			String delete = strChoice("삭제할 음료이름 입력 : ");
			int index = findIndex(drink, delete);
			if(index == -1) {
				System.out.println("없는 음료입니다.");
			}else if(!delete.equals(drink.get(index).getDrinkName())) {
				System.out.println("음료이름이 틀렸습니다.");
			}else {
				System.out.println(drink.get(index).getDrinkName()+"음료를 삭제하였습니다.");
				drink.remove(index);
				for(int i=0;i<drink.size();i++) {
					if(drink.size() - 1 == i) {
						str += drink.get(i).getDrinkName() + ",";
						str += drink.get(i).getDrinkPrice() + ",";
						str += drink.get(i).getDrinkCount();
					}else {
						str += drink.get(i).getDrinkName() + ",";
						str += drink.get(i).getDrinkPrice() + ",";
						str += drink.get(i).getDrinkCount() + "\n";
					}
					
				}
				wr.write(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				wr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//		음료추가
	void addDrink(List<vendingMachine> drink) {
		FileWriter wr = null;
		try {
			wr = new FileWriter("vending.txt",true);
			String name = strChoice("추가할 음료이름 입력 : ");
			int price = choice("추가할 음료가격 입력 : ");
			int count = choice("추가할 음료 재고수 입력 : ");
			int sellCount = 0;
			String str = "\n"+name+","+price+","+count+","+sellCount;
			wr.write(str);
			
			vendingMachine v1 = new vendingMachine(name,price,count,sellCount);
			drink.add(v1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				wr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//		음료이름으로 index 찾는 메소드
	public int findIndex(List<vendingMachine> drink ,  String name) {
		int index = -1;
		for(int i=0;i<drink.size();i++) {
			if(name.equals(drink.get(i).getDrinkName())) {
				index = i;
				break;
			}
		}
		return index;
	}
//		msg받아서 int로 반환
	int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}
//		msg받아서 String로 반환
	String strChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}
//		음료메뉴
	void view(List<vendingMachine> drink) {
		for(vendingMachine v : drink) {
			System.out.println(v);
		}
	}

}
