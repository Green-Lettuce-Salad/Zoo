package zoo;

public class Animals {
    private String nombre;
    private Species especie;
    private int edad;
    private Environment environment;

    public Animals(String nombre, Species especie, int edad, Environment environment) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.environment = environment;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Species getEspecie() {
        return especie;
    }

    public void setEspecie(Species especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Habitats habitats) {
        this.environment = environment;
    }
}
