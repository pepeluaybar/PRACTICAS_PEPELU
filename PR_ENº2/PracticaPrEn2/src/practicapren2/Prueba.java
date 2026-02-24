package practicapren2;

public class Prueba {

    private static final int MAX_MEDALLAS = 3;

    private String codigo;
    private String nombre;
    private TipoDeporte tipo;
    private int maxParticipantes;

    private Participante[] participantes;
    private int numParticipantes;

    private String[] resultados; // simple
    private boolean resultadoFinalRegistrado;

    private Medalla[] medallas;
    private int numMedallas;

    public Prueba() {
        codigo = "";
        nombre = "";
        tipo = null;
        maxParticipantes = 0;

        participantes = null;     // se creará cuando haya maxParticipantes válido
        numParticipantes = 0;

        resultados = null;
        resultadoFinalRegistrado = false;

        medallas = new Medalla[MAX_MEDALLAS];
        numMedallas = 0;
    }

    public Prueba(String codigo, String nombre, TipoDeporte tipo, int maxParticipantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.maxParticipantes = maxParticipantes;

        if (maxParticipantes > 0) {
            participantes = new Participante[maxParticipantes];
        } else {
            participantes = null;
        }
        numParticipantes = 0;

        resultados = null;
        resultadoFinalRegistrado = false;

        medallas = new Medalla[MAX_MEDALLAS];
        numMedallas = 0;
    }

    public boolean inscribirParticipante(Participante p) {

    if (p == null) {
        System.out.println("Participante no válido");
        return false;
    }

    if (maxParticipantes <= 0) {
        System.out.println("La prueba no tiene máximo de participantes válido");
        return false;
    }

    if (participantes == null) {
        participantes = new Participante[maxParticipantes];
    }

    // Comprobar tipo compatible
    if (tipo == TipoDeporte.INDIVIDUAL && !(p instanceof Deportista)) {
        System.out.println("Esta prueba es individual");
        return false;
    }

    if (tipo == TipoDeporte.EQUIPO && !(p instanceof Equipo)) {
        System.out.println("Esta prueba es por equipos");
        return false;
    }

    // Comprobar duplicado
    for (int i = 0; i < numParticipantes; i++) {
        if (participantes[i].getIdOlimpico() == p.getIdOlimpico()) {
            System.out.println("El participante ya está inscrito");
            return false;
        }
    }

    // Comprobar máximo
    if (numParticipantes >= maxParticipantes) {
        System.out.println("Se alcanzó el máximo de participantes");
        return false;
    }

    participantes[numParticipantes] = p;
    numParticipantes++;

    return true;
}

    private boolean esCompatible(Participante p) {
        if (tipo == TipoDeporte.INDIVIDUAL && p instanceof Deportista) return true;
        if (tipo == TipoDeporte.EQUIPO && p instanceof Equipo) return true;
        return false;
    }

    public void registrarResultadoFinal(String[] resultados) {
        this.resultados = resultados;
        this.resultadoFinalRegistrado = true;
    }

    public boolean asignarMedalla(TipoMedalla tipoMedalla, Participante ganador) {
        if (!resultadoFinalRegistrado) {
            System.out.println("No se pueden asignar medallas sin resultado final.");
            return false;
        }
        if (tipoMedalla == null || ganador == null) {
            System.out.println("Tipo de medalla o ganador no válido.");
            return false;
        }
        if (numMedallas >= MAX_MEDALLAS) {
            System.out.println("No se pueden asignar más de 3 medallas.");
            return false;
        }

        medallas[numMedallas] = new Medalla(tipoMedalla, ganador, this);
        numMedallas++;
        return true;
    }

    // --- GETTERS/SETTERS básicos ---

    public String getCodigo() { 
        return codigo;
    }
    
    public String getNombre() {
        return nombre; 
    }
    
    public TipoDeporte getTipo() { 
        return tipo; 
    }
    
    public int getMaxParticipantes() { 
        return maxParticipantes; 
    }
    
    public Participante[] getParticipantes() { 
        return participantes; 
    }
    
    public int getNumParticipantes() { 
        return numParticipantes; 
    }
    
    public Medalla[] getMedallas() { 
        return medallas;
    }
    
    public int getNumMedallas() { 
        return numMedallas;
    }
    
    public boolean isResultadoFinalRegistrado() {
        return resultadoFinalRegistrado; 
    }

    @Override
    public String toString() {
        return "Prueba{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", maxParticipantes=" + maxParticipantes +
                ", numParticipantes=" + numParticipantes +
                ", resultadoFinalRegistrado=" + resultadoFinalRegistrado +
                ", numMedallas=" + numMedallas +
                '}';
    }
}