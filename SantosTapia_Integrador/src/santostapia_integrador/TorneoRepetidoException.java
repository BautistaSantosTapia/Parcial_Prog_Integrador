
package santostapia_integrador;

public class TorneoRepetidoException extends RuntimeException {
    public final static String MESSAGE = "No se puede agregar este torneo, esta repetido";
    
    public TorneoRepetidoException() {
        super(MESSAGE);
    }
}

