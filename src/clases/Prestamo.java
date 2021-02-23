package clases;

import java.time.LocalDate;

public class Prestamo {
	LocalDate fechaInicio;
	LocalDate fechaFin;
	Copia libro;
	Lector lector;
	public Prestamo(LocalDate fechaInicio, LocalDate fechaFin, Copia libro, Lector lector) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.libro = libro;
		this.lector = lector;
	}
	public long getIdentificador() {
		return (this.libro).getIdentificador();
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public Lector getLector() {
		return this.lector;
	}
	public LocalDate getFechaFin() {
		return this.fechaFin;
	}
}
