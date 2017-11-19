<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="titulo" required="true" %>
<%@ attribute name="extraScripts" fragment="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	    <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	
		<title>${titulo} - Infnet</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/template/hearder.jsp" %>
	
		<jsp:doBody />
	
		<%@ include file="/WEB-INF/views/template/footer.jsp" %>
		
		<jsp:invoke fragment="extraScripts" />
		
		<script src="resources/js/jquery-3.2.1.min.js"></script>
	    <script src="resources/js/bootstrap.min.js"></script>
	</body>
</html>