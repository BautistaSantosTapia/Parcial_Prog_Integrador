
package santostapia_integrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstitutosdeInvocacion extends EscuelaMagia{
    
    private List<String> criaturasMagicas = new ArrayList<>();

    public InstitutosdeInvocacion(String nombre, int anioFundacion, String ubicacion) {
        super(nombre, anioFundacion, ubicacion);
    }

    public List<String> getCriaturasMagicas() {
        return criaturasMagicas;
    }
    
    @Override
    public String toCSV(){
        return super.toCSV() + "," + criaturasMagicas;
    }
    
    public static InstitutosdeInvocacion fromCSV(String escuelaCSV){
        String[] values = escuelaCSV.split(",");
        InstitutosdeInvocacion toReturn = null;
        if(values.length == 4){

            String nombre = values[0];
            int anioFundacion = Integer.parseInt(values[1]);
            String ubicacion = values[2];
            List<String> criaturasMagicas = Arrays.asList(values[3].split(";"));

            toReturn = new InstitutosdeInvocacion(nombre, anioFundacion, ubicacion);
        }
        return toReturn;
    }

    @Override
    public String toString() {
        return super.toString() +  " criaturasMagicas=" + criaturasMagicas + '}';
    }

    @Override
    public int compareTo(EscuelaMagia o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
