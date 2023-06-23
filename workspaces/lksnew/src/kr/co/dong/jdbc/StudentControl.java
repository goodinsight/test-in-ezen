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
		menu.showTitle("<�л� ���� ���� �ý��� ver 1.0>");
		System.out.println("1.�л���ȸ 2.�л��߰� 3.�л����� 4.�л����� 5.����");
		String select = menu.askChoice("�޴��� �����ϼ��� : ");
		return select;
	}
	
	public void studentPlay(String select) {
		// ���Ǳ� ���� �޴�
		switch (select) {
		case "1":
			menu.showTitle("<�л���ȸ>");
			System.out.println("1.�л���ü��ȸ 2.�л���ȸ");
			String sel = menu.askChoice("�޴��� �����ϼ��� : ");
			switch (sel) {
			case "1":
				this.sdc.allSearchStd();
				break;
			case "2":
				this.sdc.oneSearchStd();
				break;
			default:
				System.out.println("�߸� ���̽��ϴ�.");
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
			System.out.println("�л����� ���α׷��� �����մϴ�.");
			System.exit(0);
			break;
		default:
			System.out.println("�޴��� �ٽ� ����ּ���.");
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
