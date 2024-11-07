package org.example.models.conjunto_datos;

public class ConjuntoDatosImagen extends ConjuntoDatos {

    private int dpi;

    public ConjuntoDatosImagen(String nombre, int tamanho, int dpi) {
        super(nombre, tamanho);

        this.dpi = dpi;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    //2.2 Punto 2 - Sobreescriba el método describir() para que retorne un String con el siguiente
    // formato: Imagen, <nombre>, <tamaño>, DPI:<dpi>
    @Override
    public String describir() {
        return "Imagen " + super.getNombre() + ", " + getTamanho() + ", DPI:" + dpi;
    }
}
