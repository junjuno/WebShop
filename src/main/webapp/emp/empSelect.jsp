
<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<%-- <jsp:include page="${path}/common/commonfiles.jsp"></jsp:include> --%>
<%@ include file="../common/commonfiles.jsp" %>

<style>
@import url(//fonts.googleapis.com/earlyaccess/kopubbatang.css);
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
	body {
		width: 80%;
		margin : 0px auto;
	}
	h1{
		font-family: 'KoPub Batang', serif;
		text-align: center;
	}
	table {
		margin-left : auto;
		margin-right: auto;
		text-align : center;
	}
	
	
	th {
		font-family: monospace;
		font:bold;
		background-color: lightblue;
		color: white;
		border-radius: 15px;
		padding: 15px;
		
	}
	
	tbody tr, td{
		border-bottom: 1px solid gray;
		padding : 3px;
		font-family: 'Jeju Gothic', sans-serif;
	}
	tr:hover{
		background-color: lightgray !important; 
	}
	td .index {
		background-color: rgb(210, 210, 210);
	}
	button {
		padding: 10px;
		font : bold;
		margin-bottom: 10px;
		border-radius: 10px;
	}
</style>
<script>
	$(function(){
		$(".btnDel").on("click", function(){
			location.href="empDelete.do?empid="+$(this).attr("data-del");
		});
	});

	


	$(function(){
		$("thead tr th").click(function(e){
			var trNum = $(this).closest("th").prevAll().length;
			console.log(trNum);
			var a = $("tbody tr").each(function(index, item){
			var col = $(item).find("td:nth-child(" + (trNum+1) + ")");
			console.log(col);
			//되돌리기(기존선택을 clear)
			$(item).find("td").css("background-color", "white");
			//신규선택의 색깔 바꾸기
			$(col).css("background-color", "lightgray");
			});
		});
		
		//body > table > tbody > tr:nth-child(1) > td:nth-child(2)
		//body > table > tbody > tr:nth-child(17) > td:nth-child(2)
		
		$("button[id='btn1']").css("backgroundColor","lightyellow");
		$("button[id='btn2']").css("backgroundColor","lightgreen");
		$("button[id='btn3']").css("backgroundColor","#fff0f5");
		
		//body > table > tbody > tr:nth-child(2) > td:nth-child(2)
		//body > table > tbody > tr:nth-child(4) > td:nth-child(2)
		$('#btn1').click(function(){
			$("tbody>tr:nth-child(2n)").css("backgroundColor", "lightyellow");
		});
		$('#btn2').click(function(){
			var r = $("tr>td:nth-child(2):contains('S')");
			$(r).parent().css("backgroundColor", "lightgreen");
		});
		$('#btn3').click(function(){
			var r = $("tr>td:nth-child(2):");
			
			$(r).parent().css("backgroundColor", "#fff0f5");
			
			console.log(r);
			
		
		});
		
		
		var str = "";
		var arr=["IT_PROG", "AD_VP", "AD_PRES","ST_MAN","ST_CLERK"];
		$.each(arr, function(index, item){
			str += "<option>" + item + "</option>";
		});
		$("#jobs").html(str);  //html() : jquery 함수, innerHTML은 
		
		
		$("select").change(function(){
			var jobid = $(this).val();
			//init();
			$("tr td").css("color","black");
			$("tr td:contains('" + jobid + "')").css("color", "red");
			});
		//});
	});
</script>
</head>
<body>

	<h1>직원목록</h1>
	
	<!-- include 디렉티브는 소스를 합쳐서 컴파일한다. -->
	<%--include지시자: 합쳐서 컴파일 <%@ include file="../common/header.jsp" %> --%>
	<!--include action tag이용 : 컴파일하고 합침  -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	 <form method="post"  action="${path}/downloadTest/result.jsp" >
	 	<input type=hidden  name="param1" value="pf.jpg"/>
	 	<input type=hidden  name="param2" value="umbrella.jpg" />
   		<input type ="submit" value="이미지 다운로드" style="border-radius: 10px;padding: 12px 12px;">	 
 	</form>
 	
	<%-- <p style="color : blue"><%=company %></p> --%>
	<!-- <input type="button" id="btnLogout" value="로그아웃"> -->
	<button onclick = "location.href='${path}/emp/empinsert.do'"
	type="button" class="btn btn-success" style="margin-top:10px">신규직원등록</button>
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" 
	data-bs-target="#exampleModal" data-bs-whatever="@mdo">Modal이용 직원등록</button>
	<%@ include file="empInsertModal2.jsp"%>
	
	<br><hr>
	<button id="btn1" class="btn btn-success">짝수row 선택</button>
	<button id="btn2" class="btn btn-success">이름 s로 시작하는 직원</button>
	<button id="btn3" class="btn btn-success">s문자 포함</button>
	
	
	<select>
		<option value="IT_PROG">IT_PROG</option>
		<option>AD_VP</option>
		<option>PU_CLERK</option>
		<option>ST_MAN</option>
	</select>
	<select id="jobs">
		
	</select>
	
	<table>
	<thead>
	<tr>
	<th>순서</th>
	<th>직원번호</th>
	<th>이름</th>
	<th>성</th>
	<th>이메일</th>
	<th>급여</th>
	<th>누적급여</th>
	<th>입사일</th>
	<th>전화번호</th>
	<th>직책</th>
	<th>매니저</th>
	<th>커미션</th>
	<th>부서</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<!-- for(EmpVO emp:empAll) -->
	<c:set var="totalSalary" value="0"/>
	<c:forEach items="${empAll }" var="emp" varStatus="status">
	<c:set var="totalSalary" value="${totalSalary+emp.salary}"/>
	<tr>
	<td style="background-color: ${status.first||status.last?'lightyellow':'white'};">${status.count}</td>
	<td class="index"><a href="empDetail.do?empid=${emp.employee_id }">${emp.employee_id }</a></td>
	<td ><a style="color:${fn:length(emp.first_name)>3?'red':'blue'}" href="empDetail.do?empid=${emp.employee_id }">${emp.first_name }</a></td>
	<td>${emp.last_name }</td>
	<td>${emp.email }---
		${fn:substring(emp.email,0,fn:indexOf(emp.email,"@"))}	
	</td>
	<td>
		<fmt:formatNumber value="${emp.salary}" groupingUsed="true"/></td>
	<td>${totalSalary}</td>
	<td>
		<fmt:formatDate value="${emp.hire_date }"  pattern="yyyy/MM/dd"/></td>
	<td>${emp.phone_number}</td>
	<td>${emp.job_id}</td>
	<td>${emp.manager_id }</td>
	<td>
		<fmt:formatNumber value="${emp.commission_pct}" type="percent" /></td>
	<td>${emp.department_id}</td>
	<td><button class="btnDel" data-del="${emp.employee_id }">삭제</button></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>

</body>
</html>