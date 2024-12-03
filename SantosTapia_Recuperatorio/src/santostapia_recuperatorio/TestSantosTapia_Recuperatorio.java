
package santostapia_recuperatorio;

public class TestSantosTapia_Recuperatorio {

    public static void main(String[] args) {
        AgenciaEspacial ae = new AgenciaEspacial();

        try {
            ae.agregarNave(new NaveExploracion("nave exp", 5, 2020, TipoMision.CARTOGRAFIA));
            ae.agregarNave(new Carguero("Galactica", 10, 2019, 300));
            ae.agregarNave(new CruceroEstelar("cru esp", 22, 2022, 200));
            ae.agregarNave(new Carguero("Galactica", 17, 2019, 350));

            ae.mostrarNaves();
            System.out.println("---------------");
            ae.iniciarExploracion();

        } catch (NaveRepetidaException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

