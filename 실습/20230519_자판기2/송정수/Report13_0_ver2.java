package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report13_0_ver2 {
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
					pay = 0;
				}
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
