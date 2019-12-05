<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gimnasio</title>
<%@include file="html/meta.html"%>
<body>
	<%@include file="html/header.html"%>
	<%@include file="html/nav.html"%>
	<div class="container">
		<div class="row padding">




			<div class="card col-11 col-sm-4 margin mx-auto">
				<form action="RecoveryPassController" method="post">
					<fieldset>
						<legend>Ingresa Tu Usuario</legend>

						<div class="form-group">
							<input class="col" type="text" name="codigo"
								placeholder="Codigo Usuario" required />
						</div>


						<div class="form-group">
							<button class="btn btn-info btn-sm col-md-12" type="submit">Guardar</button>
						</div>

						<input type="hidden" value="RECOVERY_PASS" name="opcion">
					</fieldset>
				</form>


			</div>






		</div>
		<%@include file="html/footer.html"%>
	</div>
</body>
</html>