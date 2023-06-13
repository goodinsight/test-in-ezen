package kr.co.dong.room;

public class Reservation {

	private int rNo;
//	private boolean rCheck;
	private String customer;
	private String revCode;
	
	
	/**
	 * @param rNo
	 * @param customer
	 * @param revCode
	 */
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(int rNo, String customer, String revCode) {
		super();
		this.rNo = rNo;
		this.customer = customer;
		this.revCode = revCode;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getRevCode() {
		return revCode;
	}

	public void setRevCode(String revCode) {
		this.revCode = revCode;
	}
	
	

}
