package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report13 {

	public static void main(String[] args) {
//		dName,  dPrice, dAmount
//		����� 3����
		boolean power = false;
		String[] dName = {"�ݶ�","���̴�","��"};	//���� �̸�
		int[] coin = {1000,500,100,50,10};		//���� �̸�
		int[] dPrice = {700, 500, 300};		//���� ����
		int[] dAmount = {1, 1, 1};		//���� ����
		int pay = 0;		//����� �ݾ�
		int change = 10000;		//���Ǳ� �Ž�����
		int sel = 0;		//���Ǳ� ��ȣ ����
		int password = 1019;	//������ ��� ��й�ȣ
		int dChange = 0;	//�Ž����� ä���
		Scanner scan = new Scanner(System.in);
		
		
		while(!power) {		//���Ǳ� ����
			System.out.println("==========Menu==========");
			System.out.println("1.���� �ݾ����� 2."+dName[0] + dPrice[0]+ " ��������:"+dAmount[0]+ " 3."+dName[1] + dPrice[1] +" ��������:"+dAmount[1]+ " 4." +dName[2] + dPrice[2]+" ��������:"+dAmount[2]+ "\n5.�Ž����� 99.���Ǳ�����" );
			System.out.println("���� �ݾ� : "+pay+"��");
			System.out.print("���Ͻô� ���� ��ȣ�� �Է��ϼ��� : ");
			sel = scan.nextInt();
			switch(sel) {
			case 1:		//�ݾ� �Է�
				System.out.print("���Ͻô� �ݾ��� �����ϼ��� : ");
				pay += scan.nextInt();
				System.out.println("���� �ݾ� : "+pay+"��");
				break;
			case 2:		//ù��° ����
				if(dAmount[0] == 0) {
					System.out.println("�ش� ����� ��� �����ϴ�.\n�ٸ� ���Ḧ �������ּ���.");
				}
				if(pay >= dPrice[0] && dAmount[0] > 0) {
					System.out.println("***"+dName[0]+"***");
					pay -= dPrice[0];
					dAmount[0]--;
					}else if(pay < dPrice[0]) {
					System.out.println("�ݾ��� "+(dPrice[0]-pay)+"�� �����մϴ�. \n���Ǳ��� 1���� ���� �߰� �ݾ��� �־��ּ���.");
					}
				break;
			case 3:		//�ι�° ����
				if(dAmount[1] == 0) {
					System.out.println("�ش� ����� ��� �����ϴ�.\n�ٸ� ���Ḧ �������ּ���.");
				}
				if(pay >= dPrice[1] && dAmount[1] > 0) {
					System.out.println("***"+dName[1]+"***");
					pay -= dPrice[1];
					dAmount[1]--;
					}else if(pay < dPrice[1]) {
					System.out.println("�ݾ��� "+(dPrice[1]-pay)+"�� �����մϴ�. \n���Ǳ��� 1���� ���� �߰� �ݾ��� �־��ּ���.");
					}
				break;
			case 4:		//����° ����
				if(dAmount[2] == 0) {
					System.out.println("�ش� ����� ��� �����ϴ�.\n�ٸ� ���Ḧ �������ּ���.");
				}
				if(pay >= dPrice[2] && dAmount[2] > 0) {
					System.out.println("***"+dName[2]+"***");
					pay -= dPrice[2];
					dAmount[2]--;
					}else if(pay < dPrice[2]) {
					System.out.println("�ݾ��� "+(dPrice[2]-pay)+"�� �����մϴ�. \n���Ǳ��� 1���� ���� �߰� �ݾ��� �־��ּ���.");
					}
				break;
			case 5:		//�Ž�����
				if(change >= pay) {
					change -= pay;
					System.out.println("�Ž����� : " + pay+"��");
					for(int i=0;i<coin.length;i++) {	//����
						int tmp = 0;
						tmp = pay/coin[i];
						pay -= coin[i] * tmp; 
						System.out.println(coin[i]+"��:"+tmp+"��");
					}	//for�� ��
					pay = 0;
				}
				break;
			case 77:	//������ ���
				System.out.print("��й�ȣ �Է� : ");
				password = scan.nextInt();
				if(password == 1019) {
					while(sel != 5) {
						System.out.println("=====������ �޴�=====");
						System.out.println("1.���� ���� 2.���ᰡ�� ���� 3.���� ���� 4.�ܵ� ���� 5.������ ��� ����");
						System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ��� : ");
						sel = scan.nextInt();
						switch(sel) {
						case 1:		//���� ����
							System.out.println("===���� ����===");
							System.out.println("1."+dName[0]+ " 2."+dName[1]+ " 3."+dName[2]+ " 4.�ڷΰ���");
							System.out.print("���� ������ ����� ��ȣ�� �Է��ϼ��� : ");
							sel = scan.nextInt();
							switch(sel) {	//���� ����(���ἱ��)
							case 1:
								System.out.print("������ ���� �Է� : ");
								dAmount[0] = scan.nextInt();
								System.out.println("����� ���� : "+dAmount[0]);
								break;
							case 2:
								System.out.print("������ ���� �Է� : ");
								dAmount[1] = scan.nextInt();
								System.out.println("����� ���� : "+dAmount[1]);
								break;
							case 3:
								System.out.print("������ ���� �Է� : ");
								dAmount[2] = scan.nextInt();
								System.out.println("����� ���� : "+dAmount[2]);
								break;
							case 4:
								System.out.println();
								break;
							}
							break;
						case 2:	//���ᰡ�� ����
							System.out.println("===���ᰡ�� ����===");
							System.out.println("1."+dName[0]+ " 2."+dName[1]+ " 3."+dName[2]+ " 4.�ڷΰ���");
							System.out.print("������ ������ ����� ��ȣ�� �Է��ϼ��� : ");
							sel = scan.nextInt();
							switch(sel) {//���ᰡ�� ����(���ἱ��)
							case 1:
								System.out.print("������ �ݾ� �Է� : ");
								dPrice[0] = scan.nextInt();
								System.out.println("����� �ݾ� : "+dPrice[0]);
								break;
							case 2:
								System.out.print("������ �ݾ� �Է� : ");
								dPrice[1] = scan.nextInt();
								System.out.println("����� �ݾ� : "+dPrice[1]);
								break;
							case 3:
								System.out.print("������ �ݾ� �Է� : ");
								dPrice[2] = scan.nextInt();
								System.out.println("����� �ݾ� : "+dPrice[2]);
								break;
							case 4:
								System.out.println();
								break;
							}
							break;
						case 3:		//���� ��ü
							System.out.println("===���� ����===");
							System.out.println("1."+dName[0]+ " 2."+dName[1]+ " 3."+dName[2]+ " 4.�ڷΰ���");
							System.out.print("��ü�� ����� ��ȣ�� �Է��ϼ��� : ");
							sel = scan.nextInt();
							switch(sel) {	//���� ��ü(���� ����)
							case 1:
								System.out.print("��ü�� �����̸� �Է� : ");
								scan.nextLine();
								dName[0] = scan.nextLine();
								System.out.println("��ü�� ���� : "+dName[0]);
								break;
							case 2:
								System.out.print("��ü�� �����̸� �Է� : ");
								scan.nextLine();
								dName[1] = scan.nextLine();
								System.out.println("��ü�� ���� : "+dName[1]);
								break;
							case 3:
								System.out.print("��ü�� �����̸� �Է� : ");
								scan.nextLine();
								dName[2] = scan.nextLine();
								System.out.println("��ü�� ���� : "+dName[2]);
								break;
							case 4:
								System.out.println();
								break;
							}
							break;
						case 4:
							System.out.println("===�ܵ� ����===");
							System.out.println("���� �ܾ� : "+change);
							System.out.print("������ �ݾ� �Է� : ");
							dChange = scan.nextInt();
							change += dChange;
							System.out.println("�� �ܵ� : "+change+"��");
						case 5:
							System.out.println("������ ��� ����");
							break;
						}	//������ switch�� ��
					}	//������ while�� ��
				}//������ if�� ��
				break;
			case 99:	//���Ǳ� ����
				power = true;
				break;
			default :	//���� ��ȣ �Է�
				System.out.println("=====�߸��� ����=====\n�ٽ� �������ּ���.");
			
			}	//����ġ�� ��
			
		}	//while�� ��
		System.out.println("���Ǳ� ����");
	}
}
