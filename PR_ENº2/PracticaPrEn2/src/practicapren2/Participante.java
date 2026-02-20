package practicapren2;

public abstract class Participante {

    private String nombre;
    private String pais;
    private String idOlimpico;
    private int totalMedallas;

    protected Participante(String nombre, String pais, String idOlimpico) {
        this.nombre = nombre;
        this.pais = pais;
        this.idOlimpico = idOlimpico;
        this.totalMedallas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdOlimpico() {
        return idOlimpico;
    }

    public void setIdOlimpico(String idOlimpico) {
        this.idOlimpico = idOlimpico;
    }

    public int getTotalMedallas() {
        return totalMedallas;
    }

    public void setTotalMedallas(int totalMedallas) {
        this.totalMedallas = totalMedallas;
    }

    public void incrementarMedallas() {
        totalMedallas++;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", idOlimpico='" + idOlimpico + '\'' +
                ", totalMedallas=" + totalMedallas +
                '}';
    }
}
