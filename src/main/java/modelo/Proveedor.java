
package modelo;


public class Proveedor extends Admin{
    private int idProveedor;
    private String NomEmpresa;
    private String DirecProve;
    private int telefono;
    private String TipoProducto;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String NomEmpresa, String DirecProve, int telefono, String TipoProducto) {
        this.idProveedor = idProveedor;
        this.NomEmpresa = NomEmpresa;
        this.DirecProve = DirecProve;
        this.telefono = telefono;
        this.TipoProducto = TipoProducto;
    }

   

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNomEmpresa() {
        return NomEmpresa;
    }

    public void setNomEmpresa(String NomEmpresa) {
        this.NomEmpresa = NomEmpresa;
    }

    public String getDirecProve() {
        return DirecProve;
    }

    public void setDirecProve(String DirecProve) {
        this.DirecProve = DirecProve;
    }

    public String getTipoProducto() {
        return TipoProducto;
    }

    public void setTipoProducto(String TipoProducto) {
        this.TipoProducto = TipoProducto;
    }

}
