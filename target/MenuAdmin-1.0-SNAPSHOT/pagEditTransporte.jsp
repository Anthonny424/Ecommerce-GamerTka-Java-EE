

<%@page import="modelo.Transporte"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="fondoEdit">
        <%
        Negocio obj = new Negocio();
        int id=Integer.parseInt(request.getParameter("id"));
        Transporte t = obj.BuscarTransporte(id);
        %>
        <div class="formulario" style="height: 50%;">
        <form action="control" method="post">
                <h1>Editar</h1>
                <input type="hidden" name="opc" value="12">
                <p>Id Transporte: </p><input type="text" name="id" value="<%=id%>" readonly>
                <p>Nombre Conductor: </p><input type="text" name="txtNom" value="<%=t.getNomConductor()%>" required>
                <p>Placa: </p><input type="text" name="txtPlaca" value="<%=t.getPlaca()%>" required>
                <p>Tipo de Transporte: </p><input type="text" name="txtTrans" value="<%=t.getTipoTrans()%>" required>
                <input type="submit" value="Enviar" class="btnEdit">
          
            
        </form>
        </div>
    </body>
</html>
