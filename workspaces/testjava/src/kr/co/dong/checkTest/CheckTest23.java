package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest23 {
	public static void main(String[] args) {
		// 비어있는 객실 = 0 , 예약된 객실 = 1
				// 추가사항
				// 1. 객실규모(크기)는 시작과 동시에 입력함
				// 2. 호텔방번호 / 호텔방명 (예-로얄 / 참나무 등) / 객실인원 / 가격
				// 3. 예약시 예약자명 / 예약번호(취소시 필요) 등
				// 4. 기타 필여한 기능 (관리자모드)
				Scanner scan = new Scanner(System.in);
				int roomChoice = 0; // 객실번호 선택
				int roomSize = 0; // 객실갯수 지정
				String answer = ""; // Y or N
				int[] roomCheck = null; // 객실예약상태
				int[] roomNum = null; // 객실번호
				String[] roomName = null; // 객실이름
				int[] roomPer = null; // 객실인원
				int[] roomPrice = null; // 객실가격
				String[] reserveName = null; // 예약자이름
				int[] reserveNum = null; // 예약번호
				String nameCheck = null; // 예약자이름 확인
				int numCheck = 0; // 예약자번호 확인
				// 버튼사용
				int menu = 0;
				// 관리자모드
				int password = 4444;
				int input_pass = 0;
				// 예약상태
				String check0 = "예약가능☆";
				String check1 = "예약불가능★";
				// 전원
				boolean power = false;

				while (!power) {
					if(roomSize == 0) {
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("관리자모드에서 초기설정이 필요합니다.");
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					}
					System.out.println("=======================");
					System.out.println("     호텔예약/관리시스템");
					System.out.println("=======================");
					System.out.println("     1. 손님모드");
					System.out.println("     2. 관리자모드");
					System.out.println("     99. 종료하기");
					System.out.println("=======================");
					System.out.print("    메뉴를 입력해주세요 : ");
					menu = scan.nextInt();
					switch (menu) {
					case 1: // 손님용
						if (roomSize == 0) { // 방 개수가 없을경우 준비중
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							System.out.println("    아직 준비 중 입니다.");
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						} else {
							while (menu != 88) {
								System.out.println("=======================");
								System.out.println("     1. 객실예약");
								System.out.println("     2. 객실취소");
								System.out.println("     3. 객실상태확인");
								System.out.println("     88. 처음으로");
								System.out.println("=======================");
								System.out.print("    메뉴를 입력해주세요 : ");
								menu = scan.nextInt();
								switch (menu) {
								case 1: // 객실예약
									System.out.println("=======================");
									System.out.print("원하시는 방 번호를 입력해주세요(1~" + roomCheck.length + ") : ");
									roomChoice = scan.nextInt();
									if (roomCheck[roomChoice - 1] == 0) { // 예약가능할시
										System.out.println("=======================");
										System.out.println("  " + roomChoice + "번 방을 선택하셨습니다.");
										System.out.println("=======================");
										System.out.println("객실번호 : " + roomNum[roomChoice - 1]);
										System.out.println("객실이름 : " + roomName[roomChoice - 1]);
										System.out.println("수용인원 : " + roomPer[roomChoice - 1]);
										System.out.println("객실가격 : " + roomPrice[roomChoice - 1]);
										System.out.println("=======================");
										System.out.print("  예약하시겠습니까 ? (Y/N) : ");
										answer = scan.next().toUpperCase();
										if (answer.equals("Y")) { // 예약진행
											System.out.println("=======================");
											System.out.print(" 예약자명을 입력해주세요 : ");
											reserveName[roomChoice - 1] = scan.next();
											System.out.println("=======================");
											System.out.print(" 예약번호를 입력해주세요 : ");
											reserveNum[roomChoice - 1] = scan.nextInt();
											roomCheck[roomChoice - 1] = 1;
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.println("    예약이 완료 되었습니다.");
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
										} else { // 예약종료
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.println("      취소 되었습니다.");
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
										}
									} else { // 예약불가능시
										System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
										System.out.println(roomChoice + "번 객실은 이미 예약되었습니다");
										System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
									}
									break;
								case 2: // 객실취소
									System.out.println("=======================");
									System.out.print("원하시는 방 번호를 입력해주세요(1~" + roomCheck.length + ") : ");
									roomChoice = scan.nextInt();
									if (roomCheck[roomChoice - 1] == 1) { // 취소가능할시
										System.out.println("=======================");
										System.out.println("  " + roomChoice + "번 방을 선택하셨습니다.");
										System.out.println("=======================");
										System.out.println("객실번호 : " + roomNum[roomChoice - 1]);
										System.out.println("객실이름 : " + roomName[roomChoice - 1]);
										System.out.println("수용인원 : " + roomPer[roomChoice - 1]);
										System.out.println("객실가격 : " + roomPrice[roomChoice - 1]);
										System.out.println("=======================");
										System.out.print("  취소하시겠습니까 ? (Y/N) : ");
										answer = scan.next().toUpperCase();
										if (answer.equals("Y")) { // 취소진행
											System.out.println("=======================");
											System.out.print(" 예약자명을 입력해주세요 : ");
											nameCheck = scan.next();
											if (reserveName[roomChoice - 1].equals(nameCheck)) { // 이름체크
												System.out.println("=======================");
												System.out.print(" 예약번호를 입력해주세요 : ");
												numCheck = scan.nextInt();
												if (reserveNum[roomChoice - 1] == numCheck) { // 예약번호 체크
													roomCheck[roomChoice - 1] = 0; // 예약상태 변경
													reserveName[roomChoice - 1] = null; // 예약자이름 삭제
													reserveNum[roomChoice - 1] = 0; // 예약자번호 삭제
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
													System.out.println("    취소가 완료 되었습니다.");
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
												} else { //번호다를시
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
													System.out.println("   예약번호를 확인해주세요.");
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
												}
											} else { // 이름다를시
												System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
												System.out.println("   예약자성함을 확인해주세요.");
												System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											}
										} else { // 취소종료
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.println("      취소 되었습니다.");
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
										}
									} else { // 취소불가능시
										System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
										System.out.println(roomChoice + "번 객실은 예약되어있지 않습니다.");
										System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
									}
									break;
								case 3: // 객실상태확인
									System.out.println("=======================");
									for (int i = 0; i < roomSize; i++) {
										System.out.printf("%d번 객실(%d호 / %s / %d명 / %d원) : ", i + 1, roomNum[i], roomName[i],
												roomPer[i], roomPrice[i]);
										if (roomCheck[i] == 0) {
											System.out.println(check0);
										} else if (roomCheck[i] == 1) {
											System.out.println(check1);
										}
									}
									break;
								case 88:
									break;
								default: // 잘못된 번호 입력시
									System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
									System.out.println("   올바른 번호를 입력해주세요.");
									System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
								}
							}
						}
						break;
					case 2: // 관리자용
						System.out.println("=======================");
						System.out.println("  관리자모드를 선택하셨습니다.");
						System.out.println("=======================");
						System.out.print("  비밀번호를 입력해 주세요 : ");
						input_pass = scan.nextInt();
						if (input_pass == password) {
							while (menu != 88) {
								System.out.println("=======================");
								System.out.println("     1. 객실초기설정");
								System.out.println("     2. 객실상태수정");
								System.out.println("     3. 객실현황확인");
								System.out.println("     88. 처음으로");
								System.out.println("=======================");
								System.out.print("    메뉴를 입력해주세요 : ");
								menu = scan.nextInt();
								switch (menu) {
								case 1: // 객실초기설정
									System.out.println("=======================");
									System.out.print("    객실 크기를 입력해주세요 : ");
									roomSize = scan.nextInt(); // 입력한 값으로 인덱스 부여(객실 개수)
									roomCheck = new int[roomSize];
									roomNum = new int[roomSize];
									roomName = new String[roomSize];
									roomPer = new int[roomSize];
									roomPrice = new int[roomSize];
									reserveName = new String[roomSize];
									reserveNum = new int[roomSize];
									for (int i = 0; i < roomSize; i++) { // 방 상세정보 부여 (번호, 이름, 인원, 가격)
										roomNum[i] = 101 + i;
										if (i > 5) {
											roomName[i] = "패밀리";
											roomPer[i] = 4;
											roomPrice[i] = 100000;
										} else if (i > 3) {
											roomName[i] = "스위트";
											roomPer[i] = 2;
											roomPrice[i] = 90000;
										} else if (i > 1) {
											roomName[i] = "프리미엄";
											roomPer[i] = 2;
											roomPrice[i] = 80000;
										} else {
											roomName[i] = "디럭스";
											roomPer[i] = 2;
											roomPrice[i] = 70000;
										}
									}
									break;
								case 2: // 객실상태수정
									System.out.println("제작중");
									break;
								case 3: // 객실현황확인
									System.out.println("=======================");
									for (int i = 0; i < roomSize; i++) {
										System.out.printf("%d번 객실(%d호/%s) - 예약자 : %s / 예약번호 : %d ", i + 1, roomNum[i],
												roomName[i], reserveName[i], reserveNum[i]);
										System.out.println();
									}
									break;
								case 88: // 처음으로 돌아감(반복문 탈출)
									break;
								default: // 잘못된 번호 입력시
									System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
									System.out.println("   올바른 번호를 입력해주세요.");
									System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
								}
							}
						} else {
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							System.out.println("   잘못된 비밀번호 입니다.");
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						}
						break;
					case 99: // 종료
						power = true;
						break;
					default:
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("   올바른 번호를 입력해주세요.");
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					}
				}
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("   이용해 주셔서 감사합니다.");
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			}
		}
