package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {

	public static void main(String[] args) {
		boolean stop = false;
		int roommax;//총 방개수
//		int [] room = new int[4];
		
		int [] room;//예약여부
		String [] name;//방이름
		int [] price;//가격
		int [] per;//인원수
		String[] reserName;//예약자명
		int[] reserNum;//전화번호
		int roomnum=0;
		int menu =0;

//		
		
		Scanner scan = new Scanner(System.in);
		
		//
		System.out.println("총객실을 입력하세요");
		roommax = scan.nextInt();//총객실
		room = new int[roommax];//예약여부
		name = new String[roommax];//방이름
		per = new int[roommax];//총인원
		price = new int [roommax];//가격
		reserName = new String[roommax];//예약이름
		reserNum = new int[roommax];//예약번호
		
		
		
		for(int i=0;i<roommax;i++) {
			System.out.println("총객실은 "+roommax);

			System.out.println("방이름은 ");
			
			name[i]=scan.next();

			System.out.println("총인원은");
			per[i]=scan.nextInt();

			System.out.println("가격은");
			price[i]=scan.nextInt();
			
			System.out.println("입력 받은 값");
			System.out.println((i+1)+ "번 방 :" +name[i]+"/ "+per[i] + " 명 /" +price[i]+" 원 ");
			
			
		}
		
		//
		
		while(!stop) {
			System.out.println("==========================================================================================================================");
			System.out.println(" 총객실의 수는 "+roommax+"개 입니다.");
			for(int i=0;i<roommax;i++) {
			
			System.out.print(name[i]+(i+1)+"  ("+price[i]+"원)"+("  총인원")+per[i]+"명  "+room[i]+" /");
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
					System.out.println("예약자명 입력해주세요.");
					reserName[roomnum-1]=scan.next();
					System.out.println("전화번호 입력해주세요");
					reserNum[roomnum-1]=scan.nextInt();
					System.out.println("예약되었습니다.");
					}
				break;
			
			case 2://예약취소
				System.out.println("호실을 선택해주세요 (1~12)");
				roomnum= scan.nextInt();
				if(room[roomnum-1]==0) {
					System.out.println("확인된 예약이 없습니다.");
					}else {
						String tmp;
						int tmp2;
						System.out.println("예약자명 입력해주세요.");
						tmp=scan.next();
						System.out.println("전화번호 입력해주세요.");
						tmp2=scan.nextInt();
						if(reserName[roomnum-1].equals(tmp) && (reserNum[roomnum-1]==tmp2) ) {
							System.out.println("취소되었습니다.");
							room[roomnum-1]= 0 ;
						}
					}
				break;
			case 99: //프로그램 종료
				stop = true;
				System.out.println("프로그램을 종료합니다");
			}

	}

}
}