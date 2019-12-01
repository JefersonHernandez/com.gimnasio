<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clases</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="claseDao" class="com.gimnasio.model.ClaseDAO"></jsp:useBean>
	<%@include file="html/header.html"%>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">
			<div class="card col-md-8 margin">
				<c:choose>
					<c:when test="${rol_user == 1}">
					<h2>Clases</h2>
						<table class="table mb-5 table-hover table-borderless">
							<thead>
								<tr>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Codigo</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Dia</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Hora</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Descripcion</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Monitor</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Sala</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Opcion</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="n" items="${claseDao.list()}">
									<tr>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.codigo}" /></td>

										<td class="text-center font-weight-light text-white"><c:out
												value="${n.dia}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.hora}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.preparacion.descripcion}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.monitorBean.nombre}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.salaBean.numero}" /></td>
										<td class="text-center font-weight-light text-white"><a 
											href="AddClaseSocio?codigo_clase=${n.codigo}">Unirme</a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:when test="${rol_user == 2}"><h2>Clases</h2>
						<table class="table mb-5 table-hover table-borderless">
							<thead>
								<tr>
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
								<c:forEach var="n" items="${nDao.list()}">
									<tr>
										<td class="text-center font-weight-light"><c:out
												value="${n.codigo}" /></td>
										<td class="text-center font-weight-light"><c:out
												value="${n.descripcion}" /></td>

										<td class="text-center font-weight-light"><a
											class="btn btn-danger"
											href="DeleteEstadoAparato?codigo=${n.codigo}">Asistir</a></td>
										<td class="text-center font-weight-light"><a
											class="btn btn-info"
											href="DeleteEstadoAparato?codigo=${n.codigo}">SD</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:when test="${rol_user == 3}"><h2>Clases</h2>
						<table class="table mb-5 table-hover table-borderless">
							<thead>
								<tr>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Descripcion</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Dia</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Hora</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Sala</th>
									<th scope='col'
										class='border-0 text-primary text-center text-uppercase text-warning'>Monitor</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="n" items="${claseDao.list()}">
									<tr>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.codigo}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.dia}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.hora}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.preparacion.descripcion}" /></td>
										<td class="text-center font-weight-light text-white"><c:out
												value="${n.monitorBean.nombre}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>otro usuario</c:otherwise>
				</c:choose>
			</div>
			<div class="card col">
			<h2>Opciones</h2>
				<c:choose>
					<c:when test="${socio!=null}">
						<%@include file="html/aside.html"%>
					</c:when>
					<c:when test="${admin!=null}">
						Cantidad de clases <c:out value="${claseDao.list().size()}"/>
					</c:when>
					<c:otherwise>
						sdsdsdsdsdsds
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>

</body>
</html>