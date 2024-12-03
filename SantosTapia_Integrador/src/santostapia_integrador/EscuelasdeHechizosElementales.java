
package santostapia_integrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscuelasdeHechizosElementales extends EscuelaMagia{
    
    private List<String> elementosDominados = new ArrayList<>();

    public EscuelasdeHechizosElementales(String nombre, int anioFundacion, String ubicacion) {
        super(nombre, anioFundacion, ubicacion);
    }

    public List<String> getElementosDominados() {
        return elementosDominados;
    }
    
    @Override
    public String toCSV(){
        return super.toCSV() + "," + elementosDominados;
    }
    
    public static EscuelasdeHechizosElementales fromCSV(String escuelaCSV){
        String[] values = escuelaCSV.split(",");
        EscuelasdeHechizosElementales toReturn = null;
        if(values.length == 4){

            String nombre = values[0];
            int anioFundacion = Integer.parseInt(values[1]);
            String ubicacion = values[2];
            List<String> elementosDominados = Arrays.asList(values[3].split(";"));

            toReturn = new EscuelasdeHechizosElementales(nombre, anioFundacion, ubicacion);
        }
        return toReturn;
    }
    
    @Override
    public String toString() {
        return super.toString() +  " elementosDominados=" + elementosDominados + '}';
    }

    @Override
    public int compareTo(EscuelaMagia o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
