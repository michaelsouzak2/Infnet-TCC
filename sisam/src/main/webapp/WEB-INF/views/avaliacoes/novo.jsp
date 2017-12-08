<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Nova questão">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<div class="page-header">
					<h3>Nova avaliação</h3>
				</div>
				
				<form:form action="${s:mvcUrl('AC#salvar').build()}" method="POST">
					<div class="form-group">
						<label for="grupoQuestoes">Grupo de questões:</label>
						<select name="grupoQuestoes.id" id="grupoQuestoes" class="form-control">
							<c:forEach items="${gruposQuestoes}" var="grupo">
								<option value="${grupo.id}">${grupo.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="pergunta">Pergunta:</label>
						<textarea rows="6" cols="10" id="pergunta" name="pergunta" class="form-control"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>

</page:template>
