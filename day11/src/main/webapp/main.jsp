<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<a href="logout.do">로그아웃</a>
	
	<form action="main.do" method="post">
		<table border="1">
			<tr>
				<td>
					<select name="searchCondition">
						<c:forEach items="${conditionMap}" var="v">
							<option value="${v.value}">${v.key}</option>>
						</c:forEach>						
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
		<c:forEach items="${datas}" var="v">
			<tr>			
				<td><a href="board.do?bid=${v.bid}">${v.bid}</a></td>
				<td>${v.title}</td>
				<td>${v.writer}</td>
				<td>${v.bdate}</td>
				<td>${v.cnt}</td>
			</tr>
		</c:forEach>
	</table>	
	<hr>
	
	<a href="insertBoard.jsp">글 작성하기</a>
	<a href="mypage.do">마이페이지</a>	
</body>
</html>





