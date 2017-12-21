<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>

<page:template titulo="Questionários">
	
	<jsp:attribute name="extraScripts">
		<c:url value="/" var="contextPath" />
	 	<script type="text/javascript" src="${contextPath}resources/js/app/resposta.js"></script>
	</jsp:attribute>
	
	<jsp:body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					
					<div class="page-header">
						<h3>${questionario.descricao}</h3>
					</div>
					
					<form:form id="form-resposta" action="${s:mvcUrl('AC#finalizar').build()}" method="POST" class="form-group row">
						
						<input type="hidden" name="aluno.id" value="${alunoAvaliacao.aluno.id}" /> 
						<input type="hidden" name="avaliacao.id" value="${alunoAvaliacao.avaliacao.id}" /> 		
						<input type="hidden" name="id" value="${alunoAvaliacao.id}" /> 		
						
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
								
									<c:forEach items="${questionario.gruposQuestoes}" var="grupo" varStatus="statusGrupo">
										<c:forEach items="${grupo.questoes}" var="questao" varStatus="status">
											
											<c:choose>
												<c:when test="${status.index == 0}">
													<tr>
														<td colspan="8" class="form-av-grupoquest-desc">${grupo.descricao}</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr data-tr-likert>
														<td colspan="2">${questao.pergunta}</td>
														<c:forEach items="${opcoes}" var="opcao">
															<td class="text-center"	>
																<label class="form-check-label">
																	<input type="hidden" value="${questao.id}" />
																	<input type="radio" class="form-check-input cursor-pointer" value="${opcao}" />
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
					</form:form>
					
				</div>
			</div>
		</div>
	</jsp:body>

</page:template>