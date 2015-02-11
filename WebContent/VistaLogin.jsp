<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="estilo.css" rel="StyleSheet" type="text/css" id="css"/>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Bootstrap --> 
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<!-- jQuery (necesario para los plugins Javascript de Bootstrap) --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
<!-- Incluir todos los plugins compilados (abajo), o incluir archivos individuales según sea necesario --> 
<script src="js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
	<div class="navbar navbar-inverse">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">InfoPool</a>
  </div>
  <div class="navbar-collapse collapse navbar-inverse-collapse">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="vistaRegistro.jsp">Registrate</a></li>
      <li><a href="VistaLogin.jsp">Login</a></li>
    </ul>
  </div>
</div>


<% String user = (String) session.getAttribute("email");
if (user == null){ %>
<div class="container">
<div class="row"> 
<div class="col-md-6 col-md-offset-3">
<s:form action="Login" cssClass="form-horizontal">
<fieldset>
<legend>Login</legend>
<s:textfield name="email" label="Email" maxlength="20" placeholder="Email" cssClass="form-control"/>
<s:password name="password" label="Contraseña" maxlength="20" placeholder="Contraseña" cssClass="form-control"/>
<s:submit value="Ingresar" cssClass="btn btn-primary"/>
</fieldset>
</s:form>
</div>
</div>
</div>
<%} else{response.sendRedirect("backend.jsp");}%>
</body>
</html>