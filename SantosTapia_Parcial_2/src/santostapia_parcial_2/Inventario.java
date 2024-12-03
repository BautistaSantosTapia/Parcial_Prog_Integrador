
package santostapia_parcial_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Inventario<T extends CSVSerializable & Comparable> implements Inventariable<T>{
    
    List<T> naves = new ArrayList<>();

    @Override
    public void agregar(T nave){
        if (nave == null){
            throw new IllegalArgumentException("No podes agregar nulos");
        }
        naves.add(nave);
    }
    
    @Override
    public T eliminar(int indice) {
        validarIndice(indice);
        return naves.remove(indice);
    }
    
    @Override
    public void validarIndice(int indice){
        if(indice < 0 || indice >= naves.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
    }    
    
    @Override
    public void listarContenido(){
        for (T nave : naves){
            System.out.println(nave);
        }
        /*System.out.println("Contenido: ");
        listarContenido((Comparator<? super T>)Comparator.naturalOrder());
    }
    
    public void listarContenido(Comparator<? super T> comparator){
        System.out.println("Contenido: ");
        Iterator<T> it = iterator(comparator);
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
    }

    @Override
    public void ordenar() {
        if (!naves.isEmpty() && naves.get(0) instanceof Comparable) {
            ordenar((Comparator<? super T>) Comparator.naturalOrder());
        }
    }

    @Override
    public void ordenar(Comparator<? super T> comparator) {
        naves.sort(comparator);
    }
    
    @Override
    public List<T> filtrar(Predicate<? super T> criterio) {
        List<T> toReturn = new ArrayList<>();
        for(T nave : naves){
            if(criterio.test(nave)){
                toReturn.add(nave);
            }
        }
        return toReturn;
    }
    
    @Override
    public List<T> transformar(Function<? super T, ? extends T> transformacion) {
        List<T> toReturn = new ArrayList<>();
        for(T nave : naves){
            toReturn.add(transformacion.apply(nave));
        }
        return toReturn;
    }

    @Override
    public void paraCadaElemento(Consumer<? super T> accion) {
        for(T nave : naves){
            accion.accept(nave);
        }
    }
    
    
    @Override
    public void guardarEnArchivo(String path)throws IOException{

        try(FileOutputStream archivo = new FileOutputStream(path);//"src/data/naves.dat"
                ObjectOutputStream salida = new ObjectOutputStream(archivo))
        {
            salida.writeObject(naves);

            salida.close();//
        }/* catch (IOException ex){
            System.out.println(ex.getMessage());
        }*/
    }

    @Override
    public void cargarDesdeArchivo(String path)throws IOException, ClassNotFoundException{
        //NaveEspacial naveRecuperada = null;

        naves.clear();
        try(ObjectInputStream entrada = 
                new ObjectInputStream(new FileInputStream(path))){//"src/data/naves.dat"

            //naveRecuperada = (NaveEspacial) entrada.readObject();
            naves = (List<T>) entrada.readObject();
            
            entrada.close();//
        }/* catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }*/
        //System.out.println(naveRecuperada);
    }
    
    
    @Override
    public void guardarEnCSV(String path)throws IOException{
        File archivo = new File(path);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            //bw.write("sector,sueldo,nombre,dni\n"); //String toHeaderCSV
            bw.write(NaveEspacial.toHeaderCSV());
            for(T nave:naves){
                bw.write(nave.toCSV() + "\n");
            }
            bw.close();//
        }/* catch(IOException ex){
            System.out.println(ex.getMessage());
        }*/
    }
    
    @Override
    public void cargarDesdeCSV(String path, Function<String, T> transformacion) throws IOException, FileNotFoundException{
        naves.clear();
        try (FileReader lector = new FileReader(path);
                BufferedReader br = new BufferedReader(lector);)
        {
            String linea;
            //br.readLine();
            boolean primeraLinea = true;
            while((linea = br.readLine()) != null){
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                if(linea.endsWith("\n")){
                    linea = linea.substring(linea.length()-1);
                }
                naves.add(transformacion.apply(linea));
            }
            br.close();//
        }/*catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
    }
    
}
