<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/base.jsp" %>
<%@ tag body-content="scriptless"
        trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="lang" type="java.lang.String" rtexprvalue="true"
              required="false" %>


<!DOCTYPE html>
<html lang="${not empty lang ? lang : 'en_US'}">
	<title>${title}</title>
    <head>
    	<link href="${pageContext.request.contextPath}/static/login.css" rel="stylesheet"> <!-- from https://getbootstrap.com/examples/signin/ -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title><c:out value="$(htmlTitle)" /></title>
    </head>
    <body>
        <jsp:doBody />
        
    </body>
</html>
