
package santostapia_integrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AcademiasdeEncantamientos extends EscuelaMagia {
    
    private List<String> objetosEncantados = new ArrayList<>();

    public AcademiasdeEncantamientos(String nombre, int anioFundacion, String ubicacion) {
        super(nombre, anioFundacion, ubicacion);
    }
    
    public List<String> getObjetosEncantados() {
        return objetosEncantados;
    }

    @Override
    public String toString() {
        return super.toString() +  " objetosEncantados=" + objetosEncantados + '}';
    }
        
    @Override
    public String toCSV(){
        return super.toCSV() + "," + objetosEncantados;
    }
    
    public static AcademiasdeEncantamientos fromCSV(String escuelaCSV){
        String[] values = escuelaCSV.split(",");
        AcademiasdeEncantamientos toReturn = null;
        if(values.length == 4){

            String nombre = values[0];
            int anioFundacion = Integer.parseInt(values[1]);
            String ubicacion = values[2];
            List<String> objetosEncantados = Arrays.asList(values[3].split(";"));

            toReturn = new AcademiasdeEncantamientos(nombre, anioFundacion, ubicacion);
        }
        return toReturn;
    }

   

    @Override
    public int compareTo(EscuelaMagia o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

