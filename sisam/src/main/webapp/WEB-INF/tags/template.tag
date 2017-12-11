<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="titulo" required="true" %>
<%@ attribute name="extraScripts" fragment="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="icon" href="/sisam/resources/imagens/favicon.png" type="image/png">
		
		<link href="/sisam/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	    <link href="/sisam/resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	    <link href="/sisam/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="/sisam/resources/css/app/sisam.css" rel="stylesheet" type="text/css">
	
		<title>${titulo} - SISAM</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/template/hearder.jsp" %>
	
		<jsp:doBody />
	
		<%@ include file="/WEB-INF/views/template/footer.jsp" %>
				
		<script src="/sisam/resources/js/jquery-3.2.1.min.js"></script>
	    <script src="/sisam/resources/js/bootstrap.min.js"></script>
	    <script src="/sisam/resources/js/jquery.mask.min.js"></script>

		<jsp:invoke fragment="extraScripts" />

	</body>
</html>