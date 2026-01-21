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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo();
        Vehiculo v2 = new Vehiculo();
        Vehiculo v3 = new Vehiculo();
        Alquiler a = new Alquiler();
        
        v1.setMarca("Seat");
        v1.setMatricula("1234MDK");
        v1.setModelo("ibiza");
        
        v2.setMarca("");
        v2.setMatricula("1252MDK");
        v2.setModelo("leon");
        v2.setCocheDisponible(false);
        
        v3.setMarca("lamborghini");
        v3.setMatricula("1252VVK");
        v3.setModelo("huracan");
        v3.setCocheDisponible(true);
       
        a.incorporarVehiculo(a.getAlquiler(), v1);
        a.incorporarVehiculo(a.getAlquiler(), v2);
        a.incorporarVehiculo(a.getAlquiler(), v3);
        
        a.incorporarVehiculo(a.getAlquiler(), v1);
        
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
     
        
        /*
        a.incorporarVehiculo(a.getVehiculosRegistrados(), v1);
        a.incorporarVehiculo(a.getVehiculosRegistrados(), v3);
        */
        
        a.alquilarVehiculo(a.getAlquiler(), v2);
        
        for (Vehiculo v : a.getAlquiler()) {
            System.out.println(v);
        }
        
        System.out.println(a.toString());
    }   
}
