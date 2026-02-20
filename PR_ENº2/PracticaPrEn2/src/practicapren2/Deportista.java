package practicapren2;

public class Deportista extends Participante {

    private String idDeportista;

    public Deportista() {
    }

    public Deportista(String idDeportista, String nombre, String pais) {
        super(nombre, pais);
        setIdDeportista(idDeportista);
    }

    public String getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(String idDeportista) {
        this.idDeportista = validarTexto(idDeportista, "idDeportista");
    }

    @Override
    public String toString() {
        return "Deportista{" + "idDeportista='" + idDeportista + '\'' + ", nombre='" + getNombre() + '\''
                + ", pais='" + getPais() + '\'' + '}';
    }
}
