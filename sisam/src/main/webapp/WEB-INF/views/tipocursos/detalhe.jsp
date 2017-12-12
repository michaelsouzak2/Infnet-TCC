<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar Tipo de Cursos">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Edição de Tipo de Cursos</h3>
				<form:form action="${s:mvcUrl('TCC#atualizar').build()}" method="POST" commandName="tipoCurso">
					<input type="hidden" name="id" value="${tipoCurso.id}" />
					<div class="form-group">
						<label for="descricao">Descrição:</label>
						<input type="text" id="descricao" name="descricao" value="${tipoCurso.descricao}" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>