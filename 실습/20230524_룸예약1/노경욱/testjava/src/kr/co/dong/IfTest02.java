package kr.co.dong;

import java.util.Scanner;

public class IfTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		���̸� �Է¹޾Ƽ� 20�� �̸�-> "û�ҳ�", 20�� �̻�~60�� �̸�-> "�߳�", 60�� �̻��̸� -> "���"�� �ǰ� ǥ��
		
		int age = 0;
		Scanner scan = new Scanner(System.in);
		String result = null;
		
		System.out.printf("���̸� �Է��Ͻÿ�: ");
		age = scan.nextInt();
		
		if(age < 20) {
//			System.out.println("û�ҳ��Դϴ�.");
			result = "û�ҳ�";
		}else if(age > 19 && age < 60){
//			System.out.println("�߳��Դϴ�.");
			result = "�߳�";
		}
		else {
//			System.out.println("����Դϴ�");
			result = "���";
		}
//		"����� ���̴� ??���̰�, 000�Դϴ�."
		System.out.println("����� ���̴� "+ age + "���̰�, " + result + " �Դϴ�.");
	}

}
