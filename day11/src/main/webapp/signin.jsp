<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<a href="index.jsp">맨 처음으로</a>
	<form action="signin.do" method="post">
		<input type="hidden" name="role" value="USER">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="회원가입하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>