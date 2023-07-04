<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>첫번째 페이지 입니다....</h1>
	<%-- <jsp:forward page="b.jsp"></jsp:forward> --%>
	<!-- 인클루드 액션 -->
	<jsp:include page="b.jsp"></jsp:include> 
<%-- 	<% //자바 코드는 별로 좋은 코드가 아님
	RequestDispatcher rd = request.getRequestDispatcher("b.jsp");
	//rd.forward(request, response);
	rd.include(request, response);  //너가 나한테 와라!
	%> --%>
</body>
</html>