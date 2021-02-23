package servicios;

import jakarta.xml.ws.Endpoint;

public class BibliotecaService {

	public static void main(String[] args) {
		Endpoint endPoint = Endpoint.publish("http://localhost:8080/AutorService", new AutorService());
	}

}
