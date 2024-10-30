
package modelo;


public class Ensamble extends Producto{
    private int idEnsamble;
    private double preEnsamble;
    private String nomEnsamble;
    private String descEnsamble;
    private String modelo;
    private int garantia;

    public Ensamble() {
    }

    public Ensamble(int idEnsamble, double preEnsamble, String nomEnsamble, String descEnsamble, String modelo, int garantia) {
        this.idEnsamble = idEnsamble;
        this.preEnsamble = preEnsamble;
        this.nomEnsamble = nomEnsamble;
        this.descEnsamble = descEnsamble;
        this.modelo = modelo;
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getIdEnsamble() {
        return idEnsamble;
    }

    public void setIdEnsamble(int idEnsamble) {
        this.idEnsamble = idEnsamble;
    }

    public double getPreEnsamble() {
        return preEnsamble;
    }

    public void setPreEnsamble(double preEnsamble) {
        this.preEnsamble = preEnsamble;
    }

    public String getNomEnsamble() {
        return nomEnsamble;
    }

    public void setNomEnsamble(String nomEnsamble) {
        this.nomEnsamble = nomEnsamble;
    }

    public String getDescEnsamble() {
        return descEnsamble;
    }

    public void setDescEnsamble(String descEnsamble) {
        this.descEnsamble = descEnsamble;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
    
}
