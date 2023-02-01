<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Board(새글 등록)</title>
</head>
<body>

<center>
	<h1>새 글 등록 </h1>
	<a href="logout.do">Log-Out</a>
	<form action = "insertBoard.do" method = "post">
		<table border = "1" cellspacing ="0" cellpadding="0">
			<tr>
				<td bgcolor ="orange" width = "70" align ="center">제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td bgcolor ="orange" align ="center">작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td bgcolor ="orange" align ="center">내용</td>
				<td><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan = "2" align="right"><input type="submit" value="새글등록" ></td>
			</tr>
		</table>
	</form>
	<p /><hr>
		<a href="getBoardList.do">글 목록 바로가기</a>
		<!-- getBoardList.jsp로 하면 안됨. 
		controller로 요청해야 하기 떄문에..
		목록에서 db 가져온 값을 view로 받아야함.... -->



</center>

</body>
</html>