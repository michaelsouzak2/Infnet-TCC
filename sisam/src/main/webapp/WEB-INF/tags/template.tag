<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="titulo" required="true" %>
<%@ attribute name="extraScripts" fragment="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<c:url value="/" var="contextPath" />
				
		<link rel="icon" href="${contextPath}resources/images/favicon.png" type="image/png">
		
		<link href="${contextPath}resources/css/jquery-ui.min.css" rel="stylesheet" type="text/css">
		<link href="${contextPath}resources/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css">
		<link href="${contextPath}resources/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css">
		
		<link href="${contextPath}resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	    <link href="${contextPath}resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	    <link href="${contextPath}resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="${contextPath}resources/css/app/sisam.css" rel="stylesheet" type="text/css">
	
		<title>${titulo} - SISAM</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/template/hearder.jsp" %>
	
		<jsp:doBody />
	
		<%@ include file="/WEB-INF/views/template/footer.jsp" %>
				
		<script src="${contextPath}resources/js/jquery-3.2.1.min.js"></script>
	    <script src="${contextPath}resources/js/bootstrap.min.js"></script>
		<script src="${contextPath}resources/js/jquery-ui.min.js"></script>
		<script src="${contextPath}resources/js/datepicker-pt-BR.js"></script>
	    <script src="${contextPath}resources/js/jquery.mask.min.js"></script>

		<jsp:invoke fragment="extraScripts" />

	</body>
</html>