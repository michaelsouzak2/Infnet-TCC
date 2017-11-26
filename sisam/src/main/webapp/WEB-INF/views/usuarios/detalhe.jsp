<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Editar usuário">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>Edição de usuário</h4>
				<form:form action="${s:mvcUrl('UC#atualizar').build()}" method="POST" commandName="usuario">
					<input type="hidden" name="id" value="${usuario.id}" />
					<input type="hidden" name="oldPassword" value="${usuario.senha}" />
					<div class="form-group">
						<label for="email">E-mail:</label>
						<input type="text" id="matricula" name="email" value="${usuario.email}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${usuario.nome}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="senha">Senha:</label>
						<input type="password" id="senha" name="senha" value="${usuario.senha}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Permissões:</label>
						<form:select path="permissao.id" cssClass="form-control">
							<form:options items="${permissoes}" itemValue="id" itemLabel="descricao" />
						</form:select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>
	
</page:template>