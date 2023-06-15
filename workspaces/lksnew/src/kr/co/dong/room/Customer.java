package kr.co.dong.room;

public class Customer {
	// 회원가입을 해서 id pw 생성하고, 기본 이름 민증번호를 넣고 객체생성
	private String id;
	private String password;
	private String name;
	private String code;
	
//	private int headCount; // 인원수에 따른 방 예약 가능 구분이 필요할때
//	private int money; // 추후 예약시 필요
//	private String membership; // 예약 건수 누적시 멤버십 상향
	
	Customer(){
		
	}
	
	Customer(String id, String password, String name, String code){
		this.id = id;
		this.password = password;
		this.name = name;
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer Infor"+this.getId() + this.getPassword();
	}
	
	
	
	
	
//	void makeReserv() {
//		// 방을 예약하는 메소드
//	}
//	
//	void cancelReserv() {
//		// 방을 취소하는 메소드
//	}
}
