

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="fondoRegistrar">
        
        <br>
        <div class="formulario" style="height: 60%;">
        <form action="control">
            
                <input type="hidden" name="opc" value="1">
                <h1>Registrar</h1>
                <p>Nombre: </p><input type="text" name="name">
                <p>Direccion </p><input type="text" name="direccion">
                <p>Genero: </p><input type="text" name="genero">
                <p>Edad: </p><input type="text" name="edad">
                <p>CodeAdmin: </p><input type="text" name="idAdmin" value="1" readonly>
                
                <input type="submit" value="Enviar" class="btnRegis">
                
 
           
  
        </form>
        </div>
    </body>
</html>
