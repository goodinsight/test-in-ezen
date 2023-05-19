package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub //자판기구현 ,음료3종류 종류,가격은별도 재고수
		// 시작과 동시에 화면에 메뉴 보여주기 , 음료종류와 가격 ,재고수,거스름돈반환,돈입력 자판기 종료,99이외 숫자면 화면메뉴 보여줘기
		boolean power = false; // 전원임니다
		// 메뉴입력 , 돈이랑 음료이름들1,2,3 ,가격1,가격2,가격3 , 거스름돈
		Scanner scan = new Scanner(System.in);
		int money, menu, ch = 0, bt = 0; // 돈과 메뉴 와 거스름돈과 버튼을 선언

		int col = 800, sunny = 1000, apple = 1500;// 콜라800월 ,서니텐1000원 사과1500원
		int cun, five, one = 0;//천원 오백원 백원
		System.out.println("돈을입력하세여");
		money = scan.nextInt();

		System.out.println("메뉴선택하세여");
		System.out.println("1.콜라,2써니텐,3사과");
		menu = scan.nextInt();
		ch = money - menu;// 거스름돈

		
			if (menu==1&&money>col) {
				ch=money-col;
			} else if (menu==2&&money>sunny) {
				ch=money-sunny;
			} else if (menu==3&&money>apple) {
				ch=money-apple;
			}else if(money<menu) {
				System.out.println("잔돈입력하세야");
			}else {
				ch=money;
				System.out.println("돌아가라");
				if(bt!=99) {
					System.out.println("보여주");
				}else {
					System.out.println("끝인데");
				}
			}
			System.out.println("잔돈 ="+ch + "원" );
			
			cun=money/1000;
			five=money%500;
			one=money%100;
			System.out.println("천원 ="+cun + "" );
			System.out.println("오천원 ="+five + "");
			System.out.println("백원 ="+one + "");
		}

	}


