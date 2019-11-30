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
	<div class="">


		<div class="row father">
			<div class="col-md-8 dashboard">
				<header>
					<h2 class="text-center">Descripcion Gimnasio</h2>
				</header>
				<p>El Sistema Solar forma parte de la Vía Láctea y está formado
					principalmente por una estrella llamada Sol y ocho planetas como lo
					son Mercurio, Venus, Tierra, Marte, Júpiter, Saturno, Urano,
					Neptuno Algunos planetas pueden tener satélites que giran alrededor
					de estos. satélites. Ver más en Brainly.lat -
					https://brainly.lat/tarea/869118#readmore</p>
				<p>El radio ecuatorial es un factor importante ya que se define
					como la distancia del centro del planeta a su ecuador imaginario,
					con este factor se puede determinar la masa de cualquier planeta y
					con la masa de un planeta se puede determinar otros factores
					importante como la gravedad . La distancia de un planeta respecto
					del Sol puede determinar las condiciones de temperaturas y el tipo
					de clima que puede haber en cada planeta. Ver más en Brainly.lat -
					https://brainly.lat/tarea/869118#readmore</p>
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