
package santostapia_integrador;

public class EscuelaRepetidaException extends RuntimeException {
    public final static String MESSAGE = "No se puede agregar esta escuela, esta repetida";
    
    public EscuelaRepetidaException() {
        super(MESSAGE);
    }
}
