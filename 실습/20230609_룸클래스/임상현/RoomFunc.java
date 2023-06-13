package kr.co.dong.room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RoomFunc {
	FileWriter fw = null;
	Scanner scan = new Scanner(System.in);
	int choice = 0;
	String input = null;
	public int menu(){
		System.out.println("(1)예약하기, (2)예약취소, (3)방정보, (4)예약정보, (0)종료");
		System.out.print("선택 : ");
		return scan.nextInt();
	}
	// 예약
	public void Res(List<Room> list) {
		showRoom(list);
		System.out.print("예약할 호실(방 이름) 선택 : ");
		input = scan.next();
		boolean check = false;
		Room data = null;
		for(Room index : list) {
			if(String.valueOf(index.getrNo()).equals(input) || index.getrName().equals(input)) {
				check = true;
				data = index;
				break;
			}
		}
			if(check) {
				if(data.isrState() != false) {
					System.out.println("이미 예약되어있는 방입니다.");
				}else {
					System.out.print("예약자명 입력 : ");
					data.setCustomer(scan.next());
					System.out.print("예약코드 입력 : ");
					data.setResCode(scan.next());
					data.setrState(true);
					try {
						fw = new FileWriter("log.txt", true);
						fw.write("(방 예약됨)" + data.getCustomer() + "님이 " + data.getrNo() + "호실 예약 \n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(data.getrNo() + "호실 " + data.getrName() + "방이 " + data.getCustomer() + "님 이름으로 예약되었습니다. \n");
				}
			} else {
				System.out.println("잘못된 입력입니다.");
			}
	}
	
	// 예약 취소
	public void ResCancel(List<Room> list) {
		showRoom(list);
		System.out.print("예약을 취소할 호실 선택 : ");
		choice = scan.nextInt();
		Room data = findrNo(choice, list);
			if(data != null) {
				if(data.isrState() == false) {
					System.out.println("예약되어있지 않은 방입니다.");
				}else {
					System.out.print("예약코드 입력 :");
					String input = scan.next();
					if(!(input.equals(data.getResCode()))) {
						System.out.println("잘못된 예약코드입니다.");
					}else {
						try {
							fw = new FileWriter("log.txt", true);
							fw.write("(방 예약 취소됨)" + data.getCustomer() + "님이 " + data.getrNo() + "호실 예약 취소 \n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							try {
								fw.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						data.setCustomer(null);
						data.setResCode(null);
						data.setrState(false);
						
						System.out.println(data.getrNo() + "호실 " + data.getrName() + "방이 예약 취소되었습니다.");

					}
				}
			}
	}
	
	// 3번 선택 시 전체 방, 선택 방 구분
	public void Check(List<Room> list) {
		System.out.print("(1)모든 방 확인, (2)방 선택확인 : ");
		choice = scan.nextInt();
		if(choice == 1) {
			AllRoomCheck(list);
		} else if(choice == 2){
			RoomCheck(list);
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}
	
	// 전체 방 정보
	public void AllRoomCheck(List<Room> list) {
		showRoom(list);
		try {
			fw = new FileWriter("log.txt", true);
			fw.write("모든 방 확인됨 \n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 선택 방 정보
	public void RoomCheck(List<Room> list) {
		showRoom(list);
		System.out.print("확인할 호실 : ");
		choice = scan.nextInt();
		Room data = findrNo(choice, list);
		if(data != null) {
				String state = null;
				if(data.isrState() == true) {
					state = "예약됨";
				} else {
					state = "예약가능";
				}
				System.out.println("호수 : " + data.getrNo() + " 방 이름 : " + data.getrName() + " 가격 : " + data.getrPrice() + " 예약상태 : " + state);
				try {
					fw = new FileWriter("log.txt", true);
					fw.write(data.getrNo() + "번 방 확인됨 \n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
	}
	
	// 예약 확인
	public void ResCheck(List<Room> list) {
		showRoom(list);
		System.out.print("예약을 확인할 호실 : ");
		choice = scan.nextInt();
		Room data = findrNo(choice, list);
			if(data != null) {
				if(data.isrState() != true) {
					System.out.println("예약이 없습니다.");
				}else {
					System.out.println(data.getCustomer() + "님 이름으로 예약되어있습니다.");
				}
				try {
					fw = new FileWriter("log.txt", true);
					fw.write(data.getrNo() + "번 방 예약 확인됨 \n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
	
	public void showRoom(List<Room> list) {
		if(list == null) {
			System.out.println("방이 없습니다. 관리자에게 문의하세요.");
		} else {
			for(Room data : list) {
				String state = null;
				if(data.isrState() == true) {
					state = "예약됨";
				} else {
					state = "예약가능";
				}
				System.out.println("호수 : " + data.getrNo() + " 방 이름 : " + data.getrName() + " 가격 : " + data.getrPrice() + " 예약상태 : " + state);
			}
		}
	}
	
	// 방번호로 찾기
	Room findRoom(String name, List<Room> list) {
		int index = -1;
		
		for(int i = 0; i < list.size(); i++) {
			list.get(i).getrName(); // 리스트 내의 방 이름
			if(name.equals(list.get(i).getrName())) {
				index = i;
				break;
			}
		}
		return list.get(index);
	}
	
	
	Room findrNo(int rNo, List<Room> list) {
		Room index = null;
		for(Room data : list) {
			if(data.getrNo() == rNo) {
				index = data;
				break;
			}
		}
		return index;
	}	
	
	public void sort(List<Room> roomList) {
		for(int i = 0; i < roomList.size()-1; i++) {
			if(roomList.get(i).getrNo() > roomList.get(i+1).getrNo()) {
				Room data = roomList.get(i+1);
				roomList.set(i+1, roomList.get(i));
				roomList.set(i, data);
				i = -1;
			}
		}
	
	}
	
}
