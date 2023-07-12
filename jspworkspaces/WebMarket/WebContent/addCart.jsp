<%@page import="dto.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>

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
	
	ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cartlist");
	if (list == null) { 
		list = new ArrayList<Product>();
		session.setAttribute("cartlist", list);
	}

	int cnt = 0;
	Product goodsQnt = new Product();
	for (int i = 0; i < list.size(); i++) {
		goodsQnt = list.get(i);
		if (goodsQnt.getProductId().equals(id)) {
			cnt++;
			int orderQuantity = goodsQnt.getQuantity() + 1;
			goodsQnt.setQuantity(orderQuantity);
		}
	}
	
	if (cnt == 0) { 
		product.setQuantity(1);
		list.add(product);
	}

	response.sendRedirect("product.jsp?id=" + id);
%>