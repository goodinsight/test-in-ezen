package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RoomControl03 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List
		
		List<Rcus> Rcus = new ArrayList<Rcus>();
		List<Room> list = new ArrayList<Room>();
		RoomMethod method = new RoomMethod();
		boolean stop = false;

//		ȣ���� �� ������ �ʱ�ȭ�ϰ� ����
		method.init(list);

		while (!stop) {
			int sel = method.menu();

			switch (sel) {
			case 1: // �� �����ϱ�
				method.revRoom(list);
				break;
			case 2: // �� �������
				method.cancelRoom(list,Rcus);
				break;
			case 3: // �� ��üȮ�� / ����Ȯ��
				method.printRoom(list);
				break;
			case 4: // ������ ����Ȯ��
				method.infoCheck(list,Rcus);
				break;
			case 5: // �� �����
				method.removeRoom(list);
				break;
			case 6: // �� �߰��ϱ�
				method.addRoom(list);
				break;
			case 7: // �� �����ϱ�
				method.editRoom(list);
				break;
			case 8:	// ��������� �������
				method.cancelPeople(Rcus);
				break;
			default:

			}
		}
	}
}
