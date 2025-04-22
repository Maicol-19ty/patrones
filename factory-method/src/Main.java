public class Main {
    public static void main(String[] args) {
        System.out.println("Probando la Fábrica de Envíos Terrestres:");
        FabricaEnvios fabricaTerrestre = new FabricaEnvioTerrestre();
        fabricaTerrestre.despachar();

        System.out.println("\nProbando la Fábrica de Envíos Marítimos:");
        FabricaEnvios fabricaMaritima = new FabricaEnvioMaritimo();
        fabricaMaritima.despachar();

        System.out.println("\nProbando la Fábrica de Envíos Aéreos:");
        FabricaEnvios fabricaAerea = new FabricaEnvioAereo();
        fabricaAerea.despachar();
    }
}