<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar Modulos">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Edição de Modulos</h3>
				<form:form action="${s:mvcUrl('MC#atualizar').build()}" method="POST" commandName="modulo">
					<input type="hidden" name="id" value="${modulo.id}" />
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${modulo.nome}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Blocos:</label>
						<form:select path="bloco.id" cssClass="form-control">
							<form:options items="${blocos}" itemValue="id" itemLabel="nome" />
						</form:select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>