<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<p>ログイン</p>
	<form action="/blog/LoginServlet" method="post">
		<c:if test="${errorlogin != null}">
			<c:out value="${errorlogin}"></c:out>
		</c:if>
		<label for="userId">ユーザーID</label> 
			<input type="text" placeholder="YamadaTaro" name="userId">
		<label for="password">パスワード</label>
			<input type="password" placeholder="password" name="password">
		<input type="submit" value="ログイン">
	</form>
</body>
</html>