package org.example.models.conjuntoDatos;

public class ConjuntoDatosTabular extends ConjuntoDatos {

    private int nColumnas;
    private int nFilas;

    //2.2 Punto 4 - Un constructor por parámetros para esta clase
    public ConjuntoDatosTabular(String nombre,
                                int tamanho,
                                int nColumnas,
                                int nFilas) {
        super(nombre, tamanho);
        this.nColumnas = nColumnas;
        this.nFilas = nFilas;
    }
    // region already implemented
    // Esto ya lo tienen hecho según el parcial
    public int getNFilas() {
        return nFilas;
    }

    public int getNColumnas() {
        return nColumnas;
    }

    public void setNFilas(int nFilas) {
        this.nFilas = nFilas;
    }

    public void setNColumnas(int nColumnas) {
        this.nColumnas = nColumnas;
    }
    // endregion

    //2.2 punto 3 - Sobreescriba el método describir() para que retorne un String con el siguiente
    //formato: Tabular, <nombre>, <tamaño>, <Filas>x<Columnas>
    @Override
    public String describir() {
        return "Tabular " + super.getNombre() + ", " + getTamanho() + ", " + nFilas + "x" + nColumnas;
    }

}
