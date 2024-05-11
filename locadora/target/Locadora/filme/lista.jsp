<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Locadora Virtual</title>
    </head>
<body>
	<div align="center">
		<h1>Gerenciamento de Filmes</h1>
		<h2>
			<a href="/${requestScope.contextPath}">Menu Principal</a> &nbsp;&nbsp;&nbsp; 
			<a href="/${requestScope.contextPath}/filmes/cadastro">Adicione Novo Filme</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Filmes</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Studio</th>
				<th>Diretor</th>
				<th>Ano</th>
				<th>Preço</th>
				<th>Acões</th>
			</tr>
			<c:forEach var="filme" items="${requestScope.listaFilmes}">
				<tr>
					<td>${filme.id}</td>
					<td>${filme.nome}</td>
					<td>${filme.studio.empresa}</td>
					<td>${filme.diretor}</td>
					<td>${filme.ano}</td>
					<td>${filme.preco}</td>
					<td>
                        <a href="/${requestScope.contextPath}/filmes/edicao?id=${filme.id}"> Edição</a>

						&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/${requestScope.contextPath}/filmes/remocao?id=${filme.id}" onclick="return confirm('Tem certeza de que deseja excluir este item?');"> Remoção </a>
                    </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
