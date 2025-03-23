//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Luis Quan
//201927151

package TDA_Pila;

import java.util.Scanner;
import java.util.Stack;

public class TDA_Pila {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> pilaTexto = new Stack<>();
        Stack<String> pilaDeshecho = new Stack<>();
        String entrada;

        //Aqui explicamos como funcionan los comandos para poder ingresar, deshacer o rehacer
        System.out.println("Bienvenido esto es un editor de texto.");
        System.out.println("Primer paso, escribe tu texto");
        System.out.println("Comandos disponibles, se pone luego de Entrada:");
        System.out.println("DESHACER: Este elimina la última línea agregada.");
        System.out.println("REHACER: Restaura la última acción deshecha.");
        System.out.println("MOSTRAR: Muestra el texto.");
        System.out.println("SALIR: Finaliza el programa.");
        System.out.println();


        //Creamos un ciclo while para pedir el texto y los comandos
        while (true) {
            System.out.print("Entrada: ");
            entrada = scanner.nextLine();

            if (entrada.equals("SALIR")) {
                break;
            } else if (entrada.equals("DESHACER")) {
                if (!pilaTexto.isEmpty()) {
                    pilaDeshecho.push(pilaTexto.pop());
                } else {
                    System.out.println("No hay acciones para deshacer.");
                }
            } else if (entrada.equals("REHACER")) {
                if (!pilaDeshecho.isEmpty()) {
                    pilaTexto.push(pilaDeshecho.pop());
                } else {
                    System.out.println("No hay acciones para rehacer.");
                }
            } else if (entrada.equals("MOSTRAR")) {
                mostrarTexto(pilaTexto);
            } else {
                pilaTexto.push(entrada);
            }
        }

        System.out.println("¡Gracias por usar el editor de texto!");
        scanner.close();
    }

    private static void mostrarTexto(Stack<String> pilaTexto) {
        System.out.println("Estado actual del texto:");
        for (String linea : pilaTexto) {
            System.out.println(linea);
        }
    }
}
