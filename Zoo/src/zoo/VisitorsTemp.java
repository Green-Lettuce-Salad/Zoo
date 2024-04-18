package zoo;

public class VisitorsTemp {

    private String fecha;
    private int cantidad;
    private int cantMayores;
    private int cantMenores;

    public VisitorsTemp(String fecha, int cantidad, int cantMayores, int cantMenores) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.cantMayores = cantMayores;
        this.cantMenores = cantMenores;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantMayores() {
        return cantMayores;
    }

    public void setCantMayores(int cantMayores) {
        this.cantMayores = cantMayores;
    }

    public int getCantMenores() {
        return cantMenores;
    }

    public void setCantMenores(int cantMenores) {
        this.cantMenores = cantMenores;
    }
}
