package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Av2Projeto.model.domain.Nota;
import com.Av2Projeto.model.domain.Professor;

public class ProfessorDao {

	private static final String INSERT_PROFESSOR_SQL = "insert into nota(nome, titulacao)values(?,?)";
	private static final String SELECT_PROFESSOR_BY_ID = "select id_professor,  nome, titulacao from professor where id_professor =?";
	private static final String SELECT_ALL_PROFESSORES = "select * from professor";
	private static final String DELETE_PROFESSOR_SQL = "delete from nota where id_professor=?";
	private static final String UPDATE_PROFESSOR_SQL = "update nota set nome=?, titulacao=?  where id_professor=?";

	public ProfessorDao() {
		super();

	}

	// insert nota;
	public void AdicionarProfessor(Professor professor) throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(INSERT_PROFESSOR_SQL);

		ps.setString(1, professor.getNome());
		ps.setString(2, professor.getTitulacao());

		ps.execute();

	}

// select aluno por ID
	public Professor selectById(Integer id_professor) throws SQLException, ClassNotFoundException {
		Professor professor = null;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(SELECT_PROFESSOR_BY_ID);

		ps.setInt(1, id_professor);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			String nome = rs.getString("nome");
			String titulacao = rs.getString("titulacao");

			professor = new Professor(id_professor,nome,titulacao);

		}

		return professor;

	}

	// select todos os Alunos
	public List<Professor> listarProfessor() throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		List<Professor> professor = new ArrayList<>();
		PreparedStatement ps = conexao.prepareStatement(SELECT_ALL_PROFESSORES);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			int id_professor = rs.getInt("id_professor");
			String nome = rs.getString("nome");
			String titulacao = rs.getString("titulacao");
			

			professor.add(new Professor(id_professor, nome, titulacao));

		}

		return professor;
	}

	// Editar Aluno

	public boolean atualizarProfessor(Professor professor) throws SQLException, ClassNotFoundException {
		boolean rowUpdate;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(UPDATE_PROFESSOR_SQL);

		ps.setString(1, professor.getNome());
		ps.setString(2, professor.getTitulacao());
		ps.setInt(3, professor.getId_professor());

		rowUpdate = ps.executeUpdate() > 0;

		return rowUpdate;

	}

	public boolean excluirProfessor(Integer id_professor) throws SQLException, ClassNotFoundException {
		boolean rowDeletada;

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement(DELETE_PROFESSOR_SQL);

		statement.setInt(1, id_professor);

		rowDeletada = statement.executeUpdate() > 0;

		return rowDeletada;

	}

}
