<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Novo Tipo de Curso">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
				<div class="page-header">
					<h3>Novo Tipo de Curso </h3>
				</div>
			
				<form:form action="${s:mvcUrl('TCC#gravar').build()}" method="POST">
					<div class="form-group">
						<label for="descricao">Descrição:</label>
						<input type="text" id="descricao" name="descricao" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>

</page:template>
