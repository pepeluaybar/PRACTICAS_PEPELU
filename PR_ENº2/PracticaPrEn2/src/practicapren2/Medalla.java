package practicapren2;

public class Medalla {

    private TipoMedalla tipo;
    private Participante ganador;
    private Prueba prueba;
    private static int totalOtorgadas;

    public Medalla(TipoMedalla tipo, Participante ganador, Prueba prueba) {
        this.tipo = tipo;
        this.ganador = ganador;
        this.prueba = prueba;
        totalOtorgadas++;
    }

    public TipoMedalla getTipo() {
        return tipo;
    }

    public Participante getGanador() {
        return ganador;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public static int getTotalOtorgadas() {
        return totalOtorgadas;
    }

    public void setTipo(TipoMedalla tipo) {
        this.tipo = tipo;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    @Override
    public String toString() {
        return "Medalla{" + "tipo=" + tipo + ", ganador=" + ganador + ", prueba=" + prueba + '}';
    }
}