

<%@page import="modelo.Ensamble"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="js/filtrarEnsambles.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body style="
          background-image: url(https://i.pinimg.com/originals/4b/cd/6b/4bcd6b314a8bba1f278bb12315bcf8cb.jpg);
          background-repeat: repeat;">
        <%
        Negocio obj = new Negocio();     
        String nombre=(String)request.getAttribute("user");
        int idUser=(int)request.getAttribute("idUser");
        %>
        <div class="navbar" style="width: 100%;">
            
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
         
            <h2>Bienvenido: <%=nombre%>  <i class="fa-solid fa-circle-user"></i></h2>  
 
        </div>   
        <div class="tarjetas" style="width: 80%;" id="tablares">
           <%
           for(Ensamble x: obj.ListarEnsambles()){
           %>
           <form action="control">
               <input type="hidden" name="opc" value="30">
               <input type="hidden" name="idprod" value="<%=x.getIdProducto()%>">
               <input type="hidden" name="idensamble" value="<%=x.getIdEnsamble()%>">
               <input type="hidden" name="iduser" value="<%=idUser%>">
               <input type="hidden" name="name" value="<%=nombre%>">
                  
               
            <div class="card" style="width: 18rem; height: 500px; border-color: #051932; margin-bottom: 10px;">
                
                <img src="fotos/<%=x.getNomEnsamble()%>.jpg" class="card-img-top hover" onerror="src='https://play-lh.googleusercontent.com/xTAR-qIdqOBZJzQhx1IJsJgMc0kVsNGnxG-LdqVnuOgibZpqFwmKh6DcTeiuXBWCwcw=w240-h480-rw'" data-tilt data-tilt-scale="1.1">
                
                <div class="card-body" style="background-color: #1F4575; color: white;">
                    <h5 class="card-title"><%=x.getNomEnsamble()%></h5>
                    <p class="card-text">Precio: S/ <%=x.getPreEnsamble()%></p>
                    <p class="card-text">Garantía: <%=x.getGarantia()%> meses</p>
                    <p class="card-text">Cantidad: <input type="text" name="txtcant" value="1"></p>
                    
                    <a href="pagDetalleEnsamble.jsp?idprod=<%=x.getIdProducto()%>&idUser=<%=idUser%>&user=<%=nombre%>" class="btnLupa" style="bottom: -37px;"><i class="fa-solid fa-magnifying-glass"></i></a>
                    <input type="submit" value="Añadir al carrito" class="btn btn-primary">
                </div>
            </div>
           </form>
           <%
           }
           %>   
        </div>
        <script src="js/vanilla-tilt.min.js" type="text/javascript"></script>
    </body>
</html>
