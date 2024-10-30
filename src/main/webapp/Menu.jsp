

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Empleado"%>
<%@page import="dao.Negocio"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale-1,0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="theme-color" content="#0099ff">
        <link href="css/GTKA.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="HTML/2.ico.ico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>GamerTka</title>
    </head>
    <body>
       <%
        Negocio obj= new Negocio();
        %>
        
        <div class="container">
        <div class="menu">
            <nav>
                <ul>
                    <li><a href="About me" class="link">Nosotros</a></li>
                    <li><a href="control?opc=36" class="link">Juegos</a></li>
                    <li><a href="control?opc=37" class="link" >Ensambles</a></li>
                    <li><a href="news.html" class="link">Noticias</a></li>
                    <li><a href="#" class="link" id="iniciarSesionBtn">Inicio Sesion</a></li>
                </ul>
            </nav>
        </div>

        <div id="modalInicioSesion" class="modal">
            <div class="modal-content">
                <span class="close" id="cerrarModal">✖️</span>
                <div class="containerLogin" id="container">
                    <div class="form-containerLogin sign-up">
                        <form class="FormLogin" action="control" method="post">
                            <h1>Registro</h1>
                            <input type="hidden" name="opc" value="32">
                            <input type="text" name="txtnom" placeholder="Nombre" required>
                            <input type="text" name="txtapellido" placeholder="Apellido" required>
                            <div class="radio-buttons">
                                <input type="radio" name="genero" value="M" id="masculino">
                                <label for="masculino">Masculino</label>
                                <input type="radio" name="genero" value="F" id="femenino">
                                <label for="femenino">Femenino</label>
                            </div>

                            <input type="email" name="txtcorreo" placeholder="Correo" required>                       
                            <input type="password" name="pass" placeholder="Contraseña" required>
                            <input type="text" name="txtdni" placeholder="DNI" required>
                            <input type="number" name="txtedad" placeholder="Edad" required>
                            <input type="text" name="txtdireccion" placeholder="Dirección" required>
                            <select name="empleadoCombo">
                               <%
                                for(Empleado x: obj.ListarEmpleado()){
                               %>
                            <option value="<%=x.getIDEmpleado()%>"><%=x.getNombre()%></option>        
                            <%
                            }
                            %>   
                            </select>
                            <input type="submit" value="Registrarse" class="btnRegistrar">
                        </form>
                    </div>
                    
                    <div class="form-containerLogin sign-in">
                        <form class="FormLogin" action="control" method="post">
                            <h1>Iniciar Sesion</h1>
                            <input type="hidden" name="opc" value="23">
                            <input type="text" name="user" placeholder="Usuario" required>
                            <input type="password" name="pass" placeholder="Contraseña" required>
                            <input type="submit" value="Entrar" class="btnLogin">
                        </form>
                    </div>
                    
                    <div class="toggle-containerLogin">
                        <div class="toggle">
                            <div class="toggle-panel toggle-left">
                                <h1>¡Hola!</h1>
                                <p>Registrate para beneficiarte de las funciones del sitio</p>
                                <button class="hidden" id="login">Tengo cuenta</button>
                            </div>
                            <div class="toggle-panel toggle-right">
                                <h1>Bienvenido de vuelta!</h1>
                                <p>Ingresa tus datos personales para utilizar las funciones del sitio</p>
                                <button class="hidden" id="register">No tengo una cuenta</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <h1>GamerTka </h1>
        <h2>Explora || Tu mundo</h2>
        <p>"En GamerTka, hemos unido nuestra pasión por los videojuegos con la comodidad de
            las compras en línea para brindarte una experiencia de compra única. Nuestro compromiso es ofrecerte acceso
            a una
            amplia gama de títulos, desde clásicos legendarios hasta los lanzamientos más esperados, todo en un solo
            lugar. Como jugadores
            apasionados nosotros mismos, entendemos tus necesidades y deseos, y estamos aquí para satisfacerlos."</p>
    </div>

    <div class="container second">
        <h1>Juegos Exclusivos </h1>
        <div class="box">
            <span style="--i:1;"><img src="fotos/CSGO.jpg" alt=""></span>
            <span style="--i:2;"><img src="fotos/Cyberpunk2077.jpg" alt=""></span>
            <span style="--i:3;"><img src="fotos/Elden Ring.jpg" alt=""></span>
            <span style="--i:4;"><img src="fotos/FIFA 23.jpg" alt=""></span>
            <span style="--i:5;"><img src="fotos/GTAV.jpg" alt=""></span>
            <span style="--i:6;"><img src="https://gmedia.playstation.com/is/image/SIEPDC/god-of-war-ragnarok-store-art-01-10sep21$en" alt=""></span>
            <span style="--i:7;"><img src="fotos/Minecraft.jpg" alt=""></span>
            <span style="--i:8;"><img src="fotos/Ark Survival Evolved.jpg" alt=""></span>
        </div>

    </div>


    <div class="container tree">
        <h1 style="position: relative; bottom: 120px;">Ensambles de pc gamer </h1>
        <div class="box" style="position: relative; top: 130px;">
            <span style="--i:1;"><img src="fotos/PC basica.jpg" alt=""></span>
            <span style="--i:2;"><img src="fotos/PC gama alta.jpg" alt=""></span>
            <span style="--i:3;"><img src="fotos/PC gama baja.jpg" alt=""></span>
            <span style="--i:4;"><img src="fotos/PC gama media.jpg" alt=""></span>
            <span style="--i:5;"><img src="fotos/PC para streaming.jpg" alt=""></span>
            <span style="--i:6;"><img src="fotos/PC para diseño.jpg" alt=""></span>

        </div>
    </div>

    <div class="blank">
        <div class="footerContainer">
            <div class="wrapper">
                <a class="hover-fx" href=""><i class="fa-brands fa-facebook"></i></a>
                <a class="hover-fx-1" href=""><i class="fa-brands fa-instagram"></i></a>
                <a class="hover-fx-2" href=""><i class="fa-brands fa-twitter"></i></a>
                <a class="hover-fx-3" href=""><i class="fa-brands fa-youtube"></i></a>
            </div>

            <div class="footerNav">
                <ul>
                    <li><a href="">Menú</a></li>
                    <li><a href="">Ofertas</a></li>
                    <li><a href="">Acerca de nosotros</a></li>
                    <li><a href="">Contáctanos</a></li>
                    <li><a href="">Nuestro Equipo</a></li>
                </ul>
            </div>
            <div class="footerBottom">
                <p>CopyRight &copy;2023; Designed by<span class="designer">GamerTka</span></p>
            </div>
        </div>


    </div>
    
    <script src="js/script.js" type="text/javascript"></script>
    </body>
</html>
