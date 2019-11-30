<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Estado Aparato List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:useBean id="nDao" class="com.gimnasio.model.AparatoEstadoDAO"
		scope="request"></jsp:useBean>


	<%@include file="html/header.html" %>
	<%@include file="html/nav.html" %>
	<div class="container"><c:out value="${sessionScope.codigo_socio}" />
	<table class="table mb-5 table-hover">
		<thead class='bg-light'>
			<tr class="table-info">
				<th scope='col'
					class='border-0 text-primary text-center text-uppercase'>Codigo</th>
				<th scope='col'
					class='border-0 text-primary text-center text-uppercase'>Descripcion</th>
					<th scope='col'
					class='border-0 text-primary text-center text-uppercase'></th>
					
					<th scope='col'
					class='border-0 text-primary text-center text-uppercase'></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="n" items="${nDao.list()}">
				<tr>
					<td class="text-center font-weight-light"><c:out
							value="${n.codigo}" /></td>
					<td class="text-center font-weight-light"><c:out
							value="${n.descripcion}" /></td>

					<td class="text-center font-weight-light"><a
						class="btn btn-danger"
						href="DeleteEstadoAparato?codigo=${n.codigo}">delete</a></td>
						<td class="text-center font-weight-light"><a
						class="btn btn-info"
						href="DeleteEstadoAparato?codigo=${n.codigo}">editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<%@include file="html/footer.html" %>


</body>
</html>