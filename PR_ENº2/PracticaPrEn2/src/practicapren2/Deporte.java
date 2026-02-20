package practicapren2;

import java.util.Objects;

public class Deporte {

    private final String nombre;
    private final TipoDeporte tipo;

    public Deporte(String nombre, TipoDeporte tipo) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre del deporte es obligatorio");
        this.tipo = Objects.requireNonNull(tipo, "El tipo de deporte es obligatorio");
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeporte getTipo() {
        return tipo;
    }
}
