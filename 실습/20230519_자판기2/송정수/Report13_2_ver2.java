package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report13_2_ver2 {
	public static void main(String[] args) {
//		dName,  dPrice, dAmount
//		����� 3����
		boolean power = false;	//���Ǳ� ����
		boolean admin = false;	//������ ����
		String[] dName = {"�������","Ʈ����","����"};	//���� �̸�
		int[] coin = {5000,1000,500,100,50,10};		//���� �̸�
		int[] dPrice = {1500, 1000, 2500};		//���� ����
		int[] dAmount = {3, 3, 3};		//���� ����
		int pay = 0;		//����� �ݾ�
		int change = 10000;		//���Ǳ� �Ž�����
		int sel = 0;		//���Ǳ� ��ȣ ����
		int password = 1019;	//������ ��� ��й�ȣ
		int dChange = 0;	//�Ž����� ä���
		Scanner scan = new Scanner(System.in);
		
		while(!power) {		//���Ǳ� ����
			admin = false;
			System.out.println("==========Menu==========");
			System.out.print("1.���� �ݾ����� 2.���� �޴� �ҷ�����");
			System.out.println("\n5.�Ž����� 99.���Ǳ�����");
			System.out.println("���� �ݾ� : "+pay+"��");
			System.out.print("���Ͻô� ���� ��ȣ�� �Է��ϼ��� : ");
			sel = scan.nextInt();
			switch(sel) {
			case 1:		//�ݾ� �Է�
				System.out.print("���Ͻô� �ݾ��� �����ϼ��� : ");
				pay += scan.nextInt();
				System.out.println("���� �ݾ� : "+pay+"��");
				break;
			case 2:		//����޴�
				for(int i=0;i<dName.length;i++) {
					System.out.println(i+1+"."+dName[i]+dPrice[i]+" ��������:"+dAmount[i]+" ");
				}
				System.out.println("�ڷ� ���Ƿ��� �����ȣ �̿��� ��ȣ�� �Է��ϼ���.");
				System.out.print("���Ͻô� �����ȣ�� �Է��ϼ��� : ");
				sel = scan.nextInt();
				if(sel > dName.length) {
					System.out.println("�ڷ� �̵��մϴ�.");
				break;
				}
				if(dAmount[sel-1] == 0) {
					System.out.println("�ش� ����� ��� �����ϴ�.\n�ٸ� ���Ḧ �������ּ���.");
				}
				 else if(dPrice[sel-1] <= pay && dAmount[sel-1] > 0) {
					System.out.println(dName[sel-1]);
					pay -= dPrice[sel-1];
					dAmount[sel-1]--;
				}else if(pay < dPrice[sel-1]) {
					System.out.println("�ݾ��� "+(dPrice[sel-1]-pay)+"�� �����մϴ�. \n���Ǳ��� 1���� ���� �߰� �ݾ��� �־��ּ���.");
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
				}	// if�� ��
				else if(change < pay) {
					System.out.println("���Ǳ��� �ܵ��� �����Ͽ� �Ž������� ������ �ʽ��ϴ�.\n�پ��ִ� ��ȣ�� �������ּ���.");
				}
				break;
			case 77:	//������ ���
				System.out.print("��й�ȣ �Է� : ");
				password = scan.nextInt();
				if(password == 1019) {
					while(!admin) {
						System.out.println("=====������ �޴�=====");
						System.out.println("1.���� ���� 2.���ᰡ�� ���� 3.���� ���� 4.�ܵ� ���� 5.������ ��� ����");
						System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ��� : ");
						sel = scan.nextInt();
						switch(sel) {
						case 1:		//���� ����
							System.out.println("===���� ����===");
							System.out.println("1.���� �޴� �ҷ����� 2~99.�ڷΰ���");
							System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ��� : ");
							sel = scan.nextInt();
							switch(sel) {	
							case 1:		//����޴�
								for(int i=0;i<dName.length;i++) {
									System.out.print(i+1+"."+dName[i]+" ");
								}
								System.out.print(dName.length+1+"~99.�ڷ��̵�\n���� ������ ����� ��ȣ�� �Է��ϼ��� : ");
								sel = scan.nextInt();
								if(sel > dName.length) {
									System.out.println("�ڷ� �̵��մϴ�.");
									break;
								}
								System.out.println("���� ���� : "+dAmount[sel-1]+"\n�߰��� ������ �Է��ϼ��� : ");
								dAmount[sel-1] += scan.nextInt();
								System.out.println("����� ���� : "+dAmount[sel-1]);
								break;
							}	//switch�� ��
							break;
						case 2:	//���ᰡ�� ����
							System.out.println("===���ᰡ�� ����===");
							System.out.println("1.���� �޴� �ҷ����� 2~99.�ڷΰ���");
							System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ��� : ");
							sel = scan.nextInt();
							switch(sel) {	
							case 1:		//����޴�
								for(int i=0;i<dName.length;i++) {
									System.out.print(i+1+"."+dName[i]+" ");
								}
								System.out.print(dName.length+1+"~99.�ڷ� �̵�\n������ ������ ����� ��ȣ�� �Է��ϼ��� : ");
								sel = scan.nextInt();
								if(sel > dName.length) {
									System.out.println("�ڷ� �̵��մϴ�.");
									break;
								}
								System.out.println("������ ������ �Է��ϼ��� : ");
								dPrice[sel-1] = scan.nextInt();
								System.out.println("����� ���� : "+dPrice[sel-1]);
								break;
							}	//switch�� ��
							break;
						case 3:		//���� ��ü
							System.out.println("===���� ��ü===");
							System.out.println("1.���� �޴� �ҷ����� 2~99.�ڷΰ���");
							System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ��� : ");
							sel = scan.nextInt();
							switch(sel) {	//���� ��ü(���� ����)
							case 1:
								for(int i=0;i<dName.length;i++) {
									System.out.print(i+1+"."+dName[i]+" ");
								}
								System.out.print(dName.length+1+"~99.�ڷ� �̵�\n��ü�� ����� ��ȣ�� �Է��ϼ��� : ");
								sel = scan.nextInt();
								if(sel > dName.length) {
									System.out.println("�ڷ� �̵��մϴ�.");
									break;
								}
								System.out.println("��ü�� �����̸��� �Է��ϼ��� : ");
								scan.nextLine();
								dName[sel-1] = scan.nextLine();
								System.out.println("����� �����̸� : "+dName[sel-1]);
								dAmount[sel-1] = 0;
								break;
							}	//switch�� ��
							
							break;
						case 4:		//�ܵ� ����
							System.out.println("===�ܵ� ����===");
							System.out.println("���� �ܾ� : "+change+"��");
							System.out.println("�ڷ� �̵��ϽǷ��� 0���� ��������.");
							System.out.print("������ �ݾ� �Է� : ");
							dChange = scan.nextInt();
							change += dChange;
							System.out.println("�� �ܵ� : "+change+"��");
							break;
						case 5:		//������ ��� ����
							if(sel == 5) {
								admin = true;
							System.out.println("������ ��� ����");
							}
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
			}	//���� ����ġ�� ��
		}	//���� while�� ��
		System.out.println("���Ǳ� ����");
	}
}
