/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapren2;

/**
 *
 * @author EAG
 */
public class Prueba {
    private String codigo;
    private String nombre;
    private TipoDeporte tipo;
    private int maxParticipantes;
    private Participante[] participantes;
    private int numParticipantes;
    private String[] resultados;
    private Medalla[] medallas;
    private int numMedallas;
    private boolean resultadoFinalRegistrado;

    public Prueba(String codigo, String nombre, TipoDeporte tipo, int maxParticipantes, Participante[] participantes, int numParticipantes, String[] resultados, Medalla[] medallas, int numMedallas, boolean resultadoFinalRegistrado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.maxParticipantes = maxParticipantes;
        this.participantes = participantes;
        this.numParticipantes = numParticipantes;
        this.resultados = resultados;
        this.medallas = medallas;
        this.numMedallas = numMedallas;
        this.resultadoFinalRegistrado = resultadoFinalRegistrado;
    }
    
    public Prueba(Prueba p) {
        this.codigo = p.codigo;
        this.nombre = p.nombre;
        this.tipo = p.tipo;
        this.maxParticipantes = p.maxParticipantes;
        this.participantes = p.participantes;
        this.numParticipantes = p.numParticipantes;
        this.resultados = p.resultados;
        this.medallas = p.medallas;
        this.numMedallas = p.numMedallas;
        this.resultadoFinalRegistrado = p.resultadoFinalRegistrado;
    }
    public Prueba() {
        this.codigo = "";
        this.nombre = "";
        this.tipo = null;
        this.maxParticipantes = 0;
        this.participantes = new Participante[0];
        this.numParticipantes = 0;
        this.resultados = new String[0];
        this.medallas = new Medalla[0];
        this.numMedallas = 0;
        this.resultadoFinalRegistrado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeporte getTipo() {
        return tipo;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public Participante[] getParticipantes() {
        return participantes;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public String[] getResultados() {
        return resultados;
    }

    public Medalla[] getMedallas() {
        return medallas;
    }

    public int getNumMedallas() {
        return numMedallas;
    }

    public boolean isResultadoFinalRegistrado() {
        return resultadoFinalRegistrado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoDeporte tipo) {
        this.tipo = tipo;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public void setParticipantes(Participante[] participantes) {
        this.participantes = participantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    public void setResultados(String[] resultados) {
        this.resultados = resultados;
    }

    public void setMedallas(Medalla[] medallas) {
        this.medallas = medallas;
    }

    public void setNumMedallas(int numMedallas) {
        this.numMedallas = numMedallas;
    }

    public void setResultadoFinalRegistrado(boolean resultadoFinalRegistrado) {
        this.resultadoFinalRegistrado = resultadoFinalRegistrado;
    }
    
    /*
    Metodos
    */

    @Override
    public String toString() {
        return "Prueba{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", maxParticipantes=" + maxParticipantes + ", participantes=" + participantes + ", numParticipantes=" + numParticipantes + ", resultados=" + resultados + ", medallas=" + medallas + ", numMedallas=" + numMedallas + ", resultadoFinalRegistrado=" + resultadoFinalRegistrado + '}';
    }
    
}
