<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<head>
<title>회원 목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/common.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">

function fn_add() {
	location.href = "<c:url value='/MemberAdd.do'/>";
}

function fn_edit(num) {
	location.href = "<c:url value='/MemberEdit.do?num="+num+"'/>";
}

function fn_remove(num) {
	document.listForm.action = "<c:url value='/MemberRemove.do?num="+num+"'/>";
	document.listForm.submit();
}

function fn_list() {
	document.listForm.action = "<c:url value='/MemberList.do'/>";
	document.listForm.submit();
}

function fn_page(page) {
	document.listForm.pageIndex.value = page;
	document.listForm.action = "<c:url value='/MemberList.do'/>";
	document.listForm.submit();
}
</script>
</head>

<body>

<form:form commandName="searchVO" id="listForm" name="listForm" method="post">
	<form:hidden path="pageIndex" />
	
	<table align="center" border="1" cellpadding="10" cellspacing="0" style="margin-top:100px;">
		<tr>
			<td style="border-right:none;"><input type="button" value="추가" onclick="fn_add();" /></td>
			<td colspan="3" align="right" style="border-left:none;">
				<form:select path="searchCondition">
					<form:option value="0" label="아이디" />
					<form:option value="1" label="이름" />
				</form:select>
				<form:input path="searchKeyword" size="10" />
				<a href="javascript:fn_list();">검색</a>
			</td>
		</tr>
		<tr>
			<th>번호</th><th>아이디</th><th>이름</th><th>관리</th>
		</tr>
	
		<c:forEach var="result" items="${resultList}" varStatus="status">
		<tr>
			<td align="center"><c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}" /></td>
			<td><a href="javascript:fn_edit(${result.num});"><c:out value="${result.userId}" /></a></td>
			<td><c:out value="${result.userName}" /></td>
			<td align="center">
				<input type="button" value="삭제" onclick="fn_remove(${result.num});" />
			</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="4" align="center">
				<ui:pagination paginationInfo="${paginationInfo}" type="text" jsFunction="fn_page" />
			</td>
		</tr>
	</table>
</form:form>

</body>