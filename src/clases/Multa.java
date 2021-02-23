package clases;

import java.time.LocalDate;
import java.util.Date;

public class Multa {
	LocalDate fechaInicio;
	LocalDate fechaFin;
	Lector multado;
	public Multa(Lector lector, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.multado = lector;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
}

