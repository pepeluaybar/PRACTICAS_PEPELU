package practicaej10;

public class Socio {
    private String nombre;
    private int id;

    public Socio(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
    public Socio(){
    this.nombre = "";
    this.id = 0;
}
    public Socio(Socio s){
        this.nombre = s.nombre;
        this.id = s.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Socio{" + "nombre=" + nombre + ", id=" + id + '}';
    }
    
}
