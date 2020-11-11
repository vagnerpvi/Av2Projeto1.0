package com.Av2Projeto.model.domain;

public class Aluno {

	private Integer id_aluno;
	private String nome;
	private String curso;
	private Integer id_professor;

	public Aluno() {
		super();
	}

	public Aluno(Integer id_aluno, String nome, String curso, Integer id_professor) {
		super();
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.curso = curso;
		this.id_professor = id_professor;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}

}
