<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Novo questionário">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<div class="page-header">
					<h3>Novo Questionário</h3>
				</div>
			
				<form:form action="${s:mvcUrl('QAC#salvar').build()}" method="POST">
					<div class="form-group">
						
						<c:forEach items="${topicos}" var="topico">
							<label>${topico.descricao}</label>
							<c:forEach items="${topico.questoes}" var="questao">
							
								<div class="checkbox">
								    <label>
							     		<input type="checkbox" name="questoes[${questao.id}].id" value="${questao.id}" /> ${questao.pergunta}
								    </label>
								</div>
									
							</c:forEach>
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
