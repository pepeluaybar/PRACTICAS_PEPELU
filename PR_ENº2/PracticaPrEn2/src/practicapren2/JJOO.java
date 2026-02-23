package practicapren2;

public class JJOO {

    private String nombre;
    private int año;
    private String sede;
    private Deporte[] deportes;
    private int numDeportes;

    public JJOO() {
        deportes = new Deporte[30];
        numDeportes = 0;
    }

    public JJOO(String nombre, int año, String sede) {
        this();
        setNombre(nombre);
        setAnio(año);
        setSede(sede);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            System.out.println("El nombre de los JJOO no puede ser nulo");
        }
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAnio(int anio) {
        if (anio <= 0) {
            System.out.println("El año debe ser mayor que 0");
        }
        this.año = año;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        if (sede == null) {
            System.out.println("La sede no puede ser nula o vacía");
        }
        this.sede = sede;
    }

    public Deporte[] getDeportes() {
        Deporte[] copia = new Deporte[numDeportes];
        for (int i = 0; i < numDeportes; i++) {
            copia[i] = deportes[i];
        }
        return copia;
    }

    public int getNumDeportes() {
        return numDeportes;
    }
    
    public 
    

    @Override
    public String toString() {
        String texto = "JJOO{" + "nombre='" + nombre + '\'' + ", anio=" + año + ", sede='" + sede + '\''
                + ", deportes=[";
        for (int i = 0; i < numDeportes; i++) {
            texto += deportes[i];
            if (i < numDeportes - 1) {
                texto += ", ";
            }
        }
        texto += "]}";
        return texto;
    }
}