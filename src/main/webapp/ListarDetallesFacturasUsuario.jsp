

<%@page import="modelo.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    </head>
    <body style="
          background-image: url(https://oyster.ignimgs.com/mediawiki/apis.ign.com/little-nightmares-2/0/0d/IMG_3216.JPG);
          background-repeat: no-repeat;">
        <%
        Negocio obj = new Negocio(); 
        String nombre=(String)request.getAttribute("user");
        int idUser=(int)request.getAttribute("idUser");
        int idFactura=(int)request.getAttribute("idfactura");
        List<Compra> lis =(ArrayList)obj.ListarDetalleVenta(idFactura);
        %>
        <div class="navbar" style="width: 100%; top: 0px;">
            
                <div><img src="https://api.freelogodesign.org/assets/thumb/logo/d2c3e55812f3470aab7fe8bff8524420_400.png" class="logo"></div>
                <div><a href="Menu.jsp" class="opc">Inicio <i class="fa-solid fa-house-chimney"></i></a></div>
                <div><a href="control?opc=27&iduser=<%=idUser%>&name=<%=nombre%>" class="opc">Juegos <i class="fa-solid fa-gamepad"></i></a></div>
                <div><a href="control?opc=28&iduser=<%=idUser%>&name=<%=nombre%>" class="opc">Ensambles <i class="fa-solid fa-computer"></i></a></div>
                <div><a href="control?opc=25&iduser=<%=idUser%>&name=<%=nombre%>" class="opc">Ver carrito <i class="fa-solid fa-cart-shopping"></i></a></div>
                <div><a href="control?opc=34&iduser=<%=idUser%>&name=<%=nombre%>" class="opc">Ver Facturas <i class="fa-solid fa-rectangle-list"></i></a></div>
                <div><a href="" class="opc">Soporte <i class="fa-solid fa-gear"></i></a></div>
                <div class="buscar"><input type="text" id="txtnom" placeholder="Buscar"></div>
                <div class="loginadmin"><a href="LoginAdmin.jsp" class="opc"><i class="fa-solid fa-address-card"></i> <i class="fa-solid fa-caret-down"></i></a></div>
               
        </div>
        
       <div class="marco">
           
        <h2>Bienvenido: <%=nombre%> <i class="fa-solid fa-circle-user"></i></h2>  
        <br>
      </div>
        
      <div class="carrito" style="width: 80%;">
            <h1 style="color: white;">Detalle Factura <i class="fa-solid fa-cart-flatbed"></i></i></h1>
            <table class="tablacarro" style="color: white;">
            <thead>
                <tr><th>Id Detalle<th>Nombre Producto<th>Precio Producto<th>Cantidad<th>Id Producto  
            </thead>
            <%
            for(Compra x: lis){
              
            out.print("<tr><td>"+x.getIdCompra()+"<td>"+x.getNombreProducto()+"<td>"+x.getPrecioProducto()+"<td>"+x.getCantidadProducto()+"<td>"+x.getIdProducto());

            }
            
            %>
                    
            
                    
        </table>
        </div>  
    </body>
</html>
