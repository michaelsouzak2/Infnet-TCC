<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<page:template titulo="Relatório da pesquisa">
	
	<c:url value="/" var="contextPath" />
		
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
				<div class="page-header">
					<h3>Relatório da pesquisa</h3>
				</div>
				
<%-- 				<form:form action="${s:mvcUrl('RC#downloadExcel').build()}" method="POST"> --%>
				<form:form action="${contextPath}report" cssClass="form-inline" method="POST">
					<div class="form-group">
						<label>Selecione a avaliação:</label>
						<select name="id" class="form-control">
							<c:forEach items="${avaliacoes}" var="avaliacao">
								<option value="${avaliacao.id}">Id: ${avaliacao.id} - Data fim: <fmt:formatDate pattern="dd/MM/yyyy" value="${avaliacao.dataFim.time}" /></option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Gerar relatório</button>
				</form:form>
				
			</div>
		</div>
	</div>
	
</page:template>