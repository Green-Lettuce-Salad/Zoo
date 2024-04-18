package zoo;

public class Animals {
    private String nombre;
    private Species especie;
    private int edad;
    private String habitat;

    public Animals(String nombre, Species especie, int edad, String habitat) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.habitat = habitat;
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

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
