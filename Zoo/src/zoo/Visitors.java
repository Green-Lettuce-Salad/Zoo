package zoo;

public class Visitors {
    private String nombre;
    private int cedula;
    private int edad;
    private String fecha;

    public Visitors(String nombre, int cedula, int edad, String fecha) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
