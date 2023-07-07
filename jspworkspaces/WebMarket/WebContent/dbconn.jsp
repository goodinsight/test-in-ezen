<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%> 
<%
	Connection conn = null;	

	try {
		String url = "jdbc:mysql://localhost:3306/WebMarketDB?serverTimezone=UTC";
		String user = "root";
		String password = "12345";

		// 오라클일때
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Class.forName("com.mysql.jdbc.Driver");   7.0이하
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(url, user, password);
		
	} catch (SQLException ex) {
		out.println("데이터베이스 연결이 실패되었습니다.<br>");
		out.println("SQLException: " + ex.getMessage());
	}
		
%>