package clases;


public abstract class Libro {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (anio != other.anio)
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	String titulo;
	tipoLibro tipo;
	String editorial;
	int anio;
	
	public Libro(String titulo, tipoLibro tipo, String editorial, int anio) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.editorial = editorial;
		this.anio = anio;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getEditorial() {
		return this.editorial;
	}
	
	public int getAnio() {
		return this.anio;
	}
	
	public tipoLibro getTipo() {
		return this.tipo;
	}
	
}
