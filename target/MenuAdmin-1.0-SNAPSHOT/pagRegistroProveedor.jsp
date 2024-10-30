<%@page import="modelo.Proveedor"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <title>Admin</title>
    </head>
    <body class="fondoRegistrar">
        <div class="formulario" style="height: 60%;">
        <form action="control">
               <h1>Registrar</h1>
               <input type="hidden" name="opc" value="8"> 
               <p>Nombre de la Empresa: </p><input type="text"  name="nomEp" required >            
               <p>Direccion: </p><input type="text"  name="direcEp" required >   
               <p>Telefono: </p><input type="text"  name ="telfEp" required> 
               <p>Tipo de Producto: </p>
              
                <select name="tipoEp">
                 <%
                 Negocio obj = new Negocio();
                 for(Proveedor x: obj.ListarTiposDeProductos()){
                 %>   
                 <option value="<%=x.getTipoProducto()%>"><%=x.getTipoProducto()%></option>
                  
                 <%
                    }
                 %>
                </select>
                <p>IdAdmin: </p><input type="text" name="admin" value="1" readonly>
                <input type="submit" value="Enviar" class="btnRegis">
                            
            
        </form>
        </div>
    </body>
</html>