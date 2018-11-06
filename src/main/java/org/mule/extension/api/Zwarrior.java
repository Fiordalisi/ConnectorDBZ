package org.mule.extension.api;

import java.util.Objects;

public class Zwarrior {

    private String nombre;
    private int id;

    public String getNombre() {
        return this.nombre;
    }

    public int getId() {
        return id;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zwarrior zwarrior = (Zwarrior) o;
        return id == zwarrior.id &&
                Objects.equals(nombre, zwarrior.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id);
    }
}
