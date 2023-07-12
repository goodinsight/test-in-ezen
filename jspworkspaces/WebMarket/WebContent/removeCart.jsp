<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Product"%>
	<%@ include file="dbconn.jsp" %>
<%
	String id = request.getParameter("id");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("products.jsp");
		return;
	}

	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		
		String sql = "Select * from product ";
			   sql += "where p_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(6),
					rs.getString(5), rs.getLong(7), rs.getString(8), rs.getString(9));
		}
		
		
		if (product == null) {
			response.sendRedirect("exceptionNoProductId.jsp");
		}

	ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartlist");
	Product goodsQnt = new Product();
	for (int i = 0; i < cartList.size(); i++) { // 상품리스트 하나씩 출력하기
		goodsQnt = cartList.get(i);
		if (goodsQnt.getProductId().equals(id)) {
			cartList.remove(goodsQnt);
		}
	}

	response.sendRedirect("cart.jsp");
%>
