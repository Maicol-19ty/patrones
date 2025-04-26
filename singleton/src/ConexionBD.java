public class ConexionBD {
    private static ConexionBD  instancia;

    // Constructor privado para evitar instanciación externa
    private ConexionBD() {}

    // Método de acceso público para obtener la instancia
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public void conectar() {
        System.out.println("Conectado a la base de datos");
    }


}
