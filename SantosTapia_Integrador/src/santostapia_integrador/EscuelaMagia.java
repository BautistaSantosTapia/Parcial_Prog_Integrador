
package santostapia_integrador;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class EscuelaMagia implements Comparable<EscuelaMagia>, Serializable, CSVSerializable { 
    private String nombre;
    private int anioFundacion;
    private String ubicacion;

    public EscuelaMagia(String nombre, int anioFundacion, String ubicacion) {
        this.nombre = nombre;
        this.anioFundacion = anioFundacion;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    
    
    @Override
    public String toCSV(){
        return nombre + "," + anioFundacion + "," + ubicacion;
    }

    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        EscuelaMagia escuela = (EscuelaMagia) obj;
        return nombre.equals(escuela.nombre) && anioFundacion==(escuela.anioFundacion);     
    }
    
    
    public int hashCode(){
        return Objects.hash(nombre, anioFundacion);
    }  
    

    @Override
    public String toString() {
        return "EscuelaMagia{" + "nombre=" + nombre + ", anioFundacion=" + anioFundacion + ", ubicacion=" + ubicacion + ',';
    }
    
}

