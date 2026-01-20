/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaej1;
import java.util.Arrays;
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
    public boolean comprobarVehiculo(Vehiculo[] vR, Vehiculo v){
        for(int i=0; i < vR.length; i++){
            if(vR[i].getMatricula().equals(v.getMatricula())){
                return true;
            }
        }
        return false;
    }
    
    public void incorporarVehiculo(Vehiculo[] vR, Vehiculo v){
        if(comprobarVehiculo(vR, v) == false){
            Vehiculo[] nuevoArray = new Vehiculo[vR.length + 1];
            for (int i = 0; i < vR.length; i++) {
                nuevoArray[i] = vR[i];
            }
            nuevoArray[nuevoArray.length - 1] = v;
            this.vehiculos = nuevoArray;
            System.out.println("El vehiculo ha sido registrado");
        }else{
                  System.out.println("El vehiculo ya esta registrado");
        }
    }
    
// Declaración toString() (con @Override)

    @Override
    public String toString() {
        return "Alquiler{" + "vehiculos=" + Arrays.toString(vehiculos) + '}';
    }
    
}
