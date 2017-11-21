<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Login">
				
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				
				<div class="panel panel-default">
					<div class="panel-heading">Login</div>
				  	<div class="panel-body">
						<form:form servletRelativeAction="/login" method="POST">
							<div class="form-group">
								<label>E-mail:</label>
								<input type="text" name="username" class="form-control" />
							</div>
							<div class="form-group">
								<label>Senha:</label>
								<input type="password" name="password" class="form-control" />
							</div>
							<div class="checkbox">
								<label>
									<input type="checkbox" name="remember-me" />Lembrar?
								</label>
							</div> 
							
							<button type="submit" class="btn btn-primary btn-block">Entrar</button>
						</form:form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</page:template>



