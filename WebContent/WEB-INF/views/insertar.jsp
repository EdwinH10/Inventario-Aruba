<log:setLogger logger="Controlador.Insertar" />
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
	
	<h2>Llena los campos del registro a insertar</h2>
  <form action=${pageContext.request.contextPath}/Insertar method="post">
    <div class="form-group">
      <label for="elementoin">Elemento:</label>
      <input type="text" class="form-control" id="elementoin" placeholder="Ejemplo: Switch core" name="elementoin" required>
    </div>
    <div class="form-group">
      <label for="serialin">Numero de serie:</label>
      <input type="text" class="form-control" id="serialin" placeholder="Ejemplo: CNX40532J1" name="serialin" required>
    </div>
    <div class="form-group">
      <label for="partein">Numero de parte:</label>
      <input type="text" class="form-control" id="partein" placeholder="Ejemplo: JW901X" name="partein" required>
    </div>
    <div class="form-group">
      <label for="estadoin">Estado del elemento:</label>
      <input type="text" class="form-control" id="estadoin" placeholder="Ejemplo: Nuevo, Usado, En prestamo" name="estadoin" required>
    </div>
    <div class="form-group">
      <label for="ubicacionin">Ubicacion fisica del elemento:</label>
      <input type="text" class="form-control" id="ubicacionin" placeholder="Enter password" name="ubicacionin" required>
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
