package kr.co.dong.room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Admin {
	
	FileWriter fw = null;
	Scanner scan = new Scanner(System.in);
	int choice = 0;
	String pwd = "admin";
	
	public int Pwd() {
		System.out.print("비밀번호를 입력하세요(초기 비밀번호는 admin) : ");
		String input = scan.next();
		if(input.equals(pwd)) {
			try {
				fw = new FileWriter("log.txt");
				fw.write("관리자 모드 진입 \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("(1)방 추가, (2)방 제거, (3)방 수정, (4)예약확인, (5)비밀번호 변경, (0)관리자 모드 종료");
			return scan.nextInt();
		} else {
			try {
				fw = new FileWriter("log.txt");
				fw.write("관리자 모드 진입 실패 \n");
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
			return 0;
		}
	}
	
	public void PwdSet() {
		System.out.print("변경할 비밀번호 입력 : ");
		String npwd = scan.next();
		System.out.println(pwd +"가 " + npwd + "로 변경되었습니다.");
		pwd = npwd;
		try {
			fw = new FileWriter("log.txt");
			fw.write("관리자 모드 비밀번호 변경");
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
	
	public void RoomAdd(List<Room> list){
		System.out.println("호수, 방 이름, 가격, 방 설명(생략가능)을 차례대로 입력해주세요.");
		System.out.print("호수 : ");
		int rNo = scan.nextInt();
		System.out.print("방 이름 : ");
		String rName = scan.next();
		System.out.print("가격 : ");
		int rPrice = scan.nextInt();
		System.out.println("방 설명 : ");
		String rContent = scan.next();
		
		if(rContent == null) {
			list.add(new Room(rNo, rName, rPrice));
		} else{
			list.add(new Room(rNo, rName, rPrice, rContent));
		}
		try {
			fw = new FileWriter("log.txt", true);
			fw.write("(방 생성됨) 호수 : " + rNo + "방 이름 : " + rName + "가격 : " + rPrice + "방 설명 : " + rContent + "\n");
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
	
	public void RoomSet(List<Room> list) {
		showRoom(list);
		System.out.print("수정할 방의 호수 : ");
		choice = scan.nextInt();
		for(Room data : list) {
			if(data.getrNo() == choice) {
				
				System.out.println("방 이름, 가격, 방 설명(생략가능)을 차례대로 입력해주세요.");
				int rNo = data.getrNo();
				System.out.print("방 이름 : ");
				String rName = scan.next();
				System.out.print("가격 : ");
				int rPrice = scan.nextInt();
				System.out.println("방 설명 : ");
				String rContent = scan.next();
				
				System.out.println(data.getrNo() + "번 방이 이름 : " + data.getrName() + " 가격 : " + data.getrPrice() + " 설명 : " + data.getrContent() + "에서");
				System.out.println("이름 : " + rName + " 가격 : " + rPrice + " 설명 : " + rContent + "로 변경되었습니다.");
				
				if(rContent == null) {
					list.set(list.indexOf(data), new Room(rNo, rName, rPrice));
				} else{
					list.set(list.indexOf(data), new Room(rNo, rName, rPrice, rContent));
				}
				try {
					fw = new FileWriter("log.txt", true);
					fw.write("(방 수정됨) 호수 : " + rNo + "방 이름 : " + rName + "가격 : " + rPrice + "방 설명 : " + rContent + "\n");
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
				break;
			}
			
		}
	}
	
	public void resCheck(List<Room> list) {
		showRoom(list);
		System.out.print("확인할 방의 호수 : ");
		choice = scan.nextInt();
		for(Room data : list) {
			if(data.getrNo() == choice) {
				if(data.isrState() == true) {
					System.out.println(data.getrNo() + "호 이름 : " + data.getrName() + " 가격 : " + data.getrPrice() + " 예약자명 : " + data.getCustomer() + "예약코드 : " + data.getResCode());
				}else {
					System.out.println(data.getrNo() + "호 이름 : " + data.getrName() + " 가격 : " + data.getrPrice() + "예약되어있지 않습니다.");
				}
				try {
					fw = new FileWriter("log.txt", true);
					fw.write("(방 확인됨) 호수 : " + data.getrNo() + "방 이름 : " + data.getrName() + "가격 : " + data.getrPrice() + "방 설명 : " + data.getrContent() + "\n");
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
				break;
			}
		}
	}
	
	public void RoomDel(List<Room> list) {
		showRoom(list);
		System.out.print("제거할 방의 호수 입력 : ");
		choice = scan.nextInt();
		for(Room data : list) {
			try {
				fw = new FileWriter("log.txt", true);
				fw.write("(방 제거됨) 호수 : " + data.getrNo() + "방 이름 : " + data.getrName() + "가격 : " + data.getrPrice() + "방 설명 : " + data.getrContent() + "\n");
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
			if(data.getrNo() == choice) {
				System.out.println(data.getrNo() + "호가 삭제되었습니다. \n");
				list.remove(list.indexOf(data));
			}
		}
	}
	
	public void showRoom(List<Room> list) {
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
