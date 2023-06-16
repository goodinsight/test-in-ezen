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
		System.out.println("0. ��ȸ 1. ������ 2. ���ϸ��� 3. �Ŵ��߰� 4. �Ŵ����� 5. ���ݺ��� 6. ����");
	}
	
//	������
	public void updateCount(List<Machine> list) {
		view(list);
		String name = msg("��� ������ ���Ḧ �������ּ��� �ڷΰ���� B�� �����ּ���");
		if(name.equals("B")) {
			System.out.println("�Ŵ�ȭ������ ���ư��ϴ�.");
			return;
		}
		int index = findName(name, list);
		if(index != -1) {
			try {
				String str = "";
				int count = Integer.parseInt(msg("������ ������ �Է����ּ���"));
				list.get(index).setCount(count);
				System.out.println("��� �����Ǿ����ϴ�.");
				String fwStr = "";
				br = new BufferedReader(new FileReader("drinkList.txt"));
				while ((str = br.readLine()) != null) {
					fwStr += updateFile(name, count, str);
				}
				fw = new FileWriter("drinkList.txt",false);
				fw.write(write(fwStr));
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���");
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
			System.out.println("�Է��Ͻ� ����� ���� �����Դϴ� �ٽ��Է����ּ���.");
			updateCount(list);
		}
	}
	
//	���� ����
	public void sales(List<Machine> list) {
		int money = 0;
		for (Machine machine : list) {
			System.out.println("[����� : "+machine.getDrink()+", ���� : "+machine.getPrice()+", �ȸ����� : "+machine.getCount()+"��]");
			money += machine.getCount() * machine.getPrice();
		}
		System.out.println("�� ����� : " + money);
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
	
//	���Ǳ� �Ŵ� ����Ʈ
	public void view(List<Machine> list) {
		for (Machine machine : list) {
			System.out.println(machine);
		}
	}
	
//	�Ŵ��߰�
	public void updateMenu(List<Machine> list) {
		String name = msg("�߰��Ͻ� ������ �̸��� �Է����ּ��� �ڷΰ���� BŰ�� �����ּ���");
		if(name.equals("B")) {
			System.out.println("�Ŵ�ȭ������ ���ư��ϴ�.");
			return;
		}
		try {
			int price = Integer.parseInt(msg("�߰��Ͻ� ��ǰ�� ������ �Է����ּ���"));
			int count = Integer.parseInt(msg("�߰��Ͻ� ��ǰ�� ��� �Է����ּ���"));
			list.add(new Machine(name, price, count));
			System.out.println(name+"��ǰ�� �߰��Ǿ����ϴ�.");
			String str = name+","+price+","+count;
			
			fw = new FileWriter("drinkList.txt", true);
			fw.write("\n"+str);
			
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է����ּ���");
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
	
//	�Ŵ�����
	public void removeMenu(List<Machine> list) {
		view(list);
		String name = msg("�����Ͻ� ������ �̸��� �Է����ּ��� �ڷΰ���� BŰ�� �����ּ���");
		if(name.equals("B")) {
			System.out.println("�Ŵ�ȭ������ ���ư��ϴ�.");
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
			
			System.out.println("�Է��Ͻ� ���ᰡ �����Ǿ����ϴ�.");
		}else {
			System.out.println("�Է��Ͻ� ����� ���� �����Դϴ� �ٽ��Է����ּ���");
			removeMenu(list);
		}
	}
	
//	���ݺ���
	public void updatePrice(List<Machine> list) {
		view(list);
		String name = msg("������ �����Ͻ� ������ �̸��� �Է����ּ��� �ڷΰ���� BŰ�� �����ּ���");
		if(name.equals("B")) {
			System.out.println("�Ŵ�ȭ������ ���ư��ϴ�.");
			return;
		}
		int index = findName(name, list);
		if(index != -1) {
			try {
				int price = Integer.parseInt(msg("�Է��Ͻ� ������ ������ �Է����ּ���."));
				list.get(index).setPrice(price);
				System.out.println("������ ����Ǿ����ϴ�.");
				String fwStr = "";
				String str = "";
				br = new BufferedReader(new FileReader("drinkList.txt"));
				while ((str = br.readLine()) != null) {
					fwStr += updateFile(name, str, price);
				}
				fw = new FileWriter("drinkList.txt",false);
				fw.write(write(fwStr));
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���.");
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
			System.out.println("�Է��Ͻ� ����� ���� �����Դϴ� �ٽ��Է����ּ���");
			updatePrice(list);
		}
	}
	
//	���� ����� ���ϳ��� ����
	public String updateFile(String name, String readLine, int price) {
		String[] str = readLine.split(",");
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals(name)) {
				str[1] = price+"";
			}
		}
		return str[0]+","+str[1]+","+str[2]+";";
	}
	
//	��� ������ ���ϳ��� ����
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
