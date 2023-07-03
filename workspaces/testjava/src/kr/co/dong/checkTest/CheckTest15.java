/*
 *  작성자 : 양진율	 날짜 : 2023.05.25
 *  
 * 
 */

/*
 * 
 * 초기 설정
 * 
 * 0 : menu 초기화면
 * 1 : 예약
 * 		11 : 예약 객실 선택 
 * 		12 : 예약자명 & 예약 번호 입력
 * 
 * 2 : 예약 취소
 * 		21 : 예약자명 & 예약 번호 입력
 * 		22 : 객실 정보 개시 및 예약취소 확인.
 * 		
 * 3 : 예약 현황
 * 		31 : 방 이름 off
 * 		32 : 방 이름 on
 * 
 * 
 * 8(4) : 관리자 모드 
 *		80 : 관리자 모드 메뉴 선택
 *		81 : 객실 정보 변경 (변경 객실 선택)
 *			810: 변경 사항 선택(변경 메뉴)
 *			811: 객실 이름 변경
 *			812: 객실 수용 인원 변경
 *			813: 예약 가격 변경
 *			814: 예약자명 변경("" 검사)
 *			815: 예약 번호 변경("" 검사)
 *			총 객실 수 변경?
 *		82 : 예약 여부 변경 -> 결제 절차가 없는한 그냥 객실 예약/취소랑 다를바 없다.
 *		83 : 예약 현황 표시형식 변경?
 *
 * 99(5) : 종료
 *
 *
 *
 * 같은 예약자명에 같은 예약번호는??
 * 
 * 
 * 
 * 
 * 
 * <추가사항> 
 * 객실 규모는 시작과 동시에 입력
 * 
 * 호텔 방 번호 / 호텔방명 / 객실인원/ 가격
 * 예약시 예약자명/예약번호(취소시 필요) 등
 * 
 */
package kr.co.dong.checkTest;

import java.util.Arrays;
import java.util.Scanner;

