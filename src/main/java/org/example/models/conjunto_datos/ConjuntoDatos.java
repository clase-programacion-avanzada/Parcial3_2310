package org.example.models.conjunto_datos;

import java.io.Serializable;

public abstract class ConjuntoDatos implements Serializable {

    private String nombre;
    private int tamanho;

    // region already implemented
    // Esto ya lo tienen hecho según el parcial
    public ConjuntoDatos(String nombre, int tamanho) {
        this.nombre = nombre;
        this.tamanho = tamanho;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    // endregion

    public abstract String describir();

}
