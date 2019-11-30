<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Aparato</title>
</head>
<body>
<div class="row mb-5">
		<div class="col-md-3"></div>
			<div class="col-md-6 text-center" style="border-radius: 10px;padding:5px;">
				<form class="form-horizontal" method="POST"
					action="#">
					<fieldset>
						<div class="form-group">
							<div class="col">
								<input name="nombre" type="text" placeholder="Nombre"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col">
								<input name="presidente" type="text" placeholder="Presidente"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 text-center">
								<button type="submit" class="btn btn-primary btn-lg">Save</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>

		</div>

</body>
</html>