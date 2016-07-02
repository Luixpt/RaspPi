<%-- 
    Document   : WS_server
    Created on : Jun 29, 2016, 8:56:36 PM
    Author     : lfranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Service - Servidor</title>
    </head>
    <body>
        <h1>SERVER - Recebe STRING do Raspberry Pi!!!</h1>
        
        <form action="resultado_ws_1.jsp" method="post">
        <%
        String rfcode;%> 
        RF Code:<input type="text" name="rfcode" />
        <input type="submit" name="botao-ok" value="Enviar">
        
        </form>
    </body>
</html>
