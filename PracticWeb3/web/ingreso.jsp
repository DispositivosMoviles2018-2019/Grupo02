<%-- 
    Document   : ingreso
    Created on : 03-oct-2018, 9:42:44
    Author     : Carlos Caiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de bienvenida</title>
    </head>
    <body>
    <center>
        <html:form action="/ingresar" method="POST">
            
            <html:text property="bandera" value="Bienvenido al sistema de consultas" size="35"></html:text>
            <p></p>
            <html:submit property="submit" value="Ingresar al sistema"></html:submit>
            
        </html:form>
    </center>
      
    </body>
</html:html>
