/*
 * [상품관리]
 * - 상품번호(기본키역할), 상품명, 상품설명, 수량, 비고
 * 
 * testdb.goods 테이블 생성
 * 
 * 
 */
package kr.co.dong.good;

public class GoodsBean {
	private int gid;
	private String gname;
	private String gcontent;
	private int gcnt;
	private String getc;
	/**
	 * 
	 */
	public GoodsBean() {
	}
	/**
	 * @param gname
	 * @param gcontent
	 */
	public GoodsBean(String gname, String gcontent) {
		this.gname = gname;
		this.gcontent = gcontent;
	}
	
	
	/**
	 * @param gname
	 * @param gcontent
	 * @param gcnt
	 * @param getc
	 */
	public GoodsBean(String gname, String gcontent, int gcnt, String getc) {
		this.gname = gname;
		this.gcontent = gcontent;
		this.gcnt = gcnt;
		this.getc = getc;
	}
	/**
	 * @param gid
	 * @param gname
	 * @param gcontent
	 * @param gcnt
	 * @param getc
	 */
	public GoodsBean(int gid, String gname, String gcontent, int gcnt, String getc) {
		this.gid = gid;
		this.gname = gname;
		this.gcontent = gcontent;
		this.gcnt = gcnt;
		this.getc = getc;
	}
	/**
	 * @return the gid
	 */
	public int getGid() {
		return gid;
	}
	/**
	 * @param gid the gid to set
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}
	/**
	 * @return the gname
	 */
	public String getGname() {
		return gname;
	}
	/**
	 * @param gname the gname to set
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}
	/**
	 * @return the gcontent
	 */
	public String getGcontent() {
		return gcontent;
	}
	/**
	 * @param gcontent the gcontent to set
	 */
	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}
	/**
	 * @return the gcnt
	 */
	public int getGcnt() {
		return gcnt;
	}
	/**
	 * @param gcnt the gcnt to set
	 */
	public void setGcnt(int gcnt) {
		this.gcnt = gcnt;
	}
	
	/**
	 * @return the getc
	 */
	
	public String getGetc() {
		return getc;
	}
	/**
	 * @param getc the getc to set
	 */
	public void setGetc(String getc) {
		this.getc = getc;
	}
	@Override
	public String toString() {
		return "GoodsBean [gid=" + gid + ", gname=" + gname + ", gcontent=" + gcontent + ", gcnt=" + gcnt + ", getc="
				+ getc + "]";
	}
	
}
