<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Questões">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<c:if test="${not empty sucesso}">	
					<div class="alert alert-success alert-dismissable" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						${sucesso}
					</div>
				</c:if>
				
				<div class="page-header">
					<h3>Questões cadastradas
						<a href="${s:mvcUrl('QC#novo').build()}" class="btn btn-info pull-right">Novo</a>
					</h3>
				</div>
				
				<form:form action="${s:mvcUrl('QC#listarPorGrupoQuestoes').build()}" cssClass="form-inline" method="POST" commandName="grupoQuestoes">
					<div class="form-group">
						<label for="grupoQuestoes">Filtrar por grupo de questões: </label>
						<select name="id" id="grupoQuestoes" class="form-control">
							<c:forEach items="${gruposQuestoes}" var="grupo">
								<c:choose>
									<c:when test="${grupoQuestoes.id == grupo.id}">
										<option value="${grupo.id}" selected="selected">${grupo.descricao}</option>
									</c:when>
									<c:otherwise>
										<option value="${grupo.id}">${grupo.descricao}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-info">Filtrar</button>
				</form:form>
				
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Pergunta</th>
							<th class="text-center">Editar</th>
							<th class="text-center">Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${questoes}" var="questao">
							<tr>
								<td>${questao.pergunta}</td>
								<td class="text-center">
									<a href="${s:mvcUrl('QC#buscar').arg(0,questao.id).build()}">
										<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
									</a>
								</td>
								<td class="text-center">
									<a href="${s:mvcUrl('QC#remover').arg(0, questao.id).build()}">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
</page:template>