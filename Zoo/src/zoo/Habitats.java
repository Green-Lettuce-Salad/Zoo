package zoo;

public class Habitats {
    private String nombre;
    private int capacidad;
    private Environment environment;
    private String codigo;
    
    public Habitats(String nombre, int capacidad, Environment environment, String codigo) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.environment = environment;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
