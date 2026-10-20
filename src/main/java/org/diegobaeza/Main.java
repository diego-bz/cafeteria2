import java.util.Locale;
import java.util.Scanner;

public class cafeteria1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // para leer decimales con punto (20.50)

        int opcion = 0;
        int totalCompras = 0;          // contador de compras registradas
        double ventasDelDia = 0;       // acumulador del total vendido

        while (opcion != 2) {
            System.out.println("================================");
            System.out.println("       CAFETERÍA ESCOLAR");
            System.out.println("================================");
            System.out.println("1. Registrar compra");
            System.out.println("2. Salir");
            System.out.println("================================");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpia el salto de línea pendiente

            switch (opcion) {
                case 1:
                    System.out.println("================================");
                    System.out.println("       REGISTRAR COMPRA");
                    System.out.println("================================");
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();

                    System.out.print("¿Cuántos productos comprará?: ");
                    int numProductos = sc.nextInt();

                    double subtotal = 0; // acumulador del subtotal

                    for (int i = 1; i <= numProductos; i++) {
                        System.out.println("Producto " + i);
                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        System.out.print("Cantidad: ");
                        int cantidad = sc.nextInt();

                        double importe = precio * cantidad;
                        subtotal += importe;
                        System.out.println("Importe: $" + String.format(Locale.US, "%.2f", importe));
                    }
                    sc.nextLine(); // limpia el salto de línea pendiente

                    // Cálculo del descuento
                    double porcentaje;
                    if (subtotal >= 300) {
                        porcentaje = 0.10;
                    } else if (subtotal >= 100) {
                        porcentaje = 0.05;
                    } else {
                        porcentaje = 0;
                    }

                    double descuento = subtotal * porcentaje;
                    double total = subtotal - descuento;

                    totalCompras++;
                    ventasDelDia += total;

                    System.out.println("================================");
                    System.out.println("       RESUMEN DE COMPRA");
                    System.out.println("================================");
                    System.out.println("Cliente: " + cliente);
                    System.out.println("Subtotal: $" + String.format(Locale.US, "%.2f", subtotal));
                    System.out.println("Descuento: $" + String.format(Locale.US, "%.2f", descuento));
                    System.out.println("Total: $" + String.format(Locale.US, "%.2f", total));
                    System.out.println("================================");
                    break;

                case 2:
                    System.out.println("================================");
                    System.out.println("Compras registradas: " + totalCompras);
                    System.out.println("Ventas del día: $" + String.format(Locale.US, "%.2f", ventasDelDia));
                    System.out.println("¡Hasta pronto!");
                    System.out.println("================================");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        sc.close();
    }
}