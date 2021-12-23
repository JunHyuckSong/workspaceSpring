<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인페이지</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<a href="logout_C.jsp">로그아웃</a>
	
	<form action="main.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					<select name="searchCondition">
						<option value="title">제목</option>
						<option value="writer">작성자</option>	
					</select>
				</td>
				<td>
					<input type="text" name="searchContent">
				</td>
				<td>
					<input type="submit" value="검색하기">
				</td>
			</tr>
		</table>	
	</form>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<a href="board.jsp?bid=${v.bid}">${v.bid}</a>
	</table>	
	<hr>
	
	<a href="insertBoard.jsp">글 작성하기</a>
		
</body>
</html>





