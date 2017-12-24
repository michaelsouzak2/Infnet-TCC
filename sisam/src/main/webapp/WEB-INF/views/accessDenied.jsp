<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<c:url value="/" var="contextPath" />
				
		<link rel="icon" href="${contextPath}resources/images/favicon.png" type="image/png">
		
		<link href="${contextPath}resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	    <link href="${contextPath}resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	    <link href="${contextPath}resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="${contextPath}resources/css/app/sisam.css" rel="stylesheet" type="text/css">
	
		<title>ACESSO NEGADO</title>
	</head>
	<body>
		
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="access-denied">
						<h3>Acesso negado!</h3><br />
						<i class="fa fa-ban fa-5x" aria-hidden="true"></i>
						${message}
					</div>
				</div>
			</div>
		</div>
				
		<script src="${contextPath}resources/js/jquery-3.2.1.min.js"></script>
	    <script src="${contextPath}resources/js/bootstrap.min.js"></script>
	</body>
</html>