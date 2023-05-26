package kr.co.dong.checkPoint;

import java.util.Scanner;

/* 2023/05/25 추가 사항 => 1. 객실 규모는 시작과 동시에 입력 2. 호텔 방번호/ 호텔방명(ex : 로얄
		 * /스텐다드....등등)/객실 인원/ 가격 3. 예약시 예약자명/ 예약 번호 (취소시 필요) 등 4. 기타 필요한 기능 (관리자 모드)
		 *
		 * 1) 객실 규모 변경. 
		 * 2) 호실 화면에서 => 호텔 방 번호 및 인원(0인실) 가격 등등 보여주기 
		 * 3) 예약 화면에서 예약자 이름 및, 전화번호 입력 => 예약 취소시 모두 삭제 & 빈방으로 변경
		 * 4) 관리자 모드 => 예약자 확인 및 예약일 및 예약 기간(0일) 추가 인원
		 * 발생시 추가요금까지 할수 있을ㄲㅏ........
*/
public class CheckTest01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String roomType[][] = {{"스탠다드", "20000", "60000", "2"}, {"디럭스", "25000", "70000", "2"}, {"트윈", "30000", "90000", "4"}};
		String typeName[] = {"대실", "숙박"};
		String pwd = "admin";
		String state = "예약됨";
		boolean admin_Power = false;
		System.out.print("객실 규모 입력 : ");
		int size = scan.nextInt();
		int plus = 0;
		String[][] room = new String [size][8];
		int roomNum = 301;
		for(int i = 0; i < room.length; i++) {
			for(int j = 1; j <= roomType.length + 1; j++) {
			room[i][j] = roomType[i%roomType.length][j-1]; // 방 정보
			}
			room[i][5] = "empty"; // 예약자명
			room[i][6] = "empty"; // 예약번호
			room[i][7] = "NotReservation"; // 예약상태
		}
		
		for(int i = 0; i < room.length - 1; i++) {
			if(Integer.parseInt(room[i][2]) > Integer.parseInt(room[i+1][2])) {
				String[] tmp = room[i];
				room[i] = room[i+1];
				room[i+1] = tmp;
				i = 0;
			}
		}
		
		for(int i = 0; i < room.length; i++) {
			room[i][0] = String.valueOf(roomNum); // 방 번호
			roomNum++;
			if(i != room.length -1 && !(room[i][1].equals(room[i+1][1]))) {
				roomNum = ((((roomNum + 100) / 100)*100) + 1);
			}
		}
		
		while(true) {
			int choice = 0;
			System.out.print("(1)호실선택 (2)예약취소 (3)호실확인 (99)종료 : ");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				for(int i = 0; i < room.length;) {
					if(room[i][7].equals("NotReservation")){
						state = "예약가능";
					}
					System.out.printf(room[i][0] +"번 %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "인실 " + state, room[i][1] );
					i++;
					if(i%3 == 0 && i != 0) {
						System.out.println();
					}else {
						System.out.print("      ");
					}
					state = "예약됨";
				}
				
				System.out.println();
				int selNum = 0;
				System.out.print("호실번호 선택 : ");
				selNum = scan.nextInt();
				int tmp = selNum%100-1;
				if(selNum >= Integer.parseInt(room[0][0]) && selNum <= Integer.parseInt(room[room.length-1][0])) {
					if(room[tmp][7].equals("NotReservation")) {
						System.out.println("예약이 가능합니다.");
					} else {
						System.out.println("예약이 불가능합니다.");
					}
						while(true) {
							System.out.println("(1)예약 (0)돌아가기");
							int sel = scan.nextInt();
							if(sel == 0) {
								break;
							} else if(sel == 1) {
								System.out.println("(1)대실 (2)숙박 (0)돌아가기");
								sel = scan.nextInt();
							}
							if (sel == 0){
								break;
							} else if(sel == 1 || sel == 2) {
								System.out.println(selNum +"번 방 " + room[tmp][1] + " " + typeName[sel-1] + " " + room[tmp][sel+1]+"원 선택");
								System.out.println(room[tmp][1] + "방의 기준 인원은 " + room[tmp][4] + "명 입니다. (1)추가 인원 없음 (2)인원 추가(인원 당 만원 추가) : ");
								int selNum2 = scan.nextInt();
								if(selNum2 == 2) {
									System.out.println("추가 인원 수를 입력해주세요 : ");
									plus = scan.nextInt();
								}
								System.out.print("예약자명을 입력해주세요 : ");
								room[tmp][5] = scan.next();
								System.out.print("예약번호를 입력해주세요 : ");
								room[tmp][6] = scan.next();
								System.out.println(room[tmp][5] + "님 이름으로 " + selNum + "번 방이 예약되었습니다.");
								System.out.println(Integer.parseInt(room[tmp][sel+1]) + (plus * 10000) + "원 결제되었습니다.");
								room[tmp][7] = "Reservation";
								break;
							} else {
								System.out.println("잘못된 입력입니다.");
							}
						}
				}else {
					System.out.println("잘못된 입력입니다.");
				}
				break;
			// case 1 end
			case 2:
				for(int i = 0; i < room.length;) {
					System.out.printf(room[i][0] +"번 %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "인실 ", room[i][1]);
					if(room[i][7].equals("NotReservation")){
						state = "예약가능";
					}
					System.out.print(state);
					i++;
					if(i%3 == 0 && i != 0) {
						System.out.println();
					}else {
						System.out.print("      ");
					}
					state = "예약됨";
				}
				System.out.println();
				while(true){
					System.out.print("예약을 취소할 방 번호를 입력해주세요((0)돌아가기) :");
					int selNum2 = scan.nextInt();
					int tmp2 = selNum2%100-1;
					if(selNum2 > Integer.parseInt(room[0][0]) && selNum2 < Integer.parseInt(room[room.length-1][0])) {
						if(room[tmp2][7].equals("Reservation")) {
							while(true){
								System.out.print("예약번호를 입력하세요 (0)돌아가기 : ");
								String input = scan.next();
								if(input.equals(room[tmp2][6])) {
									System.out.println(selNum2 + "번 방 예약이 취소되었습니다.");
									room[tmp2][7] = "NotReservation";
									room[tmp2][5] = "empty";
									room[tmp2][6] = "NotReservation";
									break;
								}else if(input == "0") {
									break;
								}else {
									System.out.println("예약번호가 틀립니다. 다시 입력해주세요");
								}
							}
							break;
						} else {
							System.out.println("예약되지 않은 방입니다.");
						}
					}else if(selNum2 == 0){
						break;
					}else {
						System.out.println("잘못된 입력입니다.");
					}
				}
				break;
			//case 2 end
				
			case 3:
				for(int i = 0; i < room.length;) {
					System.out.printf(room[i][0] +"번 %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "인실 ", room[i][1]);
					if(room[i][7].equals("NotReservation")){
						state = "예약가능";
					}
						System.out.print(state);
					i++;
					if(i%3 == 0 && i != 0) {
						System.out.println();
					}else {
						System.out.print("      ");
					}
					state = "예약됨";
				}
				System.out.println();
				break;
				//case 3 end
				
			case 77:
					System.out.print("관리자 모드 비밀번호 입력(초기 비밀번호 : admin) : ");
					String pwdinput = scan.next();
					if(pwdinput.equals(pwd)) {
						while(!admin_Power) {
							System.out.print("(1)예약정보 확인 (2)방 변경 (3)비밀번호 변경 : ");
							int admin_sel = scan.nextInt();
							switch(admin_sel) {
							case 1:
								for(int i = 0; i < room.length;) {
									System.out.printf(room[i][0] +"번 %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "인실 ", room[i][1]);
									if(room[i][7].equals("NotReservation")){
										state = "예약가능";
									}
										System.out.print(state);
									i++;
									if(i%3 == 0 && i != 0) {
										System.out.println();
									}else {
										System.out.print("      ");
									}
									state = "예약됨";
								}
								System.out.print("확인할 방 번호를 입력해주세요 : ");
								int sel_roomNum = scan.nextInt();
								int roomNumtmp = sel_roomNum%100 - 1;
								System.out.print(room[roomNumtmp][0] + "번 방 " + room[roomNumtmp][1] + " " + typeName[0] + " : " + room[roomNumtmp][2] + " " + typeName[1] + " : " + room[roomNumtmp][3] + " ");
								if(!(room[roomNumtmp][7].equals("Reservation"))) {
									state = "예약 없음";
									System.out.println(state);
								}else {
									System.out.println(state);
									System.out.println(" 추가 인원 : " + plus + " 예약자명 : " + room[roomNumtmp][5] + " 예약번호 : " + room[roomNumtmp][6]);
								}
								break; // case 1
								
							case 2:
								for(int i = 0; i < room.length;) {
									System.out.printf(room[i][0] +"번 %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "인실 ", room[i][1]);
									if(room[i][7].equals("NotReservation")){
										state = "예약가능";
									}
										System.out.print(state);
									i++;
									if(i%3 == 0 && i != 0) {
										System.out.println();
									}else {
										System.out.print("      ");
									}
									state = "예약됨";
								}
								System.out.print("변경할 방 번호를 입력해주세요(1) : ");
								int sel1_RoomNum = scan.nextInt();
								int sel1_tmp = sel1_RoomNum%100-1;
								if(room[sel1_tmp][7].equals("NotReservation")){
									System.out.println("예약되어있지 않은 방입니다.");
								}else if(room[sel1_tmp][7].equals("Reservation")){
									System.out.print("변경할 방 번호를 입력해주세요(2) : ");
									int sel2_RoomNum = scan.nextInt();
									int sel2_tmp = sel2_RoomNum%100-1;
									if(room[sel2_tmp][7].equals("Reservation")){
										System.out.println("이미 예약된 방입니다.");
									}else {
										System.out.println(sel1_RoomNum + "번 예약정보가 " + sel2_RoomNum +"방으로 변경되었습니다.");
										room[sel2_tmp][5] = room[sel1_tmp][5];
										room[sel2_tmp][6] = room[sel1_tmp][6];
										room[sel2_tmp][7] = "Reservation";
										room[sel1_tmp][7] = "NotReservation";
									}
								}
								break;
								
							case 3:
								System.out.print("변경할 비밀번호 : ");
								String npwd = scan.next();
								System.out.println("비밀번호가 " + npwd +"로 변경되었습니다.");
								pwd = npwd;
							}//switch
						}
							break;
							
					}else {
						System.out.println("비밀번호가 틀렸습니다.");
						break;
					}
			}
			scan.close();
		}
	}
}
