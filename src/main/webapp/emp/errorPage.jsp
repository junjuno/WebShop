<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오류 정보</h1>
	<p><%=exception %></p>
	<p><%=exception.getMessage() %></p>
	<p><%exception.printStackTrace(); %></p>
</body>
</html>