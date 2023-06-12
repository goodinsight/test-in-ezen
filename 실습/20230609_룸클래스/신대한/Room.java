/*
 *  ȣ�� ���� ���α׷� �����ϱ� ver1.0
 *  - ȣ�ڹ� : ���̸�, ȣ��, ����, ����, ��������(����), �����ڸ�, �����ڵ�
 *  - �濹�� : ȣ��, �����ڸ�, �����ȣ, ������
 *  - ��� : �����ϱ�, ��������ϱ�, ȣ�ڷ� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�
 *  
 */
package kr.co.dong.room;

public class Room {

	private int roomNum;				//ȣ��
	private String roomName;			//�� �̸�
	private int roomPrice;				//�� ����
	private String roomContent;			//�� ����
	private boolean roomCheck;			//���࿩��
	
	public Room() {
		
	}
	
	public Room(int roomNum, String roomName, int roomPrice, String roomContent) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.roomContent = roomContent;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomContent() {
		return roomContent;
	}

	public void setRoomContent(String roomContent) {
		this.roomContent = roomContent;
	}

	public boolean isRoomCheck() {
		return roomCheck;
	}

	public void setRoomCheck(boolean roomCheck) {
		this.roomCheck = roomCheck;
	}


	@Override
	public String toString() {
		return "[ȣ�� : " + roomNum + ", ȣ���̸� : " + roomName + ", ȣ�ǰ��� : " + roomPrice + ", ȣ������ : "
				+ roomContent + "�������� : "+(!roomCheck?"���డ��":"����Ұ���")+"]";
	}
	
	
	
}
