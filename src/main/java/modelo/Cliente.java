
package modelo;

public class Cliente extends Empleado{
    private int IdCliente;
    private String NombreCliente;
    private String ApellidoCliente;
    private String GeneroCliente;
    private int DNI;
    private int EdadCliente;
    private String DireccionCliente;
    private String CorreoCliente;
    private String passCliente;

    public Cliente() {
    }

    public Cliente(int IdCliente, String NombreCliente, String ApellidoCliente, String GeneroCliente, int DNI, int EdadCliente, String DireccionCliente, String CorreoCliente, String passCliente) {
        this.IdCliente = IdCliente;
        this.NombreCliente = NombreCliente;
        this.ApellidoCliente = ApellidoCliente;
        this.GeneroCliente = GeneroCliente;
        this.DNI = DNI;
        this.EdadCliente = EdadCliente;
        this.DireccionCliente = DireccionCliente;
        this.CorreoCliente = CorreoCliente;
        this.passCliente = passCliente;
    }
    
    

    public String getCorreoCliente() {
        return CorreoCliente;
    }

    public void setCorreoCliente(String CorreoCliente) {
        this.CorreoCliente = CorreoCliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getApellidoCliente() {
        return ApellidoCliente;
    }

    public void setApellidoCliente(String ApellidoCliente) {
        this.ApellidoCliente = ApellidoCliente;
    }

    public String getGeneroCliente() {
        return GeneroCliente;
    }

    public void setGeneroCliente(String GeneroCliente) {
        this.GeneroCliente = GeneroCliente;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getEdadCliente() {
        return EdadCliente;
    }

    public void setEdadCliente(int EdadCliente) {
        this.EdadCliente = EdadCliente;
    }

    public String getDireccionCliente() {
        return DireccionCliente;
    }

    public void setDireccionCliente(String DireccionCliente) {
        this.DireccionCliente = DireccionCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }
    
    
    
}
