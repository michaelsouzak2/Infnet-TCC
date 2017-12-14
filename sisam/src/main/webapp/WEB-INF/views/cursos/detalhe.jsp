<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar Cursos">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Edição de Cursos</h3>
				<form:form action="${s:mvcUrl('CC#atualizar').build()}" method="POST" commandName="curso">
					<input type="hidden" name="id" value="${curso.id}" />
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${curso.nome}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Tipo de Cursos:</label>
						<form:select path="tipoCurso.id" cssClass="form-control">
							<form:options items="${tipoCursos}" itemValue="id" itemLabel="descricao" />
						</form:select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>