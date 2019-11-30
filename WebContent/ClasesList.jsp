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
	<div class="row">
	
		<div class="card col-md-8">
			<aside class="col-md-4 lateral">
				<c:choose>
					<c:when test="${socio!=null}">
						<%@include file="html/aside.html"%>
					</c:when>
					<c:otherwise>
						<%@include file="html/login.html"%>
					</c:otherwise>
				</c:choose>
			</aside>
		</div>
		<div class="card col-md-4">asa<h1>sd</h1></div>

	</div>

	<jsp:useBean id="claseDao" class="com.gimnasio.model.ClaseDAO"></jsp:useBean>

	<%@include file="html/header.html"%>
	<%@include file="html/nav.html"%>
	<c:choose>
		<c:when test="${rol_user == 1}">
		</c:when>
		<c:when test="${rol_user == 2}">
			<a>it is an monitor</a>
		</c:when>
		<c:otherwise>
			<a>it is an otro</a>
		</c:otherwise>
	</c:choose>





	<div class="row father">
		<section class="col-md-8 dashboard">
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
							<c:forEach var="n" items="${claseDao.list()}">
								<tr>
									<td class="text-center font-weight-light"><c:out
											value="${n.codigo}" /></td>

									<td class="text-center font-weight-light"><c:out
											value="${n.dia}" /></td>
									<td class="text-center font-weight-light"><c:out
											value="${n.hora}" /></td>
									<td class="text-center font-weight-light"><c:out
											value="${n.descripcion.descripcion}" /></td>
									<td class="text-center font-weight-light"><c:out
											value="${n.monitor.nombre}" /></td>
									<td class="text-center font-weight-light"><c:out
											value="${n.sala.numero}" /></td>

									<td class="text-center font-weight-light"><a
										class="btn btn-danger"
										href="DeleteEstadoAparato?codigo=${n.codigo}">Unirme</a></td>
									<td class="text-center font-weight-light"><a
										class="btn btn-info"
										href="DeleteEstadoAparato?codigo=${n.codigo}">editar</a></td>
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
				<c:otherwise>
					<a>it is an otro</a>
				</c:otherwise>
			</c:choose>
		</section>

		<aside class="col-md-4 lateral">
			<c:choose>
				<c:when test="${socio!=null}">
					<%@include file="html/aside.html"%>
				</c:when>
				<c:otherwise>
					<%@include file="html/login.html"%>
				</c:otherwise>
			</c:choose>
		</aside>

	</div>




	<%@include file="html/footer.html"%>
</body>
</html>