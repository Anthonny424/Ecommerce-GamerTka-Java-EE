

<%@page import="modelo.Juegos"%>
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
        Negocio obj= new Negocio();
        int id=Integer.parseInt(request.getParameter("id"));
        Juegos j=obj.BuscarJuego(id);
       
        %>
        <div class="formulario">
        <form action="control">
            <h1>Editar</h1>
            <input type="hidden" name="opc" value="6">
            <p>Id Juego: </p><input type="text" name="id" value="<%=id%>" readonly>
            <p>Categoria: </p><input type="text" name="cat" value="<%=j.getCategoria()%>" required>        
            <p>Nombre: </p><input type="text" name="nombre" value="<%=j.getNomJuego()%>" required>
            <p>Descripcion: </p><input type="text" name="desc" value="<%=j.getDescJuego()%>" required>
            <p>Precio: </p><input type="text" name="precio" value="<%=j.getPrecio()%>" required>
            <p>Año Lanzamiento: </p><input type="text" name="lanza" value="<%=j.getAnioLanza()%>" required>
            <p>IdProducto: <td><input type="text" name="idProducto" value="<%=j.getIdProducto()%>" readonly>
            
            <input type="submit" value="Enviar" class="btnEdit">
            
            
            
        
        </form>
        </div>
    </body>
</html>
