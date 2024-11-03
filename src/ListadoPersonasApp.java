import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        var salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e){
                System.out.println("Ocurrio un error" + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.print("""
                *** Listado Personas App ***
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opcion? ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion proporcionada
        switch (opcion){
            case 1 -> { //Agregar persona a la lista
                System.out.print("Proporciona nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Proporciona correo: ");
                var mail = consola.nextLine();
                // Crear el objeto persona
                var persona = new Persona(nombre, telefono, mail);
                // Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");

            } // Fin case 1

            case 2 -> { //Listar personas
                System.out.println("Listado de Personas: ");
                // Mejora usando lambda y metodo de referencia
                personas.forEach((persona -> System.out.println(persona)));
                //personas.forEach(System.out::println);
            }//Fin case 2
            case 3 -> { //Salimos del ciclo
                System.out.println("Hasta pronto");
                salir = true;
            } //Fin case 3
            default -> System.out.println("Opcion erronea: " + opcion);

        } //Fin switch
        return salir;
    }
}