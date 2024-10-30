
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.*;
import util.MySQLConexion;


public class Negocio {
    
    
    //Empleado
    
    
     public List<Empleado> ListarEmpleado(){ //No me mandamos nada porque lit es un SELECT*FROM sin argumentos
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Empleado> lis = new ArrayList();
        String sql="SELECT IDEmpleado, Nombre, Direccion, Genero, Edad FROM empleado";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        while(rs.next()){ //Leer FILA POR FILA
            Empleado e = new Empleado(); //SETEAR los valores
            e.setIDEmpleado(rs.getInt(1));
            e.setNombre(rs.getString(2));
            e.setDireccion(rs.getString(3));
            e.setGenero(rs.getString(4));
            e.setEdad(rs.getInt(5));
             
            lis.add(e);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
     
    public Empleado BuscarEmpleado (int id){
        //Empleado e=null; //Si le envian un IDempleado q no existe, te retornará null
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        String sql="SELECT IDEmpleado, Nombre, Direccion, Genero, Edad, IdAdmin FROM empleado WHERE IDEmpleado="+id;
        Empleado e = new Empleado();
        try{
        PreparedStatement st=cn.prepareStatement(sql); 
        //st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        
            if(rs.next()){ 
             
            e.setIDEmpleado(rs.getInt(1));
            e.setNombre(rs.getString(2));
            e.setDireccion(rs.getString(3));
            e.setGenero(rs.getString(4));
            e.setEdad(rs.getInt(5));
            e.setIdAdmin(rs.getInt(6));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return e;  
    }
    
    public void AnularEmpleado(int id){ //NO ES NECESARIO PASAR TODA LA CLASE PRESTAMO (Prestamo p)
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        try{
            
            String sql="DELETE FROM empleado WHERE IDEmpleado=?";
            PreparedStatement st=cn.prepareStatement(sql); 
         
            st.setInt(1, id);
            
            st.executeUpdate(); //Ejecutar el query
            
        }catch(Exception e){
            e.printStackTrace(); //Detectar error de gestion de datos
        }
    }
    
    public void EditarEmpleado(Empleado e){
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        try{
            
            String sql="UPDATE empleado SET Nombre=?, Direccion=?, Genero=?, Edad=?, IdAdmin= ? WHERE IDEmpleado=?"; //( 1, 2, 3, 4, 5)
            PreparedStatement st=cn.prepareStatement(sql); 
            st.setString(1, e.getNombre());
            st.setString(2, e.getDireccion());
            st.setString(3, e.getGenero());
            st.setInt(4, e.getEdad());
            st.setInt(5, e.getIdAdmin());
            st.setInt(6, e.getIDEmpleado());
            
            st.executeUpdate(); //Ejecutar el query
            
        }catch(Exception ex){
            ex.printStackTrace(); //Detectar error de gestion de datos
        }
    }
    
    public void AdicionEmpleado(Empleado e){
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="INSERT INTO empleado values(null, ?, ?, ?, ?, ?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, e.getNombre());
            st.setString(2, e.getDireccion());
            st.setString(3, e.getGenero());
            st.setInt(4, e.getEdad());
            st.setInt(5, e.getIdAdmin()); //Insertando la foranea del admin
            st.executeUpdate();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
    
    public List<Cliente> CascadaEmpleado(int id){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Cliente> lis = new ArrayList();
        
        
        try{
        String sql="SELECT c.IdCliente, NombreCli, ApellidoCli, Sexo, DNI, c.Edad, c.Direccion, Correo FROM cliente as c INNER JOIN empleado as e ON c.IDEmpleado=e.IDEmpleado WHERE e.IDEmpleado = ?";
        PreparedStatement st=cn.prepareStatement(sql);  
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){ //Leer FILA POR FILA
            Cliente c = new Cliente(); //SETEAR los valores
            c.setIdCliente(rs.getInt(1));
            c.setNombreCliente(rs.getString(2));
            c.setApellidoCliente(rs.getString(3));
            c.setGeneroCliente(rs.getString(4));
            c.setDNI(rs.getInt(5));
            c.setEdadCliente(rs.getInt(6));
            c.setDireccionCliente(rs.getString(7));
            c.setCorreoCliente(rs.getString(8));
            
 
            lis.add(c);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    
    public List<Empleado> FiltroEmpleado(String nom){ 
        
        Connection cn=MySQLConexion.getConexion(); 
        
        List<Empleado> lis = new ArrayList();
        
        try{
        String sql="SELECT IDEmpleado, Nombre, Direccion, Genero, Edad FROM empleado WHERE Nombre like ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1, nom+"%");
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){ 
            Empleado e = new Empleado(); //SETEAR los valores
            e.setIDEmpleado(rs.getInt(1));
            e.setNombre(rs.getString(2));
            e.setDireccion(rs.getString(3));
            e.setGenero(rs.getString(4));
            e.setEdad(rs.getInt(5));
             
            lis.add(e);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    public Empleado TotalEmpleado(){ 
        
        Connection cn=MySQLConexion.getConexion(); 
        Empleado e = null;
        
        
        try{
        String sql="SELECT COUNT(IDEmpleado) FROM empleado";
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs = st.executeQuery(); 
        
        if(rs.next()){ 
            e = new Empleado(); 
            e.setIDEmpleado(rs.getInt(1));
                   
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return e;
          
    }
    
    
    //Cliente
    
    public List<Cliente> ListarCliente(){ //No me mandamos nada porque lit es un SELECT*FROM sin argumentos
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Cliente> lis = new ArrayList();
        String sql="SELECT IdCliente, NombreCli, ApellidoCli, Sexo, DNI, Edad, Direccion, Correo FROM cliente";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        while(rs.next()){ //Leer FILA POR FILA
            Cliente c = new Cliente(); //SETEAR los valores
            c.setIdCliente(rs.getInt(1));
            c.setNombreCliente(rs.getString(2));
            c.setApellidoCliente(rs.getString(3));
            c.setGeneroCliente(rs.getString(4));
            c.setDNI(rs.getInt(5));
            c.setEdadCliente(rs.getInt(6));
            c.setDireccionCliente(rs.getString(7));
            c.setCorreoCliente(rs.getString(8));
             
            lis.add(c);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
     public List<Cliente> FiltroCliente(String nom){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Cliente> lis = new ArrayList();
        try{
        String sql="SELECT IdCliente, NombreCli, ApellidoCli, Sexo, DNI, Edad, Direccion, Correo FROM cliente WHERE NombreCli like ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1, nom+"%");
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        while(rs.next()){ //Leer FILA POR FILA
            Cliente c = new Cliente(); //SETEAR los valores
            c.setIdCliente(rs.getInt(1));
            c.setNombreCliente(rs.getString(2));
            c.setApellidoCliente(rs.getString(3));
            c.setGeneroCliente(rs.getString(4));
            c.setDNI(rs.getInt(5));
            c.setEdadCliente(rs.getInt(6));
            c.setDireccionCliente(rs.getString(7));
            c.setCorreoCliente(rs.getString(8));
             
            lis.add(c);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    
    public void AnularCliente(int id){ 
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        try{
            
            String sql="DELETE FROM cliente WHERE IdCliente=?";
            PreparedStatement st=cn.prepareStatement(sql); 
         
            st.setInt(1, id);
            
            st.executeUpdate(); //Ejecutar el query
            
        }catch(Exception e){
            e.printStackTrace(); //Detectar error de gestion de datos
        }
    }
    
    public List<Factura> CascadaCliente(int id){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Factura> lis = new ArrayList();
        String sql="SELECT IdFactura, FechaFac, Monto, fac_igv FROM factura AS f INNER JOIN cliente as c ON f.IdCliente=c.IdCliente WHERE c.IdCliente = ?";
        
        try{
        PreparedStatement st=cn.prepareStatement(sql);  
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){ //Leer FILA POR FILA
            Factura f = new Factura(); //SETEAR los valores
            f.setIdFactura(rs.getInt(1));
            f.setFechaFac(rs.getString(2));
            f.setMonto(rs.getDouble(3));
            f.setFacIGV(rs.getString(4));
            
             
            lis.add(f);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
     public Cliente TotalCliente(){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        Cliente c=null;
        
        
        try{
        String sql="SELECT COUNT(IdCliente) FROM cliente";
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){ 
            c = new Cliente(); //SETEAR los valores
            c.setIdCliente(rs.getInt(1));
                         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return c;
          
    }

    //Juegos
    
    public List<Juegos> ListarJuegos(){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Juegos> lis = new ArrayList();
        String sql="SELECT * FROM juegos";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        while(rs.next()){ //Leer FILA POR FILA
            Juegos j = new Juegos(); //SETEAR los valores
            j.setIdJuego(rs.getInt(1));
            j.setCategoria(rs.getString(2));
            j.setNomJuego(rs.getString(3));
            j.setDescJuego(rs.getString(4));
            j.setPrecio(rs.getDouble(5));
            j.setAnioLanza(rs.getInt(6));
            j.setIdProducto(rs.getInt(7));
             
            lis.add(j);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    
    public void adicionarJuego(Producto p, Juegos j){
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="INSERT INTO producto values(null, ?, ?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, p.getStock());
            st.setInt(2, p.getIdProveedor());
            
            st.executeUpdate();
          
         String sql2="INSERT INTO juegos VALUES (null, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st2 = cn.prepareCall(sql2);
            st2.setString(1, j.getCategoria());
            st2.setString(2, j.getNomJuego());
            st2.setString(3, j.getDescJuego());
            st2.setDouble(4, j.getPrecio());
            st2.setInt(5, j.getAnioLanza());
            st2.setInt(6, j.getIdProducto());
            
            st2.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
        
    
    
    public Juegos BuscarJuego (int id){
        //Empleado e=null; //Si le envian un IDempleado q no existe, te retornará null
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        String sql="SELECT IdJuego, Categoria, NomJuego, DescJuego, Precio, AñoLanz, idProducto FROM juegos WHERE IdJuego="+id;
        Juegos j = new Juegos();
        try{
        PreparedStatement st=cn.prepareStatement(sql); 
        
        ResultSet rs = st.executeQuery();
        
            if(rs.next()){ 
             j.setIdJuego(rs.getInt(1));
             j.setCategoria(rs.getString(2));
             j.setNomJuego(rs.getString(3));
             j.setDescJuego(rs.getString(4));
             j.setPrecio(rs.getDouble(5));
             j.setAnioLanza(rs.getInt(6));
             j.setIdProducto(rs.getInt(7));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return j;  
    }
    
    
    public void EditarJuego(Juegos j){
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        try{
            
            String sql="UPDATE juegos SET IdJuego= ?, Categoria = ?, NomJuego = ?, DescJuego = ?, Precio = ?, AñoLanz = ?, idProducto = ? WHERE IdJuego= ? "; 
            PreparedStatement st=cn.prepareStatement(sql); 
            st.setInt(1, j.getIdJuego());
            st.setString(2, j.getCategoria());
            st.setString(3, j.getNomJuego());
            st.setString(4, j.getDescJuego());
            st.setDouble(5, j.getPrecio());
            st.setInt(6, j.getAnioLanza());
            st.setInt(7, j.getIdProducto());
            st.setInt(8, j.getIdJuego());
            
            st.executeUpdate(); //Ejecutar el query
            
        }catch(Exception ex){
            ex.printStackTrace(); //Detectar error de gestion de datos
        }
    }
    
    public void AnularJuego(int id){ 
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        try{
            
            String sql="DELETE FROM juegos WHERE IdJuego=?";
            PreparedStatement st=cn.prepareStatement(sql); 
         
            st.setInt(1, id);
            
            st.executeUpdate(); //Ejecutar el query
            
        }catch(Exception e){
            e.printStackTrace(); //Detectar error de gestion de datos
        }
    }
    
    public List<Juegos> FiltroJuegos(String nom){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Juegos> lis = new ArrayList();
        String sql="SELECT NomJuego, Categoria, Precio, idProducto FROM juegos WHERE NomJuego like ?";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        st.setString(1, nom+"%");
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){ //Leer FILA POR FILA
            Juegos j = new Juegos(); //SETEAR los valores
            j.setNomJuego(rs.getString(1));
            j.setCategoria(rs.getString(2));             
            j.setPrecio(rs.getDouble(3));
            j.setIdProducto(rs.getInt(4));
             
            lis.add(j);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    //Producto
    
  
    public Producto BuscarUltimoProducto(){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        Producto p=null;
        
        String sql="SELECT idProducto FROM producto ORDER BY idProducto DESC LIMIT 1";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        if(rs.next()){ 
            p = new Producto(); 
          p.setIdProducto(rs.getInt(1));
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return p;
          
    }
    
    
    public List<Juegos> GraficoJuegos(){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Juegos> lis = new ArrayList();
        String sql="SELECT NomJuego, stock from producto as p INNER JOIN juegos as j ON p.idProducto=j.idProducto";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        while(rs.next()){ //Leer FILA POR FILA
            Juegos j = new Juegos(); //SETEAR los valores
           
            j.setNomJuego(rs.getString(1));
            j.setStock(rs.getInt(2));
             
            lis.add(j);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    public Juegos ListarDetalleJuego(int code){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        
        Juegos j =null;
        try{
        String sql="{CALL spJuegoDetalle (?)}";
        PreparedStatement st=cn.prepareStatement(sql);   
        st.setInt(1, code);
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        if(rs.next()){ //Leer FILA POR FILA
            j = new Juegos(); //SETEAR los valores
            j.setIdJuego(rs.getInt(1));
            j.setCategoria(rs.getString(2));
            j.setNomJuego(rs.getString(3));
            j.setDescJuego(rs.getString(4));
            j.setPrecio(rs.getDouble(5));
            j.setAnioLanza(rs.getInt(6));
            j.setStock(rs.getInt(7));
             
        
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return j;
          
    }
    
    public List<Juegos> ListarJuegosRandom(){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Juegos> lis = new ArrayList();
        try{
        String sql="SELECT idProducto, NomJuego, Precio FROM juegos ORDER BY RAND() LIMIT 4";
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        while(rs.next()){ //Leer FILA POR FILA
            Juegos j = new Juegos(); //SETEAR los valores
            j.setIdProducto(rs.getInt(1));
            j.setNomJuego(rs.getString(2));
            j.setPrecio(rs.getDouble(3));
    
            lis.add(j);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;    
    }
    
    
    //Proveedor
    
    public List<Proveedor> ListarProveedores(){
        Connection cn=MySQLConexion.getConexion();
        List<Proveedor> lis = new ArrayList();
       
        try{
            String sql = "SELECT  IdProveedor , NomEmpresa, Direccion, Telefono ,TipoProduc , IdAdmin FROM proveedor";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt(1));
                p.setNomEmpresa(rs.getString(2));
                p.setDirecProve(rs.getString(3));
                p.setTelefono(rs.getInt(4));
                p.setTipoProducto(rs.getString(5));
                p.setIdAdmin(rs.getInt(6));
                
                lis.add(p);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return lis;
    }
    
    public List<Proveedor> ListarTiposDeProductos(){
        Connection cn=MySQLConexion.getConexion();
        List<Proveedor> lis = new ArrayList();
        
        try{
            String sql = "SELECT DISTINCT TipoProduc from proveedor";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Proveedor p = new Proveedor();
                
                p.setTipoProducto(rs.getString(1));
                
                
                lis.add(p);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return lis;
    }
    
    
    public void AgregarProveedores(Proveedor p){
        
        Connection cn = null;
        PreparedStatement st = null;
        try{
            cn=MySQLConexion.getConexion();
            String sql ="INSERT INTO proveedor VALUES (null, ?, ?, ?, ?, ?)";
            st = cn.prepareCall(sql);
            st.setString(1,p.getNomEmpresa());
            st.setString(2, p.getDirecProve());
            st.setInt(3, p.getTelefono());
            st.setString(4, p.getTipoProducto());
            st.setInt(5, p.getIdAdmin());
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace(); 
        }
    
    }
    
    
    public Proveedor BuscarProveeedor(int id){
        
        Connection cn = null;
        Proveedor p = null;
        try{
           cn = MySQLConexion.getConexion();
           String sql ="SELECT*FROM proveedor WHERE IdProveedor =" +id;
           PreparedStatement st = cn.prepareCall(sql);
           //st.setInt(1, id);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               
              p = new Proveedor();
              p.setIdProveedor(rs.getInt(1));
              p.setNomEmpresa(rs.getString(2));
              p.setDirecProve(rs.getString(3));
              p.setTelefono(rs.getInt(4));
              p.setTipoProducto(rs.getString(5));
              p.setIdAdmin(rs.getInt(6));
              
           }
            
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
          return  p;
    }
    
    public void EliminarProveedor(int idProv){
        
        Connection cn = null;
        try{
            cn =MySQLConexion.getConexion();
           String sql ="DELETE FROM proveedor WHERE IdProveedor =?";
           PreparedStatement st = cn.prepareCall(sql);
           st.setInt(1, idProv);
           st.executeUpdate();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
          
    }
    
    public void ModificarProveedor(Proveedor p){
        
        Connection cn = null;
        try{
            cn =MySQLConexion.getConexion();
           String sql ="UPDATE  proveedor  SET NomEmpresa =?, Direccion = ?, Telefono = ?, TipoProduc=?, IdAdmin=?  WHERE IdProveedor =?";
           PreparedStatement st = cn.prepareCall(sql);
           st.setString(1, p.getNomEmpresa());
           st.setString(2,p.getDirecProve());
           st.setInt(3, p.getTelefono());
           st.setString(4, p.getTipoProducto());
           st.setInt(5, p.getIdAdmin());
           st.setInt(6, p.getIdProveedor());
           st.executeUpdate();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }
    
    //Facturas
    
    public List<Factura> ListarFacturas(){
        Connection cn=MySQLConexion.getConexion();
        List<Factura> lis = new ArrayList();
       
        try{
            String sql = "SELECT IdFactura, FechaFac, Monto, fac_igv, f.IdCliente, NombreCli FROM factura as f INNER JOIN cliente as c ON f.IdCliente=c.IdCliente";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Factura f = new Factura();
                f.setIdFactura(rs.getInt(1));
                f.setFechaFac(rs.getString(2));
                f.setMonto(rs.getDouble(3));
                f.setFacIGV(rs.getString(4));
                f.setIdCliente(rs.getInt(5));
                f.setNombreCliente(rs.getString(6));
                
                lis.add(f);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return lis;
    }
    
    public List<Factura> FiltroFacturas(String nom){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Factura> lis = new ArrayList();
        try{
        String sql="SELECT IdFactura, FechaFac, Monto, fac_igv, f.IdCliente, NombreCli FROM factura as f INNER JOIN cliente as c ON f.IdCliente=c.IdCliente WHERE NombreCli like ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1, nom+"%");
        ResultSet rs = st.executeQuery(); //Como no le vamos a pasar argumentos, directamente ejecitamos
        
        while(rs.next()){ 
            Factura f = new Factura(); 
                f.setIdFactura(rs.getInt(1));
                f.setFechaFac(rs.getString(2));
                f.setMonto(rs.getDouble(3));
                f.setFacIGV(rs.getString(4));
                f.setIdCliente(rs.getInt(5));
                f.setNombreCliente(rs.getString(6));
             
            lis.add(f);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    public List<Factura> GraficoFacturas(){
        Connection cn=MySQLConexion.getConexion();
        List<Factura> lis = new ArrayList();
       
        try{
            String sql = "SELECT e.Nombre, sum(f.Monto) FROM empleado as e INNER JOIN cliente as c ON e.IDEmpleado=c.IDEmpleado INNER JOIN factura as f ON c.IdCliente=f.IdCliente GROUP BY e.Nombre";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Factura f = new Factura();
                f.setNombre(rs.getString(1));
                f.setMonto(rs.getDouble(2));
 
                lis.add(f);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return lis;
    }
    
    public List<Factura> GraficoFacturas2(){
        Connection cn=MySQLConexion.getConexion();
        List<Factura> lis = new ArrayList();
       
        try{
            String sql = "select MONTHNAME(FechaFac) mes, sum(Monto)\n" +
                        "from factura\n" +
                        "where year(FechaFac)=2023\n" +
                            "group by month(FechaFac);";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Factura f = new Factura();
                f.setFechaFac(rs.getString(1));
                f.setMonto(rs.getDouble(2));
 
                lis.add(f);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return lis;
    }
    
    public Factura TotalMontoFacturas(){
        Connection cn=MySQLConexion.getConexion();
        Factura f=null;
        try{
            String sql = "SELECT sum(Monto) from factura";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                f = new Factura();
                f.setMonto(rs.getDouble(1));            
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return f;
    }
    
    public List<Factura> ListarFacturasSegunUser(int iduser){
        Connection cn=MySQLConexion.getConexion();
        List<Factura> lis = new ArrayList();
       
        try{
            String sql = "SELECT  IdFactura , FechaFac, Monto, fac_igv FROM factura WHERE  IdCliente =?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, iduser);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Factura f = new Factura();
                f.setIdFactura(rs.getInt(1));
                f.setFechaFac(rs.getString(2));
                f.setMonto(rs.getDouble(3));
                f.setFacIGV(rs.getString(4));
                
                
                lis.add(f);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return lis;
    }
    
    //Admin
    
    public List<Admin> ListarAdmin(){
        Connection cn=MySQLConexion.getConexion();
        List<Admin> lis = new ArrayList();
       
        try{
            String sql = "SELECT  IdAdmin , AdminUser, Contraseña FROM administrador";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Admin a = new Admin();
                a.setIdAdmin(rs.getInt(1));
                a.setAdminUser(rs.getString(2));
                a.setPass(rs.getString(3));
                
                lis.add(a);
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return lis;
    }
 
    //Ensambles
    
    public List<Ensamble> ListarEnsambles(){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Ensamble> lis = new ArrayList();
        String sql="SELECT * FROM ensamble";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){
            Ensamble e = new Ensamble(); 
            e.setIdEnsamble(rs.getInt(1));
            e.setPreEnsamble(rs.getDouble(2));
            e.setNomEnsamble(rs.getString(3));
            e.setDescEnsamble(rs.getString(4));
            e.setModelo(rs.getString(5));
            e.setGarantia(rs.getInt(6));
            e.setIdProducto(rs.getInt(7));
             
            lis.add(e);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
     public void adicionarEnsamble(Producto p, Ensamble e){
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="INSERT INTO producto values(null, ?, ?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, p.getStock());
            st.setInt(2, p.getIdProveedor());
            
            st.executeUpdate();
          
         String sql2="INSERT INTO ensamble VALUES (null, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st2 = cn.prepareCall(sql2);
            st2.setDouble(1, e.getPreEnsamble());
            st2.setString(2, e.getNomEnsamble());
            st2.setString(3, e.getDescEnsamble());
            st2.setString(4, e.getModelo());
            st2.setInt(5, e.getGarantia());
            st2.setInt(6, e.getIdProducto());
            
            st2.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
     
     public void EditarEnsamble(Ensamble e){
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        try{
            
            String sql="UPDATE ensamble SET IdEnsamble=?,PrecioEns=?,NomEnsamble=?,DescEmsamble=?, Modelo=?,Garantía=?,idProducto=? WHERE IdEnsamble=?"; 
            PreparedStatement st=cn.prepareStatement(sql); 
            st.setInt(1, e.getIdEnsamble());
            st.setDouble(2, e.getPreEnsamble());
            st.setString(3, e.getNomEnsamble());
            st.setString(4, e.getDescEnsamble());
            st.setString(5, e.getModelo());
            st.setInt(6, e.getGarantia());
            st.setInt(7, e.getIdProducto());
            st.setInt(8, e.getIdEnsamble());
            
            st.executeUpdate(); //Ejecutar el query
            
        }catch(Exception ex){
            ex.printStackTrace(); //Detectar error de gestion de datos
        }
    }
    
    public Ensamble BuscarEnsamble(int id){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        Ensamble e = null;
        String sql="SELECT * FROM ensamble WHERE IdEnsamble="+id;
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){
            e = new Ensamble(); 
            e.setIdEnsamble(rs.getInt(1));
            e.setPreEnsamble(rs.getDouble(2));
            e.setNomEnsamble(rs.getString(3));
            e.setDescEnsamble(rs.getString(4));
            e.setModelo(rs.getString(5));
            e.setGarantia(rs.getInt(6));
            e.setIdProducto(rs.getInt(7));
                    
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return e;
          
    }
    
    public void EliminarEnsamble(int id){
        
        Connection cn = null;
        try{
            cn =MySQLConexion.getConexion();
           String sql ="DELETE FROM ensamble WHERE IdEnsamble=?";
           PreparedStatement st = cn.prepareCall(sql);
           st.setInt(1, id);
           st.executeUpdate();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
          
    }
    
    
    public List<Ensamble> GraficoEnsambles(){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Ensamble> lis = new ArrayList();
        String sql="SELECT NomEnsamble, stock from ensamble as e INNER JOIN producto as p ON p.idProducto=e.idProducto";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){
            Ensamble e = new Ensamble();  
            e.setNomEnsamble(rs.getString(1));
            e.setStock(rs.getInt(2));
            lis.add(e);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
    
    
    
    public Ensamble ListarDetalleEnsamble(int id){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        Ensamble e=null;
        String sql="{CALL spEnsambleDetalle(?)}";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        st.setInt(1, id);
        ResultSet rs = st.executeQuery(); 
        
        if(rs.next()){
            e = new Ensamble(); 
            e.setIdEnsamble(rs.getInt(1));
            e.setPreEnsamble(rs.getDouble(2));
            e.setNomEnsamble(rs.getString(3));
            e.setDescEnsamble(rs.getString(4));
            e.setModelo(rs.getString(5));
            e.setGarantia(rs.getInt(6));
            e.setIdProducto(rs.getInt(7));
            e.setStock(rs.getInt(8));
             
                   
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return e;
          
    }
    
    public List<Ensamble> FiltroEnsambles(String nom){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Ensamble> lis = new ArrayList();
        String sql="SELECT NomEnsamble, PrecioEns, Garantía, idProducto FROM ensamble WHERE NomEnsamble like ?";
        try{
        PreparedStatement st=cn.prepareStatement(sql);   
        st.setString(1, nom+"%");
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){
            Ensamble e = new Ensamble(); 
            
            e.setNomEnsamble(rs.getString(1));
            e.setPreEnsamble(rs.getDouble(2));
            e.setGarantia(rs.getInt(3));
            e.setIdProducto(rs.getInt(4));
             
            lis.add(e);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
     

     
    //Transportes
    
    public List<Transporte> ListarTransportes() {
        List<Transporte> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select idTransporte, NomCondutor, Placa, TipoTrans from transporte";
            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Transporte t = new Transporte();
                t.setIdTransporte(rs.getInt(1));
                t.setNomConductor(rs.getString(2));
                t.setPlaca(rs.getString(3));
                t.setTipoTrans(rs.getString(4));
                lis.add(t);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;

    }
    
    
    public void AgregarTransporte(Transporte t){
        
        Connection cn = null;
        PreparedStatement st = null;
        try{
            cn=MySQLConexion.getConexion();
            String sql ="INSERT INTO transporte VALUES (null, ?, ?, ?)";
            st = cn.prepareCall(sql);
            st.setString(1,t.getNomConductor());
            st.setString(2, t.getPlaca());
            st.setString(3, t.getTipoTrans());
            
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace(); 
        }
    
    }
    
    
    public Transporte BuscarTransporte(int id){
        
        Connection cn = null;
        Transporte t = null;
        try{
           cn = MySQLConexion.getConexion();
           String sql ="select IdTransporte, NomCondutor, Placa, TipoTrans from transporte where IdTransporte="+id;
           PreparedStatement st = cn.prepareCall(sql);
           
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               
              t = new Transporte();
              t.setIdTransporte(rs.getInt(1));
              t.setNomConductor(rs.getString(2));
              t.setPlaca(rs.getString(3));
              t.setTipoTrans(rs.getString(4));
  
           }
            
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
          return  t;
    }
    
    public void ModificarTransporte(Transporte t){
        
        Connection cn = null;
        try{
            cn =MySQLConexion.getConexion();
           String sql ="update transporte set IdTransporte= ?, NomCondutor= ?, Placa= ?, TipoTrans= ? WHERE  IdTransporte= ?";
           PreparedStatement st = cn.prepareCall(sql);
           st.setInt(1, t.getIdTransporte());
           st.setString(2,t.getNomConductor());
           st.setString(3,t.getPlaca());
           st.setString(4,t.getTipoTrans());
           st.setInt(5, t.getIdTransporte());
           
           st.executeUpdate();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }
    
    public void EliminarTransporte(int id){
        
        Connection cn = null;
        try{
            cn =MySQLConexion.getConexion();
           String sql ="DELETE FROM transporte WHERE IdTransporte =?";
           PreparedStatement st = cn.prepareCall(sql);
           st.setInt(1, id);
           st.executeUpdate();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
          
    }
    
    //producto
    
    public Producto TotalProductos(){
       Connection cn = null;
       Producto p = null;
        try{
            cn =MySQLConexion.getConexion();
           String sql ="SELECT COUNT(IdProducto) from producto";
           PreparedStatement st = cn.prepareCall(sql);
           ResultSet rs=st.executeQuery();
      if(rs.next()){
          p= new Producto();
          p.setStock(rs.getInt(1));   
      }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return p;
    }
    
    
    //VALIDACIONES
    
    public void RegistroCliente(Cliente c){
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="INSERT INTO cliente values(null, ?, ?, ?, ?, ?, ?, ?, aes_encrypt(?,'clave123'), ?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getNombreCliente());
            st.setString(2, c.getApellidoCliente());
            st.setString(3, c.getGeneroCliente());
            st.setInt(4, c.getDNI());
            st.setInt(5, c.getEdadCliente());
            st.setString(6, c.getDireccionCliente());
            st.setString(7, c.getCorreoCliente());
            st.setString(8, c.getPassCliente());
            st.setInt(9, c.getIDEmpleado());
            
            st.executeUpdate();
            
          
            
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
    
    public Cliente ValidarUsuario(String user, String pass){
        Connection cn = null;
       Cliente c = null;
        try{
           cn =MySQLConexion.getConexion();
           String sql ="select IdCliente, NombreCli, cast(aes_decrypt(Pass, 'clave123') as char) from cliente WHERE NombreCli like ? AND cast(aes_decrypt(Pass, 'clave123')as char) like ?";
           PreparedStatement st = cn.prepareCall(sql);
           st.setString(1, user);
           st.setString(2, pass);
           ResultSet rs=st.executeQuery();
      while(rs.next()){
          c= new Cliente();
          c.setIdCliente(rs.getInt(1));
          c.setNombreCliente(rs.getString(2));
          c.setPassCliente(rs.getString(3));
      }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return c;
    }
    
    public Admin ValidarAdmin(){
        Connection cn = null;
       Admin a = null;
        try{
           cn =MySQLConexion.getConexion();
           String sql ="select AdminUser, cast(aes_decrypt(Contraseña, 'clave123') as char) from administrador";
           PreparedStatement st = cn.prepareCall(sql);
           ResultSet rs=st.executeQuery();
      if(rs.next()){
          a= new Admin();
          a.setAdminUser(rs.getString(1));
          a.setPass(rs.getString(2));
          
      }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return a;
    }
    
    //CARRITO DE COMPRAS
    
    public Juegos conseguirDatosJuego (int id){
        Connection cn = null;
        Juegos j = null;
        try{
         cn =MySQLConexion.getConexion(); 
         String sql ="SELECT NomJuego, Precio FROM juegos WHERE IdJuego = ?";
         PreparedStatement st = cn.prepareCall(sql);
         st.setInt(1, id);
         ResultSet rs=st.executeQuery();
         
        if(rs.next()){
          j= new Juegos();
          j.setNomJuego(rs.getString(1));
          j.setPrecio(rs.getDouble(2));
        } 
         
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return j;
    }
    
    public Ensamble conseguirDatosEnsamble (int id){
        Connection cn = null;
        Ensamble e = null;
        try{
         cn =MySQLConexion.getConexion(); 
         String sql ="SELECT NomEnsamble, PrecioEns FROM ensamble WHERE IdEnsamble = ?";
         PreparedStatement st = cn.prepareCall(sql);
         st.setInt(1, id);
         ResultSet rs=st.executeQuery();
         
        if(rs.next()){
          e= new Ensamble();
          e.setNomEnsamble(rs.getString(1));
          e.setPreEnsamble(rs.getDouble(2));
        } 
         
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return e;
    }
    
    public void añadirProductoAlCarrito(Compra c, int iduser){
        Connection cn = null;
        PreparedStatement st = null;
        try{
            cn=MySQLConexion.getConexion();
            String sql ="INSERT INTO compra VALUES (null, ?, ?, ?, ?, ?)";
            st = cn.prepareCall(sql);
            st.setString(1, c.getNombreProducto());
            st.setDouble(2, c.getPrecioProducto());
            st.setInt(3, c.getCantidadProducto());
            st.setInt(4, iduser);
            st.setInt(5, c.getIdProducto());
            
            st.executeUpdate();
        
        }catch(Exception ex){
            ex.printStackTrace(); 
        }
    }
    
    public List<Compra> ListarCarrito(int iduser){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Compra> lis = new ArrayList();
        
        try{
        String sql="SELECT IdCompra, NombreCompra, PrecioCompra, CantidadCompra, idProducto FROM compra WHERE idCliente = ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setInt(1, iduser);
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){
            Compra c = new Compra();  
            c.setIdCompra(rs.getInt(1));
            c.setNombreProducto(rs.getString(2));
            c.setPrecioProducto(rs.getDouble(3));
            c.setCantidadProducto(rs.getInt(4));
            c.setIdProducto(rs.getInt(5));
            
            lis.add(c);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
     
    
    public void EliminarProductoCarrito(int id){
        
        Connection cn = null;
        try{
            cn =MySQLConexion.getConexion();
           String sql ="DELETE FROM compra WHERE IdCompra=?";
           PreparedStatement st = cn.prepareCall(sql);
           st.setInt(1, id);
           st.executeUpdate();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
          
    }
     
    
    public void CrearFactura(double total, double igv, int iduser){
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="INSERT INTO factura values(null, NOW(), ?, ?, ?, ?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setDouble(1, total);
            st.setDouble(2, igv);
            st.setInt(3, iduser);
            st.setInt(4, 105);

            st.executeUpdate();
    
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
    
     public int ObtenerIdFactura(int iduser){
        Connection cn=MySQLConexion.getConexion();
        int idfactura=0;
        try{
           String sql="SELECT IdFactura FROM factura WHERE IdCliente=? ORDER BY IdFactura DESC LIMIT 1";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, iduser);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
               idfactura=rs.getInt(1);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return idfactura;
      }
    
    public void InsertarDetalleFactura(Compra c, int idfactura){
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="INSERT INTO detallefactura values(null, ?, ?, ?, ?, ?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getNombreProducto());
            st.setDouble(2, c.getPrecioProducto());
            st.setInt(3, c.getCantidadProducto());
            st.setInt(4, idfactura);
            st.setInt(5, c.getIdProducto());
            st.executeUpdate();
            
          
            
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
    
    public void ResetearCompra(int iduser){
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="DELETE FROM compra WHERE IdCliente = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, iduser);
            st.executeUpdate();
    
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
    
    public List<Compra> ListarDetalleVenta(int idfactura){ 
        
        Connection cn=MySQLConexion.getConexion(); //Nos conectamos a la BD
        
        List<Compra> lis = new ArrayList();
        
        try{
        String sql="SELECT idDetalle, NombreProducto, PrecioProducto, CantidadComprada, idProducto FROM detallefactura WHERE IdFactura =?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setInt(1, idfactura);
        ResultSet rs = st.executeQuery(); 
        
        while(rs.next()){
            Compra c = new Compra();  
            c.setIdCompra(rs.getInt(1));
            c.setNombreProducto(rs.getString(2));
            c.setPrecioProducto(rs.getDouble(3));
            c.setCantidadProducto(rs.getInt(4));
            c.setIdProducto(rs.getInt(5));
            
            lis.add(c);         
        }

        }catch (Exception ex){   
            ex.printStackTrace();
        }   
            
        return lis;
          
    }
}
 