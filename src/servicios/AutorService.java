package servicios;

import clases.Autor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import persistencia.AutorDAO;

@WebService
public class AutorService {
	@WebMethod(operationName = "agregarAutorWS")
	public boolean agregarAutor(@WebParam(name = "autor") Autor autor){
		AutorDAO dao = new AutorDAO();
		try {
			dao.agregarAutor(autor);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
