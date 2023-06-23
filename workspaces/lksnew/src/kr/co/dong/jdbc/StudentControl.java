package kr.co.dong.jdbc;

import kr.co.dong.vendingMachine.Menu;

public class StudentControl {
	private String url = "jdbc:mysql://localhost:3306/testdb";
	private String user = "root";
	private String password = "12345";
	private StudentDbCtrl sdc = null;
	private Menu menu = new Menu();
	
	
	public void init() {
		this.sdc = new StudentDbCtrl(url, user, password);
		this.sdc.connectDb();
	}
	
	public String menuView() {
		menu.showTitle("<학생 정보 관리 시스템 ver 1.0>");
		System.out.println("1.학생조회 2.학생추가 3.학생수정 4.학생삭제 5.종료");
		String select = menu.askChoice("메뉴를 선택하세요 : ");
		return select;
	}
	
	public void studentPlay(String select) {
		// 자판기 메인 메뉴
		switch (select) {
		case "1":
			menu.showTitle("<학생조회>");
			System.out.println("1.학생전체조회 2.학생조회");
			String sel = menu.askChoice("메뉴를 선택하세요 : ");
			switch (sel) {
			case "1":
				this.sdc.allSearchStd();
				break;
			case "2":
				this.sdc.oneSearchStd();
				break;
			default:
				System.out.println("잘못 고르셨습니다.");
				break;
			}
			break;
		case "2":
			this.sdc.insertStd();
			break;
		case "3":
			this.sdc.updateStd();
			break;
		case "4":
			this.sdc.deleteStd();
			break;
		case "5":
			System.out.println("학생정보 프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("메뉴를 다시 골라주세요.");
			break;
		}
	}	
	
	public void close() {
		this.sdc.closeConnection();
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentControl [url=" + url + ", user=" + user + ", password=" + password + "]";
	}	
}
