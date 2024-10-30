

<%@page import="dao.Negocio"%>
<%@page import="modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="js/filtrarEmpleado.js" type="text/javascript"></script>
        <script src="js/bootstrapValidator.js" type="text/javascript"></script>
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
        
        <div class="cabezatabla">
        <h1>Listado de Empleados</h1>
        <br>
        <input type="text" id="txtnom" placeholder="Ingrese nombre">
        </div>
        <br>
           <a href="pagRegistroEmpleado.jsp" class="btnRegistro" style="position: relative;
              left: 300px;
              top: 24px;
              font-family: arial;
              font-weight: bold;">Registrar empleado</a>
        <br>
        <div class="tablaResultado" id="tablaResultado">
        <%
        Negocio obj = new Negocio();
        %>
        <table>
            <thead
                <tr><th>ID<th>Nombre<th>Direccion<th>Genero<th>Edad<th>Foto<th>Editar<th>Delete<th>Ver clientes
            </thead>
            <%
            
            for(Empleado e:obj.ListarEmpleado()){
            out.print("<tr><td>"+e.getIDEmpleado()+"<td>"+e.getNombre()+"<td>"+e.getDireccion()+"<td>"+e.getGenero()+"<td>"+e.getEdad());
            
                %>
                <td><img src="fotos/<%=e.getIDEmpleado()%>.jpg" width="70" height="70" onerror="src='https://us.123rf.com/450wm/ahasoft2000/ahasoft20001706/ahasoft2000170602203/79919679-icono-de-vector-de-persona-desconocida-símbolo-gris-plana-pictogram-está-aislado-en-un-fondo.jpg?ver=6'">
                <td><a href="pagEditEmpleado.jsp?id=<%=e.getIDEmpleado()%>" class="edit">Editar</a>
                <td><a href="control?opc=3&id=<%=e.getIDEmpleado()%>" class="delete">Eliminar</a>
                <td><a href="control?opc=18&id=<%=e.getIDEmpleado()%>" class="cascada">Ver clientes</a>
                <%
                }
                %>
            
            
        </table>                
        </div>
    </body>
</html>
