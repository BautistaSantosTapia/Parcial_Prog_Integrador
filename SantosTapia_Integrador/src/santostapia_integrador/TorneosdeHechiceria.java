
package santostapia_integrador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import santostapia_integrador.EscuelaMagia;

public class TorneosdeHechiceria implements Comparable<TorneosdeHechiceria>, Serializable, CSVSerializable{

    private String nombre;
    private LocalDate fecha;
    private int maxParticipantes;
    private Estadodeltorneo estado;

    public TorneosdeHechiceria(String nombre, LocalDate fecha, int maxParticipantes, Estadodeltorneo estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.maxParticipantes = maxParticipantes;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public Estadodeltorneo getEstado() {
        return estado;
    }

    public void setEstado(Estadodeltorneo estado) {
        this.estado = estado;
    }
    
    
    @Override
    public String toCSV(){
        return nombre + "," + fecha + "," + maxParticipantes + "," + estado.toString();
    }
    
    public static TorneosdeHechiceria fromCSV(String torneoCSV){
        String[] values = torneoCSV.split(",");
        TorneosdeHechiceria toReturn = null;
        if(values.length == 4){

            String nombre = values[0];
            LocalDate fecha = LocalDate.parse(values[1]);
            int maxParticipantes = Integer.parseInt(values[2]);
            Estadodeltorneo estado = Estadodeltorneo.valueOf(values[3]);

            toReturn = new TorneosdeHechiceria(nombre, fecha, maxParticipantes, estado);
        }
        return toReturn;
    }

    @Override
    public String toString() {
        return "TorneosdeHechiceria{" + "nombre=" + nombre + ", fecha=" + fecha + ", maxParticipantes=" + maxParticipantes + ", estado=" + estado + '}';
    }

    @Override
    public int compareTo(TorneosdeHechiceria torneo) {
        return nombre.compareTo(torneo.nombre);
    }
    
    
}
