package practicapren2;

public class Deportista extends Participante {

    private int edad;
    private String especialidad;
    private Equipo equipo; // opcional (si aún no lo usas, se queda en null)

    public Deportista() {
        super();
        edad = 0;
        especialidad = "";
        equipo = null;
    }

    public Deportista(String nombre, String pais, int idOlimpico, int edad, String especialidad) {
        super(nombre, pais, idOlimpico);
        this.edad = edad;
        this.especialidad = especialidad;
        this.equipo = null;
    }

    public int getEdad() {
        return edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Deportista{" + "nombre=" + nombre + ", pais=" + pais
                + ", idOlimpico=" + idOlimpico + ", totalMedallas=" + totalMedallas
                + ", edad=" + edad + ", especialidad=" + especialidad + '}';
    }
}