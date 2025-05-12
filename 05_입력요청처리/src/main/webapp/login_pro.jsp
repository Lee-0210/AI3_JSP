<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		
		if(id.equals("aloha") && pw.equals("123456")) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp?error=true");
		}
	%>
