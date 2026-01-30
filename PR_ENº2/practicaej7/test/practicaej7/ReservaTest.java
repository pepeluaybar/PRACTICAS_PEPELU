package practicaej7;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    @Test
    void calcularDias_devuelveCeroSiFechasSonNull() {
        Reserva reserva = new Reserva();

        assertEquals(0, reserva.calcularDias());
    }

    @Test
    void calcularDias_calculaNochesEntreFechas() {
        Habitacion habitacion = new Habitacion(1, "Doble", true);
        Cliente cliente = new Cliente("Ana", "123");
        Reserva reserva = new Reserva(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5), habitacion, cliente);

        assertEquals(4, reserva.calcularDias());
    }

    @Test
    void calcularImporte_usaPrecioPorDia() {
        Habitacion habitacion = new Habitacion(1, "Doble", true);
        Cliente cliente = new Cliente("Ana", "123");
        Reserva reserva = new Reserva(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 3), habitacion, cliente);

        assertEquals(200, reserva.calcularImporte(100));
    }

    @Test
    void calcularImporte_noPermitePrecioNegativo() {
        Reserva reserva = new Reserva();

        assertEquals(0, reserva.calcularImporte(-50));
    }
}
