package practicaej7;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Habitacion habitacion;
    private Cliente cliente;

    public Reserva() {
        this.fechaEntrada = null;
        this.fechaSalida = null;
        this.habitacion = null;
        this.cliente = null;
    }

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Habitacion habitacion, Cliente cliente) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
        this.cliente = cliente;
    }

    public Reserva(Reserva r) {
        this.fechaEntrada = r.fechaEntrada;
        this.fechaSalida = r.fechaSalida;
        this.habitacion = r.habitacion;
        this.cliente = r.cliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Días entre entrada y salida (noches)
    public long calcularDias() {
        if (this.fechaEntrada == null || this.fechaSalida == null) return 0;
        long dias = ChronoUnit.DAYS.between(this.fechaEntrada, this.fechaSalida);
        return Math.max(0, dias);
    }

    // Importe a pagar: dias * precioPorDia
    // (el enunciado no da precio; lo pasamos como parámetro)
    public double calcularImporte(double precioPorDia) {
        return calcularDias() * Math.max(0, precioPorDia);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", habitacion=" + habitacion +
                ", cliente=" + cliente +
                '}';
    }
}
