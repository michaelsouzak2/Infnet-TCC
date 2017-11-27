<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Nova questão">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<div class="page-header">
					<h3>Nova questão</h3>
				</div>
				
				<form:form action="${s:mvcUrl('QC#salvar').build()}" method="POST">
					<div class="form-group">
						<label for="topico">Tópico:</label>
						<select name="topico.id" id="topico" class="form-control">
							<c:forEach items="${topicos}" var="topico">
								<option value="${topico.id}">${topico.descricao}</option>
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
