<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 게시글 작성</title>
</head>
<body>
	<form action="insert.do" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle" value=""></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boardWriter" value=""></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="boardContent" value=""></td>
			</tr>
		</table>
		<input type="submit" value="게시글 등록">
	</form>
</body>
</html>