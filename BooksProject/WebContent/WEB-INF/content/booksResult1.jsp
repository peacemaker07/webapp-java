<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>BooksResult1</title>
	</head>

	<body>
		<h2>登録確認</h2>
		<hr />
		書名 :<s:property value="title" /><br />
		著者 :<s:property value="author" /><br />
		ISBN :<s:property value="isbn" /><br />
		<hr />
		<a href="#" onClick="history.back(); return false;">もどる</a>
		<a href="<s:url action="register"/>">登録実行</a>
	</body>
</html>