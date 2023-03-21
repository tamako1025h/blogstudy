<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>blog</title>
</head>
<body>
<p>ホーム画面へ</p>
<c:choose>
	<c:when test="${user == null }">
		<p>ようこそゲストさん</p>
		<a href="/blog/Blog?action=login">ログイン画面へ</a>
	</c:when>
	<c:otherwise>
		<p>ようこそ<c:out value="${user.username}" />さん</p>
		<a href="/blog/Blog?action=logout">ログアウト</a>
	</c:otherwise>
</c:choose>
</body>
</html>