package kr.co.dong.room;

public class Rcus {
	
	private String name;
	private int room;
	private String num;
	private boolean check;
	/**
	 * @param name
	 * @param room
	 * @param num
	 */
	public Rcus() {}
	public Rcus(String name, int room, String num) {
		super();
		this.name = name;
		this.room = room;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "Rcus [예약자 = " + name + ", 호실 = " + room + ", 예약코드 = " + num + "]";
	}

}
