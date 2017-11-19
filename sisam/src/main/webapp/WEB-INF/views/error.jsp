<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>
	

<page:template titulo="Erro">
	<section id="index-section" class="container middle">
		
		<h2>Ocorreu um erro interno.</h2>
		<hr />
		<p>${exception.message}</p>
		
		<!-- A exceção será compilada e exibida no comentário. -->
		<!-- 
			Mensagem: ${exception.message}
			 <c:forEach items="${exception.stackTrace}" var="stk">
			 	${stk}
			 </c:forEach>
		 -->
		
	</section>
</page:template>

	
