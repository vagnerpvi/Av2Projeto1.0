package com.Av2Projeto.model.domain;

public class Login {
    private Integer id_login;
	private String matricula;
	private String senha;
	private Integer id_aluno;
	private Integer id_professor;

	public Login() {
		super();
	}

	public Login(Integer id_login ,String matricula, String senha, Integer id_aluno, Integer id_professor) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.id_aluno = id_aluno;
		this.id_professor = id_professor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}

	public Integer getId_login() {
		return id_login;
	}

	public void setId_login(Integer id_login) {
		this.id_login = id_login;
	}

}
