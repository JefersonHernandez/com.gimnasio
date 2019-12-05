<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Sala</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="salaDao" class="com.gimnasio.model.SalaDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">
			<div class="card col-md-8 margin">
				<h2>Salas</h2>
				<table class="table mb-5 table-hover table-borderless table-responsive table-striped">
					<thead>
						<tr>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Numero</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Metros
								Cuadrados</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Ubicacion</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Tipo
								Sala</th>
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
										value="${n.metrosCuadrados}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.ubicacion}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.tipoSalaBean.descripcion}" /></td>
								<td class="text-center font-weight-light text-white	">
									<form action="SalaController" method="POST">
										<input name="method" type="hidden" value="DELETE">
										<input name="id_sala" type="hidden"value="${n.numero }">
										<button class="btn btn-danger btn-sm"type="submit">Eliminar</button>
									</form></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="card col">
				<h2>Opciones</h2>
				<a  class="btn btn-info btn-sm" href="AgregarSala.jsp">Agregar Sala</a>
			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>

</body>
</html>