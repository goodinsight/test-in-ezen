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
//	���Ǳ� �ʱ⼳��
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
		
		
//		list.add(new Machine("�����սö���", 2500, 10));
//		list.add(new Machine("��ī������Ʈ", 1500, 10));
//		list.add(new Machine("����Ͽ���", 2000, 10));
	}
	
//	���Ǳ� �Ŵ���
	public void menu() {
		System.out.println("1. ���� 2. ��ȸ 3. �ܵ� 4. ���� 5. ����");
	}
	
//	���Ǳ� �Ŵ� ��ȸ
	public void view(List<Machine> list) {
		for (Machine machine : list) {
			System.out.println(machine);
		}
	}
	
//	���Ǳ� ���� ����
	public void order(List<Machine> list, Map<String, Machine> choiceList) {
		view(list);
		String name = msg("���Ḧ �������ּ���");
		int index = findName(name, list);
		int count = 0;
		if(index > -1 && list.get(index).getCount() != 0) {
			try {
				while (true) {
					count = count(index, msg("������ ������ �Է����ּ���"), list);
					if(count <= 0) {
						System.out.println("1�� �̻��� ��� �Է��ϼ���.");
					}else {
						choiceList.put("userlist",new Machine(name, list.get(index).getPrice(), count));
						break;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���");
			}
			
		}else if(index > -1 && list.get(index).getCount() == 0) {
			System.out.println("������ ��� �����ϴ� ������ �̿����ּ���.");
		}else{
			System.out.println("�Է��Ͻ� ����� ���� ���Ǳ⿡�� �Ǹ����� �ʴ� �����Դϴ� �ٽ� �Է����ּ���.");
			order(list, choiceList);
		}
		choiceList.get("userlist");
	}
	
//	����
	public void payment(List<Machine> list , Map<String, Machine> choiceList, List<Machine> selList) {
		Machine userlist = choiceList.get("userlist");
		if(userlist == null) {
			return;
		}
		int price = userlist.getCount() * userlist.getPrice();
		
		while (true) {
			if(money < price) {
				char c = msg("�ݾ��� �����մϴ� �߰����� �Ͻðڽ��ϱ� Y/N").charAt(0);
				if(c == 'Y') {
					try {
						money += Integer.parseInt(msg("�߰������Ͻ� �ݾ��� �Է����ּ��� ==> ������ �ݾ� " + (price - money)+"��"));
					} catch (NumberFormatException e) {
						System.out.println("���ڸ� �Է��ϼ���");
					}
				}else if(c == 'N') {
					choiceList.remove("userlist");
					System.out.println("�Ŵ��� �̵��մϴ�.");
					break;
				}else {
					System.out.println("Y or N�� �Է����ּ���");
				}
			}else {
				System.out.println("�̿����ּż� �����մϴ�.");
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
	
	
//	����� �޼��� ���
	public String msg(String msg) {
		System.out.println(msg);
		return sc.next();
	}
	
//	�Է��� ���� ���� ���� ��ȸ
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
	
//	��� ���� ��
	public int count(int index, String sel, List<Machine> list) {
		int count = list.get(index).getCount();
		if(Integer.parseInt(sel) > count) {
			count(index, msg("���Ǳ���� ���ᰳ���� �����մϴ� �ٽ� �Է����ּ���."), list);
		}
		return Integer.parseInt(sel);
	}
	
//	���Ǳ⿡ �ݾ� �ֱ�
	public void inputMoney() {
		try {
			money += Integer.parseInt(msg("���� �־��ּ��� ����ݾ� : " + money));
			System.out.println("�ݾ��� �����Ǽ̽��ϴ� ����ݾ� : " +money);
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��ϼ���");
		}
	}
//	�ܵ� ��ȯ
	public void returnMoney() {
		if(money > 0) {
			System.out.println("�ܵ��� "+money+"���Դϴ�.");
			money -= money;
		}else {
			System.out.println("�ܾ��� �����ϴ�.");
		}
		
	}
}
