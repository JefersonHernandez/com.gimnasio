<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Socio</title>
<%@include file="html/meta.html"%>
</head>
<body>
	<jsp:useBean id="salaDao" class="com.gimnasio.model.TipoSalaDAO"></jsp:useBean>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">
			
			<div class="card col-11 col-sm-4 margin mx-auto">
				<form action="SocioController" method="post">
					<fieldset>
						<legend>Agregar Socio</legend>
						<div class="form-group">
							<input class="col" type="text" name="nombre" placeholder="Nombre"
								required />
						</div>
						<div class="form-group">
							<input class="col" type="email" name="direccion"
								placeholder="Email" required />
						</div>
						<div class="form-group">
							<input class="col" type="text" name="profesion"
								placeholder="Profesion" required />
						</div>

						<div class="form-group">
							<input class="col" type="text" name="telefono"
								placeholder="Telefono" required />
						</div>
						<div class="form-group">
							<input class="col" type="text" name="banco" placeholder="Nombre Banco"
								required />
						</div>
						<div class="form-group">
							<input class="col" type="text" name="clave" placeholder="Clave"
								required />
						</div>

						<div class="form-group">
							<button class="btn btn-info btn-sm col-md-12" type="submit">Guardar</button>
						</div>
						<input type="hidden" value="POST" name="method">
					</fieldset>
				</form>

			</div>
		</div>
		<%@include file="html/footer.html"%>
	</div>

</body>
</html>