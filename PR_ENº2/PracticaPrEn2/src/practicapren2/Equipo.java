package practicapren2;

public class Equipo extends Participante {

    private Deportista[] miembros;
    private int numMiembros;

    public Equipo() {
        super();
        miembros = new Deportista[0];
        numMiembros = 0;
    }

    public Equipo(String nombre, String pais, int idOlimpico, Deportista[] miembros, int numMiembros) {
        super(nombre, pais, idOlimpico, 0);
        this.miembros = miembros;
        this.numMiembros = numMiembros;
    }

    public Deportista[] getMiembros() {
        return miembros;
    }

    public int getNumMiembros() {
        return numMiembros;
    }

    public void setMiembros(Deportista[] miembros) {
        this.miembros = miembros;
    }

    public void setNumMiembros(int numMiembros) {
        this.numMiembros = numMiembros;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", pais=" + pais + ", idOlimpico=" + idOlimpico
                + ", totalMedallas=" + totalMedallas + ", numMiembros=" + numMiembros + '}';
    }
}