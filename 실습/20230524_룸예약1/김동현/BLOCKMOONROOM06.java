package kr.co.dong.checkPoint;

import java.util.Scanner;

public class BLOCKMOONROOM06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// ��12���� �ִ� ����?�迭? �迭�� room[12]
		// �޴������� 1,2,3,99�� �з¹���
		// 1�� ������ ���� ������
		// ȣ�ǹ�ȣ ����(1~12) +>������¿��θ� �R������
		// ���డ�ɻ��� ->����ǽ�->ȣ�� �R�� => �޴�����
		// ����Ұ��� ȣ�ǹ�ȣ�� ���� �Ǵ� �޴��� ������
		// 2�� ������� �������(����->����) ���ȣ�� 0�̸� ����
		// 3�� �������� ȣ��Ȯ�� , 1�̸� ����Ȱ��� 0�̸� ���డ���ϴ�
		// 99�� ������ ��������
		// �߰�����1. ���ǱԸ�ũ��� ���۰� ���ÿ� �Է�����2. ȣ�ڹ��ȣ ȣ�ڹ�� �����ο��� ���ݵ�� ��
		// 3.����� �����ڸ�� �����ȣ(��ҽ� �ʿ�)��� �̰� 4.��Ÿ �ʿ��� �� �����ڸ��!?!?!?4?!?!
		Scanner scan = new Scanner(System.in);
		boolean power = false;
		//int price[] = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200 };// ȣ�ڹ氡���̴�
		int[] room = null;// 1�̸� ����ȰŰ� 0�̸� �����̸� ���»���!??!
		int[] price = null;//��������
		int[] summerin=null; // �����ο�
		int[] hotelnumber=null;// ȣ�ڹ��ȣ
		String saram[] = null;// �����ڸ�
		String roomname[] = null;// ȣ�ڹ��
		int menu;// �޴����� �ش�޴������ϴ� ����ġ������ ���� 1,2,3,4,99
		int roomsize;// ���ǱԸ�
		int num1;// �濹�� ���ζ� �������� ���θ� Ȯ���ϱ� ���� �ʿ��� ��������
		int[] math;// �����ȣ
		
		int abc=0;
		
		System.out.println("���ǱԸ�ũ�⸦ �Է¹����ô�");
		roomsize=scan.nextInt();
		room=new int[roomsize];
		price=new int[roomsize];
		summerin=new int[roomsize];
		hotelnumber=new int[roomsize];
		saram=new String[roomsize];
		roomname=new String[roomsize];
		math=new int[roomsize];
		
		for(int i=0;i<room.length;i++) {//�Է°� ����
			System.out.println("���ȣ�� �Է��ϼ���");
			hotelnumber[i]=scan.nextInt();
			System.out.println("���̸��� �Է��ϼ���");
			roomname[i]=scan.next();
			System.out.println("�����ο��� �Է��սô�");
			summerin[i]=scan.nextInt();
			System.out.println("������ �Է��սô�");
			price[i]=scan.nextInt();
		}
		while(!power) {
			System.out.println("���ȣ����÷����??");
			System.out.println("1.��������սô�");
			System.out.println("2.����ε�");
			System.out.println("3.Ȯ�ο��θ�üũ����");
			System.out.println("4.����Ȯ�� ������ Ȯ�� ���");
			System.out.println("77.�����ڸ��� ���ſ���");// 77�� �켱 �����ڸ�带 ����
			System.out.println("99.END!!!");
			System.out.println("���ȣ,�ο���,����,�����ڸ����ȣ�� �����ϰ� �˷��ּ���");
			menu = scan.nextInt();
			switch (menu) {
			case 1://����ý����̴�
				System.out.println("�ȳ��ý���(�����ҹ� �Է�)");
				num1=scan.nextInt();
				
				if(room[num1-1]==0) {
					System.out.println("�������̸��Է�");
					saram[num1-1]=scan.next();
					System.out.println("�����ȣ�����Ӵϴ�");
					math[num1-1]=scan.nextInt();
//					 if(saram.equals(math)){
//						System.out.println();
//					if(math[num1-1]==1) {
//					}
					room[num1-1]=1;
					System.out.println("�����̉���");
				}else if(room[num1-1]==1){
					System.out.println("�����̵��ִ¹��̶� �ȵǿ�");
				}
				break;
			case 2://����ϱ� ���� �������
				System.out.println("������ҿ��ε��");
				num1=scan.nextInt();
				if(room[num1-1]==1) {
					room[num1-1]=0;
					System.out.println("��ҵƾ");
				}else{
					System.out.println("������ �ȵǾ� �־��");
					
				}
				break;
			case 3:
				System.out.println("�����ο�");
				abc=scan.nextInt();
				System.out.println(hotelnumber[roomsize-1]);
				
				
				break;
			case 4:
				for(int i=0;i<room.length;i++) {
					System.out.print(i+1+". "+hotelnumber[i]+" "+roomname[i]+" "+price[i]+" "+summerin[i]+" : ");
					if(room[i]==1) {
						System.out.println("������ �� á�׿�");
					}else if(room[i]==0){
						System.out.println("������� ���� �սô�");
					}
				}
				
				break;
			case 77:
				
				
				break;
			case 99:
				
				
				break;
				
			default:
				break;
			}
		}
	}
}

