package practicaej10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 Unit tests para el ejercicio 10.

 Asunción aclarada:
 - Actividad.horario se interpreta como "horas" (duración en horas).
 - Registrarse.importe se interpreta como "precio por hora".
 - ingresoRecaudado() = actividad.getHorario() * importe.
 */
public class RegistrarseTest {

    @Test
    void ingresoRecaudado_multiplicaHorasPorPrecioHora() {
        Socio s = new Socio("Pepe", 1);
        Actividad a = new Actividad(4, 99); // 4 horas
        Registrarse r = new Registrarse(s, a, 10); // 10€/hora
        
        assertEquals(40, r.ingresoRecaudado());
    }

    @Test
    void ingresoRecaudado_devuelve0SiActividadEsNull() {
        Socio s = new Socio("Pepe", 1);
        Registrarse r = new Registrarse(s, null, 10);

        assertEquals(0, r.ingresoRecaudado());
    }

    @Test
    void gettersYSetters_funcionan() {
        Registrarse r = new Registrarse();

        Socio s = new Socio("Ana", 7);
        Actividad a = new Actividad(2, 55);

        r.setSocio(s);
        r.setActividad(a);
        r.setImporte(15);

        assertSame(s, r.getSocio());
        assertSame(a, r.getActividad());
        assertEquals(15, r.getImporte());
        assertEquals(30, r.ingresoRecaudado()); // 2 * 15
    }

    @Test
    void constructorPorDefecto_inicializaComoEsperado() {
        Registrarse r = new Registrarse();

        assertNull(r.getSocio());
        assertNull(r.getActividad());
        assertEquals(0, r.getImporte());
        assertEquals(0, r.ingresoRecaudado());
    }

    @Test
    void constructorDeCopia_copiaReferenciasYValores() {
        Socio s = new Socio("Lucia", 3);
        Actividad a = new Actividad(5, 12);
        Registrarse original = new Registrarse(s, a, 8);

        Registrarse copia = new Registrarse(original);

        assertSame(original.getSocio(), copia.getSocio());
        assertSame(original.getActividad(), copia.getActividad());
        assertEquals(original.getImporte(), copia.getImporte());
        assertEquals(original.ingresoRecaudado(), copia.ingresoRecaudado());
    }

    @Test
    void actividad_gettersSetters() {
        Actividad a = new Actividad();
        a.setHorario(3);
        a.setResponsable(10);

        assertEquals(3, a.getHorario());
        assertEquals(10, a.getResponsable());
    }

    @Test
    void socio_gettersSetters() {
        Socio s = new Socio();
        s.setNombre("Mario");
        s.setId(42);

        assertEquals("Mario", s.getNombre());
        assertEquals(42, s.getId());
    }
}
