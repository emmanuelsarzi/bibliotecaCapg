package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import clases.Autor;

public class AutorDAO {
	private static EntityManagerFactory managerFactory = Persistence
			.createEntityManagerFactory("ejsHibernate");
	public void agregarAutor(Autor autor) throws Exception{
		EntityManager em = managerFactory.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		em.persist(autor);
		tran.commit();
		em.close();
	}
	
	public List<Autor> consultarAutores(){
		EntityManager em = managerFactory.createEntityManager();
		Autor autor = em.find(Autor.class, "nombre");
		return (em.createQuery("select a from Autor a").getResultList());

	}
}
