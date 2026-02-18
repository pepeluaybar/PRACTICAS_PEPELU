package practicaej6;

public class Empleado {

    // Atributos
    private String nombre;
    private double salario;

    // Constructor por defecto
    public Empleado() {
        this.nombre = "";
        this.salario = 0;
    }

    // Constructor por parámetros
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = Math.max(0, salario);
    }

    // Constructor de copia
    public Empleado(Empleado e) {
        this.nombre = e.nombre;
        this.salario = e.salario;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = Math.max(0, salario);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                '}';
    }
}
