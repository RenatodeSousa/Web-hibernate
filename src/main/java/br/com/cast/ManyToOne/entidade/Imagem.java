package br.com.cast.ManyToOne.entidade;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="imagem")
public class Imagem {

	@Id
	@SequenceGenerator(name = "gerador_imagem_seq", sequenceName = "imagem_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_imagem_seq")
	private Integer id;
	private String caminho;

	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="id_post")
	private Post post;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagem() {
		return caminho;
	}

	public void setImagem(String imagem) {
		caminho = imagem;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
	

}
