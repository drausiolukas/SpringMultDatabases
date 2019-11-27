package com.projetodb.MultDatasources.entity.postgresql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class PostgreSQLCliente {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "nome")
	private String nome ;
	
	@Column(name = "score")
	private String score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public PostgreSQLCliente(Long id, String nome, String score) {
		super();
		this.id = id;
		this.nome = nome;
		this.score = score;
	}

	public PostgreSQLCliente() {
		super();
	}

	
	
	


}
