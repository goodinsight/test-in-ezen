/*
 * 2���� �ֻ����� �Է� �޾Ƽ� �� ���� 5, 7, 10�̸�  "��÷" �ƴϸ� "��÷�� �ƴմϴ�."
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstDice = -1;
		int secondDice = -1;
		System.out.print("ù��° �ֻ��� ���ڸ� �Է�(1~6) : ");
		firstDice = scan.nextInt();
		System.out.print("�ι�° �ֻ��� ���ڸ� �Է�(1~6) : ");
		secondDice = scan.nextInt();
		int sum = firstDice + secondDice;
		int[] prize = {5, 7, 10};
		String msg = null;
		boolean found = false;
		for(int x : prize){
			if(x == sum){
		        found = true;
		        break;
		    }
		}
		if (found) {
			msg = "��÷��";
		} else {
			msg = "��÷�� �ƴմϴ�.";
		}
		System.out.println("�� �ֻ����� ���� "+sum+"�̰�, "+msg+"....");
	}
}
