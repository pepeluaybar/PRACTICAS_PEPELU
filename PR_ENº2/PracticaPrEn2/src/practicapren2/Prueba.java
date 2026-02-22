package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Prueba {

    private String codigo;
    private String nombre;
    private TipoDeporte tipo;
    private final List<Participante> participantes;
    private final Map<Participante, String> resultados;
    private final List<Medalla> medallas;

    public Prueba() {
        this.participantes = new ArrayList<>();
        this.resultados = new LinkedHashMap<>();
        this.medallas = new ArrayList<>();
    }

    public Prueba(String codigo, String nombre, TipoDeporte tipo) {
        this();
        setCodigo(codigo);
        setNombre(nombre);
        setTipo(tipo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de la prueba no puede ser nulo o vacío");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la prueba no puede ser nulo o vacío");
        }
        this.nombre = nombre.trim();
    }

    public TipoDeporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeporte tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de deporte no puede ser nulo");
        }
        this.tipo = tipo;
    }

    public List<Participante> getParticipantes() {
        return Collections.unmodifiableList(participantes);
    }

    public Map<Participante, String> getResultados() {
        return Collections.unmodifiableMap(resultados);
    }

    public List<Medalla> getMedallas() {
        return Collections.unmodifiableList(medallas);
    }

    public boolean altaParticipante(Participante participante) {
        if (participante == null || participantes.contains(participante)) {
            return false;
        }
        return participantes.add(participante);
    }

    public boolean registrarResultado(Participante participante, String marca) {
        if (participante == null || marca == null || marca.trim().isEmpty() || !participantes.contains(participante)) {
            return false;
        }
        resultados.put(participante, marca.trim());
        return true;
    }

    public boolean asignarMedalla(TipoMedalla tipoMedalla, Participante ganador) {
        if (tipoMedalla == null || ganador == null || !participantes.contains(ganador)) {
            return false;
        }
        Medalla nueva = new Medalla(tipoMedalla, ganador, this);
        if (medallas.contains(nueva)) {
            return false;
        }
        return medallas.add(nueva);
    }

    @Override
    public String toString() {
        return "Prueba{" + "codigo='" + codigo + '\'' + ", nombre='" + nombre + '\'' + ", tipo=" + tipo
                + ", participantes=" + participantes + ", resultados=" + resultados + ", medallas=" + medallas + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prueba)) {
            return false;
        }
        Prueba prueba = (Prueba) o;
        return Objects.equals(codigo, prueba.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
