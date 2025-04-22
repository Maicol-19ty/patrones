public class Pizzeria {
    private PizzaBuilder builder;

    public Pizzeria(PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza hacerPizza(String tamaño, String ingredientes, String salsas) {
        builder.buildMasa();
        builder.buildTamaño(tamaño);
        builder.buildIngredientes(ingredientes);
        builder.buildSalsas(salsas);
        return builder.getPizza();
    }
}
