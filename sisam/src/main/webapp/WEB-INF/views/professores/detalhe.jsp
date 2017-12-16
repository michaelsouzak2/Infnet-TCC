<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar professor">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Edição de professor</h3>
				<form:form action="${s:mvcUrl('PC#atualizar').build()}" method="POST" commandName="professor">
					<input type="hidden" name="id" value="${professor.id}" />
					<div class="form-group">
						<label for="email">Matricula:</label>
						<input type="text" id="matricula" name="matricula" value="${professor.matricula}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${professor.nome}" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>