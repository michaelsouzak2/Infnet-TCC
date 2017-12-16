<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Professores">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<c:if test="${not empty sucesso}">	
					<div class="alert alert-success" role="alert">${sucesso}</div>
				</c:if>
				
				<div class="page-header">
					<h3>Professores do SISAM
						<a href="${s:mvcUrl('PC#novo').build()}" class="btn btn-info pull-right">Novo</a>
					</h3>
				</div>
				
				
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Matricula</th>
							<th>Nome</th>
							<th class="text-center">Editar</th>
							<th class="text-center">Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${professores}" var="professor">
							<tr>
								<td>${professor.matricula}</td>
								<td>${professor.nome}</td>
								<td class="text-center">
									<a href="${s:mvcUrl('PC#buscar').arg(0,professor.id).build()}">
										<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
									</a>
								</td>
								<td class="text-center">
									<a href="${s:mvcUrl('PC#remover').arg(0,professor.id).build()}">
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