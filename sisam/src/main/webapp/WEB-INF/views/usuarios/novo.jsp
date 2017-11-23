<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>

<page:template titulo="Novo usuário">
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form:form action="${s:mvcUrl('UC#gravar').build()}" method="POST">
					<div class="form-group">
						<label for="email">E-mail:</label>
						<input type="text" id="matricula" name="email" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" class="form-control" />
					</div>
					<div class="form-group">
						<label for="senha">Nova senha:</label>
						<input type="password" id="senha" name="senha" class="form-control" />
					</div>
					<div class="form-group">
						<label>Permissões:</label>
						<select name="permissao.id" class="form-control">
							<c:forEach items="${permissoes}" var="permissao">
								<option value="${permissao.id}">${permissao.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</form:form>
			</div>
		</div>
	</div>

</page:template>
