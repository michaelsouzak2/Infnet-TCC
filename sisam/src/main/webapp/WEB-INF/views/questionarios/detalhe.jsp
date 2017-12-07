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
					<input type="hidden" name="id" value="${questionario.id}" />
					<div id="questoes-selecionadas"></div>
						
					<div class="form-group">
						<label>Grupo de questões:</label>
						<c:forEach items="${gruposQuestoes}" var="grupo" varStatus="status">
							<div class="checkbox">
								<label>
									<c:choose>
										<c:when test="${grupo.id == questionario.gruposQuestoes[status.index].id}">
											<input type="checkbox" checked="checked" name="gruposQuestoes[${status.index}].id" value="${questionario.gruposQuestoes[status.index].id}" />${grupo.descricao}
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="gruposQuestoes[${status.index}].id" value="${gruposQuestoes[status.index].id}" />${grupo.descricao}
										</c:otherwise>
									</c:choose>
								</label><br />			
							</div>			
						</c:forEach>
					</div>
					
					<div class="form-group">
						<label for="descricao">Descrição:</label>
						<input type="text" id="descricao" class="form-control" name="descricao" value="${questionario.descricao}" />
					</div>
					
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>