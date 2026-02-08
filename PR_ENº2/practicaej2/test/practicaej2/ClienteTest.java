package practicaej2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void ingresarSaldo_sumaCuandoEsPositivo() {
        Cuenta cuenta = new Cuenta(1, 100);
        Cliente cliente = new Cliente(cuenta);

        cliente.ingresarSaldo(50, cuenta.getSaldo());

        assertEquals(150, cuenta.getSaldo());
    }

    @Test
    void ingresarSaldo_noModificaSiEsNegativo() {
        Cuenta cuenta = new Cuenta(1, 100);
        Cliente cliente = new Cliente(cuenta);

        cliente.ingresarSaldo(-10, cuenta.getSaldo());

        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void retirarSaldo_restaCuandoEsValido() {
        Cuenta cuenta = new Cuenta(1, 100);
        Cliente cliente = new Cliente(cuenta);

        cliente.retirarSaldo(40, cuenta.getSaldo());

        assertEquals(60, cuenta.getSaldo());
    }

    @Test
    void retirarSaldo_noPermiteRetirarMasQueElSaldo() {
        Cuenta cuenta = new Cuenta(1, 100);
        Cliente cliente = new Cliente(cuenta);

        cliente.retirarSaldo(150, cuenta.getSaldo());

        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void constructorDeCopia_copiaCuenta() {
        Cuenta cuenta = new Cuenta(1, 100);
        Cliente original = new Cliente(cuenta);
        Cliente copia = new Cliente(original);

        assertSame(cuenta, copia.getAccount());
    }
}
