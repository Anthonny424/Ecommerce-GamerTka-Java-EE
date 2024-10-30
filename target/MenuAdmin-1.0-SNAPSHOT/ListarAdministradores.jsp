


<%@page import="modelo.Admin"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
        <h1>Listado de Administradores</h1>
        <br>
        <div class="tarjetas" style="width: 83%;">
           <%
           for(Admin x: obj.ListarAdmin()){
           %>
            <div class="card" style="width: 18rem; background-color: lightgray;">
                <img src="fotos/<%=x.getAdminUser()%>.jpg" class="card-img-top" onerror="src='https://play-lh.googleusercontent.com/xTAR-qIdqOBZJzQhx1IJsJgMc0kVsNGnxG-LdqVnuOgibZpqFwmKh6DcTeiuXBWCwcw=w240-h480-rw'">
                <div class="card-body" style="background-color: white;">
                    <h5 class="card-title">AdminUser: <%=x.getAdminUser()%></h5>
                    <p class="card-text">Contraseña: <%=x.getPass()%></p>
                    <p class="card-text">Id: <%=x.getIdAdmin()%></p>
                    <a href="" class="btn btn-primary">Owner</a>
                </div>
            </div>
           <%
           }
           %>   
        </div>               
        </div>
    </body>
</html>
