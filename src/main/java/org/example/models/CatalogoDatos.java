package org.example.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.example.models.conjunto_datos.ConjuntoDatos;

public class CatalogoDatos {

    private final static String RUTA_PERSISTENCIA = "src/main/resources/catalogo.dat";

    private List<ConjuntoDatos> catalogo;

    public CatalogoDatos(List<ConjuntoDatos> catalogo) {
        this.catalogo = new ArrayList<>(catalogo);
    }
    //2.2 Punto 1 - Un constructor sin parámetros que cargue los conjuntos de datos de un archivo
    // binario. Puede asumir que la ruta del archivo está en la constante RUTA_ARCHIVO_PERSISTENCIA
    public CatalogoDatos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois =
                 new ObjectInputStream(
                     new FileInputStream(RUTA_PERSISTENCIA))) {
            catalogo = (ArrayList<ConjuntoDatos>) ois.readObject();
        }
    }

    public void serializar() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_PERSISTENCIA))) {
            oos.writeObject(catalogo);
        }
    }

    public List<String> describirConjuntos() {
        List<String> descripciones = new ArrayList<>();
        for (ConjuntoDatos conjuntoDatos : catalogo) {
            descripciones.add(conjuntoDatos.describir());
        }
        return descripciones;
    }

    //2.2 Punto 5 - Un método exportar que reciba la ruta de un archivo de texto y en este archivo
    //escriba la información de los conjuntos de datos incluidos en el catálogo. Cada línea
    //de este archivo describe a un (y sólo un) conjunto de datos usando el resultado
    //del método describir. No debe haber líneas repetidas

    public void exportar(String rutaArchivo) throws IOException {

        List<String> descripciones = describirConjuntos();

        File archivo = new File(rutaArchivo);
        Files.write(archivo.toPath(), descripciones);

    }

    //2.2 Punto 6 - Un método agregarConjuntoDatos que reciba por parámetro un conjunto de
    //datos y lo agregue a la lista de conjuntos
    public void agregarConjuntoDatos(ConjuntoDatos conjuntoDatos) {
        catalogo.add(conjuntoDatos);
    }

    //2.2 Punto 7 - Un método eliminarConjuntoDatos que reciba por parámetro el nombre de un
    //conjunto de datos y lo elimine de la lista de conjuntos. Este método debe lanzar
    //una excepción si no se encuentra un conjunto con este nombre.
    public void eliminarConjuntoDatos(String nombre) {

        ConjuntoDatos conjuntoDatos = buscarConjuntoDatos(nombre);

        if (conjuntoDatos == null) {
            throw new IllegalArgumentException("No se encontró un conjunto de datos con el nombre " + nombre);
        }

        catalogo.remove(conjuntoDatos);

    }

    private ConjuntoDatos buscarConjuntoDatos(String nombre) {

        for (ConjuntoDatos conjuntoDatos : catalogo) {
            if (conjuntoDatos.getNombre().equals(nombre)) {
                return conjuntoDatos;
            }
        }

        return null;
    }

    //2.2 Punto 8 - Un método ordenar que ordene la lista de conjuntos de datos según su tamaño y
    //en orden ascendente (de menor a mayor)
    public void ordenar() {

        // Forma de hacerlo usando el método sort de la clase List
        catalogo.sort(
            (ConjuntoDatos cd1, ConjuntoDatos cd2) ->
                cd1.getTamanho() - cd2.getTamanho()
        );

        // Otra forma de hacerlo usando burbuja
        for (int i = 0; i < catalogo.size() - 1; i++) {
            for (int j = 0; j < catalogo.size() - i - 1; j++) {
                if (catalogo.get(j).getTamanho() > catalogo.get(j + 1).getTamanho()) {
                    ConjuntoDatos temp = catalogo.get(j);
                    catalogo.set(j, catalogo.get(j + 1));
                    catalogo.set(j + 1, temp);
                }
            }
        }

        //Otra forma de hacerlo usando streams
        // Los streams no modifican la lista original, por lo que se debe asignar el resultado a la lista original
        // o retornar el resultado cambiando el tipo de retorno del método.
        catalogo = catalogo.stream()
            .sorted(Comparator.comparingInt(ConjuntoDatos::getTamanho))
            .toList();

    }
}
