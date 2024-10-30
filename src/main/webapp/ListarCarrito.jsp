

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Compra"%>
<%@page import="modelo.Juegos"%>
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
          background-image: url(https://img.redbull.com/images/q_auto,f_auto/redbullcom/2020/12/10/xeaibwprofk0mib3wkdd/gaming-ghostrunner);
          background-repeat: repeat;
          ">
            
        <%
        Negocio obj = new Negocio();
        List<Compra> lis =(ArrayList)request.getAttribute("lista");
        String nombre=(String)request.getAttribute("user");
        int idUser=(int)request.getAttribute("idUser");
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
            <h1>Carrito de compras <i class="fa-solid fa-cart-shopping"></i></h1>
            <table class="tablacarro">
            <thead>
                <tr><th>Id Compra<th>Nombre Producto<th>Precio<th>Foto<th>Cantidad<th>Total<th>Delete  
            </thead>
            <%
            double total=0;
            double igv=0;
            for(Compra x: lis){
            out.print("<tr><td>"+x.getIdCompra()+"<td>"+x.getNombreProducto()+"<td>"+x.getPrecioProducto());
            %>
            <td><img src="fotos/<%=x.getNombreProducto()%>.jpg" style="
                     width: 80px;
                     height: 80px;
                     border-radius: 50%;">
                
              
            <%
            
            out.print("<td>"+x.getCantidadProducto()+"<td>"+x.getPrecioProducto()*x.getCantidadProducto());
            total=(x.getPrecioProducto()*x.getCantidadProducto()+total);
            %>
            <td><a href="control?opc=31&iduser=<%=idUser%>&name=<%=nombre%>&idcompra=<%=x.getIdCompra()%>" class="basura" align="center"><i class="fa-solid fa-trash"></i></a>
            <%
            }
            igv=total*0.18;
            %>
            <tr><td>IGV: <td colspan="6" align="left"><%=igv%>
            <tr><td>Total: <td  colspan="6" align="left"><%=total%>
            <tr><td colspan="7"><a href="control?opc=33&igv=<%=igv%>&total=<%=total%>&iduser=<%=idUser%>&name=<%=nombre%>" class="btnComprar">Comprar</a>
                    
        </table>
        </div>
        
        
        
        
        
        
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        
    </body>
</html>
