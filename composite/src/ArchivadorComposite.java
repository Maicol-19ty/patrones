/**
 * Patrón Composite para un sistema de archivador simple
 * Permite tratar archivos individuales y carpetas de forma uniforme
 */

import java.util.ArrayList;  // Importa la clase ArrayList para manejar listas de objetos
import java.util.List;       // Importa la interfaz List para usar listas genéricas

/**
 * Component: Interfaz común para todos los elementos (archivos y carpetas)
 */
interface ArchivoComponent {
    String getNombre();                    // Método para obtener el nombre del archivo o carpeta
    int getTamaño();                       // Método para obtener el tamaño (de forma recursiva si es carpeta)
    void mostrar(String indentacion);      // Método para mostrar la estructura con indentación visual
}

/**
 * Leaf: Representa un archivo individual (no tiene hijos)
 */
class Archivo implements ArchivoComponent {
    private String nombre;  // Nombre del archivo
    private int tamaño;     // Tamaño en bytes

    // Constructor para inicializar el archivo con su nombre y tamaño
    public Archivo(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }
    /**
     * @Override indica que este método está implementando
     */
    @Override
    public String getNombre() {
        return nombre;  // Retorna el nombre del archivo
    }

    @Override
    public int getTamaño() {
        return tamaño;  // Retorna el tamaño del archivo
    }

    @Override
    public void mostrar(String indentacion) { //  //(String indentacion)	Este método recibe un parámetro llamado indentacion, que es un texto (String).
        // Muestra el archivo con su nombre y tamaño, usando indentación para jerarquía
        System.out.println(indentacion + "📄 Archivo: " + nombre + " (" + tamaño + " bytes)");
    }
}

/**
 * Composite: Representa una carpeta que puede contener archivos y otras carpetas
 */
class Carpeta implements ArchivoComponent {
    private String nombre;                               // Nombre de la carpeta
    private List<ArchivoComponent> hijos;                // Lista de archivos o carpetas que contiene

    // Constructor para inicializar la carpeta con su nombre
    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();                  // Crea una lista vacía para los hijos
    }

    @Override
    public String getNombre() {
        return nombre;                                   // Retorna el nombre de la carpeta
    }

    @Override
    public int getTamaño() {
        // Calcula el tamaño total sumando recursivamente el tamaño de todos los hijos
        int tamañoTotal = 0;
        for (ArchivoComponent componente : hijos) {
            tamañoTotal += componente.getTamaño();      // Llamada recursiva
        }
        return tamañoTotal;
    }

    // Añade un nuevo archivo o carpeta a la lista de hijos
    public void añadir(ArchivoComponent componente) {
        hijos.add(componente);
    }

    // Elimina un archivo o carpeta de la lista de hijos
    public void eliminar(ArchivoComponent componente) {
        hijos.remove(componente);
    }

    @Override
    public void mostrar(String indentacion) {
        // Muestra la carpeta con su nombre y tamaño total
        System.out.println(indentacion + "📁 Carpeta: " + nombre + " (" + getTamaño() + " bytes)");
        // Recorre todos los hijos y los muestra con más indentación (jerarquía visual)
        for (ArchivoComponent componente : hijos) {
            componente.mostrar(indentacion + "    ");
        }
    }
}

/**
 * Cliente: Utiliza la estructura de archivos
 */
public class ArchivadorComposite {
    public static void main(String[] args) {
        // Crear carpeta raíz
        Carpeta raiz = new Carpeta("Raíz");

        // Crear subcarpetas
        Carpeta documentos = new Carpeta("Documentos");
        Carpeta imagenes = new Carpeta("Imágenes");
        Carpeta proyectos = new Carpeta("Proyectos"); // Nueva subcarpeta dentro de Documentos

        // Crear archivos individuales
        Archivo archivo1 = new Archivo("documento.txt", 100);
        Archivo archivo2 = new Archivo("foto.jpg", 2000);
        Archivo archivo3 = new Archivo("config.xml", 300);
        Archivo archivo4 = new Archivo("proyecto1.docx", 500);
        Archivo archivo5 = new Archivo("proyecto2.pptx", 800);

        // Añadir archivos a carpetas correspondientes
        documentos.añadir(archivo1);     // documento.txt dentro de Documentos
        documentos.añadir(archivo3);     // config.xml dentro de Documentos

        // Añadir archivos a la subcarpeta Proyectos
        proyectos.añadir(archivo4);      // proyecto1.docx dentro de Proyectos
        proyectos.añadir(archivo5);      // proyecto2.pptx dentro de Proyectos

        // Añadir la subcarpeta Proyectos a Documentos
        documentos.añadir(proyectos);   // Proyectos dentro de Documentos

        imagenes.añadir(archivo2);       // foto.jpg dentro de Imágenes

        // Añadir carpetas a la raíz
        raiz.añadir(documentos);
        raiz.añadir(imagenes);

        // Mostrar estructura completa del archivador
        System.out.println("📂 Estructura del Archivador:");
        raiz.mostrar("");                // Muestra toda la jerarquía desde la raíz

        // Mostrar tamaño total de la raíz
        System.out.println("\n📦 Tamaño total: " + raiz.getTamaño() + " bytes");
    }
}