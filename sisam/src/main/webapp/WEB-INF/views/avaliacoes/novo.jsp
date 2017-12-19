<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>

<page:template titulo="Nova questão">

	<jsp:attribute name="extraScripts">
		<c:url value="/" var="contextPath" />
		<script type="text/javascript" src="${contextPath}resources/js/app/avaliacao.js"></script>
	 	<script type="text/javascript" src="${contextPath}resources/js/app/datepicker.js"></script>
	 	<script type="text/javascript" src="${contextPath}resources/js/app/mask.js"></script>
	</jsp:attribute>

	<jsp:body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					
					<div class="page-header">
						<h3>Nova avaliação</h3>
					</div>
					
					<form:form id="form-nova-avaliacao"
						action="${s:mvcUrl('AC#salvar').build()}" method="POST">
						<div class="form-group">
							<label for="questionario">Questionário:</label>
							<select name="questionario.id" id="questionario"
								class="form-control">
								<c:forEach items="${questionarios}" var="questionario">
									<option value="${questionario.id}">${questionario.sigla} - ${questionario.descricao}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<div class="row">
								<div class="col-lg-6">
									<label for="dataInicio">Data de início:</label>
									<input type="text" data-datepicker="from" name="dataInicio" id="dataInicio" class="form-control" />
								</div>
								<div class="col-lg-6">
									<label for="dataFim">Data fim:</label>
									<input type="text" data-datepicker="to" name="dataFim" id="dataFim" class="form-control" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="turmas">Turmas:</label>
							<select id="turmas" class="form-control">
								<option value="0">Selecione</option>
								<c:forEach items="${turmas}" var="turma">
									<option value="${turma.id}">${turma.descricao}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="turmas-selecionadas">Turmas selecionadas:</label>
							<div id="turmas-selecionadas">&nbsp;</div>
						</div>
						<div class="form-group">
							<h5>
								<strong>Convite:</strong>
							</h5>
							<label for="titulo-convite">Título:</label>
							<input name="convite.titulo" id="titulo-convite"
								class="form-control" />
							<label for="mensagem-convite">Mensagem:</label>
							<textarea rows="6" cols="10" id="mensagem-convite"
								name="convite.mensagem" class="form-control"></textarea>
						</div>
						
						<div class="form-group">
							<label for="pergunta">Objetivo da avaliação:</label>
							<textarea rows="6" cols="10" id="pergunta" name="objetivo"
								class="form-control"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Salvar</button>
					</form:form>
				</div>
			</div>
		</div>
	</jsp:body>

</page:template>
