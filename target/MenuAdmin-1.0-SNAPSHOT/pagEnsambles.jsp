

<%@page import="modelo.Ensamble"%>
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
            <%
        Negocio obj = new Negocio();
        %>
        <h1>Listado de Ensambles</h1>
        <br>
        <a href="pagRegistroEnsamble.jsp" class="btnRegistro">Registrar Ensamble</a>
        <br>
        <table>
            <thead
                <tr><th>Código<th>Precio<th>Nombre<th>Descripción del ensamble<th>Modelo<th>Garantia<th>Foto<th>Editar<th>Delete
            </thead>
           <%
           for(Ensamble x: obj.ListarEnsambles()){
            out.print("<tr><td>"+x.getIdEnsamble()+"<td>"+x.getPreEnsamble()+"<td>"+x.getNomEnsamble()+"<td>"+x.getDescEnsamble()+"<td>"+x.getModelo()+"<td>"+x.getGarantia());
            %>
            <td><img src="fotos/<%=x.getNomEnsamble()%>.jpg" onerror="src='https://previews.123rf.com/images/siirol/siirol1107/siirol110700002/9982520-signo-de-interrogación-en-una-computadora-portátil.jpg'" style="width: 70px;
                 height: 70px;">
           
           <td><a href="pagEditEnsamble.jsp?id=<%=x.getIdEnsamble()%>" class="edit">Editar</a>
           <td><a href="control?opc=16&id=<%=x.getIdEnsamble()%>" class="delete">Eliminar</a>
           <%
           }
           %>
            
            
        </table>                
        </div>
    </body>
</html>
