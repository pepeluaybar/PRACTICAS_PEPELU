package practicaej10;

public class Registrarse {
    private Socio socio;
    private Actividad actividad;
    private int importe;

    // Constructor por defecto
    public Registrarse() {
        this.socio = null;
        this.actividad = null;
        this.importe = 0;
    }

    // Constructor por parámetros
    public Registrarse(Socio socio, Actividad actividad, int importe) {
        this.socio = socio;
        this.actividad = actividad;
        this.importe = importe;
    }

    // Constructor de copia
    public Registrarse(Registrarse r) {
        this.socio = r.socio;
        this.actividad = r.actividad;
        this.importe = r.importe;
    }

    // Getters y setters
    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    // Método pedido en el diagrama
    // Devuelve el importe de esta inscripción * las horas 
    public int ingresoRecaudado() {
        if (this.actividad == null) return 0;
        return this.actividad.getHorario() * this.importe;
    }

    // Método consultar (mostrar info de la inscripción)
    public void consultar() {
        System.out.println("Socio: " + socio);
        System.out.println("Actividad: " + actividad);
        System.out.println("Importe: " + importe + "€");
    }

    @Override
    public String toString() {
        return "Registrarse{" +
                "socio=" + socio +
                ", actividad=" + actividad +
                ", importe=" + importe +
                '}';
    }
}
