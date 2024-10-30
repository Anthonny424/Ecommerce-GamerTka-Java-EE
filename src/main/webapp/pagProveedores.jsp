

<%@page import="modelo.Proveedor"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
       
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="adminbarra" style="width: 14%;">
            <div class="opcadmin" style="text-align: center;">Menú Admin</div>
            <div class="opcadmin"><a href="pagAdmin.jsp"><i class="fa-solid fa-house"></i>Inicio</a></div>
            <div class="opcadmin"><a href="pagClientes.jsp"><i class="fa-solid fa-user"></i>Clientes</a></div>
            <div class="opcadmin"><a href="pagEmpleados.jsp"><i class="fa-solid fa-people-group"></i>Empleados</a></div>
            <div class="opcadmin"><a href="pagProveedores.jsp"><i class="fa-solid fa-address-card"></i>Proveedores</a></div>
            <div class="opcadmin"><a href="pagTransportes.jsp"><i class="fa-solid fa-truck-fast"></i></i>Transporte</a></div>
            <div class="opcadmin"><a href="pagJuegos.jsp"><i class="fa-solid fa-gamepad"></i>Juegos</a></div>
            <div class="opcadmin"><a href="pagEnsambles.jsp"><i class="fa-solid fa-desktop"></i>Ensambles</a></div>
            <div class="opcadmin"><a href="pagFacturas.jsp"><i class="fa-solid fa-file-lines"></i>Facturas</a></div>
            <div class="opcadmin"><a href="ListarAdministradores.jsp"><i class="fa-solid fa-user-secret"></i>Administradores</a></div>
            <div class="opcadmin"><a href="Menu.jsp"><i class="fa-solid fa-right-to-bracket"></i>Cerrar session</a></div>
            <img src="fotos/logo.png" class="pic">   
        </div>
        <div class="tablaResultado">
                        
        <h1>Listado de Proveedores</h1>
        <br>
        <a href="pagRegistroProveedor.jsp" class="btnRegistro">Registrar Proveedor</a>
        <br>
        <table>
            <%
            Negocio obj = new Negocio();
            %>
            <thead>
            <tr>
                    <th>Codigo</th>
                    <th>Nombre Empresa</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Tipo de Producto</th>
                    <th>Foto</th>
                    <th>Id Admin</th>
                    <th>Editar</th>
                    <th>Delete</th>
             </tr>
            </thead>
            <tbody>
               <%
                for (Proveedor p : obj.ListarProveedores()) {
                %>
                <tr>
                    <td><%= p.getIdProveedor()%></td>
                    <td><%= p.getNomEmpresa()%></td>
                    <td><%= p.getDirecProve()%></td>
                    <td><%= p.getTelefono()%></td>
                    <td><%= p.getTipoProducto()%></td>
                    <td><img src="fotos/<%= p.getNomEmpresa()%>.jpg" style="width: 70px;
                             height: 70px;" onerror="src='https://i0.wp.com/clubdefotografia.net/wp-content/uploads/2012/08/10.-What-Else-Could-I-Be-NYC-BW-Edit-Explored.jpg?resize=500%2C333&ssl=1'">
                    <td><%= p.getIdAdmin()%></td>
                    <td><a class="edit" href="pagEditProveedor.jsp?codePro=<%= p.getIdProveedor()%>">Editar</a></td>
                    <td><a class="delete" href="control?opc=9&codePro=<%= p.getIdProveedor()%>">Eliminar</a></td>
                </tr>
                <%
                }
                %>
                
                
            </tbody>
           
            
            
        </table>                
        </div>
    </body>
</html>
