<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
</head>
<body>
	<h1>�Խñ� ���</h1>
	<a href="logout_C.jsp">�α׾ƿ�</a>
	
	<form action="main.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					<select name="searchCondition">
						<option value="title">����</option>
						<option value="writer">�ۼ���</option>	
					</select>
				</td>
				<td>
					<input type="text" name="searchContent">
				</td>
				<td>
					<input type="submit" value="�˻��ϱ�">
				</td>
			</tr>
		</table>	
	</form>
	<table border="1">
		<tr>
			<th>�� ��ȣ</th>
			<th>�� ����</th>
			<th>�ۼ���</th>
			<th>�ۼ���</th>
			<th>��ȸ��</th>
		</tr>
		<a href="board.jsp?bid=${v.bid}">${v.bid}</a>
	</table>	
	<hr>
	
	<a href="insertBoard.jsp">�� �ۼ��ϱ�</a>
		
</body>
</html>




