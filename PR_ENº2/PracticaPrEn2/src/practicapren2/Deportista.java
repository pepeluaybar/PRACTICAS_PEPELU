package practicapren2;

public class Deportista extends Participante {

    private int edad;
    private String especialidad;

    public Deportista() {
        super();
        edad = 0;
        especialidad = "";
    }

    public Deportista(String nombre, String pais, int idOlimpico, int edad, String especialidad) {
        super(nombre, pais, idOlimpico, 0);
        this.edad = edad;
        this.especialidad = especialidad;
    }

    public int getEdad() {
        return edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Deportista{" + "nombre=" + nombre + ", pais=" + pais + ", idOlimpico=" + idOlimpico
                + ", totalMedallas=" + totalMedallas + ", edad=" + edad + ", especialidad=" + especialidad + '}';
    }
}