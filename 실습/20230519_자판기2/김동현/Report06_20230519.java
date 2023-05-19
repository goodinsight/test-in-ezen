package kr.co.dong.array;

import java.util.Scanner;

public class Report06_20230519 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열자판기구현
		int dPrice[] = new int[] { 500, 1000, 1500 };// 가격이당
		int dAmount[] = new int[] { 3,3,3 };// 갯수를//총 금액
		String[] dName = new String[] { "바나나", "블러드", "차차차" };// 음료명칭
		boolean power = false;
		int change = 0;// 거스름돈 거스름돈=머니-선택한메뉴가격
		int money = 0;// 돈 선언
		int choice = 0;// 메뉴이다 1번 2번 3번 등등이지
		change = money - dPrice[0];
		change = money - dPrice[1];
		change = money - dPrice[2];

		Scanner scan = new Scanner(System.in);

		while (!power) {// 초아이스는 선택지
			System.out.println("현재잔액은 : "+ money);
			System.out.println("음료를 말해라");
			for(int i=0;i<dName.length;i++) {
				System.out.print(i+1+" "+dName[i]+" " +dPrice[i]+ " "  +dAmount[i]+"\n");		
			}
			System.out.println("4 돈입력");
			
			System.out.println("메뉴를 선택하자 :");
			choice=scan.nextInt();
			
			switch (choice) {
			case 1:
				if(money>=dPrice[0]&&dAmount[0]!=0) {//돈이 해당선택 음료보다 크다 이며 재고가 있을때
					money=money-dPrice[0];
					dAmount[0]=dAmount[0]-1;//재고를 1개 소진
				}else if(money<dPrice[0]){
					System.out.println("돈이없네요");
				}else if(dAmount[0]==0) {
					System.out.println("재고부족");
				}
				break;
			case 2:
				if(money>=dPrice[1]&&dAmount[1]!=0) {
					money=money-dPrice[1];
					dAmount[1]=dAmount[1]-1;
				}else if(money<dPrice[1]) {
					System.out.println("돈부족");
				}else if(dAmount[1]==0) {
						System.out.println("재고없음");
					}
				
				break;
				
			case 3:
				if(money>=dPrice[2]&&dAmount[2]!=0) {
					money=money-dPrice[2];
					dAmount[1]=dAmount[2]-1;
				}else if(money<dPrice[2]) {
					System.out.println("돈부족");
				}else if(dAmount[2]==0) {
						System.out.println("재고없음");
					}
				break;
			case 4:
				System.out.print("돈을넣으세여 : ");
				money = money + scan.nextInt();// 머니에 머니를 더해서 누적하자
				break;
				
			default:
				break;
			}
			

		

		}
		System.out.println();
	}

}
