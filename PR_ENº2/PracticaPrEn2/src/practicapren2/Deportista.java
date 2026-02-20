package practicapren2;

import java.util.Objects;

public class Deportista extends Participante {

    private final String pais;

    public Deportista(String id, String nombre, String pais) {
        super(id, nombre);
        this.pais = validarPais(pais);
    }

    public String getPais() {
        return pais;
    }

    private static String validarPais(String pais) {
        Objects.requireNonNull(pais, "El país no puede ser null");
        if (pais.trim().isEmpty()) {
            throw new IllegalArgumentException("El país no puede estar vacío");
        }
        return pais.trim();
    }
}