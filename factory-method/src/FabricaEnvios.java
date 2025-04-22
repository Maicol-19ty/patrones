public abstract class FabricaEnvios {

    public abstract Envio crearEnvio();

    public void despachar() {
        Envio envio = crearEnvio();
        System.out.println("Mensaje obtenido de la fábrica: " + envio.enviar());
    }
}
