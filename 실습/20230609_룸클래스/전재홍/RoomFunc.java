package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RoomFunc {
	static Scanner sc = new Scanner(System.in);		
	
		List<Room> list = new ArrayList<Room>();
		
		
//		예약하기 기능
		
		public void roomRev(List<Room> list) {
			System.out.println(" 현재 예약이 가능한 객실입니다. 예약할 호수를 입력해주세요. 객실 규모 : " + list.size() + " 실\n");
			
			for(Room num : list) { // 향상된 for문 사용
				
				if(num.isrState()==false) { //num은 map에서 생성된 List 번호를 불러옴 
					System.out.println(" 객실이름 :"+num.getrName()+"/ 방 번호:"+ num.getrNo()+"/ 가격:"+ num.getrPrice());
				}
			}
			int roomsel = 0; // 방 번호 고르기 변수 선언
			roomsel = sc.nextInt();
			
//			 for(int i= 0; i<list.size; i++){
//				Room num = list.get(i);
//			} ▼ 향상된 for문으로 변환
			
			for(Room num : list) {
				if(roomsel==num.getrNo()) {
					
					num.setrState(true);
					System.out.println("예약자 성함을 입력해주세요.");
					num.setCustoemr(sc.next());
					System.out.println("연락처 뒷자리를 입력해주세요[예약확인코드]");
					num.setResCode(sc.next());
				}
			}
		}	
			
		

//		예약취소 기능
		public void  roomCan(List<Room> list) {
			System.out.println(" 현재 취소 가능한 객실입니다. 취소할 호수를 입력해주세요. 객실 규모 : " + list.size() + " 실\n");
			
			for(Room num : list) { // 향상된 for문 사용
				
				if(num.isrState()==true) { //num은 map에서 생성된 List 번호를 불러옴 
					System.out.println("객실이름 :"+num.getrName()+"방 번호:"+ num.getrNo()+"가격:"+ num.getrPrice());
				}
			}
			int roomsel = 0; // 방 번호 고르기 변수 선언
			roomsel = sc.nextInt();
			
//		 for(int i= 0; i<list.size; i++){
//			Room num = list.get(i);
//		} ▼ 향상된 for문으로 변환
			
			for(Room num : list) {
				if(roomsel==num.getrNo()) {
					String roomcan = null; // 예약취소변수 선언				
					System.out.println("연락처 뒷자리를 입력해주세요[예약확인코드]");
					
					roomcan = sc.next();// 취소할 예약확인코드 입력
						if(!(num.getResCode().equals(roomsel))) {
							System.out.println("예약확인코드가 올바르지 않습니다.");							
						}else{
							num.setrState(false);
							num.setCustoemr(null);
							num.setResCode(null);
						}
					
				}
			}
			
			
		}


//		방 정보 확인
		public void  roomChck(List<Room> list) {
			System.out.println(" 현재 객실 예약 현황입니다. 객실 규모 : " + list.size() + " 실\n");
			
			for(Room num : list) { // 향상된 for문 사용
				
				if(num.isrState()==true) { //num은 map에서 생성된 List 번호를 불러옴 
					System.out.println(" ■예약■ 객실이름 :"+num.getrName()+"방 번호:"+ num.getrNo()+"가격:"+ num.getrPrice());
				}else {
					System.out.println(" ■공실■ 객실이름 :"+num.getrName()+"방 번호:"+ num.getrNo()+"가격:"+ num.getrPrice());
					
				}
			}

		}
			
		public void  nameChck(List<Room> list) {
			System.out.println(" 예약하신 객실의 정보를 불러옵니다. 예약시 입력한 코드[연락처뒷자리]를 입력해주세요.");
			
			for(Room num : list) {
				String nameChk = sc.next();
				if(!(num.getResCode().equals(nameChk))) {
					System.out.println("입력한 코드가 올바르지 않습니다.");
				}else {
					System.out.println("예약자 "+num.getCustoemr()+ " 님의 예약정보입니다 \r"
							+ num.getrName() + " 객실 : " + num.getrNo()+ " 호 입니다.");
				}
				
			}
			
		}
		
//		메뉴
		public int menu() {
						
			System.out.println(" ┌──────────────────────────────────────────┬──────────┐");
			System.out.println(" │ ┬ ┬┌─┐┌─┐┌─┐┌┬┐┌┐┌┌─┐┬  ┌─┐┌─┐           │  야좀놀자  │");
			System.out.println(" │ └┬┘├─┤┌─┘│││││││││││││  ┌─┘├─┤     ♬♩    │  숙박예약  │");
			System.out.println(" │  ┴ ┴ ┴└─┘└─┘┴ ┴┘└┘└─┘┴─┘└─┘┴ ┴           │  sys.V2  │");
			System.out.println(" ├──────────────────────────────────────────┴──────────┤");
			System.out.println(" │   1.예약     2.예약취소     3.방정보확인    0.종료합니다    │");
			System.out.println(" └─────────────────────────────────────────────────────┘");
			System.out.println(" ■■■■ 입력 = ");
			
			return sc.nextInt();
			
		}
		
//		흐름 보여주기  ㅠㅠ 아직못함
		

	

}
