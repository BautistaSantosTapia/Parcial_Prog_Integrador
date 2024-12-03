
package santostapia_integrador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Gestion<T extends CSVSerializable & Comparable> implements Gestionable<T>{
    
    List<T> escuelas = new ArrayList<>();
    List<T> torneos = new ArrayList<>();

    @Override
    public void registrarEscuela(T escuela) {
        if(escuela == null){
            throw new NullPointerException("Hay un null en lugar de una escuela");
        }
        if(escuelas.contains(escuela)){
            throw new EscuelaRepetidaException();
        }
        escuelas.add(escuela);
    }

    @Override
    public void mostrarEscuelas() {
        if(escuelas.isEmpty()){
            System.out.println("Lista de escuelas vacia");
        }
        for (T escuela : escuelas) {
            System.out.println(escuela.toString());
        }
    }

    @Override
    public List<T> filtrar(Predicate<? super T> criterio) {
        List<T> toReturn = new ArrayList<>();
        for(T escuela : escuelas){
            if(criterio.test(escuela)){
                toReturn.add(escuela);
            }
        }
        return toReturn;
    }

    
    
    @Override
    public void registrarTorneo(T torneo) {
        if(torneo == null){
            throw new NullPointerException("Hay un null en lugar de un torneo");
        }
        if(torneos.contains(torneo)){
            throw new TorneoRepetidoException();
        }
        torneos.add(torneo); 
    }

    /*@Override
    public void actualizarEstadoTorneo(T torneo, enum estado) {
        if(torneos.contains(torneo)){
            TorneosdeHechiceria torneo = (TorneosdeHechiceria) torneo
            torneo.setEstado(estado);
        }else{
            throw new NullPointerException("No existe el torneo");
        } 
    }*/

    @Override
    public void mostrarTorneos(){
        if(torneos.isEmpty()){
            System.out.println("Lista de torneos vacia");
        }
        for (T torneo : torneos) {
            System.out.println(torneo.toString());
        }
    }
    
    @Override
    public void ordenar() {
        if (!torneos.isEmpty() && torneos.get(0) instanceof Comparable) {
            ordenar((Comparator<? super T>) Comparator.comparing(TorneosdeHechiceria::getEstado));
        }
    }
    @Override
    public void ordenar(Comparator<? super T> comparator) {
        torneos.sort(comparator);
    }

    
    
    @Override
    public void permitirCrearEncantamientos() {
        for(T torneo : torneos){
            if (torneo instanceof AcademiasdeEncantamientos){
                System.out.println("Lo puede crear");
            }else{
                System.out.println("No lo puede crear");
            }
                
        }
    }
    
    @Override
    public void guardarEnCSV(String path)throws IOException{
        File archivo = new File(path);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            for(T escuela:escuelas){
                bw.write(escuela.toCSV() + "\n");
            }
            bw.close();
        }
    }
    
    @Override
    public void cargarDesdeCSV(String path, Function<String, T> transformacion) throws IOException, FileNotFoundException{
        escuelas.clear();
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
                escuelas.add(transformacion.apply(linea));
            }
            br.close();
        }
    }
    
    @Override
    public void paraCadaElementoE(Consumer<? super T> accion) {
        for(T escuela : escuelas){
            accion.accept(escuela);
        }
    }
    
    @Override
    public void paraCadaElementoT(Consumer<? super T> accion) {
        for(T torneo : torneos){
            accion.accept(torneo);
        }
    }


    }
    

    