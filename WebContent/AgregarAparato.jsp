<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Aparato</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="aparatoEstadoDao"
		class="com.gimnasio.model.AparatoEstadoDAO"></jsp:useBean>
	<jsp:useBean id="salaDao" class="com.gimnasio.model.SalaDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form action="AddAparato" method="post">
				<fieldset>
					<legend>Imformacion Aparato</legend>
					<div class="form-group row">
						<div class="col-md-6">
							<label class="col-md-4">Estado</label>
						</div>
						<div class="col-md-6">
							<select name="estado" class="col-md-12">
								<c:forEach var="n" items="${aparatoEstadoDao.list() }">
									<option value="${n.codigo}">${n.descripcion }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-6">
							<label class="col-md-12">Ubicar En Sala</label>
						</div>
						<div class="col-md-6">
							<select name="sala" class="col-md-12">
								<c:forEach var="n" items="${salaDao.list() }">
									<option value="${n.numero}">${n.numero }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<textarea name="descripcion" placeholder="Descripcion"
							class="form-control" required></textarea>
					</div>
					<div class="form-group">
						<button type="submit">Guardar</button>
					</div>
				</fieldset>

			</form>
		</div>

	</div>
	<%@include file="html/footer.html"%>
</body>
</html>