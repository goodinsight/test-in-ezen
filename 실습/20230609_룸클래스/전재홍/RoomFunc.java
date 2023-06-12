package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RoomFunc {
	static Scanner sc = new Scanner(System.in);		
	
		List<Room> list = new ArrayList<Room>();
		
		
//		�����ϱ� ���
		
		public void roomRev(List<Room> list) {
			System.out.println(" ���� ������ ������ �����Դϴ�. ������ ȣ���� �Է����ּ���. ���� �Ը� : " + list.size() + " ��\n");
			
			for(Room num : list) { // ���� for�� ���
				
				if(num.isrState()==false) { //num�� map���� ������ List ��ȣ�� �ҷ��� 
					System.out.println(" �����̸� :"+num.getrName()+"/ �� ��ȣ:"+ num.getrNo()+"/ ����:"+ num.getrPrice());
				}
			}
			int roomsel = 0; // �� ��ȣ ���� ���� ����
			roomsel = sc.nextInt();
			
//			 for(int i= 0; i<list.size; i++){
//				Room num = list.get(i);
//			} �� ���� for������ ��ȯ
			
			for(Room num : list) {
				if(roomsel==num.getrNo()) {
					
					num.setrState(true);
					System.out.println("������ ������ �Է����ּ���.");
					num.setCustoemr(sc.next());
					System.out.println("����ó ���ڸ��� �Է����ּ���[����Ȯ���ڵ�]");
					num.setResCode(sc.next());
				}
			}
		}	
			
		

//		������� ���
		public void  roomCan(List<Room> list) {
			System.out.println(" ���� ��� ������ �����Դϴ�. ����� ȣ���� �Է����ּ���. ���� �Ը� : " + list.size() + " ��\n");
			
			for(Room num : list) { // ���� for�� ���
				
				if(num.isrState()==true) { //num�� map���� ������ List ��ȣ�� �ҷ��� 
					System.out.println("�����̸� :"+num.getrName()+"�� ��ȣ:"+ num.getrNo()+"����:"+ num.getrPrice());
				}
			}
			int roomsel = 0; // �� ��ȣ ���� ���� ����
			roomsel = sc.nextInt();
			
//		 for(int i= 0; i<list.size; i++){
//			Room num = list.get(i);
//		} �� ���� for������ ��ȯ
			
			for(Room num : list) {
				if(roomsel==num.getrNo()) {
					String roomcan = null; // ������Һ��� ����				
					System.out.println("����ó ���ڸ��� �Է����ּ���[����Ȯ���ڵ�]");
					
					roomcan = sc.next();// ����� ����Ȯ���ڵ� �Է�
						if(!(num.getResCode().equals(roomsel))) {
							System.out.println("����Ȯ���ڵ尡 �ùٸ��� �ʽ��ϴ�.");							
						}else{
							num.setrState(false);
							num.setCustoemr(null);
							num.setResCode(null);
						}
					
				}
			}
			
			
		}


//		�� ���� Ȯ��
		public void  roomChck(List<Room> list) {
			System.out.println(" ���� ���� ���� ��Ȳ�Դϴ�. ���� �Ը� : " + list.size() + " ��\n");
			
			for(Room num : list) { // ���� for�� ���
				
				if(num.isrState()==true) { //num�� map���� ������ List ��ȣ�� �ҷ��� 
					System.out.println(" �Ό��� �����̸� :"+num.getrName()+"�� ��ȣ:"+ num.getrNo()+"����:"+ num.getrPrice());
				}else {
					System.out.println(" ����ǡ� �����̸� :"+num.getrName()+"�� ��ȣ:"+ num.getrNo()+"����:"+ num.getrPrice());
					
				}
			}

		}
			
		public void  nameChck(List<Room> list) {
			System.out.println(" �����Ͻ� ������ ������ �ҷ��ɴϴ�. ����� �Է��� �ڵ�[����ó���ڸ�]�� �Է����ּ���.");
			
			for(Room num : list) {
				String nameChk = sc.next();
				if(!(num.getResCode().equals(nameChk))) {
					System.out.println("�Է��� �ڵ尡 �ùٸ��� �ʽ��ϴ�.");
				}else {
					System.out.println("������ "+num.getCustoemr()+ " ���� ���������Դϴ� \r"
							+ num.getrName() + " ���� : " + num.getrNo()+ " ȣ �Դϴ�.");
				}
				
			}
			
		}
		
//		�޴�
		public int menu() {
						
			System.out.println(" ��������������������������������������������������������������������������������������������������������������");
			System.out.println(" �� �� ����������������������������������������  ������������           ��  ��������  ��");
			System.out.println(" �� ��������������������������������������������  ������������     �ݢ�    ��  ���ڿ���  ��");
			System.out.println(" ��  �� �� ���������������� ���������������������������� ��           ��  sys.V2  ��");
			System.out.println(" ��������������������������������������������������������������������������������������������������������������");
			System.out.println(" ��   1.����     2.�������     3.������Ȯ��    0.�����մϴ�    ��");
			System.out.println(" ��������������������������������������������������������������������������������������������������������������");
			System.out.println(" ����� �Է� = ");
			
			return sc.nextInt();
			
		}
		
//		�帧 �����ֱ�  �Ф� ��������
		

	

}
