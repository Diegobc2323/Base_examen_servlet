<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>formulario nuevas actividades</title>
</head>
<body class="container">

	<form action="/insertTitulacionAlumno" method="post" class="row d-flex justify-content-center">
	<div class="col-8 row justify-content-center">
		
		<select id="alumno" name="alumno">
			<c:forEach var="alumno" items="${alumnos}">
				<option value="${alumno.id}">${alumno.nombre}</option>
			</c:forEach>
		</select>
			
		<select id="titulacion" name="titulacion">
			<c:forEach var="titulacion" items="${titulaciones}">
				<option value="${titulacion.id}">${titulacion.titulo}</option>
			</c:forEach>
		</select>
		 
		<input type="submit" value="enviar" />
	</div>
	</form>
	
	<a href="/index.jsp">Volver</a>
	
</body>
</html>