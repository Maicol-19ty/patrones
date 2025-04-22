public class PizzaHawaianaBuilder extends PizzaBuilder {
    private Pizza pizza;

    public PizzaHawaianaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void buildMasa() {
        pizza.setMasa("A elección");
    }

    @Override
    public void buildTamaño(String tamaño) {
        pizza.setTamaño(tamaño);
    }

    @Override
    public void buildIngredientes(String ingredientes) {
        pizza.setIngredientes(ingredientes);
    }

    @Override
    public void buildSalsas(String salsas) {
        pizza.setSalsas(salsas);
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
