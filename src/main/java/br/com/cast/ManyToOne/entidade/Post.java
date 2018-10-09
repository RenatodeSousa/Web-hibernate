package br.com.cast.ManyToOne.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@SequenceGenerator(name = "gerador_post_seq", sequenceName = "post_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_post_seq")
	private Integer id;
	private String texto;
	private Date data;

	@OneToMany(mappedBy = "post",cascade=CascadeType.ALL)
	private List<Imagem> listImg = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Imagem> getListImg() {
		return listImg;
	}

	public void setListImg(List<Imagem> listImg) {
		
	}
	
	public void addListImg(Imagem imagem) {
		this.listImg.add(imagem);
		imagem.setPost(this);
	}

}