
package santostapia_recuperatorio;

public class NaveRepetidaException extends RuntimeException {
    public final static String MESSAGE = "No se puede agregar esta nave, esta repetida";
    
    public NaveRepetidaException() {
        super(MESSAGE);
    }
}
