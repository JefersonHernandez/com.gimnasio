<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mis Clases</title>
<%@include file="html/meta.html"%>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	
	<%@include file="html/header.html"%>
	<%@include file="html/nav.html"%>

	<div>
		<div class="row father">
			<div class="col-md-8 dashboard">

				<c:choose>
					<c:when test="${rol_user == 1}">
						<table class="table mb-5 table-hover">
							<thead class='bg-light'>
								<tr class="table-info">
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Codigo</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Dia</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Hora</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Descripcion</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Monitor</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Sala</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Cancelar</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Update</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="n" items="${socio.asiste}">
									<tr>
										<td class="text-center font-weight-light"><c:out
												value="${n.clase.codigo}" /></td>

										<td class="text-center font-weight-light"><c:out
												value="${n.clase.dia}" /></td>
										<td class="text-center font-weight-light"><c:out
												value="${n.clase.hora}" /></td>
										<td class="text-center font-weight-light"><c:out
												value="${n.clase.descripcion.descripcion}" /></td>
										<td class="text-center font-weight-light"><c:out
												value="${n.clase.monitor.nombre}" /></td>
										<td class="text-center font-weight-light"><c:out
												value="${n.clase.sala.numero}" /></td>
										<td class="text-center font-weight-light"><a
											class="btn btn-danger"
											href="DeleteClaseSocio?codigo_clase=${n.clase.codigo}&codigo_user=${socio.numero}">Cancelar</a></td>
										<td class="text-center font-weight-light"><a
											class="btn btn-info" href="#=${n.clase.codigo}">Editar</a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:when test="${rol_user == 2}">
						<table class="table mb-5 table-hover">
							<thead class='bg-light'>
								<tr class="table-info">
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Descripcion</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Dia</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Hora</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Sala</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase'>Monitor</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="n" items="${clasesDao.list()}">
									<tr>
										<td class="text-center font-weight-light"><c:out
												value="${n.hora}" /></td>
										<td class="text-center font-weight-light"><c:out
												value="${n.dia}" /></td>

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
					</c:when>
					<c:otherwise>
						<a>it is an otro</a>
					</c:otherwise>
				</c:choose>
			</div>

			<div class="col-md-4 lateral">
				<c:choose>
					<c:when test="${socio!=null}">
						<%@include file="html/aside.html"%>
					</c:when>
					<c:otherwise>
						<%@include file="html/login.html"%>
					</c:otherwise>
				</c:choose>
			</div>

		</div>
	</div>

	<%@include file="html/footer.html"%>

</body>
</html>