package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Deporte {

    private String nombre;
    private TipoDeporte tipo;
    private final List<Prueba> pruebas;

    public Deporte() {
        this.pruebas = new ArrayList<>();
    }

    public Deporte(String nombre, TipoDeporte tipo) {
        this();
        setNombre(nombre);
        setTipo(tipo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del deporte no puede ser nulo o vacío");
        }
        this.nombre = nombre.trim();
    }

    public TipoDeporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeporte tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de deporte no puede ser nulo");
        }
        this.tipo = tipo;
    }

    public List<Prueba> getPruebas() {
        return Collections.unmodifiableList(pruebas);
    }

    public boolean altaPrueba(Prueba prueba) {
        if (prueba == null || pruebas.contains(prueba)) {
            return false;
        }
        return pruebas.add(prueba);
    }

    public Prueba buscarPruebaPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        for (Prueba prueba : pruebas) {
            if (prueba.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return prueba;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Deporte{" + "nombre='" + nombre + '\'' + ", tipo=" + tipo + ", pruebas=" + pruebas + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Deporte)) {
            return false;
        }
        Deporte deporte = (Deporte) o;
        return Objects.equals(nombre, deporte.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
