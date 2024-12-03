
package santostapia_integrador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;


public class TestSantosTapia_Integrador {

    public static void main(String[] args) {
        
        try{
        Gestion<EscuelaMagia> escuelaMagica = new Gestion<>();
        Gestion<TorneosdeHechiceria> torneoEchizeria = new Gestion<>();
        
        escuelaMagica.registrarEscuela(new AcademiasdeEncantamientos("fgd", 34, "dgd"));
        escuelaMagica.registrarEscuela(new InstitutosdeInvocacion("ttr", 345, "y"));
        escuelaMagica.registrarEscuela(new EscuelasdeHechizosElementales("X-", 56, "d"));

        torneoEchizeria.registrarTorneo(new TorneosdeHechiceria("dfbd", LocalDate.now(), 5, Estadodeltorneo.CANCELADO));
        torneoEchizeria.registrarTorneo(new TorneosdeHechiceria("dfbdfg", LocalDate.now(), 6, Estadodeltorneo.PROGRAMADO));
        
        escuelaMagica.ordenar((n1, n2) -> n1.getNombre().compareTo(n2.getNombre()));
        escuelaMagica.paraCadaElementoE(escuela -> System.out.println(escuela));
        
        torneoEchizeria.ordenar((n1, n2) -> n1.getFecha().compareTo(n2.getFecha()));
        torneoEchizeria.paraCadaElementoT(torneo -> System.out.println(torneo));
        
        escuelaMagica.guardarEnCSV("src/data/escuelas.csv");
        escuelaMagica.cargarDesdeCSV("src/data/escuelas.csv", AcademiasdeEncantamientos::fromCSV);
        escuelaMagica.cargarDesdeCSV("src/data/escuelas.csv", InstitutosdeInvocacion::fromCSV);
        escuelaMagica.cargarDesdeCSV("src/data/escuelas.csv", EscuelasdeHechizosElementales::fromCSV);
        escuelaMagica.paraCadaElementoE(escuela -> System.out.println(escuela));
        
        
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
