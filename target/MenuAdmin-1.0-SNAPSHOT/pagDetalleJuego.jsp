

<%@page import="modelo.Juegos"%>
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
    <body style="
          background-image: url(https://i.pinimg.com/originals/4b/cd/6b/4bcd6b314a8bba1f278bb12315bcf8cb.jpg);
          background-repeat: repeat;">
        <%
        Negocio obj = new Negocio();
        String nombre=request.getParameter("user");
        int idUser=Integer.parseInt(request.getParameter("idUser"));
        int idProducto=Integer.parseInt(request.getParameter("idprod"));
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
            <br>
        </div> 
            
            <%
            Juegos x= obj.ListarDetalleJuego(idProducto);
            %>
        <form action="control" method="post">  
            
               <input type="hidden" name="opc" value="24">
               <input type="hidden" name="idprod" value="<%=idProducto%>">
               <input type="hidden" name="idjuego" value="<%=x.getIdJuego()%>">
               <input type="hidden" name="iduser" value="<%=idUser%>">
               <input type="hidden" name="name" value="<%=nombre%>">
            
            
        <div class="detalleart">
            <div class="imgDetalle">
                <img src="fotos/<%=x.getNomJuego()%>.jpg" width="400" height="400" data-tilt data-tilt-scale="1.2">
                <div class="PodriaInteresarte">
                    <%
                    for(Juegos y: obj.ListarJuegosRandom()){
                    %>
                    
                    <div class="card" style="width: 10rem; height: 85%; background-color: white; margin-top: 40px;">
                        <img class="card-img-top" src="fotos/<%=y.getNomJuego()%>.jpg" alt="Card image cap" style="border-radius: 5px;">
                        <div class="card-body">
                            <h5 class="card-title"><%=y.getNomJuego()%></h5>
                            <p class="card-text">Precio: S/ <%=y.getPrecio()%></p>
                            <a href="pagDetalleJuego.jsp?idprod=<%=y.getIdProducto()%>&idUser=<%=idUser%>&user=<%=nombre%>"" class="btn btn-primary">Ver</a>
                        </div>
                    </div>
                    <%
                     }
                    %>
                </div>
                    
                
            </div>
            <div class="infoDetalle">
                <h1><%=x.getNomJuego()%></h1>
                <div class="CaracteristicasProducto">
                <label><b>Categoría: </b><%=x.getCategoria()%></label>
                <br>
                <label><b>Año Lanzamiento: </b><%=x.getAnioLanza()%></label>
                <br>
                <label><b>Id Juego: </b><%=x.getIdJuego()%></label>
                <br>                
                </div>
                
                
                <div class="DescripcionProducto">
                    <p><b>Descripción: </b><%=x.getDescJuego()%></p>
                    <br>
                    <p><b>Stock: </b><%=x.getStock()%> unidades</p>
                </div>
                
                <div class="Precio">
                    <h2>Precio unidad: S/ <%=x.getPrecio()%></h2>
                <input type="number" min="1" max="9" step="1" value="1" name="txtcant">
                <input type="submit" value="Agregar al Carrito" class="btn btn-primary">
                </div>
            </div>
            
        </div> 
        </form>

            <script src="js/vanilla-tilt.min.js" type="text/javascript"></script>
    </body>
</html>
