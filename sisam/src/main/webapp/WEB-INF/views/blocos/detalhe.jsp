<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar Blocos">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Edição de Blocos</h3>
				<form:form action="${s:mvcUrl('BC#atualizar').build()}" method="POST" commandName="bloco">
					<input type="hidden" name="id" value="${bloco.id}" />
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${bloco.nome}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Cursos:</label>
						<form:select path="curso.id" cssClass="form-control">
							<form:options items="${cursos}" itemValue="id" itemLabel="nome" />
						</form:select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>