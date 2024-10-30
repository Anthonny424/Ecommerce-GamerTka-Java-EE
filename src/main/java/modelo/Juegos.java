
package modelo;

public class Juegos extends Producto{
    
    private int idJuego;
    private String categoria;
    private String NomJuego;
    private String DescJuego;
    private double precio;
    private int anioLanza;

    public Juegos() {
    }

    public Juegos(int idJuego, String categoria, String NomJuego, String DescJuego, double precio, int anioLanza) {
        this.idJuego = idJuego;
        this.categoria = categoria;
        this.NomJuego = NomJuego;
        this.DescJuego = DescJuego;
        this.precio = precio;
        this.anioLanza = anioLanza;
    }

    public int getAnioLanza() {
        return anioLanza;
    }

    public void setAnioLanza(int anioLanza) {
        this.anioLanza = anioLanza;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNomJuego() {
        return NomJuego;
    }

    public void setNomJuego(String NomJuego) {
        this.NomJuego = NomJuego;
    }

    public String getDescJuego() {
        return DescJuego;
    }

    public void setDescJuego(String DescJuego) {
        this.DescJuego = DescJuego;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
