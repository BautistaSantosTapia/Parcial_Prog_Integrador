
package santostapia_parcial_2;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Inventariable<T> {
    
    void agregar(T nave);
    
    T eliminar(int indice);
    
    void validarIndice(int indice);
    
    void listarContenido();//

    void ordenar();

    void ordenar(Comparator<? super T> comparator);
    
    List<T> filtrar(Predicate<? super T> criterio);
    
    List<T> transformar(Function<? super T, ? extends T> transformacion);

    void paraCadaElemento(Consumer<? super T> accion);
    
    
    void guardarEnArchivo(String path)throws IOException;

    void cargarDesdeArchivo(String path)throws IOException, ClassNotFoundException;
    
        
    void guardarEnCSV(String path)throws IOException;

    void cargarDesdeCSV(String path, Function<String, T> transformacion)throws IOException, FileNotFoundException;

}
