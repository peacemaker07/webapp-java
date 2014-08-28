<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BooksRegister</title>
</head>

<body>
<h2>登録実行</h2>
<hr />
<s:iterator value="books">
<p>
書名 : <s:property value="title" /><br />
著者 : <s:property value="author" /><br />
ISBN : <s:property value="isbn" /><br />
</p>
</s:iterator>

<s:property value="message" /><br />
</body>
</html>