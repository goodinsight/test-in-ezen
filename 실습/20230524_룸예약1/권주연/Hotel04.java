package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Hotel04 {

	public static void main(String[] args) {
//		�� 12���� �ְ� �迭 room[12]
//		�Է±������� menu���� : 1,2,3,99�� �Է¹���
//		1.�� ����
//		1�� ���� ���� ���� ���� => room[���ȣ]�� ���� 1�̸� �������
//		1-> ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
//		->���డ�ɻ��� -> ����ǽ� -> ȣ��Ȯ�� => �޴��� ����
		
//		2.���� ���
//		2�� ���� ��� ���� ���(����-> ����) -> room[���ȣ]�� ���� 0�̸� ����
//		2-> ȣ�ǹ�ȣ ����(1~12) -> ��Ұ��ɿ���
//		-> �ּҰ��� : �ش�ȣ���� ���� 0���� => �޴� ����
//		-> ��ҺҰ� : ����������� ���̶�� ǥ�� => �޴�����
		
//		3. ȣ��Ȯ��
//		1��-> "�����:��" 0��-> "���డ�ɡ�"
//		99 ������ ���α׷� ����

		boolean power = false;
		int[] room = {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0}; // �� ��ȣ
		int roomN = -1;
		String[] menu = {"�� ����", "���� ���","ȣ�� Ȯ��","����"}; // �޴���ȣ => ������� 1,2,3,99
		int menu1 = 0; // �޴�����
	    Scanner scan = new Scanner(System.in);
	    
	    while(!power) {
	    	System.out.println("================================================");
	    	System.out.println("                    Menu                        ");
	    	
//	    	for(int i=0;i<menu.length;i++) {
	    		System.out.println("�� 1. �� ���� 2. ���� ��� 3. ȣ�� Ȯ�� 99. ����");
	    		System.out.println("================================================");
	    		System.out.println("�����ϴ� �޴��� �������ּ���.");
	    	
	    menu1 = scan.nextInt();
	    switch(menu1) {
//		room �� 0�϶� = ���� ����, room �� 1�϶� = ���� �Ұ���
	    case 1: //����
	    	System.out.println("��"+menu[menu1-1]+"���� �����ϼ̽��ϴ�.");
	    	System.out.println("�����Ͻô� Room�� �������ּ���(1~12): ");
	    	roomN = scan.nextInt();
	    	if(roomN > 0 && roomN <= room.length && room[roomN-1] == 0) {
				room[roomN-1] = 1;
	    			System.out.println("�����Ͻ� "+ roomN + "�� ���� ���� �����մϴ�.");
	    	} else if (roomN > 0 && roomN <= room.length && room[roomN-1] == 1){
	    		System.out.println("�����Ͻ� "+ roomN + "�� ���� �̹� ����� ���Դϴ�.");
	    	} else {
	    		System.out.println("Ȯ�ε��� �ʴ� ���Դϴ�. �ٽ� �������ּ���.");
	    	}
	    	break;
	    case 2: // �������
	    	System.out.println("��"+menu[menu1-1]+"���� �����ϼ̽��ϴ�.");
	    	System.out.println("������Ͻ� Room ��ȣ�� �Է��ϼ���(1~12) : ");
	    	roomN = scan.nextInt();
	    	if(roomN > 0 && roomN <= room.length && room[roomN-1] == 1) {
				room[roomN-1] = 0;
				System.out.println("�����Ͻ� "+ roomN + "�� ���� ���������� ��ҵǾ����ϴ�.");
	    	} else if (roomN > 0 && roomN <= room.length && room[roomN-1] == 0){
	    		System.out.println("�����Ͻ� "+ roomN + "�� ���� ���� ���� ���� ���Դϴ�.");
	    	} else {
	    		System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
	    	}
	    	break;
	    case 3: // ȣ��Ȯ��
	    	for(int j = 0; j < room.length; j++) {
	    		System.out.println(j+1+"�� ��");
	    		if(room[j] == 1) {
	    		System.out.println("�ڡ��̹� ����� ���Դϴ١ڡ�");
	    	} else if(room[j] == 0) {
	    		System.out.println("�ٿ����� �����մϴ١�");
	    	}
	    	
	    	}
	    	break;
	    case 99: // ����
	    	power = true;
			System.out.println("==== ����â�� ����˴ϴ�:) ====");
			break;
							
		default :
			System.out.println("�߸� �����̽��ϴ�. �ٽ� �������ּ���.");
	      }
//	     }  	
	   }
	}
}


