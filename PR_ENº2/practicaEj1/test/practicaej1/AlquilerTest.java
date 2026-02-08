package practicaej1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlquilerTest {

    @Test
    void incorporarVehiculo_agregaCuandoNoExiste() {
        Alquiler alquiler = new Alquiler();
        Vehiculo v1 = new Vehiculo("1234ABC", "Ford", "Fiesta", true);
        Vehiculo[] actuales = new Vehiculo[0];

        alquiler.incorporarVehiculo(actuales, v1);

        Vehiculo[] registrados = alquiler.getAlquiler();
        assertEquals(1, registrados.length);
        assertSame(v1, registrados[0]);
    }

    @Test
    void incorporarVehiculo_noDuplicaMatricula() {
        Vehiculo v1 = new Vehiculo("1234ABC", "Ford", "Fiesta", true);
        Alquiler alquiler = new Alquiler(new Vehiculo[]{v1});

        alquiler.incorporarVehiculo(alquiler.getAlquiler(), v1);

        Vehiculo[] registrados = alquiler.getAlquiler();
        assertEquals(1, registrados.length);
        assertSame(v1, registrados[0]);
    }

    @Test
    void alquilarVehiculo_cambiaDisponibilidad() {
        Vehiculo v1 = new Vehiculo("1234ABC", "Ford", "Fiesta", true);
        Alquiler alquiler = new Alquiler(new Vehiculo[]{v1});

        alquiler.alquilarVehiculo(alquiler.getAlquiler(), v1);

        assertFalse(v1.isCocheDisponible());
    }

    @Test
    void alquilarVehiculo_noCambiaSiNoDisponible() {
        Vehiculo v1 = new Vehiculo("1234ABC", "Ford", "Fiesta", false);
        Alquiler alquiler = new Alquiler(new Vehiculo[]{v1});

        alquiler.alquilarVehiculo(alquiler.getAlquiler(), v1);

        assertFalse(v1.isCocheDisponible());
    }

    @Test
    void vehiculo_toString_indicaDisponibilidad() {
        Vehiculo disponible = new Vehiculo("1111AAA", "Seat", "Ibiza", true);
        Vehiculo noDisponible = new Vehiculo("2222BBB", "Seat", "Leon", false);

        assertTrue(disponible.toString().contains("Disponible: si"));
        assertTrue(noDisponible.toString().contains("Disponible: no"));
    }
}
