
package modelo;

public class Empleado extends Admin{
 private int IDEmpleado;   
 private String nombre;
 private String direccion;
 private String genero;
 private int edad;

    public Empleado() {
    }

    public Empleado(int IDEmpleado, String nombre, String direccion, String genero, int edad) {
        this.IDEmpleado = IDEmpleado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.genero = genero;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
 
 
 
 
 
}
