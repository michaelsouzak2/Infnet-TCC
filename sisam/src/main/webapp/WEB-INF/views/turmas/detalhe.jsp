<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<page:template titulo="Editar Turma">

	<jsp:attribute name="extraScripts">
	 	<script type="text/javascript"
			src="/sisam/resources/js/app/datepicker.js"></script>
	</jsp:attribute>

	<jsp:body>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Edição de Modulos</h3>
				<form:form action="${s:mvcUrl('TC#atualizar').build()}"
						method="POST" commandName="turma">
					<input type="hidden" name="id" value="${turma.id}" />
					<div class="form-group">
						<label for="nome">Descrição da turma:</label>
						<input type="text" id="descricao" name="descricao"
								value="${turma.descricao}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Professores:</label>
						<form:select path="professor.id" cssClass="form-control">
							<form:options items="${professores}" itemValue="id"
									itemLabel="nome" />
						</form:select>
					</div>
							<div class="form-group">
							<div class="row">
								<div class="col-lg-6">
									<label for="dataInicio">Data de início:</label>
									<input type="text" name="dataInicio" id="dataInicio" value="${turma.retData(0)}"
									class="form-control" />
								</div>
								<div class="col-lg-6">
									<label for="dataFim">Data fim:</label>
									<input type="text" name="dataFim" id="dataFim" value="${turma.retData(1)}" class="form-control" />
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