package practicaej6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void empleado_constructor_noPermiteSalarioNegativo() {
        Empleado empleado = new Empleado("Ana", -10);

        assertEquals(0, empleado.getSalario());
    }

    @Test
    void participacion_calculaCoste() {
        Empleado empleado = new Empleado("Ana", 15);
        Proyecto proyecto = new Proyecto("Proyecto", 1000);
        Participacion participacion = new Participacion(empleado, proyecto, 8);

        assertEquals(120, participacion.calcularCoste());
    }

    @Test
    void participacion_calculaCosteDevuelve0SiEmpleadoEsNull() {
        Participacion participacion = new Participacion(null, null, 5);

        assertEquals(0, participacion.calcularCoste());
    }

    @Test
    void proyecto_asignarEmpleado_ampliaArray() {
        Proyecto proyecto = new Proyecto("Proyecto", 1000);
        Empleado empleado = new Empleado("Ana", 10);

        for (int i = 0; i < 11; i++) {
            assertTrue(proyecto.asignarEmpleado(empleado, i + 1));
        }

        assertEquals(11, proyecto.getNumParticipaciones());
        assertEquals(11, proyecto.getParticipaciones().length);
    }

    @Test
    void proyecto_calcularCosteTotal_sumaParticipaciones() {
        Proyecto proyecto = new Proyecto("Proyecto", 1000);
        Empleado empleado1 = new Empleado("Ana", 10);
        Empleado empleado2 = new Empleado("Luis", 20);

        proyecto.asignarEmpleado(empleado1, 5);
        proyecto.asignarEmpleado(empleado2, 3);

        assertEquals(110, proyecto.calcularCosteTotal());
    }
}
