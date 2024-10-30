
$(document).ready(function () {  
   //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtnom',function(){ 
        let valor = $(this).val();  
             listado(valor);  
         
    });  
     
   function listado(consulta) {  
        opc = "20";  
        $.get("control", {opc, consulta}, (response) => {  
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";  
             console.log(misDatos);  
            
           template+=`
          
            <table>
            <thead
                <tr><th>ID<th>Nombre<th>Apellido<th>Sexo<th>DNI<th>Edad<th>Direccion<th>Correo<th>Delete<th>Ver Facturas
            </thead>
           <tbody>`;
            
            misDatos.forEach(midato => {  
                template += `  
                
                <tr>  
                <td>${midato.IdCliente}</td>  
                    <td>${midato.NombreCliente}</td>  
                    <td>${midato.ApellidoCliente}</td> 
                   <td>${midato.GeneroCliente}</td> 
                   <td>${midato.DNI}</td> 
                   <td>${midato.EdadCliente}</td>
                   <td>${midato.DireccionCliente}</td>
                   <td>${midato.CorreoCliente}</td>
                   <td><a href="control?opc=4&id=id" class="delete">Eliminar</a>
                   <td><a href="control?opc=17&id=id" class="cascada">Ver Facturas</a>
             
                    `; 
                                                  
                  
            })  
            template += `</tbody></table>`;  
            $("#tablaResultado").html(template);  
  
        })  
    } //fin de listado 
     
}) 
    