package com.Av2Projeto.model.domain;

public class Login {
   
	private String matricula;
	private String senha;
	

	public Login() {
		super();
	}

	public Login(String matricula, String senha) {
		super();
		this.matricula = matricula;
		this.senha = senha;
	
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

	

	

}
