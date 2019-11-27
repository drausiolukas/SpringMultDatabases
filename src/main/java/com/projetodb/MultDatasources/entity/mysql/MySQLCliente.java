package com.projetodb.MultDatasources.entity.mysql;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class MySQLCliente {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "nome")
	private String nome ;
	
	@Column(name = "referencia")
	private String referencia;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "whatsapp")
	private String whatsapp ;
	
	@Column(name = "datacriacao")
	private Date datacriacao ;
	
	@Column(name = "dataatualizacao")
	private Date dataatualizacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public Date getDataatualizacao() {
		return dataatualizacao;
	}

	public void setDataatualizacao(Date dataatualizacao) {
		this.dataatualizacao = dataatualizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	


}
