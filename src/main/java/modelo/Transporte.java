
package modelo;


public class Transporte {
    private int IdTransporte;
    private String NomConductor;
    private String Placa;
    private String TipoTrans;

    public Transporte() {
    }

    public Transporte(int IdTransporte, String NomConductor, String Placa, String TipoTrans) {
        this.IdTransporte = IdTransporte;
        this.NomConductor = NomConductor;
        this.Placa = Placa;
        this.TipoTrans = TipoTrans;
    }

    public String getTipoTrans() {
        return TipoTrans;
    }

    public void setTipoTrans(String TipoTrans) {
        this.TipoTrans = TipoTrans;
    }

    public int getIdTransporte() {
        return IdTransporte;
    }

    public void setIdTransporte(int IdTransporte) {
        this.IdTransporte = IdTransporte;
    }

    public String getNomConductor() {
        return NomConductor;
    }

    public void setNomConductor(String NomConductor) {
        this.NomConductor = NomConductor;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }
    
    
    
    
}
