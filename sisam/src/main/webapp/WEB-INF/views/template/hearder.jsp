<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<security:authentication property="principal" var="usuario" />
								
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
							<a href="${s:mvcUrl('UC#listar').build()} ">Usuários</a>
						</li>
						<li>
							<a href="${s:mvcUrl('TC#listar').build()} ">Tópicos</a>
						</li>
						<li>
							<a href="${s:mvcUrl('QC#listar').build()} ">Questões</a>
						</li>
						<li>
							<a href="${s:mvcUrl('QAC#listar').build()} ">Questonários</a>
						</li>
					</security:authorize>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					 <security:authorize access="isAuthenticated()">
						<li>
							<a href="#">${usuario.nome}</a>
						</li>
						<li>
						<form:form action="/sisam/logout" method="post" class="navbar-form">
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