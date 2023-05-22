package kr.co.dong.array;

import java.util.Scanner;

public class Report06_20230522 {

	public static void main(String[] args) {//99번은 자판기재고종료??!!  , 77번은 관리자모드?!?!?!
		// TODO Auto-generated method stub
		// 배열자판기구현
		int dPrice[] = new int[] { 500, 1000, 1500 };// 가격이당
		int dAmount[] = new int[] { 3, 3, 3 };// 갯수를//총 금액
		String[] dName = new String[] { "바나나", "블러드", "차차차" };// 음료명칭
		boolean power = false;
		int change = 0;// 거스름돈 거스름돈=머니-선택한메뉴가격
		int money = 0;// 돈 선언
		int choice = 0;// 메뉴이다 1번 2번 3번 등등이지
		change = money - dPrice[0];
		change = money - dPrice[1];
		change = money - dPrice[2];// 돈금액에서 가격을 뺀게 거스름돈

		Scanner scan = new Scanner(System.in);

		while (!power) {// 초아이스는 선택지
			System.out.println("현재잔액은 : " + money);
			System.out.println("음료를 말해라");
			for (int i = 0; i < dName.length; i++) {
				System.out.print(i + 1 + " " + dName[i] + " " + dPrice[i] + " " + dAmount[i] + "\n");//역슬래시앤 :줄바꿈(게헹)
			}
			System.out.println("4 돈입력 :   ");// 4일 때 돈입력 스위치문 케이스 4번으로 가자
			money=money +scan.nextInt();
			System.out.println("메뉴를 선택하자 :");//메뉴선택한걸 보여주기
			choice = scan.nextInt();
			System.out.println("누적된 금액은 :" +  money );//돈을 더해서 머니에 누적함
			switch (choice) {// 스위치문 구현 해당번호에 부합하면 그걸로 감
			case 1:
				if (money >= dPrice[0] && dAmount[0] != 0) {// 돈이 해당선택 음료보다 크다 이며 재고가 있을때
					money = money - dPrice[0];// 돈에서 선택한 음료가격을 차감하다
					dAmount[0] = dAmount[0] - 1;// 재고를 1개 소진
				} else if (money < dPrice[0]) {// 돈이 해당선택한 음료보다 작으면
					System.out.println("돈이없네요");
				} else if (dAmount[0] == 0) {// 재고가 0개면 재고가 없음
					System.out.println("재고부족");
				}
				break;
			case 2://2번메뉴에 관한것이다
				if (money >= dPrice[1] && dAmount[1] != 0) {
					money = money - dPrice[1];
					dAmount[1] = dAmount[1] - 1;
				} else if (money < dPrice[1]) {
					System.out.println("돈부족");
				} else if (dAmount[1] == 0) {
					System.out.println("재고없음");
				}

				break;

			case 3://3번째에 관한 것임
				if (money >= dPrice[2] && dAmount[2] != 0) {
					money = money - dPrice[2];
					dAmount[1] = dAmount[2] - 1;
				} else if (money < dPrice[2]) {
					System.out.println("돈부족한데요");
				} else if (dAmount[2] == 0) {
					System.out.println("재고가없는데");
				}
				break;
			case 4:
				System.out.print("돈을넣으세여 : ");
				money = money + scan.nextInt();// 머니에 머니를 더해서 누적하자
				System.out.println("누적된금액은 : " + money);
				break;
			case 77 : 
				if(power==false) {//파워가 펄스면 끝이지
					System.out.println("관리자종료임");
				}else if(dAmount[0]!=0&&dAmount[1]!=0&&dAmount[2]!=0&&money>=0){//재고들이 0이 아니면 아직 작동중이지
					System.out.println("아직시간이 많이남았음");
				}
				
			case 99:
				if(power=true) {
					System.out.println("====보여줘=====");
				}else if(power!=true){
					System.out.println("모드종료");
				}
				
			default:

			}

			

		}
		System.out.println();
	}

}
