package practicaej7;

public class Cliente {
    private String nombre;
    private String id; // documento identidad

    public Cliente() {
        this.nombre = "";
        this.id = "";
    }

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Cliente(Cliente c) {
        this.nombre = c.nombre;
        this.id = c.id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
