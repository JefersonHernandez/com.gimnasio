<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Clase</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="salaDao" class="com.gimnasio.model.SalaDAO"></jsp:useBean>
	<jsp:useBean id="monitorDao" class="com.gimnasio.model.MonitorDAO"></jsp:useBean>
	<jsp:useBean id="preparacionDao"
		class="com.gimnasio.model.PreparacionDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">

			<div class="card col-11 col-sm-4 margin mx-auto">
				<form action="ClaseController" method="post">
					<fieldset>
						<legend>Agregar Clase</legend>



						<div class="form-group row">
							<div class="col-12 col-md-6 text-center">
								<label class="col">Sala</label>
							</div>
							<div class="col-12 col-md-6 text-center">
								<select name="sala" class="col">
									<c:forEach var="n" items="${salaDao.list() }">
										<option value="${n.numero}">${n.numero }</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-6 text-center">
								<label class="col">Monitor</label>
							</div>
							<div class="col-md-6">
								<select name="monitor" class="col-md-12">
									<c:forEach var="n" items="${monitorDao.list() }">
										<option value="${n.codigo}">${n.nombre }</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-6 text-center">
								<label class="col">Preparacion</label>
							</div>
							<div class="col-md-6">
								<select name="preparacion" class="col-md-12">
									<c:forEach var="n" items="${preparacionDao.list() }">
										<option value="${n.codigo}">${n.descripcion }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-12 col-sm-6 text-center">
								<label class="col-sm-12">Dia</label>
							</div>
							<div class="col-12 col-sm-6">
								<div class="form-group">
									<input class="col" type="date" name="dia" required>
								</div>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-12 col-sm-6 text-center">
								<label class="">Hora</label>
							</div>
							<div class="col-12 col-sm-6">
								<input class="col" type="time" name="hora" required>
							</div>

						</div>
						<div class="form-group">
							<button class="btn btn-info btn-sm col-md-12" type="submit">Guardar</button>
						</div>
						<input type="hidden" name="method" value="POST">
					</fieldset>
				</form>

			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>

</body>
</html>