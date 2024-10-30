
package modelo;


public class Factura extends Cliente{
    private int IdFactura;
    private String FechaFac;
    private double Monto;
    private String FacIGV;

    public Factura() {
    }

    public Factura(int IdFactura, String FechaFac, double Monto, String FacIGV) {
        this.IdFactura = IdFactura;
        this.FechaFac = FechaFac;
        this.Monto = Monto;
        this.FacIGV = FacIGV;
    }

    public String getFacIGV() {
        return FacIGV;
    }

    public void setFacIGV(String FacIGV) {
        this.FacIGV = FacIGV;
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public String getFechaFac() {
        return FechaFac;
    }

    public void setFechaFac(String FechaFac) {
        this.FechaFac = FechaFac;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }
   
    
    
}
