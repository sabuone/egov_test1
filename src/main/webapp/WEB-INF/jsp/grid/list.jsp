<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<head>
<title>jqGrid</title>
<link href="/css/jquery-ui.min.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/css/ui.jqgrid.css" rel="stylesheet" type="text/css" media="screen" />
<script src="/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/js/grid.locale-kr.js" type="text/javascript"></script>
<script src="/js/jquery.jqGrid.min.js" type="text/javascript"></script>
</head>

<body>


<table id="jqGrid"></table>

<div id="jqGridPager"></div>

<script type="text/javascript"> 

$(document).ready(function () {
	$("#jqGrid").jqGrid({
	//	url: 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=longorders',
		url: 'http://localhost:8080/grid.json',
		mtype: "GET",
		datatype: "json",
		colModel: [
			{ label: '아이디', name: 'userId', key: true, width: 75 },
			{ label: '이름', name: 'userName', width: 150 },
		//	{ label: '패스워드', name: 'OrderDate', width: 150, formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
			{ label: '패스워드', name: 'userPassword', width: 150 },
		],
		
		viewrecords: true,
		width: 780,
		height: 350,
		rowNum: 20,
		loadonce: true,
		pager: "#jqGridPager"
	});
});

</script>

</body>