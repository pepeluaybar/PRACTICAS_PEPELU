package practicapren2;

public class Equipo extends Participante {

    private static final int MAX_MIEMBROS = 30;

    private Deportista[] miembros;
    private int numMiembros;

    public Equipo() {
        super();
        miembros = new Deportista[MAX_MIEMBROS];
        numMiembros = 0;
    }

    public Equipo(String nombre, String pais, int idOlimpico, Deportista[] miembros, int numMiembros) {
        super(nombre, pais, idOlimpico);
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
    
    public boolean agregarMiembro(Deportista d) {

    if (d == null) {
        System.out.println("Deportista no válido");
        return false;
    }

    if (numMiembros >= miembros.length) {
        System.out.println("No hay más espacio en el equipo");
        return false;
    }

    if (d.getEquipo() != null) {
        System.out.println("El deportista ya pertenece a un equipo");
        return false;
    }

    miembros[numMiembros] = d;
    numMiembros++;
    d.setEquipo(this);

    return true;
}
    
    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", pais=" + pais
                + ", idOlimpico=" + idOlimpico + ", totalMedallas=" + totalMedallas
                + ", numMiembros=" + numMiembros + '}';
    }
}