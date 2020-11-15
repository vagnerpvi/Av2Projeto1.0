package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Av2Projeto.model.domain.Aluno;

public class AlunoDao {

	private static final String INSERT_ALUNOS_SQL = "insert into aluno(nome,curso,id_professor)values(?,?,?)";
	private static final String SELECT_USER_BY_ID = "select id_aluno, nome ,curso, id_professor from aluno where id_aluno =?";
	private static final String SELECT_ALL_ALUNOS = "select*from aluno";
	private static final String DELETE_ALUNO_SQL = "delete from aluno where id_aluno=?";
	private static final String UPDATE_ALUNO_SQL = "update aluno set nome=?, curso=?, id_professor =? where id_aluno=?";

	public AlunoDao() {
		super();

	}

	// insert aluno;
	public void AdicionarAluno(Aluno aluno) throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(INSERT_ALUNOS_SQL);

		ps.setString(1, aluno.getNome());
		ps.setString(2, aluno.getCurso());
		ps.setInt(3, aluno.getId_professor());

		ps.execute();

		

	}

// select aluno por ID
	public Aluno selectById(Integer id_aluno) throws SQLException, ClassNotFoundException {
		Aluno aluno = null;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(SELECT_USER_BY_ID);

		ps.setInt(1, id_aluno);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			String nome = rs.getString("nome");
			String curso = rs.getString("curso");
			Integer id_professor = rs.getInt("id_professor");

			aluno = new Aluno(id_aluno, nome, curso, id_professor);
			
		}

		
		return aluno;

	}

	// select todos os Alunos
	public List<Aluno> listarAlunos() throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		List<Aluno> aluno = new ArrayList<>();
		PreparedStatement ps = conexao.prepareStatement(SELECT_ALL_ALUNOS);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			int id_aluno = rs.getInt("id_aluno");
			String nome = rs.getString("nome");
			String curso = rs.getString("curso");
			int id_professor = rs.getInt("id_professor");

			aluno.add(new Aluno(id_aluno, nome, curso, id_professor));
			
		}
		return aluno;
	}

	// Editar Aluno

	public boolean atualizarAluno(Aluno aluno) throws SQLException, ClassNotFoundException {
		boolean rowUpdate;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(UPDATE_ALUNO_SQL);

		ps.setString(1, aluno.getNome());
		ps.setString(2, aluno.getCurso());
		ps.setInt(3, aluno.getId_professor());
		ps.setInt(4, aluno.getId_aluno());

		
	rowUpdate = ps.executeUpdate() > 0;

		return rowUpdate;
		
	}

	public boolean excluirAluno(Integer id_aluno) throws SQLException, ClassNotFoundException {
		boolean rowDeletada;

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement(DELETE_ALUNO_SQL);

		statement.setInt(1, id_aluno);
	
       
		rowDeletada = statement.executeUpdate() > 0;

		return rowDeletada;
	}

}