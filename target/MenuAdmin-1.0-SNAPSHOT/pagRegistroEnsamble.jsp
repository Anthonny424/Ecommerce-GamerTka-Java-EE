

<%@page import="modelo.Proveedor"%>
<%@page import="modelo.Producto"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="fondoRegistrar">
        <%
        Negocio obj = new Negocio();
        Producto p=obj.BuscarUltimoProducto();
        %>
        
        
        <div class="formulario">
        <form action="control"> 
            
                <h1>Registrar</h1>
                <input type="hidden" name="opc" value="14">
                
                <p>Precio: </p><input type="text" name="precio" required>
                <p>Nombre: </p><input type="text" name="nombre" required>
                <p>Descripcion: </p><input type="text" name="desc" required>
                <p>Modelo: </p><input type="text" name="modelo" required>
                <p>Garantia: </p><input type="text" name="garantia" required>
                  
                
             
                <p>IdProducto: </p><input type="text" name="idProducto" value="<%=p.getIdProducto()+1%>"readonly>
                <p>Stock: </p><input type="text" name="stock" required>
                <p>Tipo de proveedor: </p>
                <select name="selecciona">        
                    
                        <%
                         for(Proveedor x: obj.ListarProveedores()){
                        %>
                        <option value="<%=x.getIdProveedor()%>"><%=x.getNomEmpresa()%></option>
                  
                        <%
                         }
                        %>
                    </select>
                    
                <input type="submit" value="Enviar" class="btnRegis">
              
        </form>
        </div>
    </body>
</html>
