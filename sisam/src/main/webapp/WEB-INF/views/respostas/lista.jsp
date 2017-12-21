<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>

<page:template titulo="Questionários">

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
				<input type="hidden" name="idAluno" value="${idAluno}" /> <input
					type="hidden" name="idAvaliacao" value="${idAvaliacao}" /> <input
					type="hidden" name="alunoAvaliacao" value="${alunoAvaliacao}" />

				<div class="page-header">
					<h3>Questões</h3>
				</div>
				<c:if test="${not isPermite}">
					<div class="card-block">
						<h4 class="card-title">Você não tem permissão para responder
							esta avaliação!</h4>
					</div>
				</c:if>
				<c:if test="${isPermite}">
					<form id="form-resposta"
						action="${s:mvcUrl('AC#finalizar').build()}" method="POST"
						class="form-group row">
						<div class="form-group">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th></th>
										<c:forEach items="${opcoes}" var="opcao">
											<th>${opcao.opcao}</th>
										</c:forEach>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${questoes}" var="questao">
										<tr>
											<th scope="row">${questao.id}</th>
											<th>${questao.pergunta}</th>
											<c:forEach items="${opcoes}" var="opcao">
												<th><label class="form-check-label"> <input
														class="form-check-input" type="radio" name="${questao.id}"
														id="${questao.id}" value="${questao.id}">
												</label></th>
											</c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<button type="submit" class="btn btn-primary">Finalizar</button>
					</form>
				</c:if>
			</div>
		</div>
	</div>

</page:template>