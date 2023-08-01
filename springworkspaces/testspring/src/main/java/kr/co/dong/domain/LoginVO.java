package kr.co.dong.domain;

public class LoginVO {
	private String userId;
	private String name;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "LoginVO [userId=" + userId + ", name=" + name + "]";
	}
	
	
}
