<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<page:template titulo="Turmas">

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<c:if test="${not empty sucesso}">
					<div class="alert alert-success alert-dismissable" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						${sucesso}
					</div>
				</c:if>

				<div class="page-header">
					<h3>
						Turmas do SISAM <a href="${s:mvcUrl('TC#novo').build()}"
							class="btn btn-info pull-right">Novo</a>
					</h3>
				</div>


				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Descrição</th>
							<th>Professor</th>
							<th>Modulo</th>
							<th>Data de início</th>
							<th>Data de término</th>
							<th class="text-center">Editar</th>
							<th class="text-center">Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${turmas}" var="turma">
							<tr>
								<td>${turma.descricao}</td>
								<td>${turma.professor.nome}</td>
								<td>${turma.modulo.nome}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${turma.dataInicio.time}" /></td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${turma.dataFim.time}" /></td>

								<td class="text-center"><a
									href="${s:mvcUrl('TC#buscar').arg(0,turma.id).build()}"> <i
										class="fa fa-pencil-square-o" aria-hidden="true"></i>
								</a></td>
								<td class="text-center"><a
									href="${s:mvcUrl('TC#remover').arg(0, turma.id).build()}">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</page:template>