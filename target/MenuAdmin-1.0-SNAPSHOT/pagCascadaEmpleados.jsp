

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.Negocio"%>
<%@page import="modelo.*"%>
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
        <div class="tablaResultado" style="
             width: 1160px;
             height: 900px;
             display: flex;
             ">
            <%
            List<Cliente> lis = (ArrayList)request.getAttribute("lista");
            
            %>
        <h1>Listado de clientes según empleado</h1>
        <br>
        <a href="pagEmpleados.jsp" class="volver">Volver</a>
        <br>
        <table>
            <thead
                <tr><th>Id Cliente<th>Nombre<th>Apellido<th>Sexo<th>DNI<th>Edad<th>Direccion<th>Correo<th>Ver Facturas
            </thead>
            <%
            
            for(Cliente c: lis){
            out.print("<tr><td>"+c.getIdCliente()+"<td>"+c.getNombreCliente()+"<td>"+c.getApellidoCliente()+"<td>"
            +c.getGeneroCliente()+"<td>"+c.getDNI()+"<td>"+c.getEdadCliente()+"<td>"+c.getDireccionCliente()+"<td>"+c.getCorreoCliente());
            
                %>
                <td><a href="control?opc=19&id=<%=c.getIdCliente()%>" class="cascada">Ver Facturas</a>
                <%
                }
                %>
            
            
        </table>                
        </div>
    </body>
</html>
