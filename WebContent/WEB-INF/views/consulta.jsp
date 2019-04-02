<log:setLogger logger="Controlador.Consulta" />
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
	
	<div class="container">
		<h2>Inventario de Aruba</h2>
  <p>Actualizado a las </p>            
  <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Elemento</th>
        <th>Serial</th>
        <th>Parte</th>
        <th>Estado</th>
        <th>Ubicacion</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${inventario}" var="e">
    		<tr>
        		<td><c:out value="${e.id}"/></td>
        		<td><c:out value="${e.nombre}"/></td>
        		<td><c:out value="${e.serie}"/></td>
        		<td><c:out value="${e.parte}"/></td>
        		<td><c:out value="${e.estado}"/></td>
        		<td><c:out value="${e.ubicacion}"/></td>
      		</tr>
    	</c:forEach>
    </tbody>
  </table>
  
		<br>
		<form action="${pageContext.request.contextPath}/Logout">
			<button class="btn  btn-sm btn-primary" type="submit">
			<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>Log out</button>
		</form>
	</div>
</b:base>
<log:exit/>