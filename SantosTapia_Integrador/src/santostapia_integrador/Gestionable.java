
package santostapia_integrador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Gestionable<T> {
    
    void registrarEscuela(T escuela);// excepcion y equals, hascode
    
    void mostrarEscuelas();
    
    List<T> filtrar(Predicate<? super T> criterio);
    
    
    
    
    void registrarTorneo(T torneo);
    
    //void actualizarEstadoTorneo(T torneo, enum estado); //?
    
    void mostrarTorneos();
    void ordenar();
    void ordenar(Comparator<? super T> comparator);
    
    void permitirCrearEncantamientos();
    
    void guardarEnCSV(String path)throws IOException;
    void cargarDesdeCSV(String path, Function<String, T> transformacion) throws IOException, FileNotFoundException;
    
    void paraCadaElementoE(Consumer<? super T> accion);
    void paraCadaElementoT(Consumer<? super T> accion);
}
