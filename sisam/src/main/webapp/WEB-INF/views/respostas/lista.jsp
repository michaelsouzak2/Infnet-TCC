<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>

<page:template titulo="Questionários">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<input type="hidden" name="alunoAvaliacao" value="${alunoAvaliacao}" />

				<div class="page-header">
					<h3>${questionario.descricao}</h3>
				</div>
				
				<form id="form-resposta" action="${s:mvcUrl('AC#finalizar').build()}" method="POST" class="form-group row">
					
					<div class="form-group">
						<table class="table">
							<thead>
								<tr>
									<th colspan="2">#</th>
									<c:forEach items="${opcoes}" var="opcao">
										<th class="text-center">${opcao.opcao}</th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach items="${questionario.gruposQuestoes}" var="grupo">
									<c:forEach items="${grupo.questoes}" var="questao" varStatus="status">
										
										<c:choose>
											<c:when test="${status.index == 0}">
												<tr>
													<td colspan="8" class="form-av-grupoquest-desc">${grupo.descricao}</td>
												</tr>
											</c:when>
											<c:otherwise>
												<tr>
												<td scope="row">${questao.id}</td>
												<td>${questao.pergunta}</td>
												<c:forEach items="${opcoes}" var="opcao">
													<td class="text-center">
														<label class="form-check-label">
															<input class="form-check-input cursor-pointer" type="radio" name="${questao.id}" id="${questao.id}" value="${questao.id}" />
														</label>
													</td>
												</c:forEach>
											</tr>											
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</c:forEach>
								
							</tbody>
						</table>
					</div>

					<button type="submit" class="btn btn-primary">Finalizar</button>
				</form>
				
			</div>
		</div>
	</div>

</page:template>