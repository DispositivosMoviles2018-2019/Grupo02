<%-- 
    Document   : categoria
    Created on : 03-oct-2018, 9:42:18
    Author     : Carlos Caiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page import="java.util.*, controladores_form.* " %>
<!DOCTYPE html>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de los codigos de categoria </h1>
       
         Ingrese categoría: <html:text name="categoria1form" property="codigo_cat" value="" ></html:text>
        <html:form action="/listado" method="post">
            
            <html:select property="codigo_cat">
                <html:options name="categoriaform" property="codigocategoria" />                
            </html:select>
            
            <html:submit value="Mostrar Listado de productos"/>
            
        </html:form>
        
    </body>
</html:html>
