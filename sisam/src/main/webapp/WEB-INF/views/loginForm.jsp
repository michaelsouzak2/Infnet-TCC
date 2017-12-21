<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>

<page:template titulo="Login">
	
	<div style="padding-top: 70px;"></div>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
			
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>Login</strong>
					</div>
					<div class="panel-body">
						<form:form servletRelativeAction="/login" method="POST">
							<div class="form-group">
								<label>E-mail:</label> <input type="text" name="username"
									class="form-control" />
							</div>
							<div class="form-group">
								<label>Senha:</label> <input type="password" name="password"
									class="form-control" />
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" name="remember-me" />Lembrar?
								</label>
							</div>

							<button type="submit" class="btn btn-primary btn-block">Entrar</button>
							<br>
						</form:form>
					</div>
				</div>
				
				<c:if test="${param.error != null}">
					<div class="alert alert-danger" role="alert">
						Falha ao fazer Login.
						<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
							<br />Motivo: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</c:if>
					</div>
				</c:if>

			</div>
		</div>
	</div>
</page:template>



