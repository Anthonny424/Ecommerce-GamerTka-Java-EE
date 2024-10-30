
$(document).ready(function () {  
   //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtnom',function(){ 
        let valor = $(this).val();  
             listado(valor);  
         
    });  
     
   function listado(consulta) {  
        opc = "22";  
        $.get("control", {opc, consulta}, (response) => {  
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";  
             console.log(misDatos);  
             
           template += `  
             <table>
                    <thead
                    <tr><th>Id Factura<th>Fecha Factura<th>Monto<th>IGV<th>Id Cliente<th>Cliente
                    </thead>  
                                    <tbody>`;    
            misDatos.forEach(midato => {  
                template += `  
                <tr>  
                <td>${midato.IdFactura}</td>  
                    <td>${midato.FechaFac}</td>  
                    <td>${midato.Monto}</td> 
                   <td>${midato.FacIGV}</td> 
                   <td>${midato.IdCliente}</td> 
                    <td>${midato.NombreCliente}</td>
                    
                                </tr>`;              
                  
            })  
            template += `</tbody></table>`;  
            $("#tablaResultado").html(template);  
  
        })  
    } //fin de listado 
     
}) 
    