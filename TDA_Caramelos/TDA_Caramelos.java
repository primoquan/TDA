//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Luis Quan
//201927151


import java.util.Stack;
import java.util.Random;

public class TDA_Caramelos {

    public static void main(String[] args) {
        try {
            // Crear una pila para representar el paquete de caramelos
            Stack<String> paquete = new Stack<>();
            Stack<String> temp = new Stack<>();

            // Colores disponibles para los caramelos
            String[] colores = {"amarillo", "rojo", "verde", "azul", "naranja"};
            Random rand = new Random();

            // Llenar el paquete con al menos 2 caramelos de cada color
            for (String color : colores) {
                paquete.push(color);
                paquete.push(color);
            }

            // Completar el paquete con 4 caramelos adicionales de colores aleatorios
            for (int i = 0; i < 4; i++) {
                int indiceColor = rand.nextInt(colores.length); // Selecciona un color aleatorio
                paquete.push(colores[indiceColor]);
            }

            // Mezclar el paquete para que los caramelos estén en orden aleatorio
            mezclarPila(paquete);

            // Mostrar el contenido inicial del paquete, le agrego un thread.sleep para no imprimir todo de un solo
            System.out.println("Paquete inicial: " + paquete);
            Thread.sleep(1000); // Pausa de 1 segundo

            // Sacar los caramelos uno por uno y comer solo los amarillos
            System.out.println("El niño está comiendo los caramelos amarillos...");
            while (!paquete.isEmpty()) {
                String caramelo = paquete.pop();
                if (caramelo.equals("amarillo")) {
                    System.out.println("Comió un caramelo amarillo");
                    Thread.sleep(1000); // Pausa de 1 segundo
                } else {
                    temp.push(caramelo); // Guardar los caramelos de otros colores en la pila temporal
                }
            }

            // Devolver los caramelos no comidos al paquete original en el orden original
            while (!temp.isEmpty()) {
                paquete.push(temp.pop());
            }

            // Mostrar el contenido final del paquete
            System.out.println("Paquete final después de comer los caramelos amarillos: " + paquete);
        } catch (InterruptedException e) {
            System.out.println("El programa fue interrumpido durante la pausa.");
        }
    }

    // Método para mezclar una pila
    private static void mezclarPila(Stack<String> pila) {
        Random rand = new Random();
        String[] elementos = pila.toArray(new String[0]);
        pila.clear();

        // Mezclar el arreglo de elementos
        for (int i = elementos.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = elementos[i];
            elementos[i] = elementos[j];
            elementos[j] = temp;
        }

        // Volver a llenar la pila con los elementos mezclados
        for (String elemento : elementos) {
            pila.push(elemento);
        }
    }
}