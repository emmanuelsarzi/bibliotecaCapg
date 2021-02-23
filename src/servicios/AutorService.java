package servicios;

import java.util.List;

import clases.Autor;
import clases.AutorDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import persistencia.AutorDAO;

@WebService
public class AutorService {
	@WebMethod(operationName = "agregarAutorWS")
	public boolean agregarAutor(@WebParam(name = "autor") AutorDTO autor){
		AutorDAO dao = new AutorDAO();
		Autor a = new Autor();
		a.setNombre(autor.getNombre());
		a.setNacionalidad(autor.getNacionalidad());
		a.setFechaDeNacimiento(autor.getFechaDeNacimiento());
		try {
			dao.agregarAutor(a);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@WebMethod(operationName = "consultarAutorWS")
	public List<Autor> consultarAutores(){
		AutorDAO dao = new AutorDAO();
		return dao.consultarAutores();
	}
}
