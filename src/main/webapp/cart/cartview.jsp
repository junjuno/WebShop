<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<p>�α����� ����� : ${loginUser.manager_name} </p>
<%
 	Object obj = session.getAttribute("cart");
 	if(obj!=null) {
 		HashMap<String, Integer> cart = (HashMap<String, Integer>)obj;
 		for(String key: cart.keySet()){
 			out.println("<h1>"+key+" : " +cart.get(key)+"</h1>");
 		}
 	}
%>
<a href="addCart.do">��� ����</a>
</body>
</html>