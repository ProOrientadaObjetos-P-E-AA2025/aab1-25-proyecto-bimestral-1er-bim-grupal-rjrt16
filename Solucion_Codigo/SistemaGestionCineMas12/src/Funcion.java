public class Funcion {
    private Pelicula pelicula;
    private String horario;
    private String dia;
    private double precio;

    public Funcion(Pelicula pelicula, String horario, String dia, double precio) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.dia = dia;
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }
    public String getDia() {
        return dia;
    }

    public double getPrecio() {
        return precio;
    }

    public String getInfo() {
        return pelicula.getNombre() + " - " + horario + " - Sala " + pelicula.getSala() + " - " + dia + " - $" + precio;
    }
}