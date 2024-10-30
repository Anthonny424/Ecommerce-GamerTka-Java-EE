

<%@page import="dao.Negocio"%>
<%@page import="modelo.Empleado"%>
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
        Negocio obj= new Negocio();
        int id=Integer.parseInt(request.getParameter("id"));
        Empleado e=obj.BuscarEmpleado(id);
       
        %>
       
        <br>
        <div class="formulario" style="height: 60%;">
        <form action="control">
        
            <input type="hidden" name="opc" value="2">
            <h1>Editar</h1>
            <p>ID Empleado: </p><input type="text" name="id" value="<%=id%>" readonly>
            <p>Nombre: </p><input type="text" name="name" value="<%=e.getNombre()%>" required>        
            <p>Direccion: </p><input type="text" name="direccion" value="<%=e.getDireccion()%>" required>
            <p>Genero: </p><input type="text" name="genero" value="<%=e.getGenero()%>" required>
            <p>Edad: </p><input type="text" name="edad" value="<%=e.getEdad()%>" required>
            <p>CodeAdmin: </p><input type="text" name="idAdmin" value="1" readonly>
            <input type="submit" value="Enviar" class="btnEdit">

        </form>
       </div>
    </body>
</html>
