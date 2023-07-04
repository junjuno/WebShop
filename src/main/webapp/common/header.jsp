<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="application"></c:set> --%>

<%
String company = "신한금융소프트아카데미";
%>

<%-- <div>세션에서 로그인한 사용자 읽기(ScriptLet): <%=session.getAttribute("loginUser") %></div> --%>


 
	<c:if test="${loginUser!=null }">
	<img  src="${path}/uploads/${loginUser.pic}" width="50" height="50" border-radius="30%"/>
	<div id="login-user-div" >${loginUser==null?"guest":loginUser.manager_name} 님, 반갑습니다.</div>
		 <button id="btnLogout" style="margin-top:3px; background-color:tomato;">로그아웃</button> 
		 
	</c:if>
	<c:if test="${loginUser==null }">
		 <button onclick="location.href='${path}/auth/loginCheck.do'">로그인</button> 
	</c:if>
<script>
$(function(){
	$("#btnLogout").on("click", function(){
		$.ajax({
			url:"${path}/auth/logout.do",
			success:function(responseData){
				alert(responseData+"로그아웃 되었습니다...");
				location.href="${path}/auth/loginCheck.do";
			},
			error:function(){
				alert(message);
				console.log(message);
			}
		});
	});
});
</script>