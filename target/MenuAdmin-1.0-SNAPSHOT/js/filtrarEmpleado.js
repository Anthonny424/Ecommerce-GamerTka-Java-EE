
$(document).ready(function () {  
   //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtnom',function(){ 
        let valor = $(this).val();  
             listado(valor);  
         
    });  
     
   function listado(consulta) {  
        opc = "21";  
        $.get("control", {opc, consulta}, (response) => {  
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";  
             console.log(misDatos);  
             
           template += `  
                <table>
                <thead
                <tr><th>ID<th>Nombre<th>Direccion<th>Genero<th>Edad<th>Foto<th>Editar<th>Delete<th>Ver clientes
                </thead>  
                                    <tbody>`;    
            misDatos.forEach(midato => {  
                template += `  
                <tr>  
                <td>${midato.IDEmpleado}</td>  
                    <td>${midato.nombre}</td>  
                    <td>${midato.direccion}</td> 
                   <td>${midato.genero}</td> 
                   <td>${midato.edad}</td> 
                    <td><img src="fotos/${midato.IDEmpleado}.jpg" width="70" height="70" 
                        onerror="src='https://us.123rf.com/450wm/ahasoft2000/ahasoft20001706/ahasoft2000170602203/79919679-icono-de-vector-de-persona-desconocida-símbolo-gris-plana-pictogram-está-aislado-en-un-fondo.jpg?ver=6'" ></td>
                    
                    <td><a href="pagEditEmpleado.jsp?id="${midato.IDEmpleado}" class="edit">Editar</a>
                    <td><a href="control?opc=3&id="${midato.IDEmpleado}" class="delete">Eliminar</a>
                    <td><a href="control?opc=18&id="${midato.IDEmpleado}" class="cascada">Ver clientes</a>

                `;              
                  
            })  
            template += `</tbody></table>`;  
            $("#tablaResultado").html(template);  
  
        })  
    } //fin de listado 
     
}) 
    