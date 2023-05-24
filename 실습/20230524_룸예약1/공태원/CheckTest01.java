package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {

	public static void main(String[] args) {
		boolean stop = false;
		int [] room = new int[12];
		int roomnum=0;
		int menu =0;
		Scanner scan = new Scanner(System.in);
		
		while(!stop) {
			System.out.println("==========================================================================================================================");
			for(int i=0;i<room.length;i++) {
				System.out.print("  room"+(i+1)+" :"+room[i]);
			}
			System.out.println("\n1.호실선택 2.예약취소 99.프로그램 종료");
			menu = scan.nextInt();
			switch(menu) {
			case 1://예약
				System.out.println("호실을 선택해주세요 (1~12)");
				roomnum= scan.nextInt();
				if(room[roomnum-1]==1) {
					System.out.println("예약이 불가합니다.");
				}else {
					room[roomnum-1] = 1;
					System.out.println("예약되었습니다.");
				}
				break;
			
			case 2://예약취소
				System.out.println("호실을 선택해주세요 (1~12)");
				roomnum= scan.nextInt();
				if(room[roomnum-1]==0) {
					System.out.println("확인된 예약이 없습니다.");
					}else {
						room[roomnum-1]= 0 ;
						System.out.println("예약이 취소되었습니다.");
					}
				break;
			case 99: //프로그램 종료
				stop = true;
				System.out.println("프로그램을 종료합니다");
			}

	}

}
}