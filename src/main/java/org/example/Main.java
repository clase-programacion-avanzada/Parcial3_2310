package org.example;

import java.io.IOException;
import java.util.List;
import org.example.models.CatalogoDatos;
import org.example.models.conjunto_datos.ConjuntoDatos;
import org.example.models.conjunto_datos.ConjuntoDatosImagen;
import org.example.models.conjunto_datos.ConjuntoDatosTabular;

public class Main {
    public static void main(String[] args) {

        System.out.println("Prueba del catálogo de datos");

        List<ConjuntoDatos> conjuntoDatos = List.of(
            new ConjuntoDatosTabular("Conjunto 1", 100, 5, 10),
            new ConjuntoDatosTabular("Conjunto 5", 500, 15, 30),
            new ConjuntoDatosTabular("Conjunto 3", 300, 10, 20),
            new ConjuntoDatosImagen("Conjunto 6", 600, 900),
            new ConjuntoDatosImagen("Conjunto 2", 200, 300),
            new ConjuntoDatosImagen("Conjunto 4", 400, 600)
        );

        CatalogoDatos catalogo = new CatalogoDatos(conjuntoDatos);

        //Probando punto 1
        try {
            catalogo.serializar();
        } catch (IOException e) {
            System.out.println("Error al serializar el catálogo");
            System.out.println(e.getMessage());
        }
        System.out.println("Probando punto 1");
        System.out.println("Cargando catálogo desde archivo binario");
        try {
            catalogo = new CatalogoDatos();
            System.out.println("Catálogo cargado correctamente");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el catálogo");
            System.out.println(e.getMessage());
        }
        System.out.println();
        //Probando punto 2 y 3
        System.out.println("Probando punto 2 y 3");
        ConjuntoDatos conjuntoDatosNuevo = new ConjuntoDatosTabular("Conjunto 7", 700, 20, 40);
        ConjuntoDatos conjuntoDatosNuevo2 = new ConjuntoDatosImagen("Conjunto 8", 800, 1200);

        System.out.println("Descripción del conjunto de datos Tabular: " + conjuntoDatosNuevo.describir());
        System.out.println("Descripción del conjunto de datos Imagen: " + conjuntoDatosNuevo2.describir());
        System.out.println();
        //Probando punto 5
        System.out.println("Probando punto 5, exportando catálogo a archivo de texto en src/main/resources/catalogo.txt");
        try {
            catalogo.exportar("src/main/resources/catalogo.txt");
            System.out.println("Catálogo exportado correctamente");
        } catch (IOException e) {
            System.out.println("Error al exportar el catálogo");
            System.out.println(e.getMessage());
        }
        System.out.println();
        //Probando punto 6
        System.out.println("Pobando punto 6");
        System.out.println("Conjuntos de datos en el catálogo:");
        catalogo.describirConjuntos().stream().forEach(System.out::println);

        System.out.println("Agregando conjunto de datos al catálogo");
        catalogo.agregarConjuntoDatos(conjuntoDatosNuevo);

        System.out.println();
        System.out.println("Conjuntos de datos en el catálogo:");
        catalogo.describirConjuntos().stream().forEach(System.out::println);


        System.out.println();
        //Probando punto 7
        System.out.println("Probando punto 7");

        System.out.println("Eliminando conjunto de datos del catálogo");
        catalogo.eliminarConjuntoDatos("Conjunto 7");

        System.out.println("Conjuntos de datos en el catálogo:");
        catalogo.describirConjuntos().stream().forEach(System.out::println);
        System.out.println();

        //Probando punto 8
        System.out.println("Probando punto 8");
        System.out.println("Conjuntos de datos en el catálogo:");
        catalogo.describirConjuntos().stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Ordenando catálogo por tamaño");
        catalogo.ordenar();
        System.out.println();
        System.out.println("Conjuntos de datos en el catálogo:");
        catalogo.describirConjuntos().stream().forEach(System.out::println);










    }
}