//		while (!false) {
//			
//			switch (menu) {
//			case 1:
//				System.out.println("���ǱԸ�� ??");
//				roomsize = scan.nextInt();
//				if (room[roomsize - 0] == 0) {
//					//System.out.println("�����ϴ°��ǱԸ��Դϴ�:" + roomsize);
//					room[roomsize-1]=1;
//				} else if(room[roomsize-1]==1){
//					System.out.println("�ش� ���ǱԸ� �������������� �ٽ� �����ϰ� ������:" + roomsize);
//				}
//
////					num1 = scan.nextInt();
////					if (room[num1 - 1] == 0) {
////						room[num1 - 1] = 1;// ����Ȱ���
////					} else if (room[num1 - 1] == 0) {
////						System.out.println("�ش���� ������ �����ϽǷ���??");
////					}else {//�� ����͵� �������� ���Ұ��
////						System.out.println("�ٽ� ó������ �ϼ���");
////					}
////				}
//				break;
//			case 2:
//				System.out.println("����is??");
//				System.out.println("ȣ�ڹ��ȣ�� �̸��� �����ο��� ���θ� �˷�����");
//				for (int i = 0; i < room.length; i++) {
//					for (int j = 0; j < price.length; j++) {
//						if (price[j] >= 100) {
//							System.out.println("ȣ�ڹ氡����:" + price[j]);
//						} else if (price[j] < 100) {
//							System.out.println("�ش����ǿ������������ؿ�");
//							hotelnumber = scan.nextInt();
//							if (hotelnumber > 0) {
//								System.out.println("ȣ�ڹ��ȣ�� :" + hotelnumber);
//							}else{
//								System.out.println("�׾�͵� �ƴϱ��� �����ε���");
//								roomname.equals(roomname);
//							}
//						}
////				System.out.println("���ȣ���̸����ο����������ο���Ǿ����ϴ�");
////				num1=scan.nextInt();
////				System.out.println("�����ڸ�� �����ȣ�������ϰ� �ٽ��Է��ϼ���");
////				math=scan.nextInt();
//
//					}
//				}
//				break;
//			case 3:
//				for (int i = 0; i < room.length; i++) {
////					for(int j=0; j<price.length; j++) {						
////					}
//
//					if (room[i] == 1) {
//						System.out.println(i + 1 + " ���� �����Ѿ��");
//					} else if (room[i] == 0) {
//						System.out.println(i + 1 + " ������ ������");
//
//					}
//				}
//				System.out.println("���ȣ��:");
//				System.out.println("ȣ���� Ȯ�ε����� �����ص��ǿ�");
//				hotelnumber = scan.nextInt();
//				if (hotelnumber > 0) {// ���Ǽ��ڸ� ���ȣ�� ��� �ƴϸ� �ٽ�Ȯ���ϱ�
//					System.out.println("���ȣ��: " + hotelnumber);
//				} else if (hotelnumber < 0) {
//					System.out.println("�ش�����̾����� �ٽ��ϼ���");
//				}
//				break;
//			//case 4:
//				// for(int a=0;a<saram.toString();a++) {
//
//				// }
//////				if(saram[]>0&&roomname[]>0) {
//////					saram.equals(saram);
//////					roomname.equals(roomname);
////				}
//			case 4:// �켱 �����ڸ��� 4�� ���� ȣ�� �Ǵ� �����ڸ��� �ϸ� ��
//				System.out.println("�����ڸ�� ȣ�� OR �����ڸ�庯��");
//				break;
//			case 99:// ���α׷� ���� �Ѵ� ���� �Ŀ��� ����
//				System.out.println("��������");
//				power = false;
//				break;
//			default:
//				break;
//			}
//		}
//	}
//
//}
