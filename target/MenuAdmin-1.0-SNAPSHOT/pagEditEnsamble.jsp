

<%@page import="modelo.Ensamble"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="fondoEdit">
        <%
        Negocio obj = new Negocio();
        int id=Integer.parseInt(request.getParameter("id"));
        Ensamble e=obj.BuscarEnsamble(id);
        %>
        <div class="formulario">
        <form action="control">
            
                <h1>Editar</h1>
                <input type="hidden" name="opc" value="15">
                <p>Id Ensamble: </p><input type="text" name="code" value="<%=id%>" readonly>
                <p>Precio Ensamble: </p><input type="text" name="precio" value="<%=e.getPreEnsamble()%>" required>
                <p>Nombre Ensamble: </p><input type="text" name="nombre" value="<%=e.getNomEnsamble()%>" required>
                <p>Descripcion Ensamble: </p><input type="text" name="desc" value="<%=e.getDescEnsamble()%>" required>
                <p>Modelo: </p><input type="text" name="modelo" value="<%=e.getModelo()%>" required> 
                <p>Garantia: </p><input type="text" name="garantia" value="<%=e.getGarantia()%>" required>
                <p>IdProducto: </p><input type="text" name="idProducto" value="<%=e.getIdProducto()%>" readonly>
                <input type="submit" value="Enviar" class="btnEdit">
                
            
        </form>
        </div>
    </body>
</html>
