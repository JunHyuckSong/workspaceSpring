<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
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
				<td colspan="2" align="right"><input type="submit" value="로그인하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>