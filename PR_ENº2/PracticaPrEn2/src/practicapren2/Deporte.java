package practicapren2;

public class Deporte {

    private static final int MAX_PRUEBAS = 50; // decisión técnica

    private String nombre;
    private TipoDeporte tipo;
    private int maxParticipantesPorPrueba;

    private Prueba[] pruebas;
    private int numPruebas;

    public Deporte() {
        nombre = "";
        tipo = null;
        maxParticipantesPorPrueba = 0;

        pruebas = new Prueba[MAX_PRUEBAS];
        numPruebas = 0;
    }

    public Deporte(String nombre, TipoDeporte tipo, int maxParticipantesPorPrueba) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.maxParticipantesPorPrueba = maxParticipantesPorPrueba;

        pruebas = new Prueba[MAX_PRUEBAS];
        numPruebas = 0;
    }

    public boolean agregarPrueba(Prueba p) {
        if (p == null) return false;
        if (numPruebas >= MAX_PRUEBAS) return false;

        // tipo de la prueba igual al tipo del deporte
        if (tipo != null && p.getTipo() != null && p.getTipo() != tipo) {
            System.out.println("La prueba no coincide con el tipo del deporte.");
            return false;
        }

        pruebas[numPruebas] = p;
        numPruebas++;
        return true;
    }

    public String getNombre() { return nombre; }
    public TipoDeporte getTipo() { return tipo; }
    public int getMaxParticipantesPorPrueba() { return maxParticipantesPorPrueba; }
    public Prueba[] getPruebas() { return pruebas; }
    public int getNumPruebas() { return numPruebas; }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", maxParticipantesPorPrueba=" + maxParticipantesPorPrueba +
                ", numPruebas=" + numPruebas +
                '}';
    }
}