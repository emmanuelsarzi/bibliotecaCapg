package clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
	ArrayList<Prestamo> prestamos;
	ArrayList<Copia> almacen;
	private long librosAlmacenados;
	private long lectoresAsociados;
	public Biblioteca() {
		super();
		this.prestamos = new ArrayList<Prestamo>();
		this.almacen = new ArrayList<Copia>();
		this.librosAlmacenados = 1;
		this.lectoresAsociados = 1;
	}
	
	public void agregarLibro(Copia libro){
		this.almacen.add(libro);
		this.librosAlmacenados++;
	}
	
	public Lector asociar(String nombre, String telefono, String direccion){
		return (new Lector(this.lectoresAsociados, nombre, telefono, direccion));
	}
	
	public ArrayList<Copia> getStock(){
		return this.almacen;
	}

	public void prestar(Copia copia, Lector lector, LocalDate fechaInicio, LocalDate fechaFin) throws NoSePuedePrestarUnLibroQueNoEsteEnStock, NoSePuedePrestarAUnLectorMultado, NoSePuedePrestarAUnLectorQueYaAlquiloTres {
		if(!lector.puedeRecibirPrestamoPorMultas()) throw new NoSePuedePrestarAUnLectorMultado();
		if(!lector.puedeRecibirPrestamoPorCantidad()) throw new NoSePuedePrestarAUnLectorQueYaAlquiloTres();
		Copia libroABorrar = null;
		for(Copia libro : this.almacen){
			if(((Long)libro.getIdentificador()).equals(copia.getIdentificador())){
				Prestamo prestamo = new Prestamo(fechaInicio, fechaFin, libro, lector);
				this.prestamos.add(prestamo);
				lector.recibirPrestamo(prestamo.getIdentificador(), prestamo.getFechaInicio());
				libroABorrar = libro;
			}
		}
		if(libroABorrar == null) throw new NoSePuedePrestarUnLibroQueNoEsteEnStock();
		this.almacen.remove(libroABorrar);
		
	}
	
	public void finalizarPrestamo(Lector lector, Copia libro, LocalDate fechaFin){
		Prestamo prestamoAEliminar = null;
		for(Prestamo prestamo : prestamos) {
			Long id = prestamo.getIdentificador();
			if(id.equals(libro.getIdentificador()) && prestamo.getLector().equals(lector)){
				this.almacen.add((int) libro.getIdentificador(), libro);
				prestamoAEliminar = prestamo;
				lector.devolver(id, new Date().toString());
				lector.multar(ChronoUnit.DAYS.between(prestamo.getFechaFin(), fechaFin) * 2);
			}
		}
		this.prestamos.remove(prestamoAEliminar);
	} 

	public long getLibrosAlmacenados() {
		return this.librosAlmacenados;
	}
}
