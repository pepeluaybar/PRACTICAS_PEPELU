package practicapren2;

import java.util.Objects;

public class Medalla {

    private TipoMedalla tipo;
    private Participante ganador;
    private Prueba prueba;

    public Medalla() {
    }

    public Medalla(TipoMedalla tipo, Participante ganador, Prueba prueba) {
        setTipo(tipo);
        setGanador(ganador);
        setPrueba(prueba);
    }

    public TipoMedalla getTipo() {
        return tipo;
    }

    public void setTipo(TipoMedalla tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de medalla no puede ser nulo");
        }
        this.tipo = tipo;
    }

    public Participante getGanador() {
        return ganador;
    }

    public void setGanador(Participante ganador) {
        if (ganador == null) {
            throw new IllegalArgumentException("El ganador no puede ser nulo");
        }
        this.ganador = ganador;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        if (prueba == null) {
            throw new IllegalArgumentException("La prueba no puede ser nula");
        }
        this.prueba = prueba;
    }

    @Override
    public String toString() {
        return "Medalla{" + "tipo=" + tipo + ", ganador=" + ganador + ", prueba='" + prueba.getCodigo() + "'" + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Medalla)) {
            return false;
        }
        Medalla medalla = (Medalla) o;
        return tipo == medalla.tipo && Objects.equals(prueba, medalla.prueba);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, prueba);
    }
}
