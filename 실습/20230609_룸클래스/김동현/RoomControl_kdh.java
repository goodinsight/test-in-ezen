package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//�δ콺�� ã�ƾ� �Ǵ�?!?! 

public class RoomControl_kdh {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// ȣ�ڷ� ������ �켱 5���� �������� �������� ==> List
		//
		//
		//
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

		init(list);

		while (!stop) {
			int sel = menu();

			switch (sel) {

			case 1:// �� �����ϱ�
				revRoom(list);
				break;

			case 2:// �� ���� ���
				canselRoom(list);
				break;

			case 3:// �� ��ü Ȯ��
				printRoom(list);
				break;

			case 4:// ������ ����Ȯ��
				break;
			default:

			}

		}
		
	}// ����Ʈ ���� �ش� ������ ����Ǿ� �ִ� index �� ã�� �޽��
	//���ȣ�� ã������?? , ���̸����� ã���ǰ�??!!
	int findRoom(String name, List<Room> list) {
		int index = -1;//��ã���� -1�̷�
		
		for(int i=0; i<list.size();i++) {//����Ʈ������� �� ���� �ݺ�!?!?!?!?!?!??
//			list.get(i).getrName();   ==> ����Ʈ���� ���̸�����
			if(name.equals(list.get(i).getrName())) {//��Ʈ�����̶� ���ؼ� �˳����̶� ���ؼ� �����ϴ°� ������ �δ콺�� ����????
				index=-1;
				//return index;
			break;
		}
		}
		return index;
	}
	
	
	
	
	

	private static int menu() {// �޴������ֱ�� �������� ������ �ȵ� �������� �켱 �����ϱ�
		System.out.println("�޴�����������");
		System.out.println("1.�濹������ , 2.������ҿ��� , 3.��ü���ε�� 4. ��������������Ȯ��");

		return scan.nextInt();
	}

	private static void revRoom(List<Room> list) {// �� ���� �ϱ�
		// TODO Auto-generated method stub

		System.out.println("���������ý����Դϴ�");
		int rNo = scan.nextInt();

		for (Room r : list) {
			if (rNo == 0) {
				System.out.println("���డ���ϴٳ׿�  " + list.get(rNo));
			} else if (rNo != 0) {// 1�̸� �̹� �ִ°Ŵϱ� �ȵ���
				System.out.println("�̹� ����Ȼ�����!!");
				// r=sel.room(revRoom(list.get(sel));
				System.out.println(list.add(r));

			}

		}
		
		
		
	}

	private static void canselRoom(List<Room> list) {// �濹�����
		// TODO Auto-generated method stub
		System.out.println("�濹����ҽý���");
		
		System.out.println("��ҿ��θ� Ȯ������");
		String revcode = scan.nextLine();
		int sel = 0;// �ӽú����� ��������
		if (sel == 1) {
			
			System.out.println("�����̴� �ٽ�Ȯ�ιٶ� "+  (list));
		}else if(list==null){
			
			System.out.println("����");
		}
	}

	private static void printRoom(List<Room> list) {// �� ��ü Ȯ��
		// TODO Auto-generated method stub

		System.out.println("1.��üȣ��Ȯ�� 2.����ȣ��Ȯ��");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				System.out.println(r);
			}
		} else if (sel == 2) {
			System.out.println("ȣ���� �޽��ϴ�");
			int roomname = scan.nextInt();
			System.out.println(list.get(roomname - 1));

		}
	}

	private static void init(List<Room> list) {// ����� �ȵǴ� ���
		
		Room r1 = new Room(101, "Ŀ����", 10000, "����");
		Room r2 = new Room(201, "ũ����Ż", 20000, "��û");
		Room r3 = new Room(301, "���丮��", 30000, "����");
		Room r4 = new Room(401, "��������", 40000, "����");
		Room r5 = new Room(501, "���Ӹ���", 50000, "����");

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}

}
