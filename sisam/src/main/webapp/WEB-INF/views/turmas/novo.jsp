<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>

<page:template titulo="Nova Turma">

	<jsp:attribute name="extraScripts">
		<c:url value="/" var="contextPath" />
	 	<script type="text/javascript" src="${contextPath}resources/js/app/datepicker.js"></script>
	</jsp:attribute>

	<jsp:body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<div class="page-header">
					<h3>Nova turma</h3>
				</div>

				<form:form action="${s:mvcUrl('TC#gravar').build()}" method="POST">
					<div class="form-group">
						<label for="descricao">Descrição da Turma:</label> <input
							type="text" id="descricao" name="descricao" class="form-control" />
					</div>
					<div class="form-group">
						<label>Professor:</label> <select name="professor.id"
							class="form-control">
							<c:forEach items="${professores}" var="professor">
								<option value="${professor.id}">${professor.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Modulo:</label> <select name="modulo.id"
							class="form-control">
							<c:forEach items="${modulos}" var="modulo">
								<option value="${modulo.id}">${modulo.nome}</option>
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
									<label for="dataFim">Data de término:</label>
									<input type="text" data-datepicker="to" name="dataFim" id="dataFim" class="form-control" />
								</div>
							</div>
						</div>
						
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	</jsp:body>

</page:template>
