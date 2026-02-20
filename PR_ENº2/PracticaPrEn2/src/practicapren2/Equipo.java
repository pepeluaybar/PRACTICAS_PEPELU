package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo extends Participante {

    private final List<Deportista> miembros;

    public Equipo(String id, String nombre) {
        super(id, nombre);
        this.miembros = new ArrayList<>();
    }

    public List<Deportista> getMiembros() {
        return Collections.unmodifiableList(miembros);
    }

    public void agregarMiembro(Deportista deportista) {
        if (deportista == null) {
            throw new IllegalArgumentException("El miembro no puede ser null");
        }
        if (miembros.contains(deportista)) {
            throw new IllegalStateException("El deportista ya pertenece al equipo");
        }
        miembros.add(deportista);
    }

    public void eliminarMiembro(Deportista deportista) {
        if (deportista == null) {
            throw new IllegalArgumentException("El miembro no puede ser null");
        }
        if (!miembros.remove(deportista)) {
            throw new IllegalStateException("El deportista no pertenece al equipo");
        }
    }
}