<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<security:authentication property="principal" var="usuario" />
	<c:url value="/" var="contextPath" />
	
	<security:authorize access="hasRole('ROLE_ADMINISTRADOR') or hasRole('ROLE_SECRETARIA')">
		
		<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">
				   <security:authorize access="isAuthenticated()">
				    	<a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Home</a>
				    </security:authorize>
			   </div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<security:authorize access="hasRole('ROLE_ADMINISTRADOR')">
							<li>
								<a href="${s:mvcUrl('AC#listar').build()} ">Avaliações</a>
							</li>
							<li>
								<a href="${s:mvcUrl('GQC#listar').build()} ">Grupos de questões</a>
							</li>
							<li>
								<a href="${s:mvcUrl('QC#listar').build()} ">Questões</a>
							</li>
							<li>
								<a href="${s:mvcUrl('QAC#listar').build()} ">Questionários</a>
							</li>
							<li>
								<a href="${s:mvcUrl('UC#listar').build()} ">Usuários</a>
							</li>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_SECRETARIA')">
							<li>
								<a href="${s:mvcUrl('RC#novo').build()}">Relatório</a>
							</li>
						</security:authorize>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						 <security:authorize access="isAuthenticated()">
							<li>
								<a href="${s:mvcUrl('UC#buscar').arg(0,usuario.id).build()}">${usuario.nome}</a>
							</li>
							<li>
							<form:form action="logout" method="post" class="navbar-form">
								<button type="submit" class="btn btn-link">
									<i class="fa fa-sign-out" aria-hidden="true"></i>
								</button>
							</form:form>
							</li>
						</security:authorize>
					</ul>
				</div>
			</div>
		</nav>
	
		<div style="padding-top: 70px;"></div>
	
	</security:authorize>
	
	