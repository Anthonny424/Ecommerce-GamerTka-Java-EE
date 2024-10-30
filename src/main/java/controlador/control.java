
package controlador;


import com.google.gson.Gson;
import dao.Negocio;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class control extends HttpServlet {
    Negocio obj=new Negocio();
    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    int op=Integer.parseInt(request.getParameter("opc"));
    if(op==1) adicionEmpleado(request, response);
    if(op==2) editarEmpleado(request, response);
    if(op==3) eliminarEmpleado(request, response);
    if(op==4) eliminarCliente (request, response);
    if(op==5) adicionJuego (request, response);
    if(op==6) editarJuego (request, response);
    if(op==7) eliminarJuego (request, response);
    if(op==8) adicionProveedor (request, response);
    if(op==9) eliminarProveedor (request, response);
    if(op==10) editarProveedor (request, response);
    if(op==11) adicionTransporte (request, response);
    if(op==12) editarTransporte (request, response);
    if(op==13) eliminarTransporte (request, response);
    if(op==14) adicionEnsamble (request, response);
    if(op==15) editarEnsamble (request, response);
    if(op==16) eliminarEnsamble (request, response);
    if(op==17) cascadaCliente (request, response);
    if(op==18) cascadaEmpleado (request, response);
    if(op==19) cascadaEmpleado2 (request, response);
    if(op==20) filtraCliente (request, response);
    if(op==21) filtraEmpleado (request, response);
    if(op==22) filtraFacturas (request, response);
    if(op==23) validarUsuario (request, response);
    if(op==24) añadirJuegoCarrito (request, response);
    if(op==25)  verTusCompras (request, response);
    if(op==26) validarAdmin (request, response);
    if(op==27) RedireccionarJuegos (request, response);
    if(op==28) RedireccionarEnsambles (request, response);
    if(op==29) RedireccionarIndex (request, response);
    if(op==30) añadirEnsambleCarrito (request, response);
    if(op==31) eliminarProductoCarrito (request, response);
    if(op==32) RegistrarCliente (request, response);
    if(op==33) Comprar (request, response);
    if(op==34) RedireccionarFacturas (request, response);
    if(op==35) RedireccionarDetalleFactura (request, response);
    if(op==36) VisitarJuegos (request, response);
    if(op==37) VisitarEnsambles (request, response);
    if(op==38) FiltraJuegos(request, response);
    if(op==39) FiltraEnsamble(request, response);
    }

    
    protected void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     int id=Integer.parseInt(request.getParameter("id"));
     String nombre=request.getParameter("name");
     String direccion=request.getParameter("direccion");
     String genero=request.getParameter("genero");
     int edad=Integer.parseInt(request.getParameter("edad"));
     int idAdmin=Integer.parseInt(request.getParameter("idAdmin"));
    
    Empleado e= new Empleado();
    e.setIDEmpleado(id);
    e.setNombre(nombre);
    e.setDireccion(direccion);
    e.setGenero(genero);
    e.setEdad(edad);
    e.setIdAdmin(idAdmin);
    
    obj.EditarEmpleado(e);
    
    request.getRequestDispatcher("pagEmpleados.jsp").forward(request, response);
    
    }
    
     protected void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        obj.AnularEmpleado(id);
        request.getRequestDispatcher("pagEmpleados.jsp").forward(request, response);
    }
    
     protected void adicionEmpleado(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     
     String nombre=request.getParameter("name");
     String direccion=request.getParameter("direccion");
     String genero=request.getParameter("genero");
     int edad=Integer.parseInt(request.getParameter("edad"));
     int idAdmin=Integer.parseInt(request.getParameter("idAdmin")); //FORANEA DEL ADMIN
     Empleado e = new Empleado();
     e.setNombre(nombre);
     e.setDireccion(direccion);
     e.setGenero(genero);
     e.setEdad(edad);
     e.setIdAdmin(idAdmin);
     obj.AdicionEmpleado(e);
     

     request.getRequestDispatcher("/pagEmpleados.jsp").forward(request, response);
    }
    
     
    
    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        obj.AnularCliente(id);
        request.getRequestDispatcher("/pagClientes.jsp").forward(request, response);
    } 
    
    
    protected void adicionJuego(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String categoria=request.getParameter("cat");
        String nombre=request.getParameter("nombre");
        String descripcion=request.getParameter("desc");
        double precio =Double.parseDouble(request.getParameter("precio"));
        int anioLanza = Integer.parseInt(request.getParameter("lanza"));
        
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int idProveedor = Integer.parseInt(request.getParameter("selecciona"));
        
             
        
        Producto p = new Producto();
        p.setStock(stock);
        p.setIdProveedor(idProveedor);
        
        
        Juegos j = new Juegos();
        j.setCategoria(categoria);
        j.setNomJuego(nombre);
        j.setDescJuego(descripcion);
        j.setPrecio(precio);
        j.setAnioLanza(anioLanza);
        j.setIdProducto(idProducto);
        
        obj.adicionarJuego(p, j);
        
      
        
        request.getRequestDispatcher("/pagJuegos.jsp").forward(request, response);
    } 
    
    protected void editarJuego(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     int id=Integer.parseInt(request.getParameter("id"));
     String categoria=request.getParameter("cat");
     String nombre=request.getParameter("nombre");
     String desc=request.getParameter("desc");
     double precio=Double.parseDouble(request.getParameter("precio"));
     int anio=Integer.parseInt(request.getParameter("lanza"));
     int idProducto=Integer.parseInt(request.getParameter("idProducto"));
    
    Juegos j= new Juegos();
    j.setIdJuego(id);
    j.setCategoria(categoria);
    j.setNomJuego(nombre);
    j.setDescJuego(desc);
    j.setPrecio(precio);
    j.setAnioLanza(anio);
    j.setIdProducto(idProducto);
    
    obj.EditarJuego(j);
    
    request.getRequestDispatcher("/pagJuegos.jsp").forward(request, response);
    
    }
    
    
    protected void eliminarJuego(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        obj.AnularJuego(id);
        request.getRequestDispatcher("/pagJuegos.jsp").forward(request, response);
    } 
  
    protected void adicionProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombEp = request.getParameter("nomEp");
        String direccion = request.getParameter("direcEp");
        int  telfEp = Integer.parseInt(request.getParameter("telfEp"));
        String tipoEp = request.getParameter("tipoEp");
        int idAdmin = Integer.parseInt(request.getParameter("admin"));
        
        
        Proveedor p = new Proveedor();
        p.setNomEmpresa(nombEp);
        p.setDirecProve(direccion);
        p.setTelefono(telfEp);
        p.setTipoProducto(tipoEp);
        p.setIdAdmin(idAdmin);
        obj.AgregarProveedores(p);
        
        
        request.getRequestDispatcher("/pagProveedores.jsp").forward(request, response);
    } 
    
    protected void eliminarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int idProv = Integer.parseInt(request.getParameter("codePro"));
        obj.EliminarProveedor(idProv);
        
        request.getRequestDispatcher("/pagProveedores.jsp").forward(request,response);
    }
    
    protected void editarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int idProv = Integer.parseInt(request.getParameter("codPro"));
        String nombEp = request.getParameter("nomPro");
        String direccion = request.getParameter("direcEp");
        int  telfEp = Integer.parseInt(request.getParameter("telfEp"));
        String tipoEp = request.getParameter("tipoEp");
        int idAdmin = Integer.parseInt(request.getParameter("admin"));
        
        
        Proveedor p = new Proveedor();
        p.setIdProveedor(idProv);
        p.setNomEmpresa(nombEp);
        p.setDirecProve(direccion);
        p.setTelefono(telfEp);
        p.setTipoProducto(tipoEp);
        p.setIdAdmin(idAdmin);
        obj.ModificarProveedor(p);
        
        request.getRequestDispatcher("/pagProveedores.jsp").forward(request,response);
    }
    
    protected void adicionTransporte(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     
     String nombre=request.getParameter("txtNom");
     String placa=request.getParameter("txtPlaca");
     String tipo=request.getParameter("txtTrans");
     
     Transporte t = new Transporte();
     t.setNomConductor(nombre);
     t.setPlaca(placa);
     t.setTipoTrans(tipo);
     obj.AgregarTransporte(t);
     request.getRequestDispatcher("/pagTransportes.jsp").forward(request, response);
    }
    
    protected void editarTransporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     int id=Integer.parseInt(request.getParameter("id"));
     String nombre=request.getParameter("txtNom");
     String placa=request.getParameter("txtPlaca");
     String tipo=request.getParameter("txtTrans");
     
    
    Transporte t= new Transporte();
    t.setIdTransporte(id);
    t.setNomConductor(nombre);
    t.setPlaca(placa);
    t.setTipoTrans(tipo);
    
    obj.ModificarTransporte(t);
    
    request.getRequestDispatcher("/pagTransportes.jsp").forward(request, response);
    
    }
    
    protected void eliminarTransporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        obj.EliminarTransporte(id);
        request.getRequestDispatcher("/pagTransportes.jsp").forward(request, response);
    }
    
    protected void adicionEnsamble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        double precio=Double.parseDouble(request.getParameter("precio"));
        String nombre=request.getParameter("nombre");
        String descripcion=request.getParameter("desc");
        String modelo =request.getParameter("modelo");
        int garantia = Integer.parseInt(request.getParameter("garantia"));
        
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int idProveedor = Integer.parseInt(request.getParameter("selecciona"));
        
             
        
        Producto p = new Producto();
        p.setStock(stock);
        p.setIdProveedor(idProveedor);
        
        
        Ensamble e = new Ensamble();
        e.setPreEnsamble(precio);
        e.setNomEnsamble(nombre);
        e.setDescEnsamble(descripcion);
        e.setModelo(modelo);
        e.setGarantia(garantia);
        e.setIdProducto(idProducto);
        
        obj.adicionarEnsamble(p, e);
        
        request.getRequestDispatcher("/pagEnsambles.jsp").forward(request, response);
    } 
    
    protected void editarEnsamble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     int id=Integer.parseInt(request.getParameter("code"));
     double precio=Double.parseDouble(request.getParameter("precio"));
     String nombre=request.getParameter("nombre");
     String descripcion=request.getParameter("desc");
     String modelo=request.getParameter("modelo");
     int garantia=Integer.parseInt(request.getParameter("garantia"));
     int idProducto=Integer.parseInt(request.getParameter("idProducto"));
    
    Ensamble e= new Ensamble();
    e.setIdEnsamble(id);
    e.setPreEnsamble(precio);
    e.setNomEnsamble(nombre);
    e.setDescEnsamble(descripcion);
    e.setModelo(modelo);
    e.setGarantia(garantia);
    e.setIdProducto(idProducto);
    
    obj.EditarEnsamble(e);
    
    request.getRequestDispatcher("/pagEnsambles.jsp").forward(request, response);
    
    }
    
    protected void eliminarEnsamble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        obj.EliminarEnsamble(id);
        request.getRequestDispatcher("/pagEnsambles.jsp").forward(request, response);
    }
    
    protected void cascadaCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     int id=Integer.parseInt(request.getParameter("id"));
    
    request.setAttribute("lista", obj.CascadaCliente(id));
     
    request.getRequestDispatcher("/pagCascadaClientes.jsp").forward(request, response);
    
    }
    
    protected void cascadaEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("lista", obj.CascadaEmpleado(id));
        request.setAttribute("id", id);
        request.getRequestDispatcher("/pagCascadaEmpleados.jsp").forward(request, response);
    }
    
    protected void cascadaEmpleado2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("lista", obj.CascadaCliente(id));
        request.getRequestDispatcher("/pagCascadaEmpleados2.jsp").forward(request, response);
    }
    
    protected void filtraCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom= request.getParameter("consulta");
        
        
        Gson gs = new Gson();
        PrintWriter out = response.getWriter();
        out.print(gs.toJson(obj.FiltroCliente(nom)));
        
    }
    
    protected void filtraEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom= request.getParameter("consulta");
        
        
        Gson gs = new Gson();
        PrintWriter out = response.getWriter();
        out.print(gs.toJson(obj.FiltroEmpleado(nom)));
        
    }
    
    protected void filtraFacturas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom= request.getParameter("consulta");
        
        
        Gson gs = new Gson();
        PrintWriter out = response.getWriter();
        out.print(gs.toJson(obj.FiltroFacturas(nom)));
        
    }
    
     protected void validarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("user");
       String pass=request.getParameter("pass");
       
       
       
       Cliente c = obj.ValidarUsuario(user, pass);
         if (c!=null) {
             
             
             request.setAttribute("user", user);
             request.setAttribute("idUser", c.getIdCliente());
             
            request.getRequestDispatcher("/ListarJuegos.jsp").forward(request, response); 
         }else{
             request.getRequestDispatcher("/Menu.jsp").forward(request, response);
         }  
    }
     
    protected void añadirJuegoCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idprod=Integer.parseInt(request.getParameter("idprod"));
        int idjuego=Integer.parseInt(request.getParameter("idjuego"));
        int idUser=Integer.parseInt(request.getParameter("iduser"));
        String user=request.getParameter("name");
        int cantidad=Integer.parseInt(request.getParameter("txtcant"));
        
        Juegos j =obj.conseguirDatosJuego(idjuego);
        String nombre=j.getNomJuego();
        double precio=j.getPrecio();
        
        Compra c = new Compra();
        c.setNombreProducto(nombre);
        c.setPrecioProducto(precio);
        c.setCantidadProducto(cantidad);
        c.setIdProducto(idprod);
        
        obj.añadirProductoAlCarrito(c, idUser);
        
        request.setAttribute("user", user);
        request.setAttribute("idUser", idUser);
        request.getRequestDispatcher("/ListarJuegos.jsp").forward(request, response);
    } 
    
     protected void verTusCompras(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idUser=Integer.parseInt(request.getParameter("iduser"));
        String user=request.getParameter("name");
        
        request.setAttribute("lista", obj.ListarCarrito(idUser));
        request.setAttribute("user", user);
        request.setAttribute("idUser", idUser);
        
        request.getRequestDispatcher("/ListarCarrito.jsp").forward(request, response);
    }
    
    protected void validarAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("user");
       String pass=request.getParameter("pass");
       
       
       
       Admin a = obj.ValidarAdmin();
         if (user.equals(a.getAdminUser()) && pass.equals(a.getPass())) {
             
             request.setAttribute("userAdmin", user); 
            request.getRequestDispatcher("/pagAdmin.jsp").forward(request, response); 
         }else{
             request.getRequestDispatcher("/LoginAdmin.jsp").forward(request, response);
         }  
    } 
    
    protected void RedireccionarJuegos (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("name");
       int idUser=Integer.parseInt(request.getParameter("iduser"));
       
       request.setAttribute("user", user);
       request.setAttribute("idUser", idUser);
       
       request.getRequestDispatcher("/ListarJuegos.jsp").forward(request, response);     
    }
    
    
    protected void RedireccionarEnsambles (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("name");
       int idUser=Integer.parseInt(request.getParameter("iduser"));
       
       request.setAttribute("user", user);
       request.setAttribute("idUser", idUser);
       
       request.getRequestDispatcher("/ListarEnsambles.jsp").forward(request, response);     
    }
    
    protected void RedireccionarIndex (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("name");
       int idUser=Integer.parseInt(request.getParameter("iduser"));
       
       request.setAttribute("user", user);
       request.setAttribute("idUser", idUser);
       
       request.getRequestDispatcher("/index.jsp").forward(request, response);     
    }
    
    protected void añadirEnsambleCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idprod=Integer.parseInt(request.getParameter("idprod"));
        int idensamble=Integer.parseInt(request.getParameter("idensamble"));
        int idUser=Integer.parseInt(request.getParameter("iduser"));
        String user=request.getParameter("name");
        int cantidad=Integer.parseInt(request.getParameter("txtcant"));
        
        Ensamble e =obj.conseguirDatosEnsamble(idensamble);
        String nombre= e.getNomEnsamble();
        double precio= e.getPreEnsamble();
        
        Compra c = new Compra();
        c.setNombreProducto(nombre);
        c.setPrecioProducto(precio);
        c.setCantidadProducto(cantidad);
        c.setIdProducto(idprod);
        
        obj.añadirProductoAlCarrito(c, idUser);
        
        request.setAttribute("user", user);
        request.setAttribute("idUser", idUser);
        request.getRequestDispatcher("/ListarEnsambles.jsp").forward(request, response);
    }
    
    protected void eliminarProductoCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user=request.getParameter("name");
        int idUser=Integer.parseInt(request.getParameter("iduser"));
        int id=Integer.parseInt(request.getParameter("idcompra"));
        
        obj.EliminarProductoCarrito(id);
        
        request.setAttribute("lista", obj.ListarCarrito(idUser));
        request.setAttribute("user", user);
        request.setAttribute("idUser", idUser);
        
        request.getRequestDispatcher("/ListarCarrito.jsp").forward(request, response);
    }
    
    protected void RegistrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre=request.getParameter("txtnom");
        String apellido=request.getParameter("txtapellido");
        String genero=request.getParameter("genero");
        int dni=Integer.parseInt(request.getParameter("txtdni"));
        int edad=Integer.parseInt(request.getParameter("txtedad"));
        String direccion=request.getParameter("txtdireccion");
        String correo=request.getParameter("txtcorreo");
        int idEmpleado=Integer.parseInt(request.getParameter("empleadoCombo"));
        String contra=request.getParameter("pass");
        
        Cliente c = new Cliente();
        c.setNombreCliente(nombre);
        c.setApellidoCliente(apellido);
        c.setGeneroCliente(genero);
        c.setDNI(dni);
        c.setEdadCliente(edad);
        c.setDireccionCliente(direccion);
        c.setCorreoCliente(correo);
        c.setIDEmpleado(idEmpleado);
        c.setPassCliente(contra);
        
        obj.RegistroCliente(c);
       
        request.getRequestDispatcher("/Menu.jsp").forward(request, response);
    }
    
    protected void Comprar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user=request.getParameter("name");
        int idUser=Integer.parseInt(request.getParameter("iduser"));
        double total=Double.parseDouble(request.getParameter("total"));
        double igv=Double.parseDouble(request.getParameter("igv"));
        //falta mandarle el idtransporte por combobox (predetermnado 105)
        obj.CrearFactura(total, igv, idUser); //crear factura
        int idfactura=obj.ObtenerIdFactura(idUser); //obtener ultimo idfactura
        
        //Verificar que no sea visitante
        if (user.equals("Visitante") && idUser==0) {
            obj.ResetearCompra(idUser);
            request.getRequestDispatcher("/Menu.jsp").forward(request, response);
        }else{
        
        
      List<Compra> lista = (ArrayList)obj.ListarCarrito(idUser);
        
        for (Compra x: lista) {
            
            Compra c= new Compra();
            c.setNombreProducto(x.getNombreProducto());
            c.setPrecioProducto(x.getPrecioProducto());
            c.setCantidadProducto(x.getCantidadProducto());
            c.setIdProducto(x.getIdProducto());
   
            obj.InsertarDetalleFactura(c, idfactura); 
        }
            obj.ResetearCompra(idUser); //vaciar tabla temporal de compras
            
            //QR STRING
            
            String text="Gracias por tu compra "+user+", el total fue de "+total+" y el IGV fue de "+igv;
        
        request.setAttribute("user", user);
        request.setAttribute("idUser", idUser);
        HttpSession ses= request.getSession();
        ses.setAttribute("text", text);
        request.getRequestDispatcher("/ListarFacturasUsuario.jsp").forward(request, response);
        
        }   
    }
    
    
    protected void RedireccionarFacturas (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("name");
       int idUser=Integer.parseInt(request.getParameter("iduser"));
       
        if (user.equals("Visitante") && idUser==0) {
           request.getRequestDispatcher("/Menu.jsp").forward(request, response); 
        }else{
       
       request.setAttribute("user", user);
       request.setAttribute("idUser", idUser);
       
       request.getRequestDispatcher("/ListarFacturasUsuario.jsp").forward(request, response);
       }
    }
    
     protected void RedireccionarDetalleFactura (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("name");
       int idUser=Integer.parseInt(request.getParameter("iduser"));
       int idFactura=Integer.parseInt(request.getParameter("idfactura"));
       
       request.setAttribute("user", user);
       request.setAttribute("idUser", idUser);
       request.setAttribute("idfactura", idFactura);
       
       request.getRequestDispatcher("/ListarDetallesFacturasUsuario.jsp").forward(request, response);     
    }
     
    protected void VisitarJuegos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      String user="Visitante";
      int idUser=0;
        
      request.setAttribute("user", user);
      request.setAttribute("idUser", idUser);
      
      request.getRequestDispatcher("/ListarJuegos.jsp").forward(request, response);  
    }
    
    
    protected void VisitarEnsambles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      String user="Visitante";
      int idUser=0;
        
      request.setAttribute("user", user);
      request.setAttribute("idUser", idUser);
      
      request.getRequestDispatcher("/ListarEnsambles.jsp").forward(request, response);  
    }
    
    protected void FiltraJuegos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom= request.getParameter("consulta");
        
        
        Gson gs = new Gson();
        PrintWriter out = response.getWriter();
        out.print(gs.toJson(obj.FiltroJuegos(nom)));
        
    }
    
    protected void FiltraEnsamble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom= request.getParameter("consulta");
        
        
        Gson gs = new Gson();
        PrintWriter out = response.getWriter();
        out.print(gs.toJson(obj.FiltroEnsambles(nom)));
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
