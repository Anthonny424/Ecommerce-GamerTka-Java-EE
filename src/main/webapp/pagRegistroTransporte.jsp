

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="fondoRegistrar">
        
        <div class="formulario" style="height: 50%;">
    <form action="control" method="post">
            <h1>Registrar</h1>
            <input type="hidden" name="opc" value="11">
            <p>Nombre Conductor: </p><input type="text" name="txtNom">
            <p>Placa: </p><input type="text" name="txtPlaca">
            <p>Tipo Transporte: </p><input type="text" name="txtTrans">       
            <input type="submit" value="Enviar" class="btnRegis">
       
    </form>
        </div>
    </body>    
</html>
