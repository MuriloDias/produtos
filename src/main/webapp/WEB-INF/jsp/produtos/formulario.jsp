<%@ include file="header.jspf"%>
			<form id="produtosForm" action="<c:url value="/produtos"/>"
				method="POST">
				<fieldset>
					<legend>Adicionar produtos</legend>
					<label for="nome">Nome:</label> <input id="nome" class="required"
						minlength="3" type="text" name="produto.nome"
						value="${produto.nome }" /> <label for="descricao">Descri??o:</label>
					<textarea id="descricao" class="required" maxlength="40"
						name="produto.descricao">${produto.descricao }</textarea>
					<label for="preco">Pre?o:</label> <input id="preco" min="0"
						type="text" name="produto.preco" value="${produto.preco }" />
					<button type="submit">Enviar</button>
				</fieldset>
			</form>
			<script type="text/javascript">
				$('#produtosForm').validate();
			</script>
<%@ include file="footer.jspf"%>