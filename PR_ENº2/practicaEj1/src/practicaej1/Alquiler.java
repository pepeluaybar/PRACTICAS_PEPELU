/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaej1;

import java.util.Arrays;

/**
 *
 * @author EAG
 */
public class Alquiler {
    // Declaración de atributos
    private Vehiculo[] vehiculos;

    // Constructor por defecto
    public Alquiler() {
        this.vehiculos = new Vehiculo[0];
    }

    // Constructor por parámetros
    public Alquiler(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos.clone();
    }

    // Constructor de copia
    public Alquiler(Alquiler a) {
        this.vehiculos = a.vehiculos;
    }

    // Declaración de getters (1 por atributo)
    public Vehiculo[] getAlquiler() {
        return this.vehiculos;
    }

    // Declaración de setters (1 por atributo)
    public void setAlquiler(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    // Declaración de métodos personalizados
    public boolean comprobarVehiculo(Vehiculo[] vR, Vehiculo v) {
        for (int i = 0; i < vR.length; i++) {
            if (vR[i].getMatricula().equals(v.getMatricula())) {
                return true;
            }
        }
        return false;
    }

    public void incorporarVehiculo(Vehiculo[] vR, Vehiculo v) {
        if (comprobarVehiculo(vR, v) == false) {
            // Aumentar espacio array
            Vehiculo[] nuevoArray = new Vehiculo[vR.length + 1];

            // Agregar vehiculos ya registrados
            for (int i = 0; i < vR.length; i++) {
                nuevoArray[i] = vR[i];
            }

            // Agregar nuevo vehiculo
            nuevoArray[nuevoArray.length - 1] = v;

            // Actualizar el array del objeto
            this.vehiculos = nuevoArray;

            System.out.println("El vehiculo de matricula " + v.getMatricula() + " ha sido registrado correctamente");
        } else {
            System.out.println("El vehículo ya previamente esta registrado.");
        }
    }

    // alquilarVehiculo
    public void alquilarVehiculo(Vehiculo[] vR, Vehiculo v) {
        if (comprobarVehiculo(vR, v) && v.isCocheDisponible()) {
            v.setCocheDisponible(false);
            System.out.println("Vehiculo alquilado exitosamente.");
        } else {
            System.out.println("El vehiculo no esta disponible");
        }
    }

    // Declaración toString() (con @Override)
    @Override
    public String toString() {
        return "Alquiler{" + "vehiculos=" + Arrays.toString(vehiculos) + '}';
    }


}
