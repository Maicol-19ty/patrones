import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerErrores {
    private static LoggerErrores instancia;
    private static final String RUTA_ARCHIVO = "errores.log";

    // Constructor privado para evitar instanciación externa
    private LoggerErrores() {}

    // Método de acceso público para obtener la instancia única
    public static LoggerErrores getInstancia() {
        if (instancia == null) {
            instancia = new LoggerErrores();
        }
        return instancia;
    }

    // Método para registrar errores
    public void registrarError(String mensaje) {
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO, true)) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[" + timestamp + "] ERROR: " + mensaje + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("No se pudo escribir en el archivo de log: " + e.getMessage());
        }
    }
}