package kr.co.dong;

import java.util.Scanner;

public class FlowEx6_b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		사용자에게 1(가위), 2(바위), 3(보)를 입력받고
//		컴퓨터는 임의의 수 (1~3)사이의 값을 받아서
//		사용자의 승리여부를 출력하는 프로그램을 작성하세요
		System.out.print("가위:1 바위:2 보:3 중에 하나를 입력하시오(숫자): ");
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();

		int com = (int) (Math.random() * 3) + 1;
//					(int)<- int로 변환 (Math.random() * 총개수) + 시작점
		switch (user) {
		case 1:
			if (com == 1) {
//			switch (com) {
//			case 1: //user가 1일때 com이 1 2 이런식
				System.out.println("비겼습니다");
			} else if (com == 2) {
				System.out.println("패배");
			} else {
				System.out.println("승리");
			}
			break;
		case 2:
			if (com == 2) {
				System.out.println("비겼습니다");
			} else if (com == 3) {
				System.out.println("패배");
			} else {
				System.out.println("승리");
			}
			break;
		case 3:
			if (com == 3) {
				System.out.println("비겼습니다");
			} else if (com == 1) {
				System.out.println("패배");
			} else {
				System.out.println("승리");
			}
			break;
		}
	}

}
