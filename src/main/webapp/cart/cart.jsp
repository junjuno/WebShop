<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/kopubbatang.css);
	h2{
		font-family: 'KoPub Batang', serif;
	}
	#count{
		width: 30px;
		margin : 5px;
	}
	
	#btn{
		background-color: lightyellow;
		border-radius: 10px;
		padding: 5px;
	}
	
	#btn:hover{
		background-color: lightgray !important; 
	}
	
</style>
</head>
<body>
	<h2>장바구니 담기</h2>
	<p>로그인한 사용자 : ${loginUser.manager_name} </p>
	<form action="addCart.do" method="post">

		<div class="form-check">
 			<input class="form-check-input" type="radio" name="product" id="product1" value="kimbab">
  				<label class="form-check-label" for="product1">
    				김밥
  				</label>
		</div>
		<div class="form-check">
  			<input class="form-check-input" type="radio" name="product" value="hambuger" id="product2">
  				<label class="form-check-label" for="product2">
   					햄버거
  				</label>
		</div>
		<div class="form-check">
  			<input class="form-check-input" type="radio"  name="product" value="coke" id="product3">
  				<label class="form-check-label" for="product3">
   					콜라
  				</label>
		</div>
		
		<input type="number" name="count" value="1" id="count"><br>
		<hr style="color:gray"; border-style="2px dotted">
		<input type="submit" value="장바구니 담기" id="btn">
		<input type="button" value="장바구니 보기" onClick="location.href='cartview.do'" id="btn">
		<input type="button" value="장바구니 비우기" onClick="location.href='cartremove.do'" id="btn">

	</form>
</body>
</html>