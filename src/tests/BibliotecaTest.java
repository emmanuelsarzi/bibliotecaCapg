package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import clases.Biblioteca;
import clases.Copia;
import clases.Lector;
import clases.NoSePuedePrestarAUnLectorMultado;
import clases.NoSePuedePrestarAUnLectorQueYaAlquiloTres;
import clases.NoSePuedePrestarUnLibroQueNoEsteEnStock;
import clases.tipoLibro;

class BibliotecaTest {

	@Test
	public void LaBibliotecaLePresta3LibrosAlLectorAYLeQuedan7() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
			
		Lector lectorA = biblioteca.asociar("Juan", "1140020234", "Salta 1010");
			
			
		try {
			biblioteca.prestar(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 1),lectorA, LocalDate.now(), LocalDate.now().plusDays(15));
			biblioteca.prestar(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 2),lectorA, LocalDate.now(), LocalDate.now().plusDays(5));
			biblioteca.prestar(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 8),lectorA, LocalDate.now(), LocalDate.now().plusDays(29));
		} catch (NoSePuedePrestarUnLibroQueNoEsteEnStock e) {
			fail("No se puede prestar libros que no hay en stock");
		} catch (NoSePuedePrestarAUnLectorMultado e) {
			fail("No se puede prestar a un lector multado");
		} catch (NoSePuedePrestarAUnLectorQueYaAlquiloTres e) {
			fail("No se puede prestar a un lector que ya tiene 3 libros");
		}
			
		ArrayList<Copia> resultado = new ArrayList<Copia>();
		resultado.add(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 3));
		resultado.add(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 4));
		resultado.add(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 5));
		resultado.add(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 6));
		resultado.add(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 7));
		resultado.add(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 9));
		resultado.add(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 10));
		
		
		
		assertEquals(biblioteca.getStock(), resultado);
			
	}
	
	@Test
	public void LaBibliotecaLePresta3LibrosAlLectorAYLeDevuelven3() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
			
		Lector lectorA = biblioteca.asociar("Juan", "1140020234", "Salta 1010");
		ArrayList<Copia> stockEsperado = biblioteca.getStock();
			
		Copia libro1 = new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 1);
		Copia libro2 = new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 2);
		Copia libro3 = new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 8);
		
		try {
			biblioteca.prestar(libro1,lectorA, LocalDate.now(), LocalDate.now().plusDays(4));
			biblioteca.prestar(libro2,lectorA, LocalDate.now(), LocalDate.now().plusDays(17));
			biblioteca.prestar(libro3,lectorA, LocalDate.now(), LocalDate.now().plusDays(29));
		} catch (NoSePuedePrestarUnLibroQueNoEsteEnStock e) {
			fail("No se puede prestar libros que no hay en stock");
		} catch (NoSePuedePrestarAUnLectorMultado e) {
			fail("No se puede prestar a un lector multado");
		} catch (NoSePuedePrestarAUnLectorQueYaAlquiloTres e) {
			fail("No se puede prestar a un lector que ya tiene 3 libros");
		}
			
		biblioteca.finalizarPrestamo(lectorA, libro1, LocalDate.now().plusDays(4));
		biblioteca.finalizarPrestamo(lectorA, libro2, LocalDate.now().plusDays(17));
		biblioteca.finalizarPrestamo(lectorA, libro3, LocalDate.now().plusDays(29));
		
		assertEquals(biblioteca.getStock(), stockEsperado);
			
	}
	
	@Test
	public void LaBibliotecaLePresta3LibrosAlLectorAYEl4YaNoPuede() {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
		biblioteca.agregarLibro(new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, biblioteca.getLibrosAlmacenados()));
			
		Lector lectorA = biblioteca.asociar("Juan", "1140020234", "Salta 1010");
			
		Copia libro1 = new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 1);
		Copia libro2 = new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 2);
		Copia libro3 = new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 8);
		Copia libro4 = new Copia("una historia maravillosa", tipoLibro.NOVELA, "delSur", 1999, 8);
		
		try {
			biblioteca.prestar(libro1,lectorA, LocalDate.now(), LocalDate.now().plusDays(4));
			biblioteca.prestar(libro2,lectorA, LocalDate.now(), LocalDate.now().plusDays(17));
			biblioteca.prestar(libro3,lectorA, LocalDate.now(), LocalDate.now().plusDays(29));
		} catch (NoSePuedePrestarUnLibroQueNoEsteEnStock e) {
			fail("No se puede prestar libros que no hay en stock");
		} catch (NoSePuedePrestarAUnLectorMultado e) {
			fail("No se puede prestar a un lector multado");
		} catch (NoSePuedePrestarAUnLectorQueYaAlquiloTres e) {
			assertThrows(NoSePuedePrestarAUnLectorQueYaAlquiloTres.class, () -> {
				biblioteca.prestar(libro4,lectorA, LocalDate.now(), LocalDate.now().plusDays(2));
		    });
		}
		
			
	}
	
	

}
