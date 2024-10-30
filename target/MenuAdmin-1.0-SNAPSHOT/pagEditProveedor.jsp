<%@page import="dao.Negocio"%>
<%@page import="modelo.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <title>Admin</title>
    </head>
    <body class="fondoEdit">
        <% 
         Negocio obj = new Negocio();
         int id = Integer.parseInt(request.getParameter("codePro"));
         Proveedor p = obj.BuscarProveeedor(id);
        %>
        <div class="formulario" style="height: 60%;">
        <form action="control">
        
            <h1>Editar</h1>
            <input type="hidden" name="opc" value="10"> 
            <p>Codigo Proveedor: </p><input type="text" name="codPro" value="<%=id%>" readonly>
            <p>Nombre de la Empresa: </p><input type="text" name="nomPro" value="<%=p.getNomEmpresa()%>" required>
            <p>Direccion: </p><input type="text"  name="direcEp" value="<%=p.getDirecProve()%>" required>
            <p>Telefono: </p><input type="text"  name ="telfEp" value="<%=p.getTelefono()%>" required>
            <p>Tipo de Producto: </p><input type="text"  name ="tipoEp" value="<%=p.getTipoProducto()%>" required>
            <p>codAdmin: </p><input type="text" name="admin" value="<%=p.getIdAdmin()%>" readonly>   
            <input type="submit" value="Enviar" class="btnEdit">  
      
        
        
        </form>
        </div>
    </body>
</html>