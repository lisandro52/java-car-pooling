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
<title>Administrador</title>
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
if (!tipoUsuario.equals("administrador")) {response.sendRedirect("AccesoDenegado.jsp");} %>
<div class="navbar navbar-inverse">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">InfoPool</a>
    <a class="navbar-brand" href="#">Administrador</a>
  </div>
  <div class="navbar-collapse collapse navbar-inverse-collapse">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="backend.jsp">Home</a></li>
      <li><a href="altaEvento.jsp">Eventos</a></li>
      <li><a href="salir">Salir</a></li>
    </ul>
  </div>
</div>
	
	<div>
	<s:url id="remoteurl" action="DatosTablaAction"/>
	<sjg:grid
		id="gridtable"
		caption="eventos"
		dataType="json"
		href="%{remoteurl}"
		pager="true"
		gridModel="gridModel"
		rowList="10,15,20"
		rowNum="10"
		rownumbers="true"
		autowidth="true" >
		<sjg:gridColumn name="nombre" index="nombre" title="Nombre" sortable="true"/>
		<sjg:gridColumn name="descripcion" index="descripcion" title="Descripcion" sortable="true"/>
		<sjg:gridColumn name="lugar" index="lugar" title="Lugar" sortable="true"/>
		<sjg:gridColumn name="fecha" index="fecha" title="Fecha" sortable="true"/>
		<sjg:gridColumn name="hora" index="hora" title="Hora" sortable="true"/>
	</sjg:grid>
	</div>
</body>
</html>