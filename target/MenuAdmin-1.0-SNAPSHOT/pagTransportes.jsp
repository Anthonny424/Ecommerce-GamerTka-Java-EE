

<%@page import="modelo.Transporte"%>
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
        <h1>Listado de Transportes</h1>
        <br>
        <a href="pagRegistroTransporte.jsp" class="btnRegistro">Registrar Transporte</a>
        <br>
         <table>
            <thead>
                <tr>
                    <th>Id Tranporte</th>
                    <th>Conductor</th>
                    <th>Placa</th>
                    <th>Tipo de transporte</th>
                    <th>Foto</th>
                    <th>Editar</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <%
                for (Transporte x : obj.ListarTransportes()) {
            %>
            <tr>
                <td><%=x.getIdTransporte()%></td>
                <td><%=x.getNomConductor()%></td>
                <td><%=x.getPlaca()%></td>
                <td><%=x.getTipoTrans()%></td>
                <td><img src="fotos/<%=x.getTipoTrans()%>.jpg" height="100" width="100" class="img-circle" onerror="src='fotos/sin_foto.jpg'"/></td>
                <td><a href="pagEditTransporte.jsp?id=<%=x.getIdTransporte()%>" class="edit">Editar</a></td>
                <td><a href="control?opc=13&id=<%=x.getIdTransporte()%>" class="delete">Eliminar</a></td>  
            </tr>
            <%
                }
            %>
        </table>              
        </div>
    </body>
</html>
