<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>

<page:template titulo="Editar alunos">

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Edição de alunos</h3>
				<form:form action="${s:mvcUrl('ARC#atualizar').build()}"
					method="POST" commandName="aluno">
					<input type="hidden" name="id" value="${aluno.id}" />
					<div class="form-group">
						<label for="email">E-mail:</label> <input type="text" id="email"
							name="email" value="${aluno.email}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="matricula">Matricula:</label> <input type="text"
							id="matricula" name="matricula" value="${aluno.matricula}"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="senha">Nome:</label> <input type="text" id="nome"
							name="nome" value="${aluno.nome}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Sexo:</label>
						<input type="radio" name="sexo" value="M"> Masculino
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