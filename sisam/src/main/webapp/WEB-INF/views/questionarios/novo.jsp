<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Novo questionário">
	
	<jsp:attribute name="extraScripts">
		<c:url value="/" var="contextPath" />
		<script type="text/javascript" src="${contextPath}resources/js/app/questionario.js"></script>
	</jsp:attribute>
	
	<jsp:body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h3>Novo Questionário</h3>
					</div>
				
					<form:form id="form-novo-questionario" action="${s:mvcUrl('QAC#salvar').build()}" method="POST">

						<div id="grupos-selecionados"></div>
						
						<div class="form-group">
							<label for="grupoQuestoes">Grupo de questões:</label>
							<div class="checkbox">
								<c:forEach items="${gruposQuestoes}" var="grupo" varStatus="status">
									<label>
										<input type="checkbox" data-chk-grupo value="${grupo.id}" />${grupo.descricao}
									</label><br />
								</c:forEach>
							</div>
						</div>
						
						<div class="form-group">
							<label for="descricao">Identificador:</label>
							<input type="text" name="sigla" id="sigla" class="form-control" />
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
	</jsp:body>
	
</page:template>
