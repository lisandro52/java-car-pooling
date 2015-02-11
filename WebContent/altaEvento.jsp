<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap --> 
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<!-- jQuery (necesario para los plugins Javascript de Bootstrap) --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
<!-- Incluir todos los plugins compilados (abajo), o incluir archivos individuales según sea necesario --> 
<script src="js/bootstrap.min.js"></script>
<title>Eventos</title>

	<meta charset="utf-8">
	
	<link rel="stylesheet" href="js/jquery-ui.css">
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui.js"></script>
	<link rel="stylesheet" href="js/style.css">
	<script>
	$(function() {
		$( "#fecha" ).datepicker();
	});
	</script>
</head>
<body>
<% String user = (String) session.getAttribute("email");
if (user == null){ response.sendRedirect("VistaLogin.jsp");} %>

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

<div class="container">
<div class="row"> 
<div class="col-md-6 col-md-offset-3">
<s:form action="AltaEvento" >
<fieldset>
<legend>Alta de Evento</legend>
<s:textfield name="nombre" label="Nombre:" placeholder="Nombre" cssClass="form-control"/>
<s:textfield name="descripcion" label="Descripcion:" placeholder="Descripcion" cssClass="form-control"/>
<s:textfield name="lugar" label="Lugar:" placeholder="Lugar" cssClass="form-control"/>
<s:textfield  id="fecha" name="fecha" label="fecha" placeholder="Fecha" cssClass="form-control"/>
<s:textfield name="hora" label="Hora:" placeholder="Hora" cssClass="form-control"/>
<s:submit cssClass="btn btn-primary"/>
</fieldset>
</s:form>
</div>
</div>
</div>
</body>
</html>