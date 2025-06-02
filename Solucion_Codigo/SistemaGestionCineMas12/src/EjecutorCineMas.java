
import java.util.ArrayList;
import java.util.Scanner;

public class EjecutorCineMas {

    private Scanner an = new Scanner(System.in);
    private ArrayList<Funcion> funciones = new ArrayList<>();
    private ArrayList<Snack> snacksDisponibles = new ArrayList<>();
    private ArrayList<Venta> registroVentas = new ArrayList<>();

    public static void main(String[] args) {
        EjecutorCineMas sistema = new EjecutorCineMas();
        sistema.iniciar();
    }

    public void iniciar() {
        inicializacion();
        snacks();

        int opcion;
        do {

            System.out.println("\n--- CineMas-Loja ---");
            System.out.println("1. Ver Cartelera");
            System.out.println("2. Comprar Boletos");
            System.out.println("3. Ver Registro de Ventas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = an.nextInt();
            an.nextLine();

            switch (opcion) {
                case 1:
                    mostrarCartelera();
                    break;
                case 2:
                    Venta.realizarVenta(funciones, snacksDisponibles, registroVentas, an);
                    break;
                case 3:
                    Venta.mostrarVentas(registroVentas);
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

    }

    public void inicializacion() {
        Pelicula p1 = new Pelicula("Como entrenar a tu dragon", "Accion", 1);
        Pelicula p2 = new Pelicula("Toy Story", "Animacion", 2);
        Pelicula p3 = new Pelicula("Titanic", "Romance", 3);
        Pelicula p4 = new Pelicula("Aprendiz Brujo", "Accion", 4);
        Pelicula p5 = new Pelicula("El Abismo Secreto", "Ficcion", 5);
        Pelicula p6 = new Pelicula("De todos los chicos que me enamore", "Romance", 6);
        Pelicula p7 = new Pelicula("Cars 3 ", "Animacion", 7);

        funciones.add(new Funcion(p1, "16:00", "Lunes", 5.0));
        funciones.add(new Funcion(p2, "18:00", "Miercoles", 4.5));
        funciones.add(new Funcion(p3, "20:00", "Viernes", 6.0));
        funciones.add(new Funcion(p4, "14:00", "Sabado", 8.0));
        funciones.add(new Funcion(p5, "22:00", "Jueves", 3.5));
        funciones.add(new Funcion(p6, "10:00", "Domingo", 5.0));
        funciones.add(new Funcion(p7, "08:00", "Martes", 6.5));
    }

    public void snacks() {
        snacksDisponibles.add(new Snack("Canguil", 2.0));
        snacksDisponibles.add(new Snack("Refrescos", 1.5));
        snacksDisponibles.add(new Snack("Nachos", 2.5));
        snacksDisponibles.add(new Snack("Hot Dog", 2.0));
        snacksDisponibles.add(new Snack("Granizado", 1.5));
        snacksDisponibles.add(new Snack("Pizza", 1.0));
        snacksDisponibles.add(new Snack("nada", 0.0));
    }

    public void mostrarCartelera() {
        System.out.println("\n--- Cartelera ---");
        for (int i = 0; i < funciones.size(); i++) {
            System.out.println((i + 1) + ". " + funciones.get(i).getInfo());
        }
    }
}
