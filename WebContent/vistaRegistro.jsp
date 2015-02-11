<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Registro</title>
<!-- Bootstrap --> 
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<!-- jQuery (necesario para los plugins Javascript de Bootstrap) --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
<!-- Incluir todos los plugins compilados (abajo), o incluir archivos individuales según sea necesario --> 
<script src="js/bootstrap.min.js"></script>
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

<div class="container">
<div class="row"> 
<div class="col-md-6 col-md-offset-3">
<s:form action="Registro" enctype="multipart/form-data" cssClass="form-horizontal">
<fieldset>
<legend>Registro</legend>
<s:textfield name="nombre" label="Nombre" cssClass="form-control" placeholder="Nombre"/>
<s:textfield name="apellido" label="Apellido" cssClass="form-control" placeholder="Apellido"/>
<s:textfield name="telefono" label="Telefono" cssClass="form-control" placeholder="Telefono"/>
<s:textfield name="email" label="Email" cssClass="form-control" placeholder="Email" />
<s:password name="password" label="Contraseña" cssClass="form-control" placeholder="Contraseña"/>
<s:password name="password2" label="Repetir Contraseña" cssClass="form-control" placeholder="Repetir contraseña"/>
<s:file name="foto" label="Foto" />
<s:submit cssClass="btn btn-primary"/>
</fieldset>
</s:form >
</div>
</div>
</div>
</body>
</html>