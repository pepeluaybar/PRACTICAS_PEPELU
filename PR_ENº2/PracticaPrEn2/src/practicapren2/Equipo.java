package practicapren2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo extends Participante {

    private final List<Deportista> miembros;

    public Equipo() {
        this.miembros = new ArrayList<>();
    }

    public Equipo(String nombre, String pais) {
        super(nombre, pais);
        this.miembros = new ArrayList<>();
    }

    public List<Deportista> getMiembros() {
        return Collections.unmodifiableList(miembros);
    }

    public boolean altaMiembro(Deportista deportista) {
        if (deportista == null || miembros.contains(deportista)) {
            return false;
        }
        return miembros.add(deportista);
    }

    public boolean bajaMiembro(Deportista deportista) {
        if (deportista == null) {
            return false;
        }
        return miembros.remove(deportista);
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre='" + getNombre() + '\'' + ", pais='" + getPais() + '\''
                + ", miembros=" + miembros + '}';
    }
}
