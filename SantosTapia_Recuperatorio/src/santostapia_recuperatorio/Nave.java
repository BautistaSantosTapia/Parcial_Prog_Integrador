
package santostapia_recuperatorio;

import java.util.Objects;

public abstract class Nave {
    private String nombre;
    private int capacidadTripulacion;
    private int anioLanzamiento;
    
    public Nave(String nombre, int capacidadTripulacion, int anioLanzamiento) {
        this.nombre = nombre;
        this.capacidadTripulacion = capacidadTripulacion;
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTripulacion() {
        return capacidadTripulacion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    
    
    public void explorar() {
        
    }

    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){ //
            return false;
        }
        Nave nave = (Nave) obj;
        return nombre.equals(nave.nombre) && anioLanzamiento==(nave.anioLanzamiento);     
        /*if(obj instanceof Nave nave){
            return nombre.equals(nave.nombre) && anioLanzamiento==(nave.anioLanzamiento);
        }
        return false;
        */
    }
    
    
    public int hashCode(){
        return Objects.hash(nombre, anioLanzamiento);
    } // hace que el hash sea el mismo 

    
    
    @Override
    public String toString() {
        return "Nave {nombre=" + nombre + ", capacidadTripulacion=" + capacidadTripulacion + ", anioLanzamiento=" + anioLanzamiento + '}';
    }
}
