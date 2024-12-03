
package santostapia_recuperatorio;

public class Carguero extends Nave implements Explorable{
    private int capacidadCarga;
    public static final int TONELADAS_MIN = 100;
    public static final int TONELADAS_MAX = 500;

    public Carguero(String nombre, int capacidadTripulacion, int anioLanzamiento, int capacidadCarga) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        validarCapacidad(capacidadCarga);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void explorar() {
        System.out.println("El carguero " + getNombre() + " esta explorando...");
    }

    private void validarCapacidad(int capacidadCarga){
        if(capacidadCarga < TONELADAS_MIN || capacidadCarga > TONELADAS_MAX){
            throw new IllegalArgumentException();
        }
    }
    
    @Override
    public String toString() {
        return "Carguero {nombre=" + getNombre() + ", capacidadTripulacion=" + getCapacidadTripulacion() +
               ", anioLanzamiento=" + getAnioLanzamiento() + ", capacidadCarga=" + capacidadCarga + '}';
    }
}