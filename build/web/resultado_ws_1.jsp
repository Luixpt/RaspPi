<%-- 
    Document   : resultado_ws_1
    Created on : Jun 29, 2016, 9:06:11 PM
    Author     : lfranco
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Service - Servidor - Resultado</title>
    </head>
    <body>
        <h1>Web Service - Servidor - Resultado</h1>
        <%
            
    
    try {
	ws.server.WSServer_Service service = new ws.server.WSServer_Service();
	ws.server.WSServer port = service.getWSServerPort();
	 // TODO initialize WS operation arguments here
         java.lang.String dadosrasp = request.getParameter("rfcode");
	// TODO process result here
	java.lang.String result = port.picagem(dadosrasp);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
