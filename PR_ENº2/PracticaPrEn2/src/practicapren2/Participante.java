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
    public abstract class Participante {
    protected String nombre;
    protected String pais;
    protected int idOlimpico; 
    protected int totalMedallas;

    public Participante(String nombre, String pais, int idOlimpico, int totalMedallas) {
        this.nombre = nombre;
        this.pais = pais;
        this.idOlimpico = idOlimpico;
        this.totalMedallas = totalMedallas;
    }
    
    public Participante(){
        this.nombre = "";
        this.pais = "";
        this.idOlimpico = 0;
        this.totalMedallas = 0;
    }
    
    public Participante(Participante pa){
        this.nombre = pa.nombre;
        this.pais = pa.pais;
        this.idOlimpico = pa.idOlimpico;
        this.totalMedallas = pa.totalMedallas;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setIdOlimpico(int idOlimpico) {
        this.idOlimpico = idOlimpico;
    }

    public void setTotalMedallas(int totalMedallas) {
        this.totalMedallas = totalMedallas;
    }
    
    
}