/*
 * ȣ�� ���� ���α׷� �����ϱ� Ver1.0
0 * 
 * - ȣ�ڹ� : ȣ��, ���̸�, ����, ����(����?)
 * - �濹�� : ȣ��, ���࿩��, �����ڸ�, �����ڵ�
 * 
 * - ��� : �����ϱ�, ��������ϱ�, ȣ�ڷ� ���� Ȯ��, �޴� �����ֱ�(���� ǥ��), �帧 �����ֱ�(�Է� �ȳ�)
 * 
 * 
 * - Administrator
 * - Customer
 * - Product
 * 
 */

package kr.co.dong.room;

import java.util.Scanner;

public class Room {

//	static int cnt;
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean rCheck;
	
//	----------------------- ���� �и�
	
//	private String customer;
//	private String revCode;
	

	public Room() {
		Scanner scan = new Scanner(System.in);

		
		System.out.print("\n�� ��ȣ : ");
		this.setrNo(scan.nextInt());
		System.out.print("\n�̸� : ");
		this.setrName(scan.next());
		System.out.print("\n���� : ");
		this.setrPrice(scan.nextInt());
		System.out.print("\n���� : ");
		this.setrContent(scan.nextLine());
		
		scan.close();
	}

	
	/**
	 * @param rNo
	 * @param rName
	 * @param rPrice
	 * @param rContent
	 */
	public Room(int rNo, String rName, int rPrice, String rContent) {
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public int getrPrice() {
		return rPrice;
	}

	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	
	

	public boolean isrCheck() {
		return rCheck;
	}

	public void setrCheck(boolean rCheck) {
		this.rCheck = rCheck;
	}


	@Override
	public String toString() {
		return "[���� ��ȣ=" + rNo + ", ���� �̸�=" + rName + ", ����=" + rPrice + ", ��Ÿ=" + rContent + "]";
	}
	
	
	
	
	
	
	
	
	
}
