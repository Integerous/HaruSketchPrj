<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/> 
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta 
    name="viewport"     
   	content="width=device-width, 
             initial-scale=1, minimum-scale=1, user-scalable=1"/>
<title>Insert title here</title>

<link href="${ctx}/resources/css/style.css" type="text/css" rel="stylesheet">


</head>

<body>
<!-- <div class="grid"> -->
	<!-- header -->
		<tiles:insertAttribute name="header"/>
	<!-- aside -->
		<tiles:insertAttribute name="aside"/>
	<!-- main -->
		<tiles:insertAttribute name="main"/>
	<!-- footer -->
		<tiles:insertAttribute name="footer"/>
	
	
<!-- </div> -->
</body>
</html>