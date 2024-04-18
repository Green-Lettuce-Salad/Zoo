package zoo;

public class Habitats {
    private String nombre;
    private int capacidad;
    private Environment environment;

    public Habitats(String nombre, int capacidad, Environment environment) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.environment = environment;
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
}
