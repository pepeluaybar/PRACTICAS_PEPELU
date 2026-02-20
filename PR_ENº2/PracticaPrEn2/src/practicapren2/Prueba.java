package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Prueba {

    private final String id;
    private final String nombre;
    private final Deporte deporte;
    private final List<Participante> participantesInscritos;
    private final Map<Participante, Integer> resultados;
    private final List<Medalla> medallasOtorgadas;

    public Prueba(String id, String nombre, Deporte deporte) {
        this.id = validarTexto(id, "id");
        this.nombre = validarTexto(nombre, "nombre");
        this.deporte = Objects.requireNonNull(deporte, "El deporte no puede ser null");
        this.participantesInscritos = new ArrayList<>();
        this.resultados = new LinkedHashMap<>();
        this.medallasOtorgadas = new ArrayList<>();

        deporte.agregarPruebaInterna(this);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public List<Participante> getParticipantesInscritos() {
        return Collections.unmodifiableList(participantesInscritos);
    }

    public Map<Participante, Integer> getResultados() {
        return Collections.unmodifiableMap(resultados);
    }

    public List<Medalla> getMedallasOtorgadas() {
        return Collections.unmodifiableList(medallasOtorgadas);
    }

    public void inscribirParticipante(Participante participante) {
        Objects.requireNonNull(participante, "El participante no puede ser null");
        if (participantesInscritos.contains(participante)) {
            throw new IllegalStateException("El participante ya está inscrito en la prueba");
        }

        participantesInscritos.add(participante);
        participante.agregarPruebaInterna(this);
    }

    public void desinscribirParticipante(Participante participante) {
        Objects.requireNonNull(participante, "El participante no puede ser null");
        if (!participantesInscritos.remove(participante)) {
            throw new IllegalStateException("El participante no está inscrito en la prueba");
        }

        resultados.remove(participante);
        eliminarMedallasDeParticipante(participante);
        participante.eliminarPruebaInterna(this);
    }

    public void registrarResultado(Participante participante, int posicion) {
        validarInscripcion(participante);
        if (posicion <= 0) {
            throw new IllegalArgumentException("La posición debe ser mayor que cero");
        }
        if (resultados.containsValue(posicion) && resultados.getOrDefault(participante, -1) != posicion) {
            throw new IllegalStateException("La posición ya fue asignada a otro participante");
        }

        resultados.put(participante, posicion);
    }

    public Medalla otorgarMedalla(TipoMedalla tipo, Participante participante) {
        validarInscripcion(participante);
        Objects.requireNonNull(tipo, "El tipo de medalla no puede ser null");

        boolean tipoYaOtorgado = medallasOtorgadas.stream()
                .anyMatch(m -> m.getTipo() == tipo);
        if (tipoYaOtorgado) {
            throw new IllegalStateException("La medalla de tipo " + tipo + " ya fue otorgada en esta prueba");
        }

        boolean participanteYaPremiado = medallasOtorgadas.stream()
                .anyMatch(m -> m.getParticipante().equals(participante));
        if (participanteYaPremiado) {
            throw new IllegalStateException("El participante ya recibió una medalla en esta prueba");
        }

        Medalla medalla = new Medalla(tipo, participante, this);
        medallasOtorgadas.add(medalla);
        participante.agregarMedallaInterna(medalla);
        return medalla;
    }

    public void revocarMedalla(TipoMedalla tipo) {
        Objects.requireNonNull(tipo, "El tipo de medalla no puede ser null");
        Medalla medalla = medallasOtorgadas.stream()
                .filter(m -> m.getTipo() == tipo)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No existe medalla de tipo " + tipo + " en la prueba"));

        medallasOtorgadas.remove(medalla);
        medalla.getParticipante().eliminarMedallaInterna(medalla);
    }

    private void validarInscripcion(Participante participante) {
        Objects.requireNonNull(participante, "El participante no puede ser null");
        if (!participantesInscritos.contains(participante)) {
            throw new IllegalStateException("El participante no está inscrito en la prueba");
        }
    }

    private void eliminarMedallasDeParticipante(Participante participante) {
        List<Medalla> medallasAEliminar = new ArrayList<>();
        for (Medalla medalla : medallasOtorgadas) {
            if (medalla.getParticipante().equals(participante)) {
                medallasAEliminar.add(medalla);
            }
        }

        for (Medalla medalla : medallasAEliminar) {
            medallasOtorgadas.remove(medalla);
            participante.eliminarMedallaInterna(medalla);
        }
    }

    private static String validarTexto(String texto, String campo) {
        Objects.requireNonNull(texto, "El campo " + campo + " no puede ser null");
        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        }
        return texto.trim();
    }
}
