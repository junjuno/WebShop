<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>계산기</h1>
	<form action="calc" method="post">
	입력1 : <input type="number" name="su1" value="${su1}">
	<!-- EL표기법 객체 프로퍼티 값을 꺼낼때 주로 사용-->
	<select name="op">
		<option ${op=="+"? "selected" : "" }>+</option>
		<option ${op=="-"? "selected" : "" }>-</option>
		<option ${op=="*"? "selected" : "" }>*</option>
		<option ${op=="/"? "selected" : "" }>/</option>
		<option></option>
	</select>
	입력2 : <input type="number" name="su2" value="${su2}">
	<button>=</button>
	<input type="number" value="${result}">
	</form>
</body>
</html>

