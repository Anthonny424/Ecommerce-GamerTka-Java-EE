$(document).ready(function () {  
   //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtnom',function(){ 
        let valor = $(this).val();  
             listado(valor);  
         
    });  
     
   function listado(consulta) {  
        opc = "39";  
        $.get("control", {opc, consulta}, (response) => {  
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";  
            var idUser="<%=idUser%>";
            var nombre="<%=nombre%>";
             console.log(misDatos);  
             
               
            misDatos.forEach(midato => {  
                template += `  
                <form action="control">
               <input type="hidden" name="opc" value="30">
               <input type="hidden" name="idprod" value="${midato.idProducto}">
               <input type="hidden" name="iduser" value="${idUser}">
               <input type="hidden" name="name" value="${nombre}">
                  
               
            <div class="card" style="width: 18rem; height: 500px; border-color: #051932; margin-bottom: 10px;">
                
                <img src="fotos/${midato.nomEnsamble}.jpg" class="card-img-top hover" onerror="src='https://play-lh.googleusercontent.com/xTAR-qIdqOBZJzQhx1IJsJgMc0kVsNGnxG-LdqVnuOgibZpqFwmKh6DcTeiuXBWCwcw=w240-h480-rw'" data-tilt data-tilt-scale="1.1">
                
                <div class="card-body" style="background-color: #1F4575; color: white;">
                    <h5 class="card-title">${midato.nomEnsamble}</h5>
                    <p class="card-text">Precio: S/ ${midato.preEnsamble}</p>
                    <p class="card-text">Garantía: ${midato.garantia} meses</p>
                    <p class="card-text">Cantidad: <input type="text" name="txtcant" value="1"></p>
                    
                    <a href="pagDetalleEnsamble.jsp?idprod=${midato.idProducto}&idUser=${idUser}&user=${nombre}" class="btnLupa" style="bottom: -37px;"><i class="fa-solid fa-magnifying-glass"></i></a>
                    <input type="submit" value="Añadir al carrito" class="btn btn-primary">
                </div>
            </div>
           </form>
                `;              
                  
            })  
              
            $("#tablares").html(template);  
  
        })  
    } //fin de listado 
     
}) 


