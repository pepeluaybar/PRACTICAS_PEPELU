package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Participante {

    private final String id;
    private final String nombre;
    private final List<Prueba> pruebasInscritas;
    private final List<Medalla> medallas;

    protected Participante(String id, String nombre) {
        this.id = validarTexto(id, "id");
        this.nombre = validarTexto(nombre, "nombre");
        this.pruebasInscritas = new ArrayList<>();
        this.medallas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Prueba> getPruebasInscritas() {
        return Collections.unmodifiableList(pruebasInscritas);
    }

    public List<Medalla> getMedallas() {
        return Collections.unmodifiableList(medallas);
    }

    void agregarPruebaInterna(Prueba prueba) {
        if (!pruebasInscritas.contains(prueba)) {
            pruebasInscritas.add(prueba);
        }
    }

    void eliminarPruebaInterna(Prueba prueba) {
        pruebasInscritas.remove(prueba);
    }

    void agregarMedallaInterna(Medalla medalla) {
        if (!medallas.contains(medalla)) {
            medallas.add(medalla);
        }
    }

    void eliminarMedallaInterna(Medalla medalla) {
        medallas.remove(medalla);
    }

    private static String validarTexto(String texto, String campo) {
        Objects.requireNonNull(texto, "El campo " + campo + " no puede ser null");
        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        }
        return texto.trim();
    }
}