public class CheckTest15 {
	public static void main(String[] args) {

		int roomMax = 0;//객실 규모
		
		boolean[] room = null;//예약여부
		
		String[] roomName = null;//호텔 방명
		
		int[] roomCap = null;//객실 수용 가능 인원
		
		int[] roomPrice = null;//객실 가격
		
		String[] reserveName = null;//예약자 이름
		
		String[] reservePass = null;//예약 번호(비밀번호)
		
//		String[] menuList = null;
		
		
		int menu;
		
		int view;
		
		int input;
		
		int targetIdx;
		
		boolean power;
		
		Scanner scan;
		
		int yn;
		String tmpStr;
		int tmpint;
		//초기화
		
		menu = 0;
		
		view = 1;
		
		targetIdx = 0;
		
		power = false;
		
		scan = new Scanner(System.in);
		
		yn = 0;
		
		//최초 기동시 설정
		System.out.println("시스템 초기 설정을 시작하겠습니다.\n");

		boolean tmpflag = false;
		
		while(!tmpflag) {
			try {
				System.out.print("최대 객실 수를 입력해주세요\n>>");
				roomMax = scan.nextInt();
				if(roomMax <= 0) {
					throw new Exception();
				}
				tmpflag = true;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				scan.nextLine();
			}
		}
		
		//각 배열 크기 설정및 초기화
		room = new boolean[roomMax];//예약여부
		Arrays.fill(room, false);
		
		roomName = new String[roomMax];//호텔 방명
		Arrays.fill(roomName, "");
		
		roomCap = new int[roomMax];//객실 수용 가능 인원
		Arrays.fill(roomCap, 0);
		
		roomPrice = new int[roomMax];//객실 가격
		Arrays.fill(roomPrice, 0);
		
		reserveName = new String[roomMax];
		Arrays.fill(reserveName, "");
		
		reservePass = new String[roomMax];
		Arrays.fill(reservePass, "");
		
//		초기 객실 설정
		
		tmpflag = false;
		int rinit = 0;
		int tmpswitch = 1;
		while(!tmpflag) {
			if(rinit < roomMax) {
				try {
					System.out.println();
					switch(tmpswitch) {
					case 1://호텔 방명 설정
						scan.nextLine();
						System.out.print((rinit+1)+"번 객실의 이름을 설정해주세요.\n>>");
						roomName[rinit] = scan.nextLine();
						tmpswitch++;
					case 2://객실 수용 가능 인원 설정
						System.out.print((rinit+1)+"번 객실의 수용 가능 인원을 설정해주세요.\n>>");
						roomCap[rinit] = scan.nextInt();
						if(roomCap[rinit] <= 0) throw new Exception();
						tmpswitch++;
					case 3://객실 가격 설정
						System.out.print((rinit+1)+"번 객실의 가격을 설정해주세요.\n>>");
						roomPrice[rinit] = scan.nextInt();
						if(roomCap[rinit] <= 0) throw new Exception();
						tmpswitch++;
					case 4://확인
						System.out.println("\n----------------------------------------");
						System.out.println((rinit+1)+"번 객실");
						System.out.println("객실이름 : " + roomName[rinit]);
						System.out.println("수용인원 : " + roomCap[rinit]);
						System.out.println("예약가격 : " + roomPrice[rinit]);
						System.out.println("----------------------------------------");
						System.out.println("\n위 내용으로 설정하시겠습니까?(1: yes / 0: no)");
						yn = scan.nextInt();
						if(yn == 1) rinit++;
						else if(yn != 0) throw new Exception();
						
						tmpswitch = 1;
						
					}
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
			}else {
				
				tmpflag = true;
			}
		}
		
		tmpflag = false;

//		초기 객실 설정 END

		while(!power) {
			switch(menu) {
			case 0://초기화면
				
				/*
				//현재 예약상태
				// 3번 호실 확인 추가시 삭제
				System.out.println("\n\n== 현재 예약 상태 ======================");
				
				tmpStr = "";
				for(int i = 0; i < roomMax; i++) {
					
					String star = room[i] ? "★":"☆";
					tmpStr += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmpStr += "\n";
				}
				System.out.println(tmpStr);
				
				System.out.println("====================================");
				System.out.println("★ : 예약 불가, ☆ : 예약 가능");
				*/
				//메뉴 안내
				System.out.println("\n입력 안내\n"
						+ "1\t: 예약\n"
						+ "2\t: 예약 취소\n"
						+ "3\t: 예약 현황 조회\n"
						+ "4\t: 관리자 모드\n"
						+ "99\t: 종료");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					
					switch(input) {
						case 1 ://예약
							menu = 11;
							break;
						case 2 ://예약 취소
							menu = 21;
							break;
						case 3 ://
							menu = 30 + view;
							break;
						case 4 ://관리자 메뉴로
							menu = 80;
							break;
						case 99://종료
							menu = 99;
							break;
						default :
							throw new Exception();
					}
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
				
			case 11://예약객실 선택

				System.out.println("\n예약하시고 싶은 방 번호를 입력해주세요.(취소 : 99)");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					if(input == 99) {//취소 
						menu = 0;
					}else if(room[input-1]) {//예약 불가
						System.out.println("이미 예약되어있는 방입니다.");
					}else {//예약 가능

						System.out.println("\n== 객실 정보 =============================");
						System.out.println((input)+"번 방");
						System.out.println("객실이름 : " + roomName[input-1]);
						System.out.println("수용인원 : " + roomCap[input-1]);
						System.out.println("예약가격 : " + roomPrice[input-1]);
						System.out.println("=======================================\n");
						
						System.out.println("예약이 가능한 방입니다.");
						System.out.print("예약하시겠습니까? (1: yes / 0: no)\n>>");
						yn = scan.nextInt();
						if(yn == 1) {
							targetIdx = input-1;
							menu = 12;							
						}else if(yn != 0) {
							throw new Exception();
						}
					}
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
				
			case 12://예약자명 & 예약번호 입력
				
				try {
					System.out.print("예약자 명을 입력해주세요.\n>>");
					reserveName[targetIdx] = scan.next();
					System.out.print("예약 번호를 입력해주세요.(문자 가능)\n>>");					
					reservePass[targetIdx] = scan.next();
					room[targetIdx] = true;
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("알 수 없는 오류.");
					scan.nextLine();
				}
				
				break;//예약자명 & 예약번호 입력 end
				
			case 21://예약취소
				
				try {
//					절차 진행 여부 확인
					System.out.print("예약 취소 절차를 진행하시겠습니까? (1: yes / 0: no) \n>> ");
					yn = scan.nextInt();
					if(yn == 0) {
						menu = 0;
						break;
					}else if(yn != 1) {
						throw new Exception();
					}
					
//					요구사항 입력
					System.out.print("예약자 명을 입력해주세요.\n>>");
					String tmp1 = scan.next();
					System.out.print("예약 번호를 입력해주세요.(문자 가능)\n>>");					
					String tmp2 = scan.next();
					
//					일치하는지 검색
					targetIdx = -1;
					for(int i = 0; i < roomMax; i++) {
						if(reserveName[i].equals(tmp1) && reservePass[i].equals(tmp2)) {
							targetIdx = i;
							break;
						}
					}
//					불일치시
					if(targetIdx == -1) {
						System.out.println("해당하는 예약자가 없거나 예약번호가 일치하지 않습니다.");
						break;
					}
					
//					일치시 취소 확인 절차로
					menu = 22;
					
				} catch (Exception e) {
					
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
				
			case 22://객실정보 개시 및 예약취소 확인
				
				System.out.println("== 객실 정보 =============================");
				System.out.println((targetIdx+1)+"번 방");
				System.out.println("객실이름 : " + roomName[targetIdx]);
				System.out.println("수용인원 : " + roomCap[targetIdx]);
				System.out.println("예약가격 : " + roomPrice[targetIdx]);
				System.out.println("=======================================\n");
				
				try {
					System.out.print("해당 객실의 예약을 취소하시겠습니까? (1: yes / 0: no)\n>>");
					yn = scan.nextInt();
					if(yn == 0) {
						menu = 21;
						break;
					}else if(yn != 1) {
						throw new Exception();
					}
					
					room[targetIdx] = false;
					reserveName[targetIdx] = "";
					reservePass[targetIdx] = "";
					System.out.println("\n예약이 취소되었습니다.\n");
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
			
			case 31://예약 현황(방 이름 off)
				
				System.out.println("\n\n== 현재 예약 상태 ======================");
				
				tmpStr = "";
				for(int i = 0; i < roomMax; i++) {
					
					String star = room[i] ? "★":"☆";
					tmpStr += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmpStr += "\n";
				}
				System.out.println(tmpStr);
				
				System.out.println("====================================");
				System.out.println("★ : 예약 불가, ☆ : 예약 가능");
				
				menu = 0;
				
				break;//예약 현황(방 이름 off) END
				
			case 32://예약 현황(방 이름 on)
				try {
					System.out.println("\n입력안내"
							+ "\n1\t: 예약이 되어있는 객실"
							+ "\n2\t: 예약이 되어있지 않은 객실"
							+ "\n3\t: 모든 객실"
							+ "\n99\t: 취소");
					System.out.print("원하시는 출력방식을 선택해주세요.\n>>");
					input = scan.nextInt();
					
					boolean notflag = false;
					boolean allflag = false;
					
					switch(input) {
						case 1:
							break;
						case 2:
							notflag = true;
							break;
						case 3:
							allflag = true;
							break;
						case 99:
							menu = 0;
							break;
						default:
							throw new Exception();
					}
					
					if(input == 99) break;
					
					System.out.println("\n\n== 현재 예약 상태 ======================");
					for(int i = 0; i < roomMax; i++) {
						if((notflag^room[i])||allflag) {
							
							tmpStr = "";
							
							tmpStr += String.format("%2d번 객실 [%s] ", (i+1), roomName[i]);
							
							if(allflag) {
								tmpStr += ": " + (room[i] ? "★":"☆");
							}
							
							System.out.println(tmpStr);
							
						}
					}
					System.out.println("====================================");
					if(allflag) {
						System.out.println("★ : 예약 불가, ☆ : 예약 가능");
					}
					
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				break;//예약 현황(방 이름 on) END
				
			case 80://관리자 모드 메뉴선택
				System.out.println("\n==관리자 모드 입니다.================");
				//메뉴 안내
				System.out.println("입력 안내\n"
						+ "1\t: 객실 및 예약 정보 변경\n"
//						+ "2\t: 예약 여부 변경\n"
						+ "3\t: 예약 현황 표시형식 변경\n"
						+ "99\t: 종료");
				System.out.println("================================");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					
					switch(input) {
						case 1 : //객실 및 예약 정보 변경
							menu = 81;
							break;
//						case 2 : //예약 여부 변경
						case 3 : //표시 형식 변경
							menu = 83;
							break;
						case 99://취소
							menu = 0;
							break;
						default :
							throw new Exception();
					}
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;//관리자 모드 메뉴선택 END
				
			case 81://변경 객실 선택

				try {
//					객실 선택
					System.out.print("\n변경하시고 싶은 방 번호를 입력해주세요.(취소 : 99)\n>>");
					input = scan.nextInt();
					
					if(input == 99) {//취소 
						menu = 80;//관리자 모드 메뉴로
						break;
					}else if(input <= 0 || input > roomMax) {
						throw new Exception();
					}
					
					targetIdx = input-1;
					menu = 810;
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;//변경 객실 선택 END
				
			case 810://변경 사항 선택
					
				try {
					boolean resflag = false;
					System.out.println("\n== 객실 정보 =============================");
					System.out.println((targetIdx+1)+"번 방");
					System.out.println("객실이름 : " + roomName[targetIdx]);
					System.out.println("수용인원 : " + roomCap[targetIdx]);
					System.out.println("예약가격 : " + roomPrice[targetIdx]);					
					if(room[targetIdx]) {
						System.out.println("---------------------------------------");
						System.out.println("예약자명 : " + reserveName[targetIdx]);
						System.out.println("예약번호 : " + reservePass[targetIdx]);
						resflag = true;
					}
					System.out.println("=======================================\n");
					
					//메뉴 안내
					System.out.println("입력 안내\n"
							+ "1\t: 객실이름 변경\n"
							+ "2\t: 수용인원 변경\n"
							+ "3\t: 예약가격 변경");
					
					if(room[targetIdx]) {
						System.out.print("4\t: 예약자명 변경\n");
						System.out.print("5\t: 예약번호 변경\n");
					}
					
					System.out.println("99\t: 취소");
					
					System.out.print(">> ");
					input = scan.nextInt();
					
					if(!resflag &&(input == 3 || input ==4)) {
						input = -1;
					}
					
					
					switch(input) {
						case 1: case 2: case 3: case 4: case 5:
							menu = 810 + input;
							break;
						/*
						case 1 ://객실이름 변경
							menu = 811;
							break;
						case 2 ://수용인원 변경
							menu = 822;
							break;
						case 3 ://예약가격 변경
							menu = 823;
							break;
						case 4 ://예약자명 변경
							menu = 824;
							break;
						case 5 ://예약번호 변경
							menu = 825;
							break;
					 	*/
						case 99 ://취소
							menu = 80;
							break;
						default :
							throw new Exception();
					}
					
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;//변경 사항 선택 END
				
			case 811://객실 이름 변경
				
				try {
					System.out.println("현재 객실 이름은 ["+roomName[targetIdx]+"] 입니다.");
					System.out.print("이름을 변경하시겠습니까? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpStr = roomName[targetIdx];
						scan.nextLine();
						System.out.print("변경하시고 싶은 이름을 입력해주세요 \n>>");
						roomName[targetIdx] = scan.nextLine();
						
						System.out.println((targetIdx+1)+"번 객실의 이름이 ["+tmpStr+"]에서 \n["+roomName[targetIdx]+"](으)로 변경되었습니다.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//관리자 메뉴로
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				
				break;//객실 이름 변경 END
				
			case 812://객실 수용인원 변경
				
				try {
					System.out.println("현재 객실 수용인원은 ["+roomCap[targetIdx]+"] 입니다.");
					System.out.print("수용인원을 변경하시겠습니까? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpint = roomCap[targetIdx];
						System.out.print("변경하시고 싶은 수용인원을 입력해주세요 \n>>");
						roomCap[targetIdx] = scan.nextInt();
						
						System.out.println((targetIdx+1)+"번 객실의 수용인원이 ["+tmpint+"]에서 \n["+roomCap[targetIdx]+"](으)로 변경되었습니다.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//관리자 메뉴로
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;//객실 수용인원 변경 END
				
			case 813://객실 예약가격 변경
				
				try {
					System.out.println("현재 객실 예약가격은 ["+roomPrice[targetIdx]+"] 입니다.");
					System.out.print("예약가격을 변경하시겠습니까? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpint = roomPrice[targetIdx];
						System.out.print("변경하시고 싶은 예약가격을 입력해주세요 \n>>");
						roomPrice[targetIdx] = scan.nextInt();
						
						System.out.println((targetIdx+1)+"번 객실의 예약가격이 ["+tmpint+"]에서 \n["+roomPrice[targetIdx]+"](으)로 변경되었습니다.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//관리자 메뉴로
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;//객실 예약가격 변경 END
				
			case 814://예약자명 변경
				
				try {
					System.out.println("현재 객실의 예약자명은 ["+reserveName[targetIdx]+"] 입니다.");
					System.out.print("예약자명을 변경하시겠습니까? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpStr = reserveName[targetIdx];
						scan.nextLine();
						System.out.print("변경하시고 싶은 예약자명을 입력해주세요 \n>>");
						reserveName[targetIdx] = scan.nextLine();
						
						System.out.println((targetIdx+1)+"번 객실의 예약자명이 ["+tmpStr+"]에서 \n["+reserveName[targetIdx]+"](으)로 변경되었습니다.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//관리자 메뉴로
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;//예약자명 변경 END
				
			case 815://예약번호 변경
				
				try {
					System.out.println("현재 객실의 예약번호는 ["+reservePass[targetIdx]+"] 입니다.");
					System.out.print("예약번호를 변경하시겠습니까? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpStr = reservePass[targetIdx];
						scan.nextLine();
						System.out.print("변경하시고 싶은 예약번호를 입력해주세요 \n>>");
						reservePass[targetIdx] = scan.nextLine();
						
						System.out.println((targetIdx+1)+"번 객실의 예약번호가 ["+tmpStr+"]에서 \n["+reservePass[targetIdx]+"](으)로 변경되었습니다.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//관리자 메뉴로
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;//예약번호 변경 END
				
				
			case 83:
				try {
					System.out.println("\n입력안내"
							+ "\n1\t: 객실 이름 표시 OFF"
							+ "\n2\t: 객실 이름 표시 ON");
					
					System.out.print("원하시는 표시 형식을 선택해주세요.\n>>");
					input = scan.nextInt();
					
					switch(input) {
						case 1 :
							view = 1;
							break;
						case 2 :
							view = 2;
							break;
						default :
							throw new Exception();
					}
					
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
				
			case 99://종료
				System.out.println("프로그램을 종료합니다.");
				power = true;
				break;
				
			}
		}
		
		scan.close();
		
	}

}
