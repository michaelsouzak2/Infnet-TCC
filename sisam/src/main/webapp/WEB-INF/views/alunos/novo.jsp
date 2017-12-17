<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Novo Aluno">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
				<div class="page-header">
					<h3>Novo Aluno</h3>
				</div>
			
				<form:form action="${s:mvcUrl('ARC#gravar').build()}" method="POST">
					<div class="form-group">
						<label for="email">E-mail:</label>
						<input type="text" id="email" name="email" class="form-control" />
					</div>
					<div class="form-group">
						<label for="matricula">Matricula:</label>
						<input type="text" id="matricula" name="matricula" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" class="form-control" />
					</div>
					<div class="form-group">
						<label>Sexo:</label>
						<input type="radio" name="sexo" value="M" checked> Masculino
						<input type="radio" name="sexo" value="F"> Feminino
					</div>
					<div class="form-group">
						<label>Turma:</label>
						<select name="turma.id" class="form-control">
							<c:forEach items="${turmas}" var="turma">
								<option value="${turma.id}">${turma.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>

</page:template>
