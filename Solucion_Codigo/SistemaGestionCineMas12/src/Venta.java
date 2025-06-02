import java.util.ArrayList;
import java.util.Scanner;

public class Venta {

    private Funcion funcion;
    private int cantidadBoletos;
    private ArrayList<Snack> snacks;
    private ArrayList<Integer> cantidades;
    private double total;
    
    public Venta(Funcion funcion, int cantidadBoletos, ArrayList<Snack> snacks, ArrayList<Integer> cantidades, double total) {
        this.funcion = funcion;
        this.cantidadBoletos = cantidadBoletos;
        this.snacks = snacks;
        this.cantidades = cantidades;
        this.total = total;
    }

    public void mostrarVenta() {
        System.out.println("Pelicula: " + funcion.getPelicula().getNombre());
        System.out.println("Horario: " + funcion.getHorario());
        System.out.println("Sala: " + funcion.getPelicula().getSala());
        System.out.println("Día: " + funcion.getDia());
        System.out.println("Cantidad de boletos: " + cantidadBoletos);
        System.out.println("Snacks:");
        for (int i = 0; i < snacks.size(); i++) {
            System.out.println("- " + snacks.get(i).getNombre() + " x" + cantidades.get(i));
        }
        System.out.println("Total: $" + total);
        System.out.println("------------------------");
    }

    public static void realizarVenta(ArrayList<Funcion> funciones, ArrayList<Snack> snacksDisponibles, ArrayList<Venta> registroVentas, Scanner an) {
        System.out.println("\n--- Cartelera ---");
        for (int i = 0; i < funciones.size(); i++) {
            System.out.println((i + 1) + ". " + funciones.get(i).getInfo());
        }

        System.out.print("Seleccione una función: ");
        int indiceFuncion = an.nextInt() - 1;
        if (indiceFuncion < 0 || indiceFuncion >= funciones.size()) {
            System.out.println("Función inválida.");
            return;
        }

        Funcion funcionSeleccionada = funciones.get(indiceFuncion);

        System.out.print("Cantidad de boletos: ");
        int cantidadBoletos = an.nextInt();

        double totalBoletos = funcionSeleccionada.getPrecio() * cantidadBoletos;

        switch (funcionSeleccionada.getDia().toLowerCase()) {
            case "miércoles":
                totalBoletos *= 0.8;
                System.out.println("¡Promoción del 20% aplicada en boletos!");
                break;
            case "martes":
                totalBoletos *= 0.9;
                System.out.println("¡Promoción del 10% aplicada en boletos!");
                break;
            case "viernes":
                totalBoletos *= 0.6;
                System.out.println("¡Promoción del 40% aplicada en boletos!");
                break;
            case "domingo":
                totalBoletos *= 0.5;
                System.out.println("¡Promoción del 50% aplicada en boletos!");
                break;
        }

        ArrayList<Snack> snacksComprados = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        double totalSnacks = 0;
        String continuar;
        do {
            System.out.println("\n--- Snacks disponibles ---");
            for (int i = 0; i < snacksDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + snacksDisponibles.get(i).getNombre() + " - $" + snacksDisponibles.get(i).getPrecio());
            }
            System.out.println((snacksDisponibles.size() + 1) + ". De nada");

            System.out.print("Seleccione snack: ");
            int snackIndex = an.nextInt() - 1;
            an.nextLine();

            if (snackIndex == snacksDisponibles.size()) {
                System.out.println("No se seleccionó ningún snack.");
            } else if (snackIndex >= 0 && snackIndex < snacksDisponibles.size()) {
                System.out.print("Cantidad: ");
                int cantidad = an.nextInt();
                an.nextLine();

                Snack snack = snacksDisponibles.get(snackIndex);
                snacksComprados.add(snack);
                cantidades.add(cantidad);
                totalSnacks += snack.getPrecio() * cantidad;
            } else {
                System.out.println("Selección inválida.");
            }

            System.out.print("¿Desea agregar otro snack? (si/no): ");
            continuar = an.nextLine();
        } while (continuar.equalsIgnoreCase("si"));

        double totalFinal = totalBoletos + totalSnacks;

        Venta venta = new Venta(funcionSeleccionada, cantidadBoletos, snacksComprados, cantidades, totalFinal);
        registroVentas.add(venta);

        System.out.println("\n--- Factura ---");
        venta.mostrarVenta();
    }

    public static void mostrarVentas(ArrayList<Venta> registroVentas) {
        System.out.println("\n--- Registro de Ventas ---");
        if (registroVentas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (Venta v : registroVentas) {
                v.mostrarVenta();
            }
        }
    }
}
