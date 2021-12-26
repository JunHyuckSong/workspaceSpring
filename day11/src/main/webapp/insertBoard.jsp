<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>글 작성 페이지</h1>
	<a href="main.do">메인 페이지로 이동하기</a>
	<hr>
	<form action="insertBoard.do" method="post">
		<table border="1">
			<tr>
				<td>글 제목</td>
				<td><input type="text" name="title" ></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><input type="text" name="content"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="글 등록하기"></td>
			</tr>
		</table>
	</form>
	<hr>
	
</body>
</html>