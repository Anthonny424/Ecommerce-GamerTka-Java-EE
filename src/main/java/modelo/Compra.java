
package modelo;


public class Compra extends Producto{
    private int IdCompra;
    private String NombreProducto;
    private double precioProducto;
    private int cantidadProducto;

    public Compra() {
    }

    public Compra(int IdCompra, String NombreProducto, double precioProducto, int cantidadProducto) {
        this.IdCompra = IdCompra;
        this.NombreProducto = NombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public double Total(){
        return precioProducto*cantidadProducto;
    }
    
    
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
}
