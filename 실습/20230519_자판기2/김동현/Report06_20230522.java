package kr.co.dong.array;

import java.util.Scanner;

public class Report06_20230522 {

	public static void main(String[] args) {//99���� ���Ǳ��������??!!  , 77���� �����ڸ��?!?!?!
		// TODO Auto-generated method stub
		// �迭���Ǳⱸ��
		int dPrice[] = new int[] { 500, 1000, 1500 };// �����̴�
		int dAmount[] = new int[] { 3, 3, 3 };// ������//�� �ݾ�
		String[] dName = new String[] { "�ٳ���", "����", "������" };// �����Ī
		boolean power = false;
		int change = 0;// �Ž����� �Ž�����=�Ӵ�-�����Ѹ޴�����
		int money = 0;// �� ����
		int choice = 0;// �޴��̴� 1�� 2�� 3�� �������
		change = money - dPrice[0];
		change = money - dPrice[1];
		change = money - dPrice[2];// ���ݾ׿��� ������ ���� �Ž�����

		Scanner scan = new Scanner(System.in);

		while (!power) {// �ʾ��̽��� ������
			System.out.println("�����ܾ��� : " + money);
			System.out.println("���Ḧ ���ض�");
			for (int i = 0; i < dName.length; i++) {
				System.out.print(i + 1 + " " + dName[i] + " " + dPrice[i] + " " + dAmount[i] + "\n");//�������þ� :�ٹٲ�(����)
			}
			System.out.println("4 ���Է� :   ");// 4�� �� ���Է� ����ġ�� ���̽� 4������ ����
			money=money +scan.nextInt();
			System.out.println("�޴��� �������� :");//�޴������Ѱ� �����ֱ�
			choice = scan.nextInt();
			System.out.println("������ �ݾ��� :" +  money );//���� ���ؼ� �ӴϿ� ������
			switch (choice) {// ����ġ�� ���� �ش��ȣ�� �����ϸ� �װɷ� ��
			case 1:
				if (money >= dPrice[0] && dAmount[0] != 0) {// ���� �ش缱�� ���Ẹ�� ũ�� �̸� ��� ������
					money = money - dPrice[0];// ������ ������ ���ᰡ���� �����ϴ�
					dAmount[0] = dAmount[0] - 1;// ��� 1�� ����
				} else if (money < dPrice[0]) {// ���� �ش缱���� ���Ẹ�� ������
					System.out.println("���̾��׿�");
				} else if (dAmount[0] == 0) {// ��� 0���� ��� ����
					System.out.println("������");
				}
				break;
			case 2://2���޴��� ���Ѱ��̴�
				if (money >= dPrice[1] && dAmount[1] != 0) {
					money = money - dPrice[1];
					dAmount[1] = dAmount[1] - 1;
				} else if (money < dPrice[1]) {
					System.out.println("������");
				} else if (dAmount[1] == 0) {
					System.out.println("������");
				}

				break;

			case 3://3��°�� ���� ����
				if (money >= dPrice[2] && dAmount[2] != 0) {
					money = money - dPrice[2];
					dAmount[1] = dAmount[2] - 1;
				} else if (money < dPrice[2]) {
					System.out.println("�������ѵ���");
				} else if (dAmount[2] == 0) {
					System.out.println("������µ�");
				}
				break;
			case 4:
				System.out.print("������������ : ");
				money = money + scan.nextInt();// �ӴϿ� �Ӵϸ� ���ؼ� ��������
				System.out.println("�����ȱݾ��� : " + money);
				break;
			case 77 : 
				if(power==false) {//�Ŀ��� �޽��� ������
					System.out.println("������������");
				}else if(dAmount[0]!=0&&dAmount[1]!=0&&dAmount[2]!=0&&money>=0){//������ 0�� �ƴϸ� ���� �۵�������
					System.out.println("�����ð��� ���̳�����");
				}
				
			case 99:
				if(power=true) {
					System.out.println("====������=====");
				}else if(power!=true){
					System.out.println("�������");
				}
				
			default:

			}

			

		}
		System.out.println();
	}

}
