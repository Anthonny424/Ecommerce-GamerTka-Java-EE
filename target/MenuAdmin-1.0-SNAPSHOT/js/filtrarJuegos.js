
$(document).ready(function () {  
   //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtnom',function(){ 
        let valor = $(this).val();  
             listado(valor);  
         
    });  
     
   function listado(consulta) {  
        opc = "38";  
        $.get("control", {opc, consulta}, (response) => {  
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";  
            var idUser = `<%=idUser%>`;
            
             console.log(misDatos);  
             
              
            misDatos.forEach(midato => {  
                template += `  
                
                <form action="control">
               <input type="hidden" name="opc" value="24">
               <input type="hidden" name="idprod" value="${midato.idProducto}">
               <input type="hidden" name="iduser" value="${idUser}">
               
               
            <div class="card" style="width: 18rem; height: 450px; border-color: #051932; margin-bottom: 10px;">
                <article>
                <img src="fotos/${midato.NomJuego}.jpg" class="card-img-top" onerror="src='https://play-lh.googleusercontent.com/xTAR-qIdqOBZJzQhx1IJsJgMc0kVsNGnxG-LdqVnuOgibZpqFwmKh6DcTeiuXBWCwcw=w240-h480-rw'">
                <img src="fotos/${midato.NomJuego}.png" class="card-img-top">
                </article>
                <div class="card-body" style="background-color: #1F4575; color: white;">
                    <h5 class="card-title">${midato.NomJuego}</h5>
                    <p class="card-text">Categoría: ${midato.categoria}</p>
                    <p class="card-text">Precio: S/ ${midato.precio}</p>
                    <p class="card-text">Cantidad: <input type="text" name="txtcant" value="1"></p>
                    
                    <input type="submit" value="Añadir al carrito" class="btn btn-primary">
                    <a href="pagDetalleJuego.jsp?idprod=${midato.idProducto}" class="btnLupa"><i class="fa-solid fa-magnifying-glass"></i></a>
                    
                </div>
            </div>
            </form>    
              `;              
                  
            })  
             
            $("#tablares").html(template);  
  
        })  
    } //fin de listado 
     
}) 
