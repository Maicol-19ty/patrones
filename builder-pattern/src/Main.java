import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos datos al usuario
        System.out.print("Elige el tamaño de la pizza: ");
        String tamaño = sc.nextLine();
        System.out.print("Elige los ingredientes (separados por coma): ");
        String ingredientes = sc.nextLine();
        System.out.print("Elige las salsas (separadas por coma): ");
        String salsas = sc.nextLine();

        PizzaBuilder builder = new PizzaHawaianaBuilder();
        Pizzeria pizzeria = new Pizzeria(builder);

        Pizza miPizza = pizzeria.hacerPizza(tamaño, ingredientes, salsas);
        miPizza.mostrarPizza();
    }
}