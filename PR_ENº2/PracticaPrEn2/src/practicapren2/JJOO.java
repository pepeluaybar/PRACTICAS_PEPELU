package practicapren2;

public class JJOO {

    private static final int MAX_DEPORTES = 30;
    private static final int MAX_PARTICIPANTES = 420;

    private String nombre;
    private int anio;
    private String sede;

    private Deporte[] deportes;
    private int numDeportes;

    private Participante[] participantes;
    private int numParticipantes;

    public JJOO() {
        nombre = "";
        anio = 0;
        sede = "";

        deportes = new Deporte[MAX_DEPORTES];
        numDeportes = 0;

        participantes = new Participante[MAX_PARTICIPANTES];
        numParticipantes = 0;
    }

    public JJOO(String nombre, int anio, String sede) {
        this();
        setNombre(nombre);
        setAnio(anio);
        setSede(sede);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.equals("")) {
            System.out.println("El nombre de los JJOO no puede ser nulo o vacío");
        } else {
            this.nombre = nombre;
        }
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio <= 0) {
            System.out.println("El año debe ser mayor que 0");
        } else {
            this.anio = anio;
        }
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        if (sede == null || sede.equals("")) {
            System.out.println("La sede no puede ser nula o vacía");
        } else {
            this.sede = sede;
        }
    }

    public Deporte[] getDeportes() {
        Deporte[] copia = new Deporte[numDeportes];
        for (int i = 0; i < numDeportes; i++) {
            copia[i] = deportes[i];
        }
        return copia;
    }

    public int getNumDeportes() {
        return numDeportes;
    }

    // +registrarNuevoDeporte(d: Deporte): void
    public void registrarNuevoDeporte(Deporte d) {

        if (d == null) {
            System.out.println("No se puede registrar un deporte nulo");
            return;
        }

        if (numDeportes >= MAX_DEPORTES) {
            System.out.println("No hay más espacio para deportes");
            return;
        }

        for (int i = 0; i < numDeportes; i++) {
            if (deportes[i] != null && deportes[i].getNombre() != null
                    && deportes[i].getNombre().equals(d.getNombre())) {
                System.out.println("Ese deporte ya está registrado");
                return;
            }
        }

        deportes[numDeportes] = d;
        numDeportes++;
    }

    // +registrarNuevoDeportista(d: Deportista): void
    public void registrarNuevoDeportista(Deportista d) {

        if (d == null) {
            System.out.println("No se puede registrar un deportista nulo");
            return;
        }

        if (numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("No hay más espacio para registrar participantes");
            return;
        }

        for (int i = 0; i < numParticipantes; i++) {
            if (participantes[i] != null && participantes[i].getIdOlimpico() == d.getIdOlimpico()) {
                System.out.println("Ya existe un participante con ese id olímpico");
                return;
            }
        }

        participantes[numParticipantes] = d;
        numParticipantes++;
    }

    // +crearEquipo(nombre: String, miembros: Deportista[]): Equipo
    public Equipo crearEquipo(String nombreEquipo, Deportista[] miembros) {

        if (nombreEquipo == null || nombreEquipo.equals("")) {
            System.out.println("El equipo debe tener nombre");
            return null;
        }

        if (miembros == null || miembros.length == 0) {
            System.out.println("El equipo debe tener al menos un miembro");
            return null;
        }

        if (numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("No hay espacio para más participantes");
            return null;
        }

        if (miembros[0] == null) {
            System.out.println("Hay un miembro nulo en el equipo");
            return null;
        }

        String paisBase = miembros[0].getPais();

        for (int i = 0; i < miembros.length; i++) {
            if (miembros[i] == null) {
                System.out.println("Hay un miembro nulo en el equipo");
                return null;
            }
            if (miembros[i].getPais() == null || !miembros[i].getPais().equals(paisBase)) {
                System.out.println("Todos los miembros del equipo deben ser del mismo país");
                return null;
            }
            if (miembros[i].getEquipo() != null) {
                System.out.println("Un deportista ya pertenece a un equipo");
                return null;
            }
        }

        int nuevoId = 10000 + numParticipantes + 1;

        Equipo equipo = new Equipo(nombreEquipo, paisBase, nuevoId);

        for (int i = 0; i < miembros.length; i++) {
            if (!equipo.agregarMiembro(miembros[i])) {
                System.out.println("No se pudo crear el equipo (falló al añadir miembros)");
                return null;
            }
        }

        // Registrar como participante
        participantes[numParticipantes] = equipo;
        numParticipantes++;

        return equipo;
    }

    // +inscribirEnPrueba(par: Participante, pr: Prueba): boolean
    public boolean inscribirEnPrueba(Participante par, Prueba pr) {

        if (par == null || pr == null) {
            System.out.println("Participante o prueba no válidos");
            return false;
        }

        return pr.inscribirParticipante(par);
    }

    // +mostrarMedalleroPorPais(participantes: Participante[]): String
    // (la firma del diagrama lleva parámetro; usamos el array que nos pasen)
    public String mostrarMedalleroPorPais(Participante[] participantesEntrada) {

        if (participantesEntrada == null) {
            return "No hay participantes.";
        }

        // Máximo países <= participantesEntrada.length
        String[] paises = new String[participantesEntrada.length];
        int[] cantidad = new int[participantesEntrada.length];
        int numPaises = 0;

        for (int i = 0; i < numDeportes; i++) {
            if (deportes[i] == null) continue;

            Prueba[] pruebas = deportes[i].getPruebas();
            if (pruebas == null) continue;

            for (int j = 0; j < pruebas.length; j++) {
                if (pruebas[j] == null) continue;
                if (!pruebas[j].isResultadoFinalRegistrado()) continue;

                Medalla[] medallas = pruebas[j].getMedallas();
                int limite = pruebas[j].getNumMedallas();
                if (limite > 3) limite = 3;

                for (int k = 0; k < limite; k++) {
                    if (medallas == null || k >= medallas.length || medallas[k] == null) continue;
                    if (medallas[k].getGanador() == null) continue;

                    String pais = medallas[k].getGanador().getPais();
                    if (pais == null) continue;

                    int pos = -1;
                    for (int p = 0; p < numPaises; p++) {
                        if (paises[p] != null && paises[p].equals(pais)) {
                            pos = p;
                            break;
                        }
                    }

                    if (pos == -1) {
                        paises[numPaises] = pais;
                        cantidad[numPaises] = 1;
                        numPaises++;
                    } else {
                        cantidad[pos] = cantidad[pos] + 1;
                    }
                }
            }
        }

        if (numPaises == 0) {
            return "No hay medallas registradas.";
        }

        String texto = "Medallero por país:\n";
        for (int i = 0; i < numPaises; i++) {
            texto += paises[i] + ": " + cantidad[i] + "\n";
        }

        return texto;
    }

    // +participanteConMasMedallas(): Participante
    public Participante participanteConMasMedallas() {

        if (numParticipantes == 0) {
            return null;
        }

        int[] contador = new int[numParticipantes];

        for (int i = 0; i < numDeportes; i++) {
            if (deportes[i] == null) continue;

            Prueba[] pruebas = deportes[i].getPruebas();
            if (pruebas == null) continue;

            for (int j = 0; j < pruebas.length; j++) {
                if (pruebas[j] == null) continue;
                if (!pruebas[j].isResultadoFinalRegistrado()) continue;

                Medalla[] medallas = pruebas[j].getMedallas();
                int limite = pruebas[j].getNumMedallas();
                if (limite > 3) limite = 3;

                for (int k = 0; k < limite; k++) {
                    if (medallas == null || k >= medallas.length || medallas[k] == null) continue;
                    if (medallas[k].getGanador() == null) continue;

                    int idGanador = medallas[k].getGanador().getIdOlimpico();

                    for (int x = 0; x < numParticipantes; x++) {
                        if (participantes[x] != null && participantes[x].getIdOlimpico() == idGanador) {
                            contador[x] = contador[x] + 1;
                            break;
                        }
                    }
                }
            }
        }

        int posMejor = 0;
        for (int i = 1; i < numParticipantes; i++) {
            if (contador[i] > contador[posMejor]) {
                posMejor = i;
            }
        }

        return participantes[posMejor];
    }

    @Override
    public String toString() {
        String texto = "JJOO{" + "nombre='" + nombre + '\'' + ", anio=" + anio + ", sede='" + sede + '\''
                + ", deportes=[";

        for (int i = 0; i < numDeportes; i++) {
            texto += deportes[i];
            if (i < numDeportes - 1) {
                texto += ", ";
            }
        }

        texto += "]}";
        return texto;
    }
}