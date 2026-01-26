package practicaej6;

public class Participacion {

    // Atributos
    private Empleado empleado;
    private Proyecto proyecto;
    private int horas;

    // Constructor por defecto
    public Participacion() {
        this.empleado = null;
        this.proyecto = null;
        this.horas = 0;
    }

    // Constructor por parámetros
    public Participacion(Empleado empleado, Proyecto proyecto, int horas) {
        this.empleado = empleado;
        this.proyecto = proyecto;
        this.horas = Math.max(0, horas); // evita horas negativas
    }

    // Constructor de copia
    public Participacion(Participacion p) {
        this.empleado = p.empleado;
        this.proyecto = p.proyecto;
        this.horas = p.horas;
    }

    // Getters
    public Empleado getEmpleado() {
        return empleado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public int getHoras() {
        return horas;
    }

    // Setters
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setHoras(int horas) {
        this.horas = Math.max(0, horas);
    }

    // Método personalizado: coste de ESTA participación
    // (horas trabajadas * salario del empleado)
    public double calcularCoste() {
        if (empleado == null) return 0;
        return horas * empleado.getSalario();
    }

    @Override
    public String toString() {
        return "Participacion{" +
                "empleado=" + empleado +
                ", proyecto=" + proyecto +
                ", horas=" + horas +
                '}';
    }
}
