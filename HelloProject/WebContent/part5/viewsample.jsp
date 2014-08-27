<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="ViewSampleSubmit">
	<s:checkboxlist label="あなたの好きなお酒は？（複数可）" name="items1"
		list="#{ '1':'日本酒', '2':'焼酎', '3':'ワイン','4':'ビール','5':'ウイスキー'}" />
	<s:checkboxlist label="どこでお酒を買うことが多いですか？（複数可）" name="items2"
		list="#{'スーパー':'スーパー', 'コンビニ':'コンビニ', 'ディスカウントストア':'ディスカウントストア',
 			'自動販売機':'自動販売機', 'その他':'その他'}" />
	<s:submit value="確認" />
</s:form>

回答：<br />

<s:append id="allItems">
	<s:param value="items1" />
	<s:param value="items2" />
</s:append>

<s:iterator value="allItems">
	<s:property /><br />
</s:iterator>

<s:if test="%{downok}">
	<a href="Download.action">ダウンロード</a>
</s:if>
</body>
</html>