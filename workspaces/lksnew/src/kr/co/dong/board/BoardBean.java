package kr.co.dong.board;

import java.time.LocalDateTime;

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;

public class BoardBean {
	private int aid;	//�� ��ȣ
	private String title;	//�� ����
	private String content;	//�� ����
	private LocalDateTime createdAt;	//�� �ۼ���
	private String createdBy;	//�� �ۼ���
	private LocalDateTime modifiedAt;	//�� ������
	private String modifiedBy;	//�� ������
	/**
	 * @param aid
	 * @param title
	 * @param content
	 * @param createdAt
	 * @param createdBy
	 */
	public BoardBean(int aid, String title, String content, LocalDateTime createdAt, String createdBy) {
		super();
		this.aid = aid;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}
	public BoardBean(String title, String content, LocalDateTime createdAt, String createdBy) {
		super();
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}
	
	public BoardBean(String title, String content, String createdBy) {
		LocalDateTime createdAt = LocalDateTime.now();
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "BoardBean [aid=" + aid + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
				+ ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy + "]";
	}
	
	
}
