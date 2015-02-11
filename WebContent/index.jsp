<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap --> 
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<!-- jQuery (necesario para los plugins Javascript de Bootstrap) --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
<!-- Incluir todos los plugins compilados (abajo), o incluir archivos individuales según sea necesario --> 
<script src="js/bootstrap.min.js"></script>
<title>InfoPool</title>
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
      <% String user = (String) session.getAttribute("email"); 
      String tipoUsuario = (String) session.getAttribute("tipoUsuario");
      if (tipoUsuario!=null && (tipoUsuario.equals("viajero"))){ %>
      <li><a href="backendViajero.jsp">Home</a></li>
      <%;} 
      	else {if (tipoUsuario!=null && (tipoUsuario.equals("administrador"))){ %>
      	<li><a href="backend.jsp">Home</a></li>	
 		<% ;}} %>
      <li><a href="vistaRegistro.jsp">Registrate</a></li>
	  <% if (user == null){  %>
      <li><a href="VistaLogin.jsp">Login</a></li>
      <%  ;}
	  else {%>
	  <li><a href="salir">Salir</a></li>
	  <% ;} %>
    </ul>
  </div>
</div>

<div class="container">
<div class="jumbotron">
</div>
<div class="col-md-6 col-md-offset-3">
  <img src="foto.jpg" alt="" class="img-circle">
  <p><a class="btn btn-primary btn-lg">Leer mas</a></p>

</div>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-6 footer-left">
                <ul class="list-inline">
                    <li>
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                        <a href="#">Contacto</a>
                    </li>
                    <li>
                        <a href="#">Ayuda</a>
                    </li>
                
                </ul>
                
            </div>
            
        </div>
        <hr>
    </div>
</footer>
</body>
</html>