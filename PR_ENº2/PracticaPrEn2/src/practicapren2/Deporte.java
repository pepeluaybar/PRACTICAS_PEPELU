package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Deporte {

    private final String id;
    private final String nombre;
    private final TipoDeporte tipo;
    private final List<Prueba> pruebas;

    public Deporte(String id, String nombre, TipoDeporte tipo) {
        this.id = validarTexto(id, "id");
        this.nombre = validarTexto(nombre, "nombre");
        this.tipo = Objects.requireNonNull(tipo, "El tipo de deporte no puede ser null");
        this.pruebas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeporte getTipo() {
        return tipo;
    }

    public List<Prueba> getPruebas() {
        return Collections.unmodifiableList(pruebas);
    }

    void agregarPruebaInterna(Prueba prueba) {
        if (!pruebas.contains(prueba)) {
            pruebas.add(prueba);
        }
    }

    void eliminarPruebaInterna(Prueba prueba) {
        pruebas.remove(prueba);
    }

    private static String validarTexto(String texto, String campo) {
        Objects.requireNonNull(texto, "El campo " + campo + " no puede ser null");
        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        }
        return texto.trim();
    }
}