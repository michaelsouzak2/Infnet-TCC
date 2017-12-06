<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar Grupo de questões">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h3>Edição de Grupo de questões</h3>
				</div>
				<form:form action="${s:mvcUrl('GQC#atualizar').build()}" method="POST" commandName="grupoQuestoes">
					<input type="hidden" name="id" value="${grupoQuestoes.id}" />
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="descricao" value="${grupoQuestoes.descricao}" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>