<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head jqueryui="true" jquerytheme="redmond"/>
<title>Viajero</title>
<!-- Bootstrap --> 
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<!-- jQuery (necesario para los plugins Javascript de Bootstrap) --> 
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> --> 
<!-- Incluir todos los plugins compilados (abajo), o incluir archivos individuales según sea necesario --> 
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<% String user = (String) session.getAttribute("email");
String tipoUsuario = (String) session.getAttribute("tipoUsuario");
if (user == null){ response.sendRedirect("VistaLogin.jsp");} 
if (!tipoUsuario.equals("viajero")) {response.sendRedirect("AccesoDenegado.jsp");} %> 
<div class="navbar navbar-inverse">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">InfoPool</a>
    <a class="navbar-brand" href="#">Viajero</a>
  </div>
  <div class="navbar-collapse collapse navbar-inverse-collapse">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="backendViajero.jsp">Home</a></li>
      <li><a href="#">Agregar nuevo recorrido</a></li>
      <li><a href="#">Visualizar/modificar recorrido</a></li>
      <li><a href="#">Participar en recorrido</a></li>
      <li><a href="#">Calificar usuarios</a></li>
      <li><a href="#">Mensajería</a></li>
      <li><a href="salir">Salir</a></li>
    </ul>
  </div>
</div>
	
  <h1> EN CONSTRUCCIÓN!</h1>
	
</body>
</html>