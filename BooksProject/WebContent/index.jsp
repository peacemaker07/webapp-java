<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BooksProject!</title>
</head>

<body>
<a href="<s:url action="booksInput1"/>">BooksSample1</a><br />
<a href="<s:url action="booksInput2"/>">BooksSample2（ScopedModelDriven）</a><br />
<a href="<s:url action="booksInput3"/>">BooksSample3（DB）</a><br />
</body>
</html>