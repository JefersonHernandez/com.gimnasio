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
			<div class="card col-12 col-sm-6 text-center mx-auto">
				<c:if test="${error_msg !=null }">
				

					<div class="alert alert-danger" role="alert">
							<label>${error_msg}</label>
					</div>
				</c:if>
			</div>





		</div>
		<%@include file="html/footer.html"%>
	</div>
</body>
</html>