package practicapren2;

public class Participante {

    protected String nombre;
    protected String pais;
    protected int idOlimpico;
    protected int totalMedallas;

    public Participante() {
        nombre = "";
        pais = "";
        idOlimpico = 0;
        totalMedallas = 0;
    }

    public Participante(String n, String p, int id) {
        nombre = n;
        pais = p;
        idOlimpico = id;
        totalMedallas = 0;
    }

    public Participante(Participante pa) {
        nombre = pa.nombre;
        pais = pa.pais;
        idOlimpico = pa.idOlimpico;
        totalMedallas = pa.totalMedallas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getIdOlimpico() {
        return idOlimpico;
    }

    public int getTotalMedallas() {
        return totalMedallas;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setPais(String p) {
        pais = p;
    }

    public void setIdOlimpico(int id) {
        idOlimpico = id;
    }

    public void setTotalMedallas(int totalMedallas) {
        this.totalMedallas = totalMedallas;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + ", País: " + pais
                + ", ID Olímpico: " + idOlimpico + ", Medallas: " + totalMedallas;
    }

    @Override
    public String toString() {
        return "Participante{" + "nombre=" + nombre + ", pais=" + pais
                + ", idOlimpico=" + idOlimpico + ", totalMedallas=" + totalMedallas + '}';
    }
}