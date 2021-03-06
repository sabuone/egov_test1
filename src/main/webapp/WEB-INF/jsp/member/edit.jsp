<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<head>
<title>회원 수정</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/common.css'/>"/>
<script type="text/javascript" src="<c:url value='/validator.do'/>"></script>
<validator:javascript formName="memberVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript">
function fn_edit() {
	var form = document.editForm;

	if (!validateMemberVO(form)){
		return;
	} else {
		form.action = "<c:url value='/MemberEdit.do'/>";
		form.submit();
	}
}
</script>
</head>

<body>

<form:form commandName="memberVO" id="editForm" name="editForm" method="post">
	<form:hidden path="num" />
	
	<table align="center" border="1" cellpadding="10" cellspacing="0" style="margin-top:100px;">
		<tr>
			<th>아이디</th><td><form:input path="userId" /></td>
		</tr>
		<tr>
			<th>패스워드</th><td><form:input path="userPassword" /></td>
		</tr>
		<tr>
			<th>이름</th><td><form:input path="userName" /></td>
		</tr>
		<tr>
			<th colspan="2"><input type="button" value="수정" onclick="fn_edit();" /></th>
		</tr>
		<tr>
			<th colspan="2">
				<form:errors path="userId" /><br/>
				<form:errors path="userPassword" /><br/>
				<form:errors path="userName" />
			</th>
		</tr>
	</table>
</form:form>

</body>