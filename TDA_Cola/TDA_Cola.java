//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Luis Quan
//201927151

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TDA_Cola {

    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Mostrar lista de comandos al inicio
        System.out.println("Bienvenido al sistema de atención de la tienda.");
        System.out.println("Ingrese el nombre del cliente para agregarlo a la fila.");
        System.out.println("Comandos disponibles:");
        System.out.println("ATENDER: Atiende al primer cliente en la fila.");
        System.out.println("MOSTRAR: Muestra el estado actual de la fila.");
        System.out.println("SALIR: Finaliza el programa.");

        while (!salir) {
            System.out.print("Ingrese el nombre del cliente o un comando: ");
            String entrada = scanner.nextLine().trim();

            // Verificar si la entrada es un comando
            switch (entrada.toUpperCase()) {
                case "ATENDER":
                    if (!fila.isEmpty()) {
                        String clienteAtendido = fila.poll();
                        System.out.println("Atendiendo a: " + clienteAtendido);
                    } else {
                        System.out.println("No hay clientes en la fila.");
                    }
                    break;

                case "MOSTRAR":
                    if (!fila.isEmpty()) {
                        System.out.println("Fila actual: " + String.join(", ", fila));
                    } else {
                        System.out.println("La fila está vacía.");
                    }
                    break;

                case "SALIR":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    // Si no es un comando, asumimos que es el nombre de un cliente
                    if (!entrada.isEmpty()) {
                        fila.add(entrada);
                        System.out.println(entrada + " ha llegado a la fila.");
                    } else {
                        System.out.println("Entrada no válida. Intente nuevamente.");
                    }
                    break;
            }
        }

        scanner.close();
    }
}