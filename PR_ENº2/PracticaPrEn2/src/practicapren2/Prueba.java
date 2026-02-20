package practicapren2;

import java.util.Objects;

public class Prueba {

    private final String nombre;
    private final TipoDeporte tipo;

    public Prueba(String nombre, TipoDeporte tipo) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre de la prueba es obligatorio");
        this.tipo = Objects.requireNonNull(tipo, "El tipo de prueba es obligatorio");
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeporte getTipo() {
        return tipo;
    }

    public boolean esPorEquipos() {
        return tipo == TipoDeporte.EQUIPOS;
    }
}
