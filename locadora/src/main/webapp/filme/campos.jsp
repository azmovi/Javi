<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${filme != null}">
                            Edição
                        </c:when>
			<c:otherwise>
                            Cadastro
                        </c:otherwise>
		</c:choose>
	</caption>

	<c:if test="${filme != null}">
		<input type="hidden" name="id" value="${filme.id}" />
	</c:if>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45"
			required value="${filme.nome}" /></td>
	</tr>
	<tr>
		<td><label for="diretor">Diretor</label></td>
		<td><input type="text" id="diretor" name="diretor" size="45" required
			value="${filme.diretor}" /></td>
	</tr>
	<tr>
		<td><label for="studio"> Studio </label></td>
		<td><select id="studio" name="studio">
				<c:forEach items="${studios}" var="studio">
					<option value="${studio.key}"
						${filme.studio.empresa == studio.value ? 'selected' : '' }>
						${studio.value}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><label for="ano">Ano</label></td>
		<td><input type="number" id="ano" name="ano" size="5" required
			min="1500" value="${filme.ano}" /></td>
	</tr>
	<tr>
		<td><label for="preco">Preço</label></td>
		<td><input type="number" id="preco" name="preco" required
			min="0.01" step="any" size="5" value="${filme.preco}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>
