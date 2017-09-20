<%-- 
    Document   : personas
    Created on : 16/09/2017, 16:14:27
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de personas</h1>
        Usuario: <c:out value="${usuario}"/>
        <c:forEach items="${personas}" var="persona" > 
            <p>Nombre: <c:out value="${persona.nombre}"/></p>
        </c:forEach>
    </body>
</html>
