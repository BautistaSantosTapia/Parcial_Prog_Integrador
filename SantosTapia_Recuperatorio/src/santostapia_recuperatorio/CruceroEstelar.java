
package santostapia_recuperatorio;


public class CruceroEstelar extends Nave {
    private int cantidadPasajeros;

    public CruceroEstelar(String nombre, int capacidadTripulacion, int anioLanzamiento, int cantidadPasajeros) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String toString() {
        return "CruceroEstelar {nombre=" + getNombre() + ", capacidadTripulacion=" + getCapacidadTripulacion() +
               ", anioLanzamiento=" + getAnioLanzamiento() + ", cantidadPasajeros=" + cantidadPasajeros + '}';
    }
}