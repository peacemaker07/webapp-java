<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>�A���P�[�g</title>
</head>
<body>
<s:form action="ResearchConfirm">
<s:textfield label="���O" name="name" />
<s:textfield label="���[���A�h���X" name="email" />
<s:textfield label="�N��" name="age" />
<s:radio label="�ǂ̌g�т�CM���D���H" name="career" 
         list="#{'1':'�h�R��', '2':'����', '3':'�\�t�g�o���N'}"/>
<s:submit value="�m�F" />
</s:form>
</body>
</body>
</html>