package com.Av2Projeto.model.domain;

public class Professor {
	private Integer id_professor;
	private String nome;
	private String titulacao;

	public Professor() {
		super();
	}

	public Professor(Integer id_professor, String nome, String titulacao) {
		super();
		this.id_professor = id_professor;
		this.nome = nome;
		this.titulacao = titulacao;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

}
