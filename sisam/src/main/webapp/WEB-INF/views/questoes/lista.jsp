<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Questões">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<c:if test="${not empty sucesso}">	
					<div class="alert alert-success" role="alert">${sucesso}</div>
				</c:if>
				
				<div class="page-header">
					<h3>Questões cadastradas
						<a href="${s:mvcUrl('QC#novo').build()}" class="btn btn-info pull-right">Novo</a>
					</h3>
				</div>
				
				<form:form action="${s:mvcUrl('QC#listarPorTopico').build()}" cssClass="form-inline" method="POST" commandName="topico">
					<div class="form-group">
						<label for="topico">Filtrar por tópico: </label>
						<select name="id" id="topico" class="form-control">
							<c:forEach items="${topicos}" var="t">
								<c:choose>
									<c:when test="${topico.id == t.id}">
										<option value="${t.id}" selected="selected">${t.descricao}</option>
									</c:when>
									<c:otherwise>
										<option value="${t.id}">${t.descricao}</option>
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