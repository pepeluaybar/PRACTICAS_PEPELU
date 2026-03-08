package practicapren2;

public class Deporte {

    private static final int MAX_PRUEBAS = 50;

    private String nombre;
    private TipoDeporte tipoD;
    private int maxParticipantesPorPrueba;

    private Prueba[] pruebas;
    private int numPruebas;

    public Deporte() {
        nombre = "";
        tipoD = null;
        maxParticipantesPorPrueba = 0;

        pruebas = new Prueba[MAX_PRUEBAS];
        numPruebas = 0;
    }

    public Deporte(String nombre, TipoDeporte tipoD, int maxParticipantesPorPrueba) {
        this.nombre = nombre;
        this.tipoD = tipoD;
        this.maxParticipantesPorPrueba = maxParticipantesPorPrueba;

        pruebas = new Prueba[MAX_PRUEBAS];
        numPruebas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeporte getTipoD() {
        return tipoD;
    }

    public int getMaxParticipantesPorPrueba() {
        return maxParticipantesPorPrueba;
    }

    public Prueba[] getPruebas() {
        return pruebas;
    }

    public int getNumPruebas() {
        return numPruebas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoD(TipoDeporte tipoD) {
        this.tipoD = tipoD;
    }

    public void setMaxParticipantesPorPrueba(int maxParticipantesPorPrueba) {
        this.maxParticipantesPorPrueba = maxParticipantesPorPrueba;
    }

    public boolean agregarPrueba(Prueba p) {
        if (p == null) {
            System.out.println("Prueba no válida");
            return false;
        }

        if (numPruebas >= MAX_PRUEBAS) {
            System.out.println("No hay más espacio para pruebas");
            return false;
        }

        // Coherencia de tipo
        if (tipoD != null && p.getTipo() != null && p.getTipo() != tipoD) {
            System.out.println("La prueba no coincide con el tipo del deporte");
            return false;
        }

        // Coherencia de max (opcional): si el deporte define max, la prueba debería respetarlo
        if (maxParticipantesPorPrueba > 0 && p.getMaxParticipantes() != maxParticipantesPorPrueba) {
            // No lo bloqueo, pero aviso:
            System.out.println("Aviso: maxParticipantes de la prueba no coincide con el del deporte");
        }

        pruebas[numPruebas] = p;
        numPruebas++;
        return true;
    }

    @Override
    public String toString() {
        return "Deporte{" + "nombre=" + nombre + ", tipoD=" + tipoD
                + ", maxParticipantesPorPrueba=" + maxParticipantesPorPrueba
                + ", numPruebas=" + numPruebas + '}';
    }
}