<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar questionário">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h3>Editar questionário</h3>
				</div>
				
				<form:form action="${s:mvcUrl('QAC#atualizar').build()}" method="POST" commandName="questionario">
					<input type="hidden" name="questionario.id" value="${questionario.id}" />
					<div id="questoes-selecionadas"></div>
						
					<div class="form-group">
						<c:forEach items="${gruposQuestoes}" var="grupo" varStatus="status">
							<c:choose>
								<c:when test="${grupo.id == questionario.gruposQuestoes[status.index].id}">
									<input type="checkbox" checked="checked" name="questionario.gruposQuestoes[${status.index}].id" value="${questionario.gruposQuestoes[status.index].id}" />
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="questionario.gruposQuestoes[${status.index}].id" value="${questionario.gruposQuestoes[status.index].id}" />
								</c:otherwise>
							</c:choose>							
							${grupo.descricao}							
						</c:forEach>
					</div>
					
					<div class="form-group">
						<label for="descricao">Descrição:</label>
						<input type="text" name="descricao" id="descricao" class="form-control" />
					</div>
					
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>