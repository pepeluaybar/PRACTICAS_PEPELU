package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JJOO {

    private final String nombre;
    private final Map<String, Deporte> deportesPorId;
    private final Map<String, Participante> participantesPorId;
    private final Map<String, Prueba> pruebasPorId;

    public JJOO(String nombre) {
        this.nombre = validarTexto(nombre, "nombre");
        this.deportesPorId = new LinkedHashMap<>();
        this.participantesPorId = new LinkedHashMap<>();
        this.pruebasPorId = new LinkedHashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Deporte> getDeportes() {
        return Collections.unmodifiableList(new ArrayList<>(deportesPorId.values()));
    }

    public List<Participante> getParticipantes() {
        return Collections.unmodifiableList(new ArrayList<>(participantesPorId.values()));
    }

    public List<Prueba> getPruebas() {
        return Collections.unmodifiableList(new ArrayList<>(pruebasPorId.values()));
    }

    public void registrarDeporte(Deporte deporte) {
        Objects.requireNonNull(deporte, "El deporte no puede ser null");
        validarClaveNoDuplicada(deportesPorId, deporte.getId(), "deporte");
        deportesPorId.put(deporte.getId(), deporte);
    }

    public void registrarParticipante(Participante participante) {
        Objects.requireNonNull(participante, "El participante no puede ser null");
        validarClaveNoDuplicada(participantesPorId, participante.getId(), "participante");
        participantesPorId.put(participante.getId(), participante);
    }

    public void registrarPrueba(Prueba prueba) {
        Objects.requireNonNull(prueba, "La prueba no puede ser null");
        validarClaveNoDuplicada(pruebasPorId, prueba.getId(), "prueba");
        if (!deportesPorId.containsKey(prueba.getDeporte().getId())) {
            throw new IllegalStateException("No se puede registrar una prueba con un deporte no registrado en JJOO");
        }
        pruebasPorId.put(prueba.getId(), prueba);
    }

    public Deporte buscarDeportePorId(String id) {
        return deportesPorId.get(validarTexto(id, "id"));
    }

    public Participante buscarParticipantePorId(String id) {
        return participantesPorId.get(validarTexto(id, "id"));
    }

    public Prueba buscarPruebaPorId(String id) {
        return pruebasPorId.get(validarTexto(id, "id"));
    }

    public List<Deporte> buscarDeportesPorNombre(String nombre) {
        String filtro = validarTexto(nombre, "nombre").toLowerCase();
        return deportesPorId.values().stream()
                .filter(deporte -> deporte.getNombre().toLowerCase().contains(filtro))
                .collect(Collectors.toList());
    }

    public List<Participante> buscarParticipantesPorNombre(String nombre) {
        String filtro = validarTexto(nombre, "nombre").toLowerCase();
        return participantesPorId.values().stream()
                .filter(participante -> participante.getNombre().toLowerCase().contains(filtro))
                .collect(Collectors.toList());
    }

    public List<Prueba> buscarPruebasPorNombre(String nombre) {
        String filtro = validarTexto(nombre, "nombre").toLowerCase();
        return pruebasPorId.values().stream()
                .filter(prueba -> prueba.getNombre().toLowerCase().contains(filtro))
                .collect(Collectors.toList());
    }

    public void eliminarPrueba(String idPrueba) {
        Prueba prueba = buscarPruebaPorId(idPrueba);
        if (prueba == null) {
            throw new IllegalStateException("No existe una prueba con el id indicado");
        }

        for (Participante participante : new ArrayList<>(prueba.getParticipantesInscritos())) {
            prueba.desinscribirParticipante(participante);
        }

        prueba.getDeporte().eliminarPruebaInterna(prueba);
        pruebasPorId.remove(prueba.getId());
    }

    private static <T> void validarClaveNoDuplicada(Map<String, T> mapa, String id, String entidad) {
        if (mapa.containsKey(id)) {
            throw new IllegalStateException("Ya existe un " + entidad + " registrado con id " + id);
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
