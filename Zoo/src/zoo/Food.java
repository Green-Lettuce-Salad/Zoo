package zoo;

public class Food {
    private String codHorario;
    private Species specie;
    private String horario;
    private int cantidad;
    private String notas;

    public Food(String codHorario, Species specie, String horario, int cantidad, String notas) {
        this.codHorario = codHorario;
        this.specie = specie;
        this.horario = horario;
        this.cantidad = cantidad;
        this.notas = notas;
    }

    public String getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(String codHorario) {
        this.codHorario = codHorario;
    }

    public Species getSpecie() {
        return specie;
    }

    public void setSpecie(Species specie) {
        this.specie = specie;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
