package clases;

import java.time.LocalDate;
import java.util.HashMap;

public class Lector {
	long identificador;
	String nombre;
	String telefono;
	String direccion;
	private int librosAlquilados;
	private HashMap<Long, LocalDate> alquileres;
	private Multa multa;
	
	public Lector(long identificador, String nombre, String telefono, String direccion) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.multa = null;
		this.librosAlquilados = 0;
		this.alquileres = new HashMap<Long, LocalDate>();
	}

	public void devolver(long identificador, String fechaActual){
		if(this.librosAlquilados < 1) return;
		this.librosAlquilados--;
		this.alquileres.remove(identificador);
	}
	
	public boolean puedeRecibirPrestamoPorMultas(){
		return this.multa == null;
	}
	
	public void recibirPrestamo(long identificador, LocalDate fechaActual){
		this.librosAlquilados ++;
		this.alquileres.put(identificador, fechaActual);
	}
	public void multar(long diasMultado){
		LocalDate fechaFin = LocalDate.now();
		fechaFin.plusDays(diasMultado);
		this.multa = new Multa(this, LocalDate.now(), fechaFin);
	}

	public boolean puedeRecibirPrestamoPorCantidad() {
		return this.librosAlquilados < 3;
	}
}
