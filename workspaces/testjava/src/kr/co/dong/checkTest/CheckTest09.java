package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest09 {
	public static void main(String[] args) {
//		�߰����� : 1.���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է�
//		 2.ȣ�ڹ��ȣ/ȣ�ڹ��(��-�ξ�/������ ��)/�����ο�/���� ->1901ȣ~1919ȣ (1�� ������� �κ�)2�� ��Ʈ�Ͻ��� 3�� ������ 4�� ���̳���,��ȥ���� 5~18�� ���ǽ��� 2�� �����
//		 3.����� �����ڸ�/�����ȣ(��ҽ� �ʿ�) ��
//		 4.��Ÿ �ʿ��� ���(�����ڸ��)


int[] room = {0,0,0,0,0,0,0,0,0,0,0,0};				//room[] ���� ��ȣ
int menu = 0;							//menu switch������ �Է¹��� ����
int rooms = 0;							//��üȭ�� -> 2.ROOMS �޴� ����
int reservation=0;						//��üȭ�� -> 2.ROOMS -> 2.ROOM RESERVATION �޴� ����
int choiceRoom = 0;						//��üȭ�� -> 2.ROOMS -> 2.ROOM RESERVATION -> case 2(RESERVATION) ȣ�ǹ�ȣ ����
int roomType = 0;						//��üȭ�� -> 2.ROOMS -> 1.ROOM TYPE -> case 1 ��Ÿ�� ����
int count = 0;

//String name = null;				//�����ڸ�
String[] name = new String[12];	//�����ڸ� �迭

int reservationNum=0;			//�����ȣ
//int numOfPeople =0;				//�����ο� (�����ο� �ʰ��� �߰��ݾ�) -> ��ȭ����/�湮�� ó���ϱ�
String name2 = null;			//������� �Է¿� �����ڸ�
String name3 = null;			//����Ȯ�� �Է¿� �����ڸ�

Scanner scan = new Scanner(System.in);
boolean hotel = false;			//��üȭ�� while��
boolean booking = false;		
boolean menu2=false;			//��üȭ�� -> 2.ROOMS while��
boolean menu2_2=false;			//��üȭ�� -> 2.ROOMS -> 2.ROOM RESERVATION while��
boolean menu2_1=false;			//��üȭ�� -> 2.ROOMS -> 1.ROOM TYPE while��
boolean menu2_2_1=false;		//��üȭ�� -> 2.ROOMS -> 2.ROOM RESERVATION -> 2.RESERVATION while��


while(!hotel) {
	System.out.println();
	System.out.println("						 �� GRAND SY HOTEL ��");
	System.out.println("�� GRAND SY HOTEL�� ���Ű��� ȯ���մϴ�.");
	System.out.println("=======================================================================");
	System.out.println("[1] HOTEL [2] ROOMS [3] AREA ATTRACTION [4] DINING [5] SPECIAL EVENTS");
	System.out.println("[0] CLOSE");
	System.out.println("=======================================================================");
	System.out.print("�� ��ȣ�� �Է��ϼ���. > ");
	menu = scan.nextInt();
	
	switch (menu) {
	case 1:
		System.out.println();
		System.out.println("��GRAND SY HOTEL��");
		System.out.println();
		System.out.println("�� �λ� �ְ�� ���Ÿ� ȣ��");
		System.out.println("�� ���� �ٴٿ� ���ȴ뱳 ������ �ڶ��ϴ� �λ��� ���帶ũ.");
		System.out.println("�� ���Ÿ��� ǰ�ݰ� ���õ� ��Ÿ�Ϸ� ������ ������ ���� Ư���ϰ� ����� �帳�ϴ�.");
		System.out.println("�� �λ��� MICE�� ���� �߽����� ��ġ�� '�׷��� SY ȣ��'���� �������̰� �������� �� ���㼭�񽺸� ������ ������. ");
		System.out.println("�� �λ꿡���� �߾��� GRAND SY HOTEL�� �Բ��ϼ���.");
		break;
		
	case 2:
		while(!menu2) {
		//ȣ�� ���ȣ �Ը� ���� rooms while�� ->menu2
		System.out.println();
		System.out.println("						 �� GRAND SY HOTEL ��");
		System.out.println("< ROOMS >");
		System.out.println("=======================================================================");
		System.out.println("[1] ROOM TYPE [2] ROOM RESERVATION [0] CLOSE");
		System.out.println("=======================================================================");
		System.out.print("�� ��ȣ�� �Է��ϼ���. > ");
		rooms = scan.nextInt();
			
			switch (rooms) {
			case 1:
				while(!menu2_1) {
					System.out.println();
					System.out.println("						 �� GRAND SY HOTEL ��");
					System.out.println("< ROOM TYPE >");
					System.out.println("======================================================================");
					System.out.println("[ 1] Presidential Suite");
					System.out.println("[ 2] Diplomat Suite");
					System.out.println("[ 3] Royal Executive Family Suite");
					System.out.println("[ 4] Royal Executive Suite");
					System.out.println("[ 5] Premium Family Suite");
					System.out.println("[ 6] Premium Executive Suite");
					System.out.println("----------------------------------------------------------------------");
					System.out.println("[ 7] Premium Double");
					System.out.println("[ 8] Premium Twin");
					System.out.println("[ 9] Premium Double (Ocean View)");
					System.out.println("[10] Premium Twin (Ocean View)");
					System.out.println("[11] Deluxe Double");
					System.out.println("[12] Deluxe Twin");
					System.out.println("======================================================================");
					System.out.println("[0] CLOSE");
					System.out.println("======================================================================");
					System.out.println();
					System.out.print("�� ROOM TYPE�� �����ϼ���. > ");
					roomType = scan.nextInt();
//					1~6, 9,10: Ocean View

					
					switch (roomType) {
					case 1:
						System.out.println("[ 1] Presidential Suite");
						System.out.println("<�ѹ�> 1912ȣ");
						System.out.println("<ũ��> 198������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��2(2 King Bed), �Ž�1, ���̴׷�1, ���Ǻ� ���2");
						System.out.println("<�ο�> 8�� (�ִ� 12��, �ο� �߰��� �߰��ݾ�)");
						System.out.println("<����> �ָ� �� ������: $2,000 ����: $1,800");
						
						break;
						
					case 2:
						System.out.println("[ 2] Diplomat Suite");
						System.out.println("<�ѹ�> 1911ȣ");
						System.out.println("<ũ��> 155������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��2(2 King Bed), �Ž�1, ���̴׷�1, ���Ǻ� ���1");
						System.out.println("<�ο�> 4�� (�ִ� 8��, �ο� �߰��� �߰��ݾ�)");
						System.out.println("<����> �ָ� �� ������: $1,800 ����: $1,600");
						break;
						
					case 3:
						System.out.println("[ 3] Royal Executive Family Suite");
						System.out.println("<�ѹ�> 1910ȣ");
						System.out.println("<ũ��> 107������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��2(2 Queen Bed, 2 Single Bed), �Ž�1, ���1");
						System.out.println("<�ο�> 4�� (�ִ� 6��, �ο� �߰��� �߰��ݾ�)");
						System.out.println("<����> �ָ� �� ������: $1,400 ����: $1,200");
						break;

						
					case 4:
						System.out.println("[ 4] Royal Executive Suite");
						System.out.println("<�ѹ�> 1909ȣ");
						System.out.println("<ũ��> 107������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��2(2 King Bed), �Ž�1, ���1");
						System.out.println("<�ο�> 4�� (�ִ� 6��, �ο� �߰��� �߰��ݾ�)");
						System.out.println("<����> �ָ� �� ������: $1,200 ����: $1,000");
						break;

					case 5:
						System.out.println("[ 5] Premium Family Suite");
						System.out.println("<�ѹ�> 1908ȣ");
						System.out.println("<ũ��> 87������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��1(1 Queen Bed, 1 Single Bed), �Ž�1, ���1");
						System.out.println("<�ο�> 3�� (�ִ� 4��, �ο� �߰��� �߰��ݾ�)");
						System.out.println("<����> �ָ� �� ������: $1,000 ����: $800");
						break;

					case 6:
						System.out.println("[ 6] Premium Executive Suite");
						System.out.println("<�ѹ�> 1907ȣ");
						System.out.println("<ũ��> 87������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��1(1 King Bed), �Ž�1, ���1");
						System.out.println("<�ο�> 2�� (�ִ� 4��, �ο� �߰��� �߰��ݾ�)");
						System.out.println("<����> �ָ� �� ������: $1,000 ����: $800");
						break;

					case 7:
						System.out.println("[ 7] Premium Double");
						System.out.println("<�ѹ�> 1906ȣ");
						System.out.println("<ũ��> 59������");
						System.out.println("<�ɼ�> ħ��1(1 King Bed), ���1");
						System.out.println("<�ο�> 2�� (�ο��߰� �Ұ�)");
						System.out.println("<����> �ָ� �� ������: $800 ����: $600");
						break;

					case 8:
						System.out.println("[ 8] Premium Twin");
						System.out.println("<�ѹ�> 1905ȣ");
						System.out.println("<ũ��> 59������");
						System.out.println("<�ɼ�> ħ��1(2 Single Bed), ���1");
						System.out.println("<�ο�> 2�� (�ο��߰� �Ұ�)");
						System.out.println("<����> �ָ� �� ������: $800 ����: $600");
						break;

					case 9:
						System.out.println("[ 9] Premium Double (Ocean View)");
						System.out.println("<�ѹ�> 1904ȣ");
						System.out.println("<ũ��> 59������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��1(1 King Bed), ���1");
						System.out.println("<�ο�> 2�� (�ο��߰� �Ұ�)");
						System.out.println("<����> �ָ� �� ������: $900 ����: $700");
						break;

						
					case 10:
						System.out.println("[10] Premium Twin (Ocean View)");
						System.out.println("<�ѹ�> 1903ȣ");
						System.out.println("<ũ��> 59������");
						System.out.println("<�ɼ�> ���Ǻ�, ħ��1(2 Single Bed), ���1");
						System.out.println("<�ο�> 2�� (�ο��߰� �Ұ�)");
						System.out.println("<����> �ָ� �� ������: $900 ����: $700");
						break;

						
					case 11:
						System.out.println("[11] Deluxe Double");
						System.out.println("<�ѹ�> 1902ȣ");
						System.out.println("<ũ��> 41������");
						System.out.println("<�ɼ�> ħ��1(1 King Bed), ���1");
						System.out.println("<�ο�> 2�� (�ο��߰� �Ұ�)");
						System.out.println("<����> �ָ� �� ������: $700 ����: $500");
						break;

						
					case 12:
						System.out.println("[12] Deluxe Twin");
						System.out.println("<�ѹ�> 1901ȣ");
						System.out.println("<ũ��> 41������");
						System.out.println("<�ɼ�> ħ��1(2 Single Bed), ���1");
						System.out.println("<�ο�> 2�� (�ο��߰� �Ұ�)");
						System.out.println("<����> �ָ� �� ������: $700 ����: $500");
						break;

					case 0:
						menu2_1 = true;
						System.out.println("> ���� ȭ������ ���ư��ϴ�.");
						break;

					default:
						System.out.println("�� �߸��� ��ȣ�Դϴ�. ��ȣ�� �ٽ� �Է��ϼ���.");
						break;
					}
				}
				menu2_1=!menu2_1;
				break;
				
			case 2:
				while(!menu2_2) {
					System.out.println();
					System.out.println("						 �� GRAND SY HOTEL ��");
					System.out.println("< ROOM RESERVATION >");
					System.out.println("=======================================================================");
					System.out.println("[1] RESERVATION [2] CANCEL RESERVATION [3] RESERVATION CONFIRMATION");
					System.out.println("[0] CLOSE");
					System.out.println("=======================================================================");
					System.out.print("�� ��ȣ�� �Է��ϼ���. > ");
					reservation = scan.nextInt();		
				
					switch (reservation) {
					case 1:
						while(!menu2_2_1) {
							
						System.out.println("						 �� GRAND SY HOTEL ��");
						System.out.println("< RESERVATION >");
						System.out.println("======================================================================");
						System.out.println("�� ROOM TYPE \t \t \t \t \t > ROOM NUMBER");
						System.out.println("[ 1] Presidential Suite \t \t \t > [1912ȣ]");
						System.out.println("[ 2] Diplomat Suite \t \t \t \t > [1911ȣ]");						
						System.out.println("[ 3] Royal Executive Family Suite \t \t > [1910ȣ]");
						System.out.println("[ 4] Royal Executive Suite \t \t \t > [1909ȣ]");
						System.out.println("[ 5] Premium Family Suite \t \t \t > [1908ȣ]");
						System.out.println("[ 6] Premium Executive Suite \t \t \t > [1907ȣ]");
						System.out.println("----------------------------------------------------------------------");
						System.out.println("[ 7] Premium Double \t \t \t \t > [1906ȣ]");
						System.out.println("[ 8] Premium Twin \t \t \t \t > [1905ȣ]");
						System.out.println("[ 9] Premium Double (Ocean View) \t \t > [1904ȣ]");
						System.out.println("[10] Premium Twin (Ocean View) \t \t \t > [1903ȣ]");
						System.out.println("[11] Deluxe Double \t \t \t \t > [1902ȣ]");
						System.out.println("[12] Deluxe Twin \t \t \t \t > [1901ȣ]");
						System.out.println("======================================================================");
						System.out.println("[0] CLOSE");
						System.out.println("======================================================================");
						
						System.out.print("�� ���Ͻô� ROOM TYPE ��ȣ�� �����ϼ���. (1~12) >");
						choiceRoom = scan.nextInt();
							if(choiceRoom == 0){
								System.out.println("����ȭ������ ���ư��ϴ�.");
								menu2_2_1 = !menu2_2_1;
							}else if(choiceRoom>room.length) {
								System.out.println("�Է��Ͻ� ������ ���� �����Դϴ�.");
							}else if(room[choiceRoom-1]==1) {
								System.out.println("�� ������ �Ұ����մϴ�. �ٸ� ȣ���� �����ϼ���.");
								
							}else{
							
								System.out.println("> ������ �����մϴ�.");
								System.out.println();
								System.out.print("�� �����ڸ��� �Է��ϼ���. > ");		//�������,����Ȯ�ν� -> �����ڸ� �Է� (name.equals = -> ����ȭ�� �Ѿ��)
								name[choiceRoom-1] = scan.next();
								
								if(choiceRoom>0 && choiceRoom<10) {
									System.out.println("> [190"+(choiceRoom)+"ȣ]�� ����Ǿ����ϴ�.");
									System.out.println("> �����ȣ�� " + (choiceRoom) + "�Դϴ�.");
									room[choiceRoom-1] = 1;
									name[choiceRoom-1] = name[choiceRoom-1]+choiceRoom;	//�迭���� �ֱ�
									break;
								}else{
									System.out.println("> [19"+(choiceRoom)+"ȣ]�� ����Ǿ����ϴ�.");
									System.out.println("> �����ȣ�� " + (choiceRoom) + "�Դϴ�.");
									room[choiceRoom-1] = 1;
									name[choiceRoom-1] = name[choiceRoom-1]+choiceRoom;
									break;
								}
							}	
						}
						break;
					case 2:
						boolean b = false;
						System.out.println();
						System.out.println("						 �� GRAND SY HOTEL ��");
						System.out.println("< CANCEL RESERVATION >");
						System.out.println("======================================================================");

						System.out.print("�� ������ ���԰� �����ȣ�� �Է��ϼ���. (ex. name1) > ");
						name2 = scan.next();
						for(int i=0; i<name.length; i++) {
							if(name2.equals(name[i])) {
								choiceRoom = i;
								b = true;
								break;
							}
						}
							if(choiceRoom+1<10 && b) {
								System.out.println("> [190"+ (choiceRoom+1) + "ȣ��]�� ������ ����մϴ�.");
								room[choiceRoom]=0;
							} else if(choiceRoom+1>=10 && b){
								System.out.println("> [19"+ (choiceRoom+1) + "ȣ��]�� ������ ����մϴ�.");
								room[choiceRoom]=0;
							}else{
							System.out.println("�� ���೻���� ��ȸ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
							}
						break;
					case 3:
						System.out.println();
						System.out.println("						 �� GRAND SY HOTEL ��");
						System.out.println("< RESERVATION CONFIRMATION >");
						System.out.println("======================================================================");
						System.out.println("�� ROOM TYPE \t \t \t \t \t > ROOM NUMBER");
						System.out.println("[ 1] Presidential Suite \t \t \t > [1912ȣ]");
						System.out.println("[ 2] Diplomat Suite \t \t \t \t > [1911ȣ]");						
						System.out.println("[ 3] Royal Executive Family Suite \t \t > [1910ȣ]");
						System.out.println("[ 4] Royal Executive Suite \t \t \t > [1909ȣ]");
						System.out.println("[ 5] Premium Family Suite \t \t \t > [1908ȣ]");
						System.out.println("[ 6] Premium Executive Suite \t \t \t > [1907ȣ]");
						System.out.println("----------------------------------------------------------------------");
						System.out.println("[ 7] Premium Double \t \t \t \t > [1906ȣ]");
						System.out.println("[ 8] Premium Twin \t \t \t \t > [1905ȣ]");
						System.out.println("[ 9] Premium Double (Ocean View) \t \t > [1904ȣ]");
						System.out.println("[10] Premium Twin (Ocean View) \t \t \t > [1903ȣ]");
						System.out.println("[11] Deluxe Double \t \t \t \t > [1902ȣ]");
						System.out.println("[12] Deluxe Twin \t \t \t \t > [1901ȣ]");
						System.out.println("======================================================================");
						System.out.println("[0] CLOSE");
						System.out.println("======================================================================");
						
						
						for(int i=0; i<room.length; i++) {
							if((i+1)<10) {
								System.out.print("["+"190"+(i+1)+"ȣ] : ");
							} else {
								System.out.print("[" + "19" + (i+1)+"ȣ] : ");
							}
							
							if(room[i]==1) {
								System.out.println("�� NO VACANCY ��");
							} else {
								System.out.println("�� VACANCY ��");
							}
						}
						
						break;
	
					case 0:
						menu2_2 = true;
						System.out.println("> ����ȭ������ ���ư��ϴ�.");
						break;
	
					default:
						System.out.println("�� �߸��� ��ȣ�Դϴ�. ��ȣ�� �ٽ� �Է��ϼ���.");
						break;
					}
				}
				menu2_2=!menu2_2;
				break;
				
			case 0:
				menu2 = true;	
				System.out.println("> ���� ȭ������ ���ư��ϴ�.");
				break;
				
			default:
				System.out.println("�� �߸��� ��ȣ�Դϴ�. ��ȣ�� �ٽ� �Է��ϼ���.");
				break;
			}
		}
		
		
		menu2 = !menu2;
		break;
	case 3:
		System.out.println("> ���� �غ����Դϴ�.");
		break;
		
	case 4:
		System.out.println("> ���� �غ����Դϴ�.");
		break;
		
	case 5:
		System.out.println("> ���� �غ����Դϴ�.");
		break;
		
	case 0:
		hotel = true;
		System.out.println("�� GRAND SY HOTEL�� �湮���ּż� �����մϴ�.");
		System.out.println("END");
		break;

	default:
		System.out.println("�߸��� ��ȣ�Դϴ�. ��ȣ�� �ٽ� �Է��ϼ���.");
		break;
	}
	
}

}
}
