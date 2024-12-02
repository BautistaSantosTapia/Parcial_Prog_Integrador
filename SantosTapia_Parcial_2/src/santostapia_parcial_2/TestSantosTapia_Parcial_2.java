
package santostapia_parcial_2;

import java.io.IOException;
import java.util.Comparator;

public class TestSantosTapia_Parcial_2 {

    public static void main(String[] args) {

        try {
            // Crear un inventario de naves espaciales
            Inventario<NaveEspacial> inventarioNaves = new Inventario<>();
            inventarioNaves.agregar(new NaveEspacial("Millennium Falcon", Categoria.TRANSPORTE, 100, 2));
            inventarioNaves.agregar(new NaveEspacial("TIE Fighter", Categoria.MILITAR, 16, 3));
            inventarioNaves.agregar(new NaveEspacial("X-Wing", Categoria.MILITAR, 14, 4));
            inventarioNaves.agregar(new NaveEspacial("Discovery One", Categoria.CIENTIFICA, 60, 5));
            inventarioNaves.agregar(new NaveEspacial("USS Enterprise", Categoria.CIENTIFICA, 50, 1));
            
            // Mostrar todas las naves en el inventario
            System.out.println("Inventario de naves espaciales:");
            inventarioNaves.paraCadaElemento(nave -> System.out.println(nave));
            
            // Filtrar naves por categoría MILITAR
            System.out.println("\nNaves de la categoría MILITAR:");
            inventarioNaves.filtrar(nave -> nave.getCategoria() == Categoria.MILITAR)
            .forEach(nave -> System.out.println(nave));
            
            // Filtrar naves cuyo nombre contiene "Falcon"
            System.out.println("\nNaves cuyo nombre contiene 'Falcon':");
            inventarioNaves.filtrar(nave -> nave.getNombre().contains("Falcon"))
            .forEach(nave -> System.out.println(nave));
            
            // Ordenar naves de manera natural (por id)
            System.out.println("\nNaves ordenadas de manera natural (por nombre):");
            inventarioNaves.ordenar();
            inventarioNaves.paraCadaElemento(nave -> System.out.println(nave));
            
            // Ordenar naves por nombre utilizando un Comparator
            System.out.println("\nNaves ordenadas por id:");
            inventarioNaves.ordenar((n1, n2) -> Integer.compare(n1.getId(), n2.getId())); // Comparator.comparing(NaveEspacial::getId)
            inventarioNaves.paraCadaElemento(nave -> System.out.println(nave));
            
            // Guardar el inventario en un archivo binario
            inventarioNaves.guardarEnArchivo("src/data/naves.dat");
            
            // Cargar el inventario desde el archivo binario
            Inventario<NaveEspacial> inventarioCargado = new Inventario<>();
            inventarioCargado.cargarDesdeArchivo("src/data/naves.dat");
            System.out.println("\nNaves cargadas desde archivo binario:");
            inventarioCargado.paraCadaElemento(nave -> System.out.println(nave));
            
            // Guardar el inventario en un archivo CSV
            inventarioNaves.guardarEnCSV("src/data/naves.csv");
            
            // Cargar el inventario desde el archivo CSV
            inventarioCargado.cargarDesdeCSV("src/data/naves.csv", NaveEspacial::fromCSV);
            System.out.println("\nNaves cargadas desde archivo CSV:");
            inventarioCargado.paraCadaElemento(nave -> System.out.println(nave));
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
    
    
}
