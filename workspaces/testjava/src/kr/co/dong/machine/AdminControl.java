package kr.co.dong.machine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminControl {
	
	Scanner sc = new Scanner(System.in);
	FileWriter fw = null;
	BufferedReader br = null;
	
	public void menu() {
		System.out.println("0. 조회 1. 재고수정 2. 금일매출 3. 매뉴추가 4. 매뉴삭제 5. 가격변경 6. 종료");
	}
	
//	재고수정
	public void updateCount(List<Machine> list) {
		view(list);
		String name = msg("재고를 수정할 음료를 선택해주세요 뒤로가기는 B를 눌러주세요");
		if(name.equals("B")) {
			System.out.println("매뉴화면으로 돌아갑니다.");
			return;
		}
		int index = findName(name, list);
		if(index != -1) {
			try {
				String str = "";
				int count = Integer.parseInt(msg("수정할 개수를 입력해주세요"));
				list.get(index).setCount(count);
				System.out.println("재고가 수정되었습니다.");
				String fwStr = "";
				br = new BufferedReader(new FileReader("drinkList.txt"));
				while ((str = br.readLine()) != null) {
					fwStr += updateFile(name, count, str);
				}
				fw = new FileWriter("drinkList.txt",false);
				fw.write(write(fwStr));
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}else {
			System.out.println("입력하신 음료는 없는 음료입니다 다시입력해주세요.");
			updateCount(list);
		}
	}
	
//	금일 매출
	public void sales(List<Machine> list) {
		int money = 0;
		for (Machine machine : list) {
			System.out.println("[음료명 : "+machine.getDrink()+", 가격 : "+machine.getPrice()+", 팔린개수 : "+machine.getCount()+"개]");
			money += machine.getCount() * machine.getPrice();
		}
		System.out.println("총 매출액 : " + money);
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
	
//	자판기 매뉴 리스트
	public void view(List<Machine> list) {
		for (Machine machine : list) {
			System.out.println(machine);
		}
	}
	
//	매뉴추가
	public void updateMenu(List<Machine> list) {
		String name = msg("추가하실 음료의 이름을 입력해주세요 뒤로가기는 B키를 눌러주세요");
		if(name.equals("B")) {
			System.out.println("매뉴화면으로 돌아갑니다.");
			return;
		}
		try {
			int price = Integer.parseInt(msg("추가하실 상품의 가격을 입력해주세요"));
			int count = Integer.parseInt(msg("추가하실 상품의 재고를 입력해주세요"));
			list.add(new Machine(name, price, count));
			System.out.println(name+"상품이 추가되었습니다.");
			String str = name+","+price+","+count;
			
			fw = new FileWriter("drinkList.txt", true);
			fw.write("\n"+str);
			
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력해주세요");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	매뉴삭제
	public void removeMenu(List<Machine> list) {
		view(list);
		String name = msg("삭제하실 음료의 이름을 입력해주세요 뒤로가기는 B키를 눌러주세요");
		if(name.equals("B")) {
			System.out.println("매뉴화면으로 돌아갑니다.");
			return;
		}
		int index = findName(name, list);
		if(index != -1) {
			list.remove(index);
			String str = "";
			for (int i = 0; i < list.size(); i++) {
				Machine m = list.get(i);
				if(i == list.size()-1) {
					str += m.getDrink()+","+m.getPrice()+","+m.getCount();
				}else {
					str += m.getDrink()+","+m.getPrice()+","+m.getCount()+"\n";
				}
			}
			
			try {
				fw = new FileWriter("drinkList.txt", false);
				fw.write(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("입력하신 음료가 삭제되었습니다.");
		}else {
			System.out.println("입력하신 음료는 없는 음료입니다 다시입력해주세요");
			removeMenu(list);
		}
	}
	
//	가격변경
	public void updatePrice(List<Machine> list) {
		view(list);
		String name = msg("가격을 변경하실 음료의 이름을 입력해주세요 뒤로가기는 B키를 눌러주세요");
		if(name.equals("B")) {
			System.out.println("매뉴화면으로 돌아갑니다.");
			return;
		}
		int index = findName(name, list);
		if(index != -1) {
			try {
				int price = Integer.parseInt(msg("입력하신 음료의 가격을 입력해주세요."));
				list.get(index).setPrice(price);
				System.out.println("가격이 변경되었습니다.");
				String fwStr = "";
				String str = "";
				br = new BufferedReader(new FileReader("drinkList.txt"));
				while ((str = br.readLine()) != null) {
					fwStr += updateFile(name, str, price);
				}
				fw = new FileWriter("drinkList.txt",false);
				fw.write(write(fwStr));
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else {
			System.out.println("입력하신 음료는 없는 음료입니다 다시입력해주세요");
			updatePrice(list);
		}
	}
	
//	가격 변경시 파일내용 변경
	public String updateFile(String name, String readLine, int price) {
		String[] str = readLine.split(",");
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals(name)) {
				str[1] = price+"";
			}
		}
		return str[0]+","+str[1]+","+str[2]+";";
	}
	
//	재고 수정시 파일내용 변경
	public String updateFile(String name, int count, String readLine) {
		String[] str = readLine.split(",");
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals(name)) {
				str[2] = count+"";
			}
		}
		return str[0]+","+str[1]+","+str[2]+";";
	}
	
	public String write(String write) {
		String[] str = write.split(";");
		String insert = "";
		for (int i = 0; i < str.length; i++) {
			if(str.length-1 == i) {
				insert += str[i];
			}else {
				insert += str[i]+"\n";
			}
		}
		return insert;
	}
}
