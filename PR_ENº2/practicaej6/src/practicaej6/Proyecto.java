package practicaej6;

public class Proyecto {

    // Atributos
    private String nombre;
    private double presupuesto;

    // Para gestionar participaciones (empleado + horas)
    private Participacion[] participaciones;
    private int numParticipaciones;

    // Constructor por defecto
    public Proyecto() {
        this.nombre = "";
        this.presupuesto = 0;
        this.participaciones = new Participacion[10];
        this.numParticipaciones = 0;
    }

    // Constructor por parámetros
    public Proyecto(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = Math.max(0, presupuesto);
        this.participaciones = new Participacion[10];
        this.numParticipaciones = 0;
    }

    // Constructor de copia
    public Proyecto(Proyecto p) {
        this.nombre = p.nombre;
        this.presupuesto = p.presupuesto;
        this.participaciones = p.participaciones.clone();
        this.numParticipaciones = p.numParticipaciones;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public Participacion[] getParticipaciones() {
        return participaciones;
    }

    public int getNumParticipaciones() {
        return numParticipaciones;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = Math.max(0, presupuesto);
    }

    public void setParticipaciones(Participacion[] participaciones) {
        this.participaciones = participaciones;
    }

    public boolean asignarEmpleado(Empleado empleado, int horas) {
        if (empleado == null || horas < 0) return false;

        if (this.numParticipaciones >= this.participaciones.length) {
            Participacion[] nuevo = new Participacion[this.participaciones.length + 1];
            for (int i = 0; i < this.participaciones.length; i++) {
                nuevo[i] = this.participaciones[i];
            }
            this.participaciones = nuevo;
        }

        this.participaciones[this.numParticipaciones] = new Participacion(empleado, this, horas);
        this.numParticipaciones++;
        return true;
    }

    public double calcularCosteTotal() {
        double total = 0;

        for (int i = 0; i < this.numParticipaciones; i++) {
            if (this.participaciones[i] != null) {
                total += this.participaciones[i].calcularCoste();
            }
        }

        return total;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", numParticipaciones=" + numParticipaciones +
                '}';
    }
}
