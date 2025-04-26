public class Main {
    public static void main(String[] args) {
        // Obtener la instancia del logger
        LoggerErrores logger = LoggerErrores.getInstancia();

        // Usar la conexión a la base de datos
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            conexion.conectar();
        } catch (Exception e) {
            // Registrar un error si ocurre algo al conectar
            logger.registrarError("Error al conectar a la base de datos: " + e.getMessage());
        }

        // Simular errores para demostrar el uso del logger
        try {
            // Simular un error en el programa
            int resultado = 10 / 0; // Esto generará una excepción de división por cero
        } catch (ArithmeticException e) {
            // Utilizar el logger para registrar el error
            logger.registrarError("Error de cálculo: " + e.getMessage());
        }

        try {
            // Simular otro error
            String texto = null;
            texto.length(); // Esto generará una excepción NullPointerException
        } catch (NullPointerException e) {
            // Utilizar el logger para registrar el error
            logger.registrarError("Error de puntero nulo: " + e.getMessage());
        }

        System.out.println("Pruebas finalizadas. Los errores han sido registrados en el archivo de log.");
    }
}