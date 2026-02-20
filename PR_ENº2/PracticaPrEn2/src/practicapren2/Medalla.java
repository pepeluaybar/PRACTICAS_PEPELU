package practicapren2;

import java.util.Objects;

public class Medalla {

    private final TipoMedalla tipo;
    private final Participante participante;
    private final Prueba prueba;

    public Medalla(TipoMedalla tipo, Participante participante, Prueba prueba) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo de medalla no puede ser null");
        this.participante = Objects.requireNonNull(participante, "El participante no puede ser null");
        this.prueba = Objects.requireNonNull(prueba, "La prueba no puede ser null");
    }

    public TipoMedalla getTipo() {
        return tipo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Prueba getPrueba() {
        return prueba;
    }
}
