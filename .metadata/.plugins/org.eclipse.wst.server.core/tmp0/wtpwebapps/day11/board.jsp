<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
</head>
<body>
	<h1>�� ������</h1>
	<a href="main.jsp">���� �������� �̵��ϱ�</a>
	<hr>
	<form action="updateBoard_C.jsp" method="post">
		<table border="1">
			<tr>
				<td>�� ����</td>
				<td><input type="text" name="title" value="${data.title}"></td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td>{data.writer}</td>
			</tr>
			<tr>
				<td>�� ����</td>
				<td><input type="text" name="content" value="${data.content}"></td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td>{data.bdate}</td>
			</tr>
			<tr>
				<td>��ȸ��</td>
				<td>{data.cnt}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�� �����ϱ�"></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="deleteBoard_C.jsp?bid=${data.bid}">�� �����ϱ�</a>
</body>
</html>