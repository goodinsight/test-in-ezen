/*
 * �μ��� ��
 * �μ��� ��
 * �μ��� ��
 * �μ��� ����
 * ------------------------------
 * �޼ҵ� => Ŭ����:���뼺
 * 1) ���� ����(Ÿ��)
 * 2) �Ű������� ����(Ÿ��)
 * 
 * event handler(listener) - GUI
 *  - ���콺, Ű���� ��
 *  
 */
package kr.co.dong.ioclasses;

import java.util.Scanner;

public class MethodTest {
	static Scanner scan = new Scanner(System.in);
	static int[] inputnum = new int[2];
	public static void main(String[] args) {
//		����
		Cal cal = null;
		boolean done = true;
		
//		�ʱ�ȭ��(�޴�)
		while(done) {
			int sel = menu();
			int r = 0;
			switch(sel) {
			case 1: 
				inputNumber();
				cal = new Cal();
				r  = cal.sum(inputnum[0], inputnum[1]);
				printResult(r);
				break;
			case 2:
				inputNumber();
				cal = new Cal();
				r = cal.minus(inputnum[0], inputnum[1]);
				printResult(r);
				break;
			case 3:
				inputNumber();
				cal = new Cal();
				r = cal.multiply(inputnum[0], inputnum[1]);
				printResult(r);
				break;
			case 4:
				inputNumber();
				cal = new Cal();
				try {
					r =(int) cal.divide(inputnum[0], inputnum[1]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printResult(r);
				break;
			default :
					
			}
			System.out.println("��� �Ϸ�");
			System.out.println("==========================");
		}
		
	}
	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("�ش� ������ ����� ��������.");
		System.out.println("1. �� 2. �� 3. �� 4. ������");
		System.out.print("Your Choice : ");
		int sel = scan.nextInt();
		return sel;
	}
	private static void printResult(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("����� : " + obj);
	}
	private static void inputNumber() {
		// �μ� �Է¹޾Ƽ� ����
		System.out.println("first Number : ");
		int n1 = scan.nextInt();
		System.out.println("second Number : ");
		int n2 = scan.nextInt();
		inputnum[0] = n1;
		inputnum[1] = n2;
	}
}






















