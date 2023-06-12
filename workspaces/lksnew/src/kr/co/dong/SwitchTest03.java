package kr.co.dong;

import java.util.Random;
import java.util.Scanner;

public class SwitchTest03 {
	public static void main(String[] args) {
		
//		사용자에게 1(가위), 2(바위), 3(보)를 입력받고
//		컴퓨터는 임의의 수(1~3) 사이의 값을 받아서
//		사용자의 승리여부를 출력하는 프로그램을 작성하세요
		int userNum = 0;
		int comNum = 0;
		String result = null;
		String comValue = null;
		String userValue = null;
		
		가위바위보:
		while(true) {
			입력부:
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.print("가위(또는 1), 바위(또는 2), 보(또는 3) 중 하나를 입력, 그만하시려면 (0)을 입력하세요: ");
				userValue = scan.next();
				comNum = (int)(Math.random()*3 + 1);
				switch (comNum) {
				case 1:
					comValue = "가위" ;
					break;
				case 2:
					comValue = "바위" ;
					break;
				case 3:
					comValue = "보" ;
					break;
				}
				switch (userValue) {
				case "1": case "가위":
					userValue = "가위" ;
					userNum = 1;
					result = whoIsWin(userNum, comNum);
					break 입력부;
				case "2": case "바위":
					userValue = "바위" ;
					userNum = 2;
					result = whoIsWin(userNum, comNum);
					break 입력부;
				case "3": case "보":
					userValue = "보" ;
					userNum = 3;
					result = whoIsWin(userNum, comNum);
					break 입력부;
				case "0":
					break 가위바위보;
				default:
					System.out.println("다시 입력하세요.");
					break ;
				}
			}
			System.out.println("당신은 "+ userValue +"이고, 컴퓨터는 " + comValue + "입니다. 컴퓨터와의 결과는 " + result+ " 입니다.");
		}
	}

	private static String whoIsWin(int a, int b) {
		String result = null;
		if (a - b == 1 || a - b == -2) {
			result = "승리";
		} else if (a - b == -1 || a - b == 2) {
			result = "패배";
		} else if (a - b == 0) {
			result = "비김";
		}
		return result;
	}
}
