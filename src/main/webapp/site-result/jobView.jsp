<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<ul>
	<c:forEach begin="1" end="5" var="index">
		<li>${jobList[index].job_id }-----${jobList[index].job_title }</li>
	</c:forEach>
</ul>