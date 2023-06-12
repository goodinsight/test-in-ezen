/*
 * 두수의 합
 * 두수의 차
 * 두수의 곱
 * 두수의 나눔
 * ------------------------------
 * 메소드 => 클래스:재사용성
 * 1) 리턴 유무(타입)
 * 2) 매개변수의 유무(타입)
 * 
 * event handler(listener) - GUI
 *  - 마우스, 키보드 등
 *  
 */
package kr.co.dong.ioclasses;

import java.util.Scanner;

public class MethodTest {
	static Scanner scan = new Scanner(System.in);
	static int[] inputnum = new int[2];
	public static void main(String[] args) {
//		선언
		Cal cal = null;
		boolean done = true;
		
//		초기화면(메뉴)
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
			System.out.println("계산 완료");
			System.out.println("==========================");
		}
		
	}
	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("해당 계산기의 기능을 연습하자.");
		System.out.println("1. 합 2. 차 3. 곱 4. 나누기");
		System.out.print("Your Choice : ");
		int sel = scan.nextInt();
		return sel;
	}
	private static void printResult(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("결과값 : " + obj);
	}
	private static void inputNumber() {
		// 두수 입력받아서 저장
		System.out.println("first Number : ");
		int n1 = scan.nextInt();
		System.out.println("second Number : ");
		int n2 = scan.nextInt();
		inputnum[0] = n1;
		inputnum[1] = n2;
	}
}






















