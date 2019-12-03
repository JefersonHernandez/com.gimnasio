<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Socios</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="salaDao" class="com.gimnasio.model.SocioDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">
			<div class="card col-md-8 margin">
			<h2>Socios</h2>
				<table class="table mb-5 table-hover table-borderless">
					<thead>
						<tr>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Numero</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Nombre</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Banco</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Direccion</th>

							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Profesion</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Telefono</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Opcion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${salaDao.list()}">
							<tr>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.numero}" /></td>

								<td class="text-center font-weight-light text-white"><c:out
										value="${n.nombre}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.datosBancarios}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.direccion}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.profesion}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.telefono}" /></td>
								<td class="text-center font-weight-light text-white"><a class="text-danger"
									href="#">Eliminar</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="card col">
			<h2>Opciones</h2>
			<a href="#">Agregar Socio</a>
			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>

</body>
</html>