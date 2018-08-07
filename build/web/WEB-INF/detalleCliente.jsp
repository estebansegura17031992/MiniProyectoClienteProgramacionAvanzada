<%-- 
    Document   : detalleCliente
    Created on : Aug 7, 2018, 2:59:22 PM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${user.getNombre()}</h1>
        <br />
        <p>Id: ${user.getIdUser()}</p>
        <p>Email: ${user.getEmail()}</p>
        <p>Password: ${user.getPassword()}</p>
    </body>
</html>
