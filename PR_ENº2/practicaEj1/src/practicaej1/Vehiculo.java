/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaej1;

/**
 *
 * @author EAG
 */
public class Vehiculo {
// Declaración de atributos
 
    private String matricula, marca, modelo;
    private boolean cocheDisponible;

// Constructor por defecto
    public Vehiculo(){
        this.matricula = "";
        this.marca = "";
        this.modelo = "";
        this.cocheDisponible = true;
    }
    
// Constructor por parámetros
    public Vehiculo(String matricula, String marca, String modelo, boolean cocheDisponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cocheDisponible = cocheDisponible;
    }
// Constructor de copia
    public Vehiculo(Vehiculo v){
        this.matricula = v.matricula;
        this.marca = v.marca;
        this.modelo = v.modelo;
        this.cocheDisponible = v.cocheDisponible;
    }
// Declaración de getters (1 por atributo)
    public String getMatricula(){
        return this.matricula;
    }
    public String getMarca(){
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }    
    public boolean getCocheDisponible(){
        return this.cocheDisponible;
    }    
// Declaración de setters (1 por atributo)
    public void setMatricula(String matricula){
         this.matricula = matricula;
    }
    public void setMarca(String marca){
         this.marca = marca;
    }
    public void setModelo(String modelo){
         this.modelo = modelo;
    }    
    public void setCocheDisponible(boolean cocheDisponible){
         this.cocheDisponible = cocheDisponible;
    } 
// Declaración de métodos personalizados
    
// Declaración toString() (con @Override) 
    @Override
        public String toString() {
            String cadena = "Matricula: " + matricula +
                            ", Marca: " + marca +
                            ", Modelo: " + modelo +
                            ", Disponible: ";

            if (cocheDisponible) {
                cadena += "sí";
            } else {
                cadena += "no";
            }

            return cadena;
}
}
