<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar tópico">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>Edição de usuário</h4>
				<form:form action="${s:mvcUrl('TC#atualizar').build()}" method="POST" commandName="topico">
					<input type="hidden" name="id" value="${topico.id}" />
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="descricao" value="${topico.descricao}" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>