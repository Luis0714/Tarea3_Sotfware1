import Controlers.ControlRegalo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ControlRegalo controlRegalo = new ControlRegalo("C:/Archivos 6° Semestre/SOTFWARE 1/ENTREGABLES/Tarea 3/Archivos De Prueba/Proveedores.json","C:/Archivos 6° Semestre/SOTFWARE 1/ENTREGABLES/Tarea 3/Archivos De Prueba/Productos.Json");
        Scanner lector = new Scanner(System.in);

        System.out.print("Edad: ");
        int edad = lector.nextInt();
        System.out.print("Precio maximo: ");
        int precio = lector.nextInt();

        controlRegalo.mostrarRegalosPorCriterios(edad,precio);
    }
}