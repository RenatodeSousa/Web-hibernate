package br.com.cast.ManyToOne.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.ManyToOne.entidade.Imagem;
import br.com.cast.ManyToOne.entidade.Post;

public class DAOPost {
	private EntityManager em;

	public DAOPost() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoa");
		em = emf.createEntityManager();
	}

	public void inserirPost(Post post) {

		em.getTransaction().begin();
		em.persist(post);

		em.getTransaction().commit();
		em.close();
		System.out.println("Inserido com sucesso");

	}
	
	public Imagem buscarPorIdimg(Integer id) {
		return em.find(Imagem.class, id);
	}
	public Post buscarPorIdpost(Integer id) {
		return em.find(Post.class, id);
	}
	
	public List<Post> buscarTodos() {
	       StringBuilder hql = new StringBuilder();
	       hql.append("SELECT DISTINCT p ")
	          .append(" FROM ").append(Post.class.getName()).append(" p ")
	          .append(" LEFT JOIN FETCH p.listImg ");

	       Query query = em.createQuery(hql.toString());

	       return query.getResultList();
	   }
	    
	
		
	
}
