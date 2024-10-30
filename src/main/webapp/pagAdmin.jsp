

<%@page import="modelo.*"%>
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
    <body style="background-color: #F3EFF1">
        
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
        <br>
        <div class="dashboard">
            <div class="datosgenerales">
                
                <div class="general" style="border-radius: 0px 20px 20px 0px;
                                            border: 8px #1C9FF4 solid;
                                            border-bottom: none;
                                            border-right: none;
                                            border-top: none;">
                    <%
                    Negocio obj= new Negocio();
                    Factura f = obj.TotalMontoFacturas();
                    %>
                    <h2>Ganancia total</h2>
                    <p>Monto: <%=f.getMonto()%></p>
                </div>
                <div class="general" style="border-radius: 0px 20px 20px 0px;
                                            border: 8px #F4AC1C solid;
                                            border-bottom: none;
                                            border-right: none;
                                            border-top: none;">
                    <%
                    Producto p =obj.TotalProductos();
                    %>
                    <h2>Total productos</h2>
                    <p>Cantidad: <%=p.getStock()%></p>
                </div>
                <div class="general" style="border-radius: 0px 20px 20px 0px;
                                            border: 8px #18C21B solid;
                                            border-bottom: none;
                                            border-right: none;
                                            border-top: none;">
                    <%
                    Cliente c = obj.TotalCliente();
                    %>
                    <h2>Total clientes</h2>
                    <p>Cantidad: <%=c.getIdCliente()%></p>
                </div>
                <div class="general" style="border-radius: 0px 20px 20px 0px;
                                            border: 8px #CD1756 solid;
                                            border-bottom: none;
                                            border-right: none;
                                            border-top: none;">
                    <%
                    Empleado e = obj.TotalEmpleado();
                    %>
                    <h2>Total empleados</h2>
                    <p>Cantidad: <%=e.getIDEmpleado()%></p>
                </div>
            </div>
            <div class="flex">
            <iframe src="GraficoFacturas.jsp" class="grafico"></iframe>
            <iframe src="GraficoFacturas2.jsp" class="grafico"></iframe>
            <iframe src="GraficoJuegos.jsp" class="grafico"></iframe>
            <iframe src="GraficoEnsambles.jsp" class="grafico"></iframe>
            </div>
        </div>
    </body>
</html>
