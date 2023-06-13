package kr.co.dong.checkTest;

import java.util.Arrays;
import java.util.Scanner;

public class CheckTest13 {
	public static void main(String[] args) {
//		키보드에 의한 입력작성
//		방12개가 있고 =>변수?배열? => 배열 예약room[12]
//		입력구성에서	//menu변수:1,2,3,99를 입력받음
//		1을 누른경우는 방의 예약,	//room[방번호]의 값이 1이면 예약상태
//			1->호실번호 선택(1~12) -> 예약상태여부 확인
//		->예약가능상태 -> 에약실시 ->호실확인 => 메뉴로 복귀
//		->예약불가상태 -> 호실번호 선택(1~12) or 메뉴로 복귀
//		2를 누른 경우 예약취소(예약->공실),	//room[방번호]의 값이 0이면 공실
//				2-> 호실번호선택(1~12)->취소가능여부
//			->취소가능: 해당호실의 값을 0으로 =>메뉴복귀
//			->취소불가: 예약되지않은 방이라고 표시. =>메뉴복귀
//		3을 누른 경우는 호실 확인,	//1인 경우는 "예약됨:★"0인경우는 "예약가능☆"
//		99를 누른 경우는 프로그램종료.
//		=> 추가사항 : 1.객실규모(크기)는 시작과 동시에 입력함  호텔 총 방개수
//				    2.호텔방번호/호텔방명(예-로얄/참나무 등)/객실인원/가격
//					3.예약시 예약자명/예약번호(취소시 필요) 등
//					4.기타 필요한 기능(관리자모드)
		Scanner scan = new Scanner(System.in);
		boolean power = false; 				// 프로그램 전원
		boolean equ = false;				//비교
		int[] rSweet = null;				//호텔 방 이름
		int[] bSweet = null;				//비지니스
		int[] eSweet = null;				//이코노미
		int[] price = {45000,60000,80000};	//가격
		int[] person = {2,3,4};				//객실인원
		int choice = 0;						//객실선택
		String[] prename = null;			//예약자 이름
		int[] prenum = null;				//예약자 예약번호
		int count = 0;						//예약횟수
		int[] preroom = null;				//예약된 호실
		int pnum = 0;						//투숙인원 입력
		int pay = 0;						//결제금액
		String possible = "";
		System.out.println("로얄 방 개수를 입력하세요 : ");
		int sel = scan.nextInt();			//선택 
		rSweet = new int[sel];				//로얄 방 개수
		System.out.println("비지니스 방 개수를 입력하세요 : ");
		sel = scan.nextInt();
		bSweet = new int[sel];
		System.out.println("이코노미 방 개수를 입력하세요 : ");
		sel= scan.nextInt();
		eSweet = new int[sel];
		prename = new String[rSweet.length+bSweet.length+eSweet.length];
		prenum = new int[rSweet.length+bSweet.length+eSweet.length];
		preroom = new int[rSweet.length+bSweet.length+eSweet.length];

		while(!power) {
			System.out.println("=====호텔 메뉴=====");
			System.out.println("1.호실예약 2.예약취소 3.호실확인 4.결제금액 투입 5.결제금액 반환 99.종료");
			System.out.println("남은 금액 : "+pay);
			System.out.println("원하시는 번호를 입력하세요 : ");
			sel=scan.nextInt();
			switch (sel) {
			case 1:
				System.out.println("3층 - 로얄(최대4명)80000원\n2층 - 비지니스(최대3명)60000원\n1층 - 이코노미(최대2명)45000원");
				System.out.println("예약할 층을 입력해주세요 : ");
				sel = scan.nextInt();
				if(pay < price[sel-1]) {
					System.out.println("금액이 부족합니다.");
					break;
				}
				
				if(sel == 3) {
					for(int i=0;i<rSweet.length;i++) {
						if(i % 4 == 0) {
							System.out.println();
						}
						if(rSweet[i] == 0) {
							possible = "예약 가능";
						}else {
							possible = "예약 불가능";
						}
						System.out.print("30"+(i+1)+"호"+possible+"   ");
					}
					System.out.println();
				}else if(sel == 2) {
					for(int i=0;i<bSweet.length;i++) {
						if(i % 4 == 0) {
							System.out.println();
						}
						if(bSweet[i] == 0) {
							possible = "예약 가능";
						}else {
							possible = "예약 불가능";
						}
						System.out.print("20"+(i+1)+"호"+possible+"   ");
					}
					System.out.println();
				}else if(sel == 1) {
					for(int i=0;i<eSweet.length;i++) {
						if(i % 4 == 0) {
							System.out.println();
						}
						if(eSweet[i] == 0) {
							possible = "예약 가능";
						}else {
							possible = "예약 불가능";
						}
						System.out.print("10"+(i+1)+"호"+possible+"   ");
					}
				}else {
					System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
				}
				System.out.println();
				System.out.println("원하시는 호실(맨뒤숫자만)을 입력해주세요 : ");
				choice = scan.nextInt();
				System.out.println("투숙인원을 입력해주세요 : ");
				pnum = scan.nextInt();
				if(pnum > person[sel-1]) {
					System.out.println("호실 최대인원수를 넘습니다.");
					break;
				}
				if(sel == 3) {
					if(rSweet[choice-1] == 1) {
						System.out.println("이미 예약된 호실입니다.");
					}else {
						System.out.println("예약하시는 분의 성함을 입력해주세요 :");
						scan.nextLine();
						prename[count] = scan.nextLine();
						System.out.println("원하시는 예약번호 6자리를 입력하세요 :");
						prenum[count] = scan.nextInt();
						System.out.println("예약이 완료되었습니다.");
						pay -=price[sel-1];
						rSweet[choice-1] = 1;
						preroom[count] = sel*100 +choice;
						count++;
					}
				}else if(sel == 2) {
					if(bSweet[choice-1] == 1) {
						System.out.println("이미 예약된 호실입니다.");
					}else {
						System.out.println("예약하시는 분의 성함을 입력해주세요 :");
						scan.nextLine();
						prename[count] = scan.nextLine();
						System.out.println("원하시는 예약번호 6자리를 입력하세요 :");
						prenum[count] = scan.nextInt();
						System.out.println("예약이 완료되었습니다.");
						pay -=price[sel-1];
						bSweet[choice-1] = 1;
						preroom[count] = sel*100 +choice;
						count++;
					}
				}else if(sel == 1) {
					if(eSweet[choice-1] == 1) {
						System.out.println("이미 예약된 호실입니다.");
					}else {
						System.out.println("예약하시는 분의 성함을 입력해주세요 :");
						scan.nextLine();
						prename[count] = scan.nextLine();
						System.out.println("원하시는 예약번호를 입력하세요 :");
						prenum[count] = scan.nextInt();
						System.out.println("예약이 완료되었습니다.");
						pay -=price[sel-1];
						eSweet[choice-1] = 1;
						preroom[count] = sel*100 +choice;
						count++;
					}
				}
				break;
			case 2:
				System.out.println("취소하실 호실을 입력해주세요 : ");
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
					System.out.println("예약하신분의 성함과 예약번호를 입력해주세요 : ");
					scan.nextLine();
					if(prename[tmp].equals(scan.nextLine()) && prenum[tmp] == scan.nextInt()) {
						System.out.println("예약이 취소되었습니다.");
						if(preroom[tmp] / 100 == 1) {
							eSweet[preroom[tmp]%10-1] = 0;
						}else if(preroom[tmp] / 100 == 2) {
							bSweet[preroom[tmp]%10-1] = 0;
						}else if(preroom[tmp] / 100 ==3) {
							rSweet[preroom[tmp]%10-1] = 0;
						}
					}else {
						System.out.println("입력하신 이름과 번호가 다릅니다.");
					}
				}
				break;
			case 3:
				System.out.println("===호실 확인 메뉴===");
				System.out.println("3층 - 로얄\n2층 - 비지니스\n1층 - 이코노미");
				for(int i=0;i<rSweet.length;i++) {
					if(i % 4 == 0) {
						System.out.println();
					}
					if(rSweet[i] == 0) {
						possible = "예약 가능";
					}else {
						possible = "예약 불가능";
					}
					System.out.print("30"+(i+1)+"호"+possible+"   ");
				}
				System.out.println();
				for(int i=0;i<bSweet.length;i++) {
					if(i % 4 == 0) {
						System.out.println();
					}
					if(bSweet[i] == 0) {
						possible = "예약 가능";
					}else {
						possible = "예약 불가능";
					}
					System.out.print("20"+(i+1)+"호"+possible+"   ");
				}
				System.out.println();
				for(int i=0;i<eSweet.length;i++) {
					if(i % 4 == 0) {
						System.out.println();
					}
					if(eSweet[i] == 0) {
						possible = "예약 가능";
					}else {
						possible = "예약 불가능";
					}
					System.out.print("10"+(i+1)+"호"+possible+"   ");
				}
				System.out.println();
				break;
			case 4:
				System.out.println("원하시는 금액을 입력하세요 : ");
				pay += scan.nextInt();
				break;
			case 5:
				System.out.println("결제금액을 반환합니다.");
				System.out.println(pay);
				pay = 0;
				break;
			case 77:
				System.out.println("===관리자 모드===");
				break;
			case 99:
				System.out.println("프로그램 종료");
				power = true;
				break;
			default:
				break;
			}
		}//while문 끝
	}

}
