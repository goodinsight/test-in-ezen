package kr.co.dong.checkTest;

import java.util.Arrays;
import java.util.Scanner;

public class CheckTest13 {
	public static void main(String[] args) {
//		Ű���忡 ���� �Է��ۼ�
//		��12���� �ְ� =>����?�迭? => �迭 ����room[12]
//		�Է±�������	//menu����:1,2,3,99�� �Է¹���
//		1�� �������� ���� ����,	//room[���ȣ]�� ���� 1�̸� �������
//			1->ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
//		->���డ�ɻ��� -> ����ǽ� ->ȣ��Ȯ�� => �޴��� ����
//		->����Ұ����� -> ȣ�ǹ�ȣ ����(1~12) or �޴��� ����
//		2�� ���� ��� �������(����->����),	//room[���ȣ]�� ���� 0�̸� ����
//				2-> ȣ�ǹ�ȣ����(1~12)->��Ұ��ɿ���
//			->��Ұ���: �ش�ȣ���� ���� 0���� =>�޴�����
//			->��ҺҰ�: ����������� ���̶�� ǥ��. =>�޴�����
//		3�� ���� ���� ȣ�� Ȯ��,	//1�� ���� "�����:��"0�ΰ��� "���డ�ɡ�"
//		99�� ���� ���� ���α׷�����.
//		=> �߰����� : 1.���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է���  ȣ�� �� �氳��
//				    2.ȣ�ڹ��ȣ/ȣ�ڹ��(��-�ξ�/������ ��)/�����ο�/����
//					3.����� �����ڸ�/�����ȣ(��ҽ� �ʿ�) ��
//					4.��Ÿ �ʿ��� ���(�����ڸ��)
		Scanner scan = new Scanner(System.in);
		boolean power = false; 				// ���α׷� ����
		boolean equ = false;				//��
		int[] rSweet = null;				//ȣ�� �� �̸�
		int[] bSweet = null;				//�����Ͻ�
		int[] eSweet = null;				//���ڳ��
		int[] price = {45000,60000,80000};	//����
		int[] person = {2,3,4};				//�����ο�
		int choice = 0;						//���Ǽ���
		String[] prename = null;			//������ �̸�
		int[] prenum = null;				//������ �����ȣ
		int count = 0;						//����Ƚ��
		int[] preroom = null;				//����� ȣ��
		int pnum = 0;						//�����ο� �Է�
		int pay = 0;						//�����ݾ�
		String possible = "";
		System.out.println("�ξ� �� ������ �Է��ϼ��� : ");
		int sel = scan.nextInt();			//���� 
		rSweet = new int[sel];				//�ξ� �� ����
		System.out.println("�����Ͻ� �� ������ �Է��ϼ��� : ");
		sel = scan.nextInt();
		bSweet = new int[sel];
		System.out.println("���ڳ�� �� ������ �Է��ϼ��� : ");
		sel= scan.nextInt();
		eSweet = new int[sel];
		prename = new String[rSweet.length+bSweet.length+eSweet.length];
		prenum = new int[rSweet.length+bSweet.length+eSweet.length];
		preroom = new int[rSweet.length+bSweet.length+eSweet.length];

		while(!power) {
			System.out.println("=====ȣ�� �޴�=====");
			System.out.println("1.ȣ�ǿ��� 2.������� 3.ȣ��Ȯ�� 4.�����ݾ� ���� 5.�����ݾ� ��ȯ 99.����");
			System.out.println("���� �ݾ� : "+pay);
			System.out.println("���Ͻô� ��ȣ�� �Է��ϼ��� : ");
			sel=scan.nextInt();
			switch (sel) {
			case 1:
				System.out.println("3�� - �ξ�(�ִ�4��)80000��\n2�� - �����Ͻ�(�ִ�3��)60000��\n1�� - ���ڳ��(�ִ�2��)45000��");
				System.out.println("������ ���� �Է����ּ��� : ");
				sel = scan.nextInt();
				if(pay < price[sel-1]) {
					System.out.println("�ݾ��� �����մϴ�.");
					break;
				}
				
				if(sel == 3) {
					for(int i=0;i<rSweet.length;i++) {
						if(i % 4 == 0) {
							System.out.println();
						}
						if(rSweet[i] == 0) {
							possible = "���� ����";
						}else {
							possible = "���� �Ұ���";
						}
						System.out.print("30"+(i+1)+"ȣ"+possible+"   ");
					}
					System.out.println();
				}else if(sel == 2) {
					for(int i=0;i<bSweet.length;i++) {
						if(i % 4 == 0) {
							System.out.println();
						}
						if(bSweet[i] == 0) {
							possible = "���� ����";
						}else {
							possible = "���� �Ұ���";
						}
						System.out.print("20"+(i+1)+"ȣ"+possible+"   ");
					}
					System.out.println();
				}else if(sel == 1) {
					for(int i=0;i<eSweet.length;i++) {
						if(i % 4 == 0) {
							System.out.println();
						}
						if(eSweet[i] == 0) {
							possible = "���� ����";
						}else {
							possible = "���� �Ұ���";
						}
						System.out.print("10"+(i+1)+"ȣ"+possible+"   ");
					}
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				}
				System.out.println();
				System.out.println("���Ͻô� ȣ��(�ǵڼ��ڸ�)�� �Է����ּ��� : ");
				choice = scan.nextInt();
				System.out.println("�����ο��� �Է����ּ��� : ");
				pnum = scan.nextInt();
				if(pnum > person[sel-1]) {
					System.out.println("ȣ�� �ִ��ο����� �ѽ��ϴ�.");
					break;
				}
				if(sel == 3) {
					if(rSweet[choice-1] == 1) {
						System.out.println("�̹� ����� ȣ���Դϴ�.");
					}else {
						System.out.println("�����Ͻô� ���� ������ �Է����ּ��� :");
						scan.nextLine();
						prename[count] = scan.nextLine();
						System.out.println("���Ͻô� �����ȣ 6�ڸ��� �Է��ϼ��� :");
						prenum[count] = scan.nextInt();
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						pay -=price[sel-1];
						rSweet[choice-1] = 1;
						preroom[count] = sel*100 +choice;
						count++;
					}
				}else if(sel == 2) {
					if(bSweet[choice-1] == 1) {
						System.out.println("�̹� ����� ȣ���Դϴ�.");
					}else {
						System.out.println("�����Ͻô� ���� ������ �Է����ּ��� :");
						scan.nextLine();
						prename[count] = scan.nextLine();
						System.out.println("���Ͻô� �����ȣ 6�ڸ��� �Է��ϼ��� :");
						prenum[count] = scan.nextInt();
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						pay -=price[sel-1];
						bSweet[choice-1] = 1;
						preroom[count] = sel*100 +choice;
						count++;
					}
				}else if(sel == 1) {
					if(eSweet[choice-1] == 1) {
						System.out.println("�̹� ����� ȣ���Դϴ�.");
					}else {
						System.out.println("�����Ͻô� ���� ������ �Է����ּ��� :");
						scan.nextLine();
						prename[count] = scan.nextLine();
						System.out.println("���Ͻô� �����ȣ�� �Է��ϼ��� :");
						prenum[count] = scan.nextInt();
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						pay -=price[sel-1];
						eSweet[choice-1] = 1;
						preroom[count] = sel*100 +choice;
						count++;
					}
				}
				break;
			case 2:
				System.out.println("����Ͻ� ȣ���� �Է����ּ��� : ");
				int tmp = 0;
				choice = scan.nextInt();
				for(int i=0;i<preroom.length;i++) {
					if(choice == preroom[i]) {
						tmp = i;
						equ = true;
						break;
					}
				}
				if(equ == true) {
					System.out.println("�����Ͻź��� ���԰� �����ȣ�� �Է����ּ��� : ");
					scan.nextLine();
					if(prename[tmp].equals(scan.nextLine()) && prenum[tmp] == scan.nextInt()) {
						System.out.println("������ ��ҵǾ����ϴ�.");
						if(preroom[tmp] / 100 == 1) {
							eSweet[preroom[tmp]%10-1] = 0;
						}else if(preroom[tmp] / 100 == 2) {
							bSweet[preroom[tmp]%10-1] = 0;
						}else if(preroom[tmp] / 100 ==3) {
							rSweet[preroom[tmp]%10-1] = 0;
						}
					}else {
						System.out.println("�Է��Ͻ� �̸��� ��ȣ�� �ٸ��ϴ�.");
					}
				}
				break;
			case 3:
				System.out.println("===ȣ�� Ȯ�� �޴�===");
				System.out.println("3�� - �ξ�\n2�� - �����Ͻ�\n1�� - ���ڳ��");
				for(int i=0;i<rSweet.length;i++) {
					if(i % 4 == 0) {
						System.out.println();
					}
					if(rSweet[i] == 0) {
						possible = "���� ����";
					}else {
						possible = "���� �Ұ���";
					}
					System.out.print("30"+(i+1)+"ȣ"+possible+"   ");
				}
				System.out.println();
				for(int i=0;i<bSweet.length;i++) {
					if(i % 4 == 0) {
						System.out.println();
					}
					if(bSweet[i] == 0) {
						possible = "���� ����";
					}else {
						possible = "���� �Ұ���";
					}
					System.out.print("20"+(i+1)+"ȣ"+possible+"   ");
				}
				System.out.println();
				for(int i=0;i<eSweet.length;i++) {
					if(i % 4 == 0) {
						System.out.println();
					}
					if(eSweet[i] == 0) {
						possible = "���� ����";
					}else {
						possible = "���� �Ұ���";
					}
					System.out.print("10"+(i+1)+"ȣ"+possible+"   ");
				}
				System.out.println();
				break;
			case 4:
				System.out.println("���Ͻô� �ݾ��� �Է��ϼ��� : ");
				pay += scan.nextInt();
				break;
			case 5:
				System.out.println("�����ݾ��� ��ȯ�մϴ�.");
				System.out.println(pay);
				pay = 0;
				break;
			case 77:
				System.out.println("===������ ���===");
				break;
			case 99:
				System.out.println("���α׷� ����");
				power = true;
				break;
			default:
				break;
			}
		}//while�� ��
	}

}
