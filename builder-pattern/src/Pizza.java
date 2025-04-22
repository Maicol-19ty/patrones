public class Pizza {

    private String masa;
    private String tamaño;
    private String ingredientes;
    private String salsas; // Nuevo campo

    // Setters
    public void setMasa(String masa) {
        this.masa = masa;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setSalsas(String salsas) {
        this.salsas = salsas;
    }

    // Método para mostrar la pizza final
    public void mostrarPizza() {
        System.out.println("Pizza [Masa: " + masa + ", Tamaño: " + tamaño + ", Ingredientes: " + ingredientes + ", Salsas: " + salsas + "]");
    }

}
