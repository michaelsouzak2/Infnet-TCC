<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<page:template titulo="Avaliações">

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
						Avaliações cadastradas <a href="#" class="btn btn-info pull-right">Novo</a>
					</h3>
				</div>

				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>data de inicio</th>
							<th>Data fim</th>
							<th>Questionário</th>
							<th class="text-center">Editar</th>
							<th class="text-center">Excluir</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${avaliacoes}" var="avaliacao">
							<tr>
								<td>${avaliacao.id}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${avaliacao.dataInicio.time}" /></td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${avaliacao.dataFim.time}" /></td>
								<td>${avaliacao.questionario.sigla}</td>
								<td class="text-center"><a href="#"> <i
										class="fa fa-pencil-square-o" aria-hidden="true"></i>
								</a></td>
								<td class="text-center"><a href="#"> <i
										class="fa fa-trash-o" aria-hidden="true"></i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>

</page:template>
