package practicaej7;

public class Habitacion {
    private int numero;
    private String tipo;
    private boolean habitacionDisponible;

    public Habitacion() {
        this.numero = 0;
        this.tipo = "";
        this.habitacionDisponible = true;
    }

    public Habitacion(int numero, String tipo, boolean habitacionDisponible) {
        this.numero = numero;
        this.tipo = tipo;
        this.habitacionDisponible = habitacionDisponible;
    }

    public Habitacion(Habitacion h) {
        this.numero = h.numero;
        this.tipo = h.tipo;
        this.habitacionDisponible = h.habitacionDisponible;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isHabitacionDisponible() {
        return habitacionDisponible;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHabitacionDisponible(boolean habitacionDisponible) {
        this.habitacionDisponible = habitacionDisponible;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", disponible=" + habitacionDisponible +
                '}';
    }
}
