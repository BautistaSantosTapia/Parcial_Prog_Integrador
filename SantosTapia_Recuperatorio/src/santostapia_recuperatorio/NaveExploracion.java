
package santostapia_recuperatorio;

public class NaveExploracion extends Nave implements Explorable{
    private TipoMision tipoMision;

    public NaveExploracion(String nombre, int capacidadTripulacion, int anioLanzamiento, TipoMision tipoMision) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.tipoMision = tipoMision;
    }

    @Override
    public void explorar() {
        System.out.println("La nave exploradora " + getNombre() + " esta explorando...");
    }

    @Override
    public String toString() {
        return "NaveExploracion {nombre=" + getNombre() + ", capacidadTripulacion=" + getCapacidadTripulacion() +
               ", anioLanzamiento=" + getAnioLanzamiento() + ", tipoMision=" + tipoMision + '}';
    }
}


