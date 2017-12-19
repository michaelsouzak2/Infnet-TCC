<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar questionário">
	
	<jsp:attribute name="extraScripts">
		<c:url value="/" var="contextPath" />
		<script type="text/javascript" src="${contextPath}resources/js/app/questionario.js"></script>
	</jsp:attribute>
	
	<jsp:body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h3>Editar questionário</h3>
					</div>
					
					<form:form id="form-altera-questionario" action="${s:mvcUrl('QAC#atualizar').build()}" method="POST" commandName="questionario">
						<input type="hidden" name="id" value="${questionario.id}" />
						
						<div id="grupos-atuais">
							<c:forEach items="${questionario.gruposQuestoes}" var="grupoAtual">
								<input type="hidden" value="${grupoAtual.id}" />
							</c:forEach>
						</div>
						
						<div id="grupos-selecionados"></div>
							
						<div class="form-group">
							<label>Grupo de questões:</label>
							<c:forEach items="${gruposQuestoes}" var="grupo" varStatus="status">
								<div class="checkbox">
									<label>
										<input type="checkbox" data-chk-grupo value="${grupo.id}" />${grupo.descricao}
									</label><br />			
								</div>			
							</c:forEach>
						</div>
						
						<div class="form-group">
							<label for="sigla">Sigla:</label>
							<input type="text"  id="sigla" class="form-control" name="sigla" value="${questionario.sigla}"  />
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
	</jsp:body>
		
</page:template>