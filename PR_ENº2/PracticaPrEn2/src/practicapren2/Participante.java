package practicapren2;

import java.util.Objects;

public abstract class Participante {

    private String nombre;
    private String pais;

    public Participante() {
    }

    public Participante(String nombre, String pais) {
        setNombre(nombre);
        setPais(pais);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "nombre");
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = validarTexto(pais, "pais");
    }

    protected final String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede ser nulo o vacío");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Participante{" + "nombre='" + nombre + '\'' + ", pais='" + pais + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participante that = (Participante) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais);
    }
}
