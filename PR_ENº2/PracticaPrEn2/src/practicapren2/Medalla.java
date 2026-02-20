package practicapren2;

import java.util.Objects;

public class Medalla {

    private final TipoMedalla tipo;
    private final Prueba prueba;

    public Medalla(TipoMedalla tipo, Prueba prueba) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo de medalla es obligatorio");
        this.prueba = Objects.requireNonNull(prueba, "La prueba asociada es obligatoria");
    }

    public TipoMedalla getTipo() {
        return tipo;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public boolean esOro() {
        return tipo == TipoMedalla.ORO;
    }
}
