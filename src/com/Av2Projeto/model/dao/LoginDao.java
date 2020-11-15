package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Av2Projeto.model.domain.Login;

public class LoginDao {

	private static final String INSERT_LOGIN_SQL = "insert into login(matricula,senha,id_aluno,id_professor)values(?,?,?,?)";
	private static final String SELECT_LOGIN_BY_ID = "select id_login,id_aluno,id_professor from login where id_login =?";
	private static final String SELECT_ALL_LOGIN = "select*from login";
	private static final String DELETE_LOGIN_SQL = "delete from login where id_login=?";
	private static final String UPDATE_LOGIN_SQL = "update login set matricula=?, senha=?, id_aluno =?,id_professor =?  where id_login=?";

	public LoginDao() {
		super();

	}

	// insert aluno;
	public void AdicionarLogin(Login login) throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(INSERT_LOGIN_SQL);

		ps.setString(1, login.getMatricula());
		ps.setString(2, login.getSenha());
		ps.setInt(3, login.getId_aluno());
		ps.setInt(4, login.getId_professor());

		System.out.println("matricula DAO" + login.getMatricula());
		System.out.println("senha DAO" + login.getSenha());
		System.out.println("id_aluno DAO" + login.getId_aluno());
		System.out.println("id_professor DAO" + login.getId_professor());
		System.out.println();

		ps.execute();

	}

// select aluno por ID
	public Login selectById(Integer id_login) throws SQLException, ClassNotFoundException {
		Login login = null;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(SELECT_LOGIN_BY_ID);

		ps.setInt(1, id_login);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			String matricula = rs.getString("matricula");
			String senha = rs.getString("senha");
			Integer id_aluno = rs.getInt("id_aluno");
			Integer id_professor = rs.getInt("id_professor");

			login = new Login(id_login, matricula, senha, id_aluno, id_professor);
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

			int id_login = rs.getInt("id_login");
			String matricula = rs.getString("matricula");
			String senha = rs.getString("senha");
			int id_aluno = rs.getInt("id_aluno");
			int id_professor = rs.getInt("id_professor");

			login.add(new Login(id_aluno, matricula, senha, id_aluno, id_professor));

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
		ps.setInt(3, login.getId_aluno());
		ps.setInt(4, login.getId_professor());
		ps.setInt(5, login.getId_login());

		return rowUpdate = ps.executeUpdate() > 0;

	}

	public boolean excluirLogin(Integer id_login) throws SQLException, ClassNotFoundException {
		boolean rowDeletada;

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement(DELETE_LOGIN_SQL);

		statement.setInt(1, id_login);

		return rowDeletada = statement.executeUpdate() > 0;

	}

}
