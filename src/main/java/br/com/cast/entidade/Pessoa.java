package br.com.cast.entidade;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity

public class Pessoa {

	@Id
	@SequenceGenerator(name="gerador_pessoa_seq", 
    sequenceName="pessoa_id_seq", 
    allocationSize=1)
@GeneratedValue(strategy=GenerationType.SEQUENCE, 
	generator="gerador_pessoa_seq")
	private Integer id;
	private String nome;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name= "id_cargo")
	private Cargo cargo;

	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
