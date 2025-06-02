public class Pelicula {
    private String nombre;
    private String genero;
    private int sala;

    public Pelicula(String nombre, String genero, int sala) {
        this.nombre = nombre;
        this.genero = genero;
        this.sala = sala;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }
    public int getSala(){
        return sala;
    }
}