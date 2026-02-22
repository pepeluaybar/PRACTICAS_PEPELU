package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JJOO {

    private String nombre;
    private int anio;
    private String sede;
    private final List<Deporte> deportes;

    public JJOO() {
        this.deportes = new ArrayList<>();
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
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de JJOO no puede ser nulo o vacío");
        }
        this.nombre = nombre.trim();
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio <= 0) {
            throw new IllegalArgumentException("El año debe ser mayor que 0");
        }
        this.anio = anio;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        if (sede == null || sede.trim().isEmpty()) {
            throw new IllegalArgumentException("La sede no puede ser nula o vacía");
        }
        this.sede = sede.trim();
    }

    public List<Deporte> getDeportes() {
        return Collections.unmodifiableList(deportes);
    }

    public boolean altaDeporte(Deporte deporte) {
        if (deporte == null || deportes.contains(deporte)) {
            return false;
        }
        return deportes.add(deporte);
    }

    public boolean altaPrueba(String nombreDeporte, Prueba prueba) {
        Deporte deporte = buscarDeporte(nombreDeporte);
        return deporte != null && deporte.altaPrueba(prueba);
    }

    public boolean altaParticipante(String nombreDeporte, String codigoPrueba, Participante participante) {
        Prueba prueba = buscarPrueba(nombreDeporte, codigoPrueba);
        return prueba != null && prueba.altaParticipante(participante);
    }

    public boolean registrarResultado(String nombreDeporte, String codigoPrueba, Participante participante, String marca) {
        Prueba prueba = buscarPrueba(nombreDeporte, codigoPrueba);
        return prueba != null && prueba.registrarResultado(participante, marca);
    }

    public boolean asignarMedalla(String nombreDeporte, String codigoPrueba, TipoMedalla tipo, Participante ganador) {
        Prueba prueba = buscarPrueba(nombreDeporte, codigoPrueba);
        return prueba != null && prueba.asignarMedalla(tipo, ganador);
    }

    public Deporte buscarDeporte(String nombreDeporte) {
        if (nombreDeporte == null || nombreDeporte.trim().isEmpty()) {
            return null;
        }
        for (Deporte deporte : deportes) {
            if (deporte.getNombre().equalsIgnoreCase(nombreDeporte.trim())) {
                return deporte;
            }
        }
        return null;
    }

    public Prueba buscarPrueba(String nombreDeporte, String codigoPrueba) {
        Deporte deporte = buscarDeporte(nombreDeporte);
        return deporte == null ? null : deporte.buscarPruebaPorCodigo(codigoPrueba);
    }

    @Override
    public String toString() {
        return "JJOO{" + "nombre='" + nombre + '\'' + ", anio=" + anio + ", sede='" + sede + '\''
                + ", deportes=" + deportes + '}';
    }
}
