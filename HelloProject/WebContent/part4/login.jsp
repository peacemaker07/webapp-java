<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>���O�C��</title>
</head>
<body>
<s:form action="Login" >
<s:textfield label="���[�U�[ID" name="userid" />
<s:password label="�p�X���[�h" name="password" />
<s:submit value="���O�C��" />
</s:form>
</body>
</html>