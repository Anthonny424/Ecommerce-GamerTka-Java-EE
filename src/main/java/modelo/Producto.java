
package modelo;


public class Producto extends Proveedor{
   private int idProducto; 
   private int stock;

    public Producto() {
    }

    public Producto(int idProducto, int stock) {
        this.idProducto = idProducto;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
   
   
   
   
}
