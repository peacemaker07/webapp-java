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
	<s:checkboxlist label="���Ȃ��̍D���Ȃ����́H�i�����j" name="items1"
		list="#{ '1':'���{��', '2':'�Ē�', '3':'���C��','4':'�r�[��','5':'�E�C�X�L�['}" />
	<s:checkboxlist label="�ǂ��ł����𔃂����Ƃ������ł����H�i�����j" name="items2"
		list="#{'�X�[�p�[':'�X�[�p�[', '�R���r�j':'�R���r�j', '�f�B�X�J�E���g�X�g�A':'�f�B�X�J�E���g�X�g�A',
 			'�����̔��@':'�����̔��@', '���̑�':'���̑�'}" />
	<s:submit value="�m�F" />
</s:form>

�񓚁F<br />

<s:append id="allItems">
	<s:param value="items1" />
	<s:param value="items2" />
</s:append>

<s:iterator value="allItems">
	<s:property /><br />
</s:iterator>

<s:if test="%{downok}">
	<a href="Download.action">�_�E�����[�h</a>
</s:if>
</body>
</html>