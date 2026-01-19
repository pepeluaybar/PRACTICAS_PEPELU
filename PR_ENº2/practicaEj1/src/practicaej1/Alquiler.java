/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaej1;
import practicaej1.Vehiculo;
/**
 *
 * @author EAG
 */
public class Alquiler {
// Declaración de atributos
    private Vehiculo[] vehiculos;
    
// Constructor por defecto
    public Alquiler(){
        this.vehiculos = new Vehiculo[0];
    }
// Constructor por parámetros
    public Alquiler(Vehiculo[] vehiculos){
        this.vehiculos = vehiculos.clone();
    }
// Constructor de copia
    public Alquiler(Alquiler a){
        this.vehiculos = a.vehiculos;
    }
// Declaración de getters (1 por atributo)
    public Vehiculo[] getAlquiler(){
        return this.vehiculos;
    }
// Declaración de setters (1 por atributo)
    public void setAlquiler(Vehiculo[] vehiculos){
         this.vehiculos = vehiculos;
    }
// Declaración de métodos personalizados
    for(int i = 0; i < )
// Declaración toString() (con @Override)
}
