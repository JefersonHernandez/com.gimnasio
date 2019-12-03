<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Monitores</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="salaDao" class="com.gimnasio.model.MonitorDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">
			<div class="card col-md-8 margin">
			<h2>Monitores</h2>
				<table class="table mb-5 table-hover table-borderless">
					<thead>
						<tr>
							<th scope='col'
								class='border-0 text-warning text-center text-uppercase'>Codigo</th>
							<th scope='col'
								class='border-0 text-warning text-center text-uppercase'>Nombre</th>
							<th scope='col'
								class='border-0 text-warning text-center text-uppercase'>Años Experiencia</th>
							<th scope='col'
								class='border-0 text-warning text-center text-uppercase'>Titulo</th>
							<th scope='col'
								class='border-0 text-warning text-center text-uppercase'>Telefono</th>
							<th scope='col'
								class='border-0 text-warning text-center text-uppercase'>Opcion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${salaDao.list()}">
							<tr>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.codigo}" /></td>

								<td class="text-center font-weight-light text-white"><c:out
										value="${n.nombre}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.experiencia}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.titulo}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.telefono}" /></td>
								<td class="text-center font-weight-light"><a class="text-danger"
									href="#">Eliminar</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="card col">
			<h2>Opciones</h2>
				<a href="#">Agregar Monitor</a>
			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>

</body>
</html>