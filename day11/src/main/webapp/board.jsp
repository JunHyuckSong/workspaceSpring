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
	<a href="main.do">���� �������� �̵��ϱ�</a>
	<hr>
	<img alt="���Ͼ��ε�" src="${data.filepath}">
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="bid" value="${data.bid}">
		<table border="1">
			<tr>
				<td>�� ����</td>
				<td><input type="text" name="title" value="${data.title}"></td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td>${data.writer}</td>
			</tr>
			<tr>
				<td>�� ����</td>
				<td><input type="text" name="content" value="${data.content}"></td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td>${data.bdate}</td>
			</tr>
			<tr>
				<td>��ȸ��</td>
				<td>${data.cnt}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�� �����ϱ�"></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="deleteBoard.do?bid=${data.bid}">�� �����ϱ�</a>
</body>
</html>