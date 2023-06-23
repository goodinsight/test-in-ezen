package kr.co.dong.jdbc;

public class StudentTest {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "root";
		String password = "12345";
		StudentDbCtrl sdc = new StudentDbCtrl(url, user, password);
		sdc.connectDb();
		sdc.allSearchStd();
	}
}
