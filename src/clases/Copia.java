package clases;

public class Copia extends Libro{


	public Copia(String titulo, tipoLibro tipo, String editorial, int anio, long identificador) {
		super(titulo, tipo, editorial, anio);
		this.identificador = identificador;
		estado = estadoCopia.BIBLIOTECA;
	}


	long identificador;
	estadoCopia estado;
	
	
	public long getIdentificador() {
		return this.identificador;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + (int) (identificador ^ (identificador >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Copia other = (Copia) obj;
		if (estado != other.estado)
			return false;
		if (identificador != other.identificador)
			return false;
		return true;
	}




	
	
}
