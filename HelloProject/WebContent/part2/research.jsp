<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>アンケート</title>
</head>
<body>
<s:form action="ResearchConfirm">
<s:textfield label="名前" name="name" />
<s:textfield label="メールアドレス" name="email" />
<s:textfield label="年齢" name="age" />
<s:radio label="どの携帯のCMが好き？" name="career" 
         list="#{'1':'ドコモ', '2':'ａｕ', '3':'ソフトバンク'}"/>
<s:submit value="確認" />
</s:form>
</body>
</body>
</html>