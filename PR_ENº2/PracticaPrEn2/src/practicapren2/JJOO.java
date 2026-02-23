package practicapren2;

public class JJOO {

    private static final int MAX_DEPORTES = 30;
    private static final int MAX_DEPORTISTAS = 300;
    private static final int MAX_EQUIPOS = 120;
    private static final int MAX_PARTICIPANTES = 420;
    private static final int MAX_PAISES = 120;

    private String nombre;
    private int anio;
    private String sede;

    private Deporte[] deportes;
    private int numDeportes;

    private Deportista[] deportistas;
    private int numDeportistas;

    private Equipo[] equipos;
    private int numEquipos;

    private Participante[] participantes;
    private int numParticipantes;

    public JJOO() {
        nombre = "";
        anio = 0;
        sede = "";

        deportes = new Deporte[MAX_DEPORTES];
        numDeportes = 0;

        deportistas = new Deportista[MAX_DEPORTISTAS];
        numDeportistas = 0;

        equipos = new Equipo[MAX_EQUIPOS];
        numEquipos = 0;

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

    public boolean registrarNuevoDeporte(Deporte d) {
        if (d == null) {
            System.out.println("No se puede registrar un deporte nulo");
            return false;
        }

        if (numDeportes >= MAX_DEPORTES) {
            System.out.println("No hay más espacio para deportes");
            return false;
        }

        for (int i = 0; i < numDeportes; i++) {
            if (deportes[i].getNombre().equals(d.getNombre())) {
                System.out.println("Ese deporte ya está registrado");
                return false;
            }
        }

        deportes[numDeportes] = d;
        numDeportes++;
        return true;
    }

    public boolean registrarNuevoDeportista(Deportista d) {
        if (d == null) {
            System.out.println("No se puede registrar un deportista nulo");
            return false;
        }

        if (numDeportistas >= MAX_DEPORTISTAS || numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("No hay más espacio para registrar deportistas");
            return false;
        }

        for (int i = 0; i < numDeportistas; i++) {
            if (deportistas[i].getIdOlimpico() == d.getIdOlimpico()) {
                System.out.println("Ya existe un deportista con ese id olímpico");
                return false;
            }
        }

        deportistas[numDeportistas] = d;
        numDeportistas++;

        participantes[numParticipantes] = d;
        numParticipantes++;

        return true;
    }

    public Equipo crearEquipo(String nombre, Deportista[] miembros) {
        if (nombre == null || nombre.equals("")) {
            System.out.println("El equipo debe tener nombre");
            return null;
        }

        if (miembros == null || miembros.length == 0) {
            System.out.println("El equipo debe tener al menos un miembro");
            return null;
        }

        if (numEquipos >= MAX_EQUIPOS || numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("No hay espacio para más equipos");
            return null;
        }

        String paisBase = "";
        int numMiembrosValidos = 0;

        for (int i = 0; i < miembros.length; i++) {
            if (miembros[i] == null) {
                System.out.println("Hay un miembro nulo en el equipo");
                return null;
            }

            if (i == 0) {
                paisBase = miembros[i].getPais();
            } else if (!miembros[i].getPais().equals(paisBase)) {
                System.out.println("Todos los miembros del equipo deben ser del mismo país");
                return null;
            }

            numMiembrosValidos++;
        }

        Deportista[] copia = new Deportista[numMiembrosValidos];
        for (int i = 0; i < numMiembrosValidos; i++) {
            copia[i] = miembros[i];
        }

        int nuevoId = 10000 + numEquipos + 1;
        Equipo equipo = new Equipo(nombre, paisBase, nuevoId, copia, numMiembrosValidos);

        equipos[numEquipos] = equipo;
        numEquipos++;

        participantes[numParticipantes] = equipo;
        numParticipantes++;

        return equipo;
    }

    public boolean inscribirEnPrueba(Participante par, Prueba pr) {
        if (par == null || pr == null) {
            System.out.println("Participante o prueba no válidos");
            return false;
        }

        if (!esTipoCompatible(par, pr)) {
            System.out.println("El participante no es compatible con el tipo de prueba");
            return false;
        }

        Participante[] inscritos = pr.getParticipantes();
        int max = pr.getMaxParticipantes();

        if (max <= 0) {
            System.out.println("La prueba no tiene un máximo de participantes válido");
            return false;
        }

        if (inscritos == null || inscritos.length < max) {
            Participante[] nuevos = new Participante[max];
            if (inscritos != null) {
                for (int i = 0; i < pr.getNumParticipantes() && i < inscritos.length; i++) {
                    nuevos[i] = inscritos[i];
                }
            }
            pr.setParticipantes(nuevos);
            inscritos = nuevos;
        }

        for (int i = 0; i < pr.getNumParticipantes(); i++) {
            if (inscritos[i] != null && inscritos[i].getIdOlimpico() == par.getIdOlimpico()) {
                System.out.println("Ese participante ya está inscrito en esta prueba");
                return false;
            }
        }

        if (pr.getNumParticipantes() >= max) {
            System.out.println("Se alcanzó el máximo de participantes de la prueba");
            return false;
        }

        inscritos[pr.getNumParticipantes()] = par;
        pr.setNumParticipantes(pr.getNumParticipantes() + 1);
        return true;
    }

    public String mostrarMedalleroPorPais() {
        String[] paises = new String[MAX_PAISES];
        int[] cantidad = new int[MAX_PAISES];
        int numPaises = 0;

        for (int i = 0; i < numDeportes; i++) {
            Prueba[] pruebas = deportes[i].getPruebas();
            for (int j = 0; j < pruebas.length; j++) {
                if (pruebas[j] != null) {
                    Medalla[] medallas = pruebas[j].getMedallas();

                    if (!pruebas[j].isResultadoFinalRegistrado()) {
                        continue;
                    }

                    int limite = pruebas[j].getNumMedallas();
                    if (limite > 3) {
                        limite = 3;
                    }

                    for (int k = 0; k < limite; k++) {
                        if (medallas != null && k < medallas.length && medallas[k] != null
                                && medallas[k].getGanador() != null) {
                            String pais = medallas[k].getGanador().getPais();

                            int pos = -1;
                            for (int p = 0; p < numPaises; p++) {
                                if (paises[p].equals(pais)) {
                                    pos = p;
                                }
                            }

                            if (pos == -1) {
                                if (numPaises < MAX_PAISES) {
                                    paises[numPaises] = pais;
                                    cantidad[numPaises] = 1;
                                    numPaises++;
                                }
                            } else {
                                cantidad[pos] = cantidad[pos] + 1;
                            }
                        }
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

    public Participante participanteConMasMedallas() {
        for (int i = 0; i < numParticipantes; i++) {
            participantes[i].setTotalMedallas(0);
        }

        for (int i = 0; i < numDeportes; i++) {
            Prueba[] pruebas = deportes[i].getPruebas();
            for (int j = 0; j < pruebas.length; j++) {
                if (pruebas[j] != null && pruebas[j].isResultadoFinalRegistrado()) {
                    int limite = pruebas[j].getNumMedallas();
                    if (limite > 3) {
                        limite = 3;
                    }

                    Medalla[] medallas = pruebas[j].getMedallas();
                    for (int k = 0; k < limite; k++) {
                        if (medallas != null && k < medallas.length && medallas[k] != null
                                && medallas[k].getGanador() != null) {
                            Participante ganador = medallas[k].getGanador();
                            ganador.setTotalMedallas(ganador.getTotalMedallas() + 1);
                        }
                    }
                }
            }
        }

        if (numParticipantes == 0) {
            return null;
        }

        Participante mejor = participantes[0];
        for (int i = 1; i < numParticipantes; i++) {
            if (participantes[i].getTotalMedallas() > mejor.getTotalMedallas()) {
                mejor = participantes[i];
            }
        }

        return mejor;
    }

    private boolean esTipoCompatible(Participante par, Prueba pr) {
        if (pr.getTipo() == TipoDeporte.INDIVIDUAL && par instanceof Deportista) {
            return true;
        }

        if (pr.getTipo() == TipoDeporte.EQUIPO && par instanceof Equipo) {
            return true;
        }

        return false;
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
