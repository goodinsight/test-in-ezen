package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest11 {
	public static void main(String[] args) {

		boolean power = true; // 전원
		String[][] room = null; // 객실별 정보
		int[][] resNum = null; // 객실별 예약 인원, 예약 번호
		String[] resName = null; // 객실별 예약자 이름
		boolean[] rAbl = null; // 객실별 예약 가능 여부
		int roomCount = 0; // 예약된 객실 수
		String input = null; // 콘솔 입력값
		int count = 0; // for문과 사용하는 임시 카운트
		int cmm = 0; // 스위치 제어
		int idx = 0; // 콘솔 입력값에서 연동되는 배열 인덱스
		int tmp = 0; // 콘솔 입력값 int 변환 후 임시 저장
		int tmp2 = 0; // tmp값을 유지해야할 때 사용되는 두번째 임시 저장
		int[] roomSize = null; // 객실별 규모
		String[] log = null; // 예약 내역
		int logMax = 10; // 예약 내역 최대치
		int logCount = 0; // 예약 내역 인덱스 제어

		String[][] roomD = { // 객실별 정보 기본값
				{ "101", "싱글A", "1인", "50000" }, { "102", "싱글B", "1인", "50000" }, { "103", "싱글C", "1인", "50000" },
				{ "104", "싱글D", "1인", "50000" }, { "201", "더블A", "2인", "100000" }, { "202", "더블B", "2인", "100000" },
				{ "203", "더블C", "2인", "100000" }, { "204", "더블D", "2인", "100000" }, { "301", "쿼드A", "4인", "200000" },
				{ "302", "쿼드B", "4인", "200000" }, { "303", "쿼드C", "4인", "200000" }, { "304", "쿼드D", "4인", "200000" }, };
		room = new String[12][4]; // 객실별 정보 초기화
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[0].length; j++) {
				room[i][j] = roomD[i][j];
			}
		}
		resNum = new int[12][2]; // 객실별 예약 인원, 예약 번호 초기화
		resName = new String[12]; // 객실별 예약자 이름 초기화
		rAbl = new boolean[12]; // 객실별 예약 가능 여부 초기화
		for (int i = 0; i < rAbl.length; i++) {
			rAbl[i] = true;
		}
		roomSize = new int[12]; // 객실별 규모 초기화
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i == 3) {
					continue;
				}
				roomSize[idx] = i;
				idx += 1;
			}
		}
		log = new String[logMax]; // 예약 내역 초기화
		int pass = 1111; // 관리자 암호 초기화

		Scanner scan = new Scanner(System.in); // Scanner 클래스 호출
		CheckTest11 ra = new CheckTest11(); // RoomArr11_1 클래스 호출

		while (power) { // 첫 화면
			System.out.println();
			System.out.println("[호텔 예약 프로그렘]");
			System.out.println("(1)사용자 예약 메뉴 (2)관리자 모드 (99)종료");
			System.out.print("항목 번호를 입력해주세요 : ");

			input = scan.nextLine();
			cmm = ra.toInt(input);
			if ((cmm != 1 && cmm != 2 && cmm != 99) || cmm == -1) {
				System.out.println("***올바른 번호를 입력해주세요.***");
				continue;
			}

			switch (cmm) {
			case 1: // 사용자 예약 메뉴
				while (true) {
					System.out.println();
					System.out.println("[예약 메뉴]");
					System.out.println("(1)예약 (2)예약 확인/취소 (3)객실 정보 (99)첫 화면 복귀");
					System.out.print("항목 번호를 입력해주세요 : ");

					input = scan.nextLine();
					cmm = ra.toInt(input);

					if ((cmm != 1 && cmm != 2 && cmm != 3 && cmm != 99) || cmm == -1) {
						System.out.println("***올바른 번호를 입력해주세요.***");
						continue;
					}

					switch (cmm) {
					case 1: // 예약
						while (true) {
							if (roomCount == room.length) {
								System.out.println("***현재 예약 가능한 객실이 없습니다.***");
								break;
							}
							tmp2 = ra.maxNum(roomSize);
							System.out.print("최대 " + tmp2 + "명까지의 예약할 인원 수를 입력해주세요.(취소:99) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp > tmp2) {
								System.out.println("***최대 " + tmp2 + "명까지만 예약이 가능합니다.***");
								continue;
							} else if (tmp < 1) {
								System.out.println("***올바른 인원 수를 입력해주세요.***");
								continue;
							}

							count = 0;
							for (int i = 0; i < room.length; i++) {
								if (rAbl[i] == true && tmp <= roomSize[i]) {
									count += 1;
								}
							}
							if (count == 0) {
								System.out.println("***" + tmp + "명 예약 가능한 객실이 없습니다.***");
								break;
							}

							System.out.println();
							System.out.println("[예약 가능한 객실]");
							System.out.println(" 번호 호수 객실명 규모  예약가격");

							for (int i = 0; i < room.length; i++) {
								if (rAbl[i] == true && tmp <= roomSize[i]) {
									System.out.printf("(%2d) %s %s %s %7s%n", i + 1, room[i][0], room[i][1], room[i][2],
											room[i][3]);
								}
							}
							System.out.print("예약할 객실 번호를 입력해주세요. (99:취소) : ");
							input = scan.nextLine();
							idx = ra.toInt(input) - 1;
							if (idx == 98) {
								break;
							} else if (idx > room.length || idx < 0 || rAbl[idx] == false || tmp > roomSize[idx]) {
								System.out.println("***올바른 객실 번호를 입력해주세요.***");
								continue;
							}

							System.out.println(room[idx][0] + "호 " + room[idx][1] + " 객실을 예약합니다.");
							System.out.print("예약자 이름을 입력해주세요. : ");
							resName[idx] = scan.nextLine();

							while (true) {
								System.out.print("예약 번호를 작성해주세요.(4자리) : ");
								input = scan.nextLine();
								tmp2 = ra.toInt(input);
								if (tmp2 > 9999 || tmp2 < 1000 || tmp2 == -1) {
									System.out.println("***올바른 예약 번호를 작성해주세요.***");
									continue;
								}

								count = 0;
								for (int i = 0; i < room.length; i++) {
									if (tmp2 == resNum[i][1]) {
										System.out.println("***중복된 예약 번호입니다.***");
										count += 1;
										break;
									}
								}
								if (count > 0) {
									continue;
								}

								break;
							}

							resNum[idx][0] = tmp;
							resNum[idx][1] = tmp2;
							rAbl[idx] = false;
							roomCount += 1;

							System.out.printf("%n%s호 %s 객실이 %s 님 %d명 일행에게 예약되었습니다.%n", room[idx][0], room[idx][1],
									resName[idx], resNum[idx][0]);

							if (logCount >= log.length) {
								for (int i = 1; i < log.length; i++) {
									log[i - 1] = log[i];
								}
								log[logCount - 1] = room[idx][0] + "호 " + room[idx][1] + " - " + resName[idx];
							} else {
								log[logCount] = room[idx][0] + "호 " + room[idx][1] + " - " + resName[idx];
								logCount += 1;
							}

							break;

						}

						continue;

					case 2: // 예약 확인/취소
						while (true) {
							System.out.print("예약 번호를 입력해주세요.(99:취소) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp > 9999 || tmp < 1000 || tmp2 == -1) {
								System.out.println("***올바른 예약 번호를 입력해주세요.***");
								continue;
							}

							count = 0;
							for (int i = 0; i < room.length; i++) {
								if (tmp == resNum[i][1]) {
									idx = i;
									count += 1;
								}
							}

							if (count == 0) {
								System.out.println("***등록된 예약 번호가 없습니다.***");
								break;
							}

							System.out.printf("%s 님 %d명 일행, %s호 %s 객실 예약되어있습니다.%n", resName[idx], resNum[idx][0],
									room[idx][0], room[idx][1]);

							while (true) {
								System.out.print("예약을 취소하시겠습니까?(y/n) : ");
								input = scan.nextLine();
								if (!(input.equals("y")) && !(input.equals("n"))) {
									continue;
								}
								break;
							}

							if (input.equals("n")) {
								System.out.println("예약이 유지됩니다.");
								break;
							}
							System.out.println("예약을 취소했습니다.");
							resName[idx] = null;
							resNum[idx][0] = 0;
							resNum[idx][1] = 0;
							rAbl[idx] = true;

							break;
						}

						continue;

					case 3: // 객실 정보
						System.out.println();
						System.out.println("[객실 정보]");
						System.out.println(" 번호  호수  객실명 규모  예약가격");
						for (int i = 0; i < room.length; i++) {
							System.out.printf("(%2d) %s호 %s %2s %7s ", i + 1, room[i][0], room[i][1], room[i][2],
									room[i][3]);
							if (rAbl[i]) {
								System.out.print("예약가능☆");
							} else {
								System.out.print("예약불가★");
							}
							System.out.println();
						}

						continue;

					case 99: // 첫 화면 복귀

						break;
					}
					break;

				}

				break;

			case 2: // 관리자 모드
				System.out.print("관리자 암호를 입력해주세요. : ");
				input = scan.nextLine();
				tmp = ra.toInt(input);
				if (tmp != pass) {
					System.out.println("***관리자 암호가 맞지 않습니다.***");
					break;
				}

				while (true) {
					System.out.println();
					System.out.println("[관리자 모드]");
					System.out.println("(1)객실 정보 변경 (2)예약 정보 변경 (3)전체 재설정 (4)예약 내역 (99)첫 화면 복귀");
					System.out.print("항목 번호를 입력해주세요. : ");
					input = scan.nextLine();
					cmm = ra.toInt(input);
					if (cmm == 99) {
						break;
					} else if ((cmm != 1 && cmm != 2 && cmm != 3 && cmm != 4 && cmm != 99) || cmm == -1) {
						System.out.println("***올바른 번호를 입력해주세요.***");
						continue;
					}
					switch (cmm) {
					case 1: // 객실 정보 변경
						while (true) {
							System.out.println();
							System.out.println("[객실 정보]");
							System.out.println(" 번호  호수 객실명 규모  예약가격");
							for (int i = 0; i < room.length; i++) {
								System.out.printf("(%2d) %s호 %s %s %7s%n", i + 1, room[i][0], room[i][1], room[i][2],
										room[i][3]);
							}

							System.out.print("정보를 변경할 객실 번호를 입력해주세요.(99:취소) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp < 1 || tmp > room.length || tmp == -1) {
								System.out.println("***올바른 객실 번호를 입력해주세요.***");
								continue;
							}
							idx = tmp - 1;

							while (true) {
								System.out.printf("(%2d) %s호 %s %s %7s%n", idx + 1, room[idx][0], room[idx][1],
										room[idx][2], room[idx][3]);
								System.out.println("(1)객실 이름 변경 (2)객실 규모 변경 (3)객실 가격 변경 (99)다른 객실 선택");
								System.out.print("항목 번호를 입력해주세요. : ");
								input = scan.nextLine();
								cmm = ra.toInt(input);
								if (cmm == 99) {
									break;
								} else if ((cmm != 1 && cmm != 2 && cmm != 3) || cmm == -1) {
									System.out.println("***올바른 항목 번호를 입력해주세요.***");
									continue;
								}

								switch (cmm) {
								case 1: // 객실 이름 변경
									System.out.print("변경할 이름을 입력해주세요.");
									room[idx][1] = scan.nextLine();

									break;

								case 2: // 객실 규모 변경
									tmp2 = ra.maxNum(roomSize);
									System.out.print("변경할 규모를 입력해주세요.(최대 " + tmp2 + "인) : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);

									if (tmp < 1) {
										System.out.println("***1인 이상의 규모를 입력해주세요.***");
										continue;
									} else if (tmp > 8) {
										System.out.println("***" + tmp2 + "인 이하의 규모를 입력해주세요***");
										continue;
									}
									roomSize[idx] = tmp;
									room[idx][2] = tmp + "인";

									break;

								case 3: // 객실 가격 변경
									System.out.print("변경할 가격을 입력해주세요 : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 0) {
										System.out.println("***0 이상의 가격을 입력해주세요.***");
										continue;
									}
									room[idx][3] = tmp + "";

									break;

								}

							}
						}
						continue;

					case 2: // 예약 정보 변경
						while (true) {
							System.out.println();
							System.out.println("[예약 정보]");
							System.out.println(" 번호  호수 객실명 규모  예약가격");
							for (int i = 0; i < room.length; i++) {
								System.out.printf("(%2d) %s호 %s %s %7s ", i + 1, room[i][0], room[i][1], room[i][2],
										room[i][3]);
								if (rAbl[i]) {
									System.out.print("예약가능☆");
								} else {
									System.out.printf("예약완료★ %s %d인 %d ", resName[i], resNum[i][0], resNum[i][1]);
								}
								System.out.println();
							}

							System.out.print("정보를 변경할 객실 번호를 입력해주세요.(99:취소) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp < 1 || tmp > room.length || tmp == -1) {
								System.out.println("***올바른 객실 번호를 입력해주세요.***");
								continue;
							}
							idx = tmp - 1;
							while (true) {
								System.out.printf("(%2d) %s호 %s %s %7s ", idx + 1, room[idx][0], room[idx][1],
										room[idx][2], room[idx][3]);
								if (rAbl[idx]) {
									System.out.print("예약가능☆");
								} else {
									System.out.printf("예약완료★ %s %d인 %d ", resName[idx], resNum[idx][0], resNum[idx][1]);
								}
								System.out.println();
								System.out.println("(1)예약자 변경 (2)예약 인원 변경 (3)예약 상태 변경 (4)예약 취소 (99)다른 객실 선택");
								System.out.print("항목 번호를 입력해주세요. : ");
								input = scan.nextLine();
								cmm = ra.toInt(input);
								if (cmm == 99) {
									break;
								} else if ((cmm != 1 && cmm != 2 && cmm != 3 && cmm != 4) || cmm == -1) {
									System.out.println("***올바른 항목 번호를 입력해주세요.***");
									continue;
								}
								switch (cmm) {
								case 1: // 예약자 변경
									System.out.print("변경할 예약자 이름을 입력해주세요. : ");
									resName[idx] = scan.nextLine();

									break;

								case 2: // 예약 인원 변경
									System.out.print("변경할 예약 인원을 입력해주세요.(" + roomSize[idx] + "명 이하) : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 1 || tmp > roomSize[idx]) {
										System.out.println("***올바른 인원을 입력해주세요.***");
										continue;
									}
									resNum[idx][0] = tmp;

									break;

								case 3: // 예약 상태 변경
									System.out.println("예약 가능/불가 상태를 변경합니다.");
									rAbl[idx] = !rAbl[idx];

									break;

								case 4: // 예약 취소
									while (true) {
										System.out.print("예약 정보를 삭제하겠습니까?(y/n) : ");
										input = scan.nextLine();
										if (!(input.equals("y")) && !(input.equals("n"))) {
											continue;
										}
										break;
									}

									if (input.equals("n")) {
										System.out.println("예약 정보가 유지됩니다.");
										break;
									}
									System.out.println("예약 정보를 삭제했습니다.");
									resName[idx] = null;
									resNum[idx][0] = 0;
									resNum[idx][1] = 0;
									rAbl[idx] = true;

									break;
								}
							}
						}
						continue;

					case 3: // 전체 재설정
						while (true) {
							System.out.println();
							System.out.println("(1)신규 재설정 (2)기본값 복원");
							System.out.print("항목 번호를 입력해주세요.(99:취소) : ");
							input = scan.nextLine();
							cmm = ra.toInt(input);
							if (cmm == 99) {
								break;
							}
							if (cmm != 1 && cmm != 2 || cmm == -1) {
								System.out.println("올바른 항목 번호를 입력해주세요.");
								continue;
							}

							switch (cmm) {
							case 1: // 신규 재설정
								while (true) {
									System.out.print("전체 객실 정보 신규 설정을 시작하겠습니까?(y/n) : ");
									input = scan.nextLine();
									if (!(input.equals("y")) && !(input.equals("n"))) {
										continue;
									}
									break;
								}
								if (input.equals("n")) {
									System.out.println("취소되었습니다.");
									break;
								}

								System.out.println("[신규 설정을 시작합니다.]");
								System.out.println("1. 호텔 규모 설정");

								while (true) {
									System.out.print("호텔의 층수를 입력해주세요 : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 0) {
										System.out.println("***1층 이상의 층수를 입력해주세요.***");
										continue;
									}
									break;
								}
								while (true) {
									System.out.print("호텔 층별 객실 수를 입력해주세요. : ");
									input = scan.nextLine();
									tmp2 = ra.toInt(input);
									if (tmp2 < 0) {
										System.out.println("***1개 이상의 객실 수를 입력해주세요.***");
										continue;
									}
									break;
								}
								room = new String[tmp * tmp2][4];
								resNum = new int[tmp * tmp2][2];
								resName = new String[tmp * tmp2];
								roomSize = new int[tmp * tmp2];
								rAbl = new boolean[tmp * tmp2];
								for (int i = 0; i < rAbl.length; i++) {
									rAbl[i] = true;
								}

								idx = 0;
								for (int i = 1; i <= tmp; i++) {
									for (int j = 1; j <= tmp2; j++) {
										if (j < 10) {
											room[idx][0] = i + "0" + j;
											idx += 1;
										} else {
											room[idx][0] = i + "" + j;
											idx += 1;
										}
									}
								}

								while (true) {
									System.out.println("2. 객실 정보 입력");
									for (int i = 0; i < room.length; i++) {
										System.out.printf("(%2d) %s %s %s %s%n", i + 1, room[i][0], room[i][1],
												room[i][2], room[i][3]);
									}
									System.out.print("정보를 입력할 객실 번호를 입력해주세요. : ");
									input = scan.nextLine();
									idx = ra.toInt(input) - 1;
									if (idx < 0 || idx >= room.length) {
										System.out.println("***올바른 객실 번호를 입력해주세요.***");
										continue;
									}

									System.out.printf("%s호의 최대 인원을 입력해주세요. : ", room[idx][0]);
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 1) {
										System.out.println("***1인 이상의 최대 인원을 입력해주세요.***");
										continue;
									}
									room[idx][2] = tmp + "인";
									roomSize[idx] = tmp;

									System.out.printf("%s호의 객실 이름을 입력해주세요. : ", room[idx][0]);
									room[idx][1] = scan.nextLine();

									System.out.printf("%s호의 예약 가격을 입력해주세요. : ", room[idx][0]);
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 0) {
										System.out.println("***0 이상의 가격을 입력해주세요.***");
										continue;
									}
									room[idx][3] = tmp + "";

									count = 0;
									for (int i = 0; i < room.length; i++) {
										for (int j = 0; j < room[i].length; j++) {
											if (room[i][j] == null) {
												count += 1;
											}
										}
									}

									if (count == 0) {
										System.out.println("모든 객실의 신규 정보가 입력되었습니다.");
										break;
									}

								}

								break;

							case 2: // 기본값 복원
								while (true) {
									System.out.print("모든 객실 정보를 초기화하겠습니까?(y/n) : ");
									input = scan.nextLine();
									if (!(input.equals("y")) && !(input.equals("n"))) {
										continue;
									}
									break;
								}
								if (input.equals("n")) {
									System.out.println("취소되었습니다.");
									break;
								}

								room = new String[12][4];
								for (int i = 0; i < room.length; i++) {
									for (int j = 0; j < room[0].length; j++) {
										room[i][j] = roomD[i][j];
									}
								}
								resNum = new int[12][2];
								resName = new String[12];
								rAbl = new boolean[12];
								for (int i = 0; i < rAbl.length; i++) {
									rAbl[i] = true;
								}
								idx = 0;
								roomSize = new int[12];
								for (int i = 1; i <= 4; i++) {
									for (int j = 1; j <= 4; j++) {
										if (i == 3) {
											continue;
										}
										roomSize[idx] = i;
										idx += 1;
									}
								}

								System.out.println("모든 객실 정보가 기본값으로 초기화되었습니다.");

								break;
							}

						}

						continue;

					case 4: // 예약 내역
						while (true) {
							System.out.println();
							System.out.println("(1)내역 확인 (2)내역 삭제 (3)내역 용량 변경");
							System.out.print("항목 번호를 입력해주세요.(99:취소) : ");

							input = scan.nextLine();
							cmm = ra.toInt(input);

							if (cmm != 1 && cmm != 2 && cmm != 3 && cmm != 99 || cmm == -1) {
								System.out.println("***올바른 항목 번호를 입력해주세요.***");
							} else if (cmm == 99) {
								break;
							}

							switch (cmm) {
							case 1: // 내역 확인
								System.out.println();
								count = 0;
								for (int i = 0; i < log.length; i++) {
									if (log[i] != null) {
										System.out.println(log[i]);
										count += 1;
									}
								}
								if (count == 0) {
									System.out.println("예약 내역이 없습니다.");
								}

								break;

							case 2: // 내역 삭제
								while (true) {
									System.out.println("예약 내역을 전부 삭제합니까?(y/n) : ");
									input = scan.nextLine();
									if (!(input.equals("n")) && !(input.equals("y"))) {
										continue;
									} else if (input.equals("n")) {
										System.out.println("취소되었습니다.");
										break;
									}
									log = new String[logMax];
									logCount = 0;

									break;
								}

								break;

							case 3: // 내역 용량 변경
								while (true) {
									System.out.println("현재 내역 최대 저장 개수 : " + logMax);
									System.out.println("*변경시 예약 내역이 전부 삭제됩니다.*");
									System.out.print("변경할 최대 저장 개수를 입력해주세요.(99:취소) : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 1) {
										System.out.println("***1 이상의 저장 개수를 입력해주세요***");
										continue;
									} else if (tmp == 99) {
										break;
									}
									logMax = tmp;
									log = new String[logMax];

									break;

								}

								break;
							}

						}

						continue;

					case 99: // 첫 화면 복귀
						break;
					}

					break;
				}
				break;

			case 99: // 종료
				System.out.println("종료합니다.");
				scan.close();
				power = false;

			} // end of switch main

		} // end of while(power)

	} // end of main

	int toInt(String str) { // int 변환 예외처리 메소드
		try {
			int result = Integer.parseInt(str);
			return result;
		} catch (Exception e) {
			return -1;
		}
	} // end of toInt

	int maxNum(int x[]) { // 배열 최대값 메소드
		int max = x[0];
		for (int i = 1; i < x.length; i++) {
			if (x[i] > max) {
				max = x[i];
			}
		}
		return max;
	} // end of maxNum

} // end of class
