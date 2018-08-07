<%-- 
    Document   : index.jsp
    Created on : Aug 7, 2018, 1:51:46 PM
    Author     : esteban
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${users}" var="user">
            <form method="POST" action="detalleCliente.htm">
                <c:out value="${user.getNombre()}"/>
                <input name="userId" type="text" value="${user.getIdUser()}" hidden>
                <button type="submit">Detalle</button>
            </form>
                
            <br />
      </c:forEach>
    </body>
</html>
