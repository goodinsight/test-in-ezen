package vendingMachine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminControl {
	Scanner scan = new Scanner(System.in);

//		�����ڸ�� ���
	int password(int pass) {
		int password = 1234;
		return password;
	}
//		��������߰�
	void plusDrink(List<vendingMachine> drink) {
		view(drink);
		String str = strChoice("��� ������ �����̸��� �Է��ϼ��� : ");
		int per = findIndex(drink, str);
		
		if(per == -1) {
			System.out.println("���� �����Դϴ�.");
		}else if(!str.equals(drink.get(per).getDrinkName())) {
			System.out.println("�����̸��� Ʋ�Ƚ��ϴ�.");
		}else {
			drink.get(per).setDrinkCount(choice("������ ������ �Է��ϼ��� :"));
		}
		
	}
	
//		������Ȳ
	void selling(List<vendingMachine> drink) {
		int all = 0;
		for(int i=0;i<drink.size();i++) {
			System.out.println(drink.get(i).getDrinkName() +" �ȸ����� : " +drink.get(i).getSellCount() + " �ȸ� �ݾ� : "+(drink.get(i).getDrinkPrice() * drink.get(i).getSellCount())  );
			all += drink.get(i).getDrinkPrice() * drink.get(i).getSellCount();
		}
		System.out.println("�� �ȸ� �ݾ�"+all);
	}
//		���ᰡ�ݺ���
	void editPrice(List<vendingMachine> drink) {
		
		view(drink);
		String edit = strChoice("���ݺ����� �����̸� �Է� : ");
		int index = findIndex(drink, edit);
		if(index == -1) {
			System.out.println("���� �����Դϴ�.");
		}else if(!edit.equals(drink.get(index).getDrinkName())) {
			System.out.println("�����̸��� Ʋ�Ƚ��ϴ�.");
		}else {
			int editP = choice("������ ������ �Է� : ");
			int before = drink.get(index).getDrinkPrice();
			drink.get(index).setDrinkPrice(editP);
			System.out.println(before + "-->" + editP + "�� ����Ǿ����ϴ�.");
		}
	}
//		��������
	void deleteDrink(List<vendingMachine> drink) {
		FileWriter wr = null;
		String str = "";
		try {
			wr = new FileWriter("vending.txt");
			
			view(drink);
			String delete = strChoice("������ �����̸� �Է� : ");
			int index = findIndex(drink, delete);
			if(index == -1) {
				System.out.println("���� �����Դϴ�.");
			}else if(!delete.equals(drink.get(index).getDrinkName())) {
				System.out.println("�����̸��� Ʋ�Ƚ��ϴ�.");
			}else {
				System.out.println(drink.get(index).getDrinkName()+"���Ḧ �����Ͽ����ϴ�.");
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
	
//		�����߰�
	void addDrink(List<vendingMachine> drink) {
		FileWriter wr = null;
		try {
			wr = new FileWriter("vending.txt",true);
			String name = strChoice("�߰��� �����̸� �Է� : ");
			int price = choice("�߰��� ���ᰡ�� �Է� : ");
			int count = choice("�߰��� ���� ���� �Է� : ");
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
//		�����̸����� index ã�� �޼ҵ�
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
//		msg�޾Ƽ� int�� ��ȯ
	int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}
//		msg�޾Ƽ� String�� ��ȯ
	String strChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}
//		����޴�
	void view(List<vendingMachine> drink) {
		for(vendingMachine v : drink) {
			System.out.println(v);
		}
	}

}
