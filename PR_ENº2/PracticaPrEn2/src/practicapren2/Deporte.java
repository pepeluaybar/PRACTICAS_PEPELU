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
public class Deporte {
    private String nombre;
    private TipoDeporte tipoD;
    private Prueba[] pruebas;

    public Deporte(String nombre, TipoDeporte tipoD, Prueba[] pruebas) {
        this.nombre = nombre;
        this.tipoD = tipoD;
        this.pruebas = pruebas;
    }
    public Deporte(Deporte d){
        this.nombre = d.nombre;
        this.tipoD = d.tipoD;
        this.pruebas = d.pruebas;    
}
    public Deporte(){
        this.nombre = "";
        this.tipoD = null;
        this.pruebas = new Prueba[0]; 
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeporte getTipoD() {
        return tipoD;
    }

    public Prueba[] getPruebas() {
        return pruebas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoD(TipoDeporte tipoD) {
        this.tipoD = tipoD;
    }

    public void setPruebas(Prueba[] pruebas) {
        this.pruebas = pruebas;
    }
    /*
    Metodos
    
    */
    
    @Override
    public String toString() {
        return "Prueba{" + "nombre=" + nombre + ", tipoD=" + tipoD + ", pruebas=" + pruebas + '}';
    }
    
}