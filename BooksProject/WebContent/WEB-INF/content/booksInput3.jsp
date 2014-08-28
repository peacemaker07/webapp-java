<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BooksInput3</title>
</head>

<body>
<h2>本の登録</h2>
<hr />
<s:form action="booksDB" >
<s:textfield name="title" label="書名" />
<s:textfield name="author" label="著者" />
<s:textfield name="isbn" label="ISBN" />
<s:submit />
</s:form>

</body>
</html>