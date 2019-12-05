<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salas</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="salaDao" class="com.gimnasio.model.TipoSalaDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">
			
			<div class="card col-11 col-sm-4 margin mx-auto">
				<form action="AddSala" method="post">
					<fieldset>
						<legend>Agregar Sala</legend>
						<div class="form-group">
							<input class="col" type="text" name="ubicacion" placeholder="Ubicacion"
								required />
						</div>
						<div class="form-group">
							<input class="col" type="text" name="metros" placeholder="Metros Cuadrados"
								required />
						</div>
						<div class="form-group row">
						<div class="col col-sm-6 text-center">
							<label class="col">Tipo Sala</label>
						</div>
						<div class="col-md-6">
							<select name="tipo_sala" class="col-md-12">
								<c:forEach var="n" items="${salaDao.list() }">
									<option value="${n.codigo}">${n.descripcion }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group ">
							<button class="btn btn-info btn-sm col-md-12" type="submit">Guardar</button>
						</div>
					</fieldset>
				</form>

			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>

</body>
</html>