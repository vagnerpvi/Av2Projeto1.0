package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Av2Projeto.model.domain.Login;

public class LoginDao {

	private static final String INSERT_LOGIN_SQL = "insert into login(matricula,senha)values(?,?,?,?)";
	private static final String SELECT_LOGIN_BY_ID = "";
	private static final String SELECT_ALL_LOGIN = "select*from login";
	private static final String SELECT_VALIDACAO = "select*from login where matricula =? and senha=? ";
	private static final String DELETE_LOGIN_SQL = "delete from login where matricula=?";
	private static final String UPDATE_LOGIN_SQL = "update login set matricula=?, senha=? where matricula=?";

	public LoginDao() {
		super();

	}

	// insert aluno;
	public void AdicionarLogin(Login login) throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(INSERT_LOGIN_SQL);

		ps.setString(1, login.getMatricula());
		ps.setString(2, login.getSenha());
		

		System.out.println("matricula DAO" + login.getMatricula());
		System.out.println("senha DAO" + login.getSenha());
		
		System.out.println();

		ps.execute();

	}

	public boolean validar(Login login) throws ClassNotFoundException, SQLException {
		boolean status = false;

		try {
			Connection conexao = ConexaoJDBCFactory.getConexao();
			PreparedStatement ps = conexao.prepareStatement(SELECT_VALIDACAO);

			ps.setString(1, login.getMatricula());
			ps.setString(2, login.getSenha());

			System.out.println("matricula DAO" + login.getMatricula());
			System.out.println("senha DAO" + login.getSenha());

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				status=true;
				login.setMatricula("matricula");
				login.setSenha("senha");
			}
			if(status) {
				return status;
		 }else {
			 return status;
		 }	
			
		} catch (SQLException e) {
			System.out.println("" + e);
		}
		return status;
	}

// select aluno por ID
	public Login selectById(String matricula) throws SQLException, ClassNotFoundException {
		Login login = null;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(SELECT_LOGIN_BY_ID);

		ps.setString(1, matricula);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			String matricula1 = rs.getString("matricula");
			String senha = rs.getString("senha");
			

			login = new Login(matricula1, senha);
		}
		return login;

	}

	// select todos os Alunos
	public List<Login> listarLogin() throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		List<Login> login = new ArrayList<>();
		PreparedStatement ps = conexao.prepareStatement(SELECT_ALL_LOGIN);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			String matricula = rs.getString("matricula");
			String senha = rs.getString("senha");
			

			login.add(new Login(matricula,senha));

		}
		return login;
	}

	// Editar Aluno

	public boolean atualizarLogin(Login login) throws SQLException, ClassNotFoundException {
		boolean rowUpdate;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(UPDATE_LOGIN_SQL);

		ps.setString(1, login.getMatricula());
		ps.setString(2, login.getSenha());
		

		return rowUpdate = ps.executeUpdate() > 0;

	}

	public boolean excluirLogin(String matricula) throws SQLException, ClassNotFoundException {
		boolean rowDeletada;

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement(DELETE_LOGIN_SQL);

		statement.setString(1, matricula);

		return rowDeletada = statement.executeUpdate() > 0;

	}

}
