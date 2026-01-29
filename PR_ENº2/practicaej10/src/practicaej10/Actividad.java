package practicaej10;

public class Actividad {
    private int horario, responsable;
    
    public Actividad(){
        this.horario = 0;
        this.responsable = 0;
    }

    public Actividad(int horario, int responsable) {
        this.horario = horario;
        this.responsable = responsable;
    }
    
    public Actividad(Actividad a){
        this.horario = a.horario;
        this.responsable = a.responsable;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Actividad{" + "horario=" + horario + ", responsable=" + responsable + '}';
    }
    
}
