<log:setLogger logger="Controlador.Actualizar" />
<log:entry/>
<b:base title="BD Inventario Aruba">
	<log:debug message="Hit por SessionID: ${sessionScope.sessionId }"/>
	
	<nav class="navbar navbar-default">
  		<div class="container-fluid">
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">Inventario Aruba</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="active"><a href="${pageContext.request.contextPath}/Login">Home</a></li>
      		<li><a href="${pageContext.request.contextPath}/Consulta">Consulta</a></li>
      		<li><a href="${pageContext.request.contextPath}/Insertar">Insertar</a></li>
      		<li><a href="${pageContext.request.contextPath}/Actualizar">Actualizar</a></li>
      		<li><a href="${pageContext.request.contextPath}/Eliminar">Eliminar</a></li>
    	</ul>
  </div>
	</nav>
	
	<h2>Llena los campos solicitados</h2>
  <form action=${pageContext.request.contextPath}/Actualizar method="post">
    <div class="form-group">
      <label for="idac">ID del registro a actualizar (lo puedes revisar en la pestaña de Consulta):</label>
      <input type="text" class="form-control" id="idac" placeholder="Ejemplo: 10" name="idac" required>
    </div>
    <div class="form-group">
      <label for="elementoac">Elemento:</label>
      <input type="text" class="form-control" id="elementoac" placeholder="Ejemplo: Switch core" name="elementoac" required>
    </div>
    <div class="form-group">
      <label for="serialac">Numero de serie:</label>
      <input type="text" class="form-control" id="serialac" placeholder="Ejemplo: CNX40532J1" name="serialac" required>
    </div>
    <div class="form-group">
      <label for="parteac">Numero de parte:</label>
      <input type="text" class="form-control" id="parteac" placeholder="Ejemplo: JW901X" name="parteac" required>
    </div>
    <div class="form-group">
      <label for="estadoac">Estado del elemento:</label>
      <input type="text" class="form-control" id="estadoac" placeholder="Ejemplo: Nuevo, Usado, En prestamo" name="estadoac" required>
    </div>
    <div class="form-group">
      <label for="ubicacionac">Ubicacion fisica del elemento:</label>
      <input type="text" class="form-control" id="ubicacionac" placeholder="Enter password" name="ubicacionac" required>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>

  
		<br>
	<div>
		<form action="${pageContext.request.contextPath}/Logout">
			<button class="btn  btn-sm btn-primary" type="submit">
			<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>Log out</button>
		</form>
	</div>
</b:base>
<log:exit/>