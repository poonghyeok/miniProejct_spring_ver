<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
req.num = ${requestScope.num}
	<h3> 글이 삭제되었습니다. </h3>
	<a href="http://localhost:8080/miniPJ/board/boardList.do?pg=${requestScope.previousPage}">글목록</a>

</body>
</html>