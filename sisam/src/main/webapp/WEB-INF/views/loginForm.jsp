<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Login">
	<div class="container">
				
		<h1>Login</h1>
		<form:form servletRelativeAction="/login" method="POST">
			<div class="form-group">
				<label>E-mail:</label>
				<input type="text" name="username" class="form-control" />
			</div>
			<div class="form-group">
				<label>Senha:</label>
				<input type="password" name="password" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Logar</button>
		</form:form>

	</div>
</page:template>



