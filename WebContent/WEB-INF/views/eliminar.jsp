<log:setLogger logger="Controlador.Eliminar" />
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
	
	<h2>Llena el campo solicitado</h2>
  <form action=${pageContext.request.contextPath}/Eliminar method="post">
    <div class="form-group">
      <label for="idel">ID del registro a eliminar (lo puedes revisar en la pestaña de Consulta):</label>
      <input type="text" class="form-control" id="idel" placeholder="Ejemplo: 21" name="idel" required>
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