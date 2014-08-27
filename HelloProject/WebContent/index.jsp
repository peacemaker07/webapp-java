<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello!Project</title>
</head>
<body>
<a href="Hello.action">こんにちは</a><br />
<a href="Research.action">アンケート</a><br />
<a href="ResearchPart3.action"> アンケート 2</a><br />
<a href="ViewSample.action"> アンケート 3</a><br />
<br />
<s:property value="replyMsg"/>
</body>
</html>
