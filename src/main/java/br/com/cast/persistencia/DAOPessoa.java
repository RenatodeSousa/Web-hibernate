package br.com.cast.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entidade.Pessoa;

public class DAOPessoa {

	
	private EntityManager em;
	
	public DAOPessoa() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pessoa");
		em = emf.createEntityManager();
	}
	
	public void inserir(Pessoa p) {
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void alterar(Pessoa p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		
		
	}
	public void delete (Integer id) {
		
		em.getTransaction().begin();
		em.remove(id);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pessoa> consultar(){
		
		String sql = "select p From pessoa p  JOIN  fetch p.cargo c ";
		Query query = em.createQuery("from "+ Pessoa.class.getName());
			
		return query.getResultList();
		
	}
}
