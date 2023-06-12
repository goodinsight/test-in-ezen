package kr.co.dong.room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Admin {
	
	FileWriter fw = null;
	Scanner scan = new Scanner(System.in);
	int choice = 0;
	String pwd = "admin";
	
	public int Pwd() {
		System.out.print("��й�ȣ�� �Է��ϼ���(�ʱ� ��й�ȣ�� admin) : ");
		String input = scan.next();
		if(input.equals(pwd)) {
			try {
				fw = new FileWriter("log.txt");
				fw.write("������ ��� ���� \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("(1)�� �߰�, (2)�� ����, (3)�� ����, (4)����Ȯ��, (5)��й�ȣ ����, (0)������ ��� ����");
			return scan.nextInt();
		} else {
			try {
				fw = new FileWriter("log.txt");
				fw.write("������ ��� ���� ���� \n");
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
			return 0;
		}
	}
	
	public void PwdSet() {
		System.out.print("������ ��й�ȣ �Է� : ");
		String npwd = scan.next();
		System.out.println(pwd +"�� " + npwd + "�� ����Ǿ����ϴ�.");
		pwd = npwd;
		try {
			fw = new FileWriter("log.txt");
			fw.write("������ ��� ��й�ȣ ����");
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
	
	public void RoomAdd(List<Room> list){
		System.out.println("ȣ��, �� �̸�, ����, �� ����(��������)�� ���ʴ�� �Է����ּ���.");
		System.out.print("ȣ�� : ");
		int rNo = scan.nextInt();
		System.out.print("�� �̸� : ");
		String rName = scan.next();
		System.out.print("���� : ");
		int rPrice = scan.nextInt();
		System.out.println("�� ���� : ");
		String rContent = scan.next();
		
		if(rContent == null) {
			list.add(new Room(rNo, rName, rPrice));
		} else{
			list.add(new Room(rNo, rName, rPrice, rContent));
		}
		try {
			fw = new FileWriter("log.txt", true);
			fw.write("(�� ������) ȣ�� : " + rNo + "�� �̸� : " + rName + "���� : " + rPrice + "�� ���� : " + rContent + "\n");
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
	
	public void RoomSet(List<Room> list) {
		showRoom(list);
		System.out.print("������ ���� ȣ�� : ");
		choice = scan.nextInt();
		for(Room data : list) {
			if(data.getrNo() == choice) {
				
				System.out.println("�� �̸�, ����, �� ����(��������)�� ���ʴ�� �Է����ּ���.");
				int rNo = data.getrNo();
				System.out.print("�� �̸� : ");
				String rName = scan.next();
				System.out.print("���� : ");
				int rPrice = scan.nextInt();
				System.out.println("�� ���� : ");
				String rContent = scan.next();
				
				System.out.println(data.getrNo() + "�� ���� �̸� : " + data.getrName() + " ���� : " + data.getrPrice() + " ���� : " + data.getrContent() + "����");
				System.out.println("�̸� : " + rName + " ���� : " + rPrice + " ���� : " + rContent + "�� ����Ǿ����ϴ�.");
				
				if(rContent == null) {
					list.set(list.indexOf(data), new Room(rNo, rName, rPrice));
				} else{
					list.set(list.indexOf(data), new Room(rNo, rName, rPrice, rContent));
				}
				try {
					fw = new FileWriter("log.txt", true);
					fw.write("(�� ������) ȣ�� : " + rNo + "�� �̸� : " + rName + "���� : " + rPrice + "�� ���� : " + rContent + "\n");
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
				break;
			}
			
		}
	}
	
	public void resCheck(List<Room> list) {
		showRoom(list);
		System.out.print("Ȯ���� ���� ȣ�� : ");
		choice = scan.nextInt();
		for(Room data : list) {
			if(data.getrNo() == choice) {
				if(data.isrState() == true) {
					System.out.println(data.getrNo() + "ȣ �̸� : " + data.getrName() + " ���� : " + data.getrPrice() + " �����ڸ� : " + data.getCustomer() + "�����ڵ� : " + data.getResCode());
				}else {
					System.out.println(data.getrNo() + "ȣ �̸� : " + data.getrName() + " ���� : " + data.getrPrice() + "����Ǿ����� �ʽ��ϴ�.");
				}
				try {
					fw = new FileWriter("log.txt", true);
					fw.write("(�� Ȯ�ε�) ȣ�� : " + data.getrNo() + "�� �̸� : " + data.getrName() + "���� : " + data.getrPrice() + "�� ���� : " + data.getrContent() + "\n");
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
				break;
			}
		}
	}
	
	public void RoomDel(List<Room> list) {
		showRoom(list);
		System.out.print("������ ���� ȣ�� �Է� : ");
		choice = scan.nextInt();
		for(Room data : list) {
			try {
				fw = new FileWriter("log.txt", true);
				fw.write("(�� ���ŵ�) ȣ�� : " + data.getrNo() + "�� �̸� : " + data.getrName() + "���� : " + data.getrPrice() + "�� ���� : " + data.getrContent() + "\n");
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
			if(data.getrNo() == choice) {
				System.out.println(data.getrNo() + "ȣ�� �����Ǿ����ϴ�. \n");
				list.remove(list.indexOf(data));
			}
		}
	}
	
	public void showRoom(List<Room> list) {
		for(Room data : list) {
			String state = null;
			if(data.isrState() == true) {
				state = "�����";
			} else {
				state = "���డ��";
			}
			System.out.println("ȣ�� : " + data.getrNo() + " �� �̸� : " + data.getrName() + " ���� : " + data.getrPrice() + " ������� : " + state);
		
		}
	}
	
}
