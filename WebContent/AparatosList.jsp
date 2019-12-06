<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aparato List</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="aparatoDao" class="com.gimnasio.model.AparatoDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>

	<div class="container">
		<div class="row padding">
			<div class=" card col-12 col-sm-8 margin mx-auto">
				<h2>Aparatos</h2>
				<table class="col-sm-12 table mb-0 table-hover table-borderless table-responsive">
					<thead>
						<tr>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Codigo</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Descripcion</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Estado</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Ubicacion</th>
							<th scope='col'
								class='border-0 text-primary text-center text-uppercase text-warning'>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${aparatoDao.list()}">
							<tr>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.codigo}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.descripcion}" /></td>
								<td class="text-center font-weight-light text-white"><c:out
										value="${n.aparatoEstado.descripcion}" /></td>
								<td class="text-center font-weight-light text-white">Sala <c:out
										value="${n.sala.numero}" /></td>
								<td class="text-center font-weight-light text-white"><a
									href="DeleteAparato?codigo_aparato=${n.codigo }"
									class="btn btn-danger btn-sm" href="#">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="card col">
				<h2>Opciones</h2>

				
					<a class="btn btn-info btn-sm" href="AgregarAparato.jsp">Agregar Aparado</a>
				

			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>



</body>
</html